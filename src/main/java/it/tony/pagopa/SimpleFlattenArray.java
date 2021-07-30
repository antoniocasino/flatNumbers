package it.tony.pagopa;

import java.util.ArrayList;
import java.util.List;

public class SimpleFlattenArray {

    public static int[] flattenIntegerArray(Object[] array) {
        int[] result = new int[0];
        if (array != null && array.length > 0) {
            List<Integer> flattenList = new ArrayList<>();
            for (Object element : array) {
                flatten(element, flattenList);
            }
            result = flattenList.stream().mapToInt(Integer.class::cast).toArray();
        }
        return result;
    }

    private static void flatten(Object root, List<Integer> flattenList) {
        if (root instanceof Object[]) {
            Object[] array = ((Object[]) root);
            for (Object element :array) {
                flatten(element, flattenList);
            }
        } else {
            flattenList.add((Integer) root);
        }
    }
}
