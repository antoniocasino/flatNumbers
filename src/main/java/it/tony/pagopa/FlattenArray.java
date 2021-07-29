package it.tony.pagopa;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class FlattenArray {

    static int MAX_CAPACITY = 1000;

    public static int[] flattenIntegerArray(String array) {
        if(array == null || array.length() ==0 ) return new int[0];
        Gson gson = new Gson();
        Object[] root = gson.fromJson(array, Object[].class);
        List<Object> flattenList = new ArrayList<>();
        for (int i = 0; i < root.length; i++) {
            flatten(root[i], flattenList, 0);
        }
        return flattenList.stream().mapToInt(Integer.class::cast).toArray();
    }

    private static int flatten(Object root, List<Object> flattenList, int capacity) {
        if (root instanceof List) {
            Object[] array = ((List<?>) root).toArray();
            for (int i = 0; i < array.length; i++) {
                capacity = flatten(array[i], flattenList, capacity);
            }
        } else {
            if (capacity > MAX_CAPACITY) {
                throw new RuntimeException("max capacity "+ MAX_CAPACITY +" reached");
            }
            if (root instanceof Double) {
                flattenList.add((int) Double.parseDouble(root.toString()));
            } else {
                flattenList.add(Integer.parseInt(root.toString()));
            }
            capacity++;
        }
        return capacity;
    }

}


