package it.tony.pagopa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SimpleFlattenArrayTest {

    @Test
    public void testNullArray() {
        System.out.println("\ntestNullArray: ");
        int[] flat = SimpleFlattenArray.flattenIntegerArray(null);
        System.out.println("flatten: "+ Arrays.toString(flat));
        assert isMatchingDimension(flat,0);
    }

    @Test
    public void testEmptyArray() {
        System.out.println("\ntestEmptyArray: []");
        int[] flat = SimpleFlattenArray.flattenIntegerArray(new Object[0]);
        System.out.println("flatten: "+ Arrays.toString(flat));
        assert isMatchingDimension(flat,0);
    }

    @Test
    public void testOneDimensionArray() {
        System.out.println("\ntestSingleDimensionalArray: [1,2,3,4] ");
        int[] flat = SimpleFlattenArray.flattenIntegerArray(new Object[] {1,2,3,4});
        System.out.println("flatten: "+ Arrays.toString(flat));
        assert isMatchingDimension(flat,4);
    }

    @Test
    public void testTwoDimensionArray() {
        System.out.println("\ntestTwoDimensionalArray: [[1,7,8],2,3,4,[3,4,44,45]] ");
        int[] flat = SimpleFlattenArray.flattenIntegerArray(new Object[] { new Object[] {1,7,8}, 2,3,4, new Object[] {3,4,44,45}});
        System.out.println("flatten: "+ Arrays.toString(flat));
        assert isMatchingDimension(flat,10);
    }

    @Test
    public void testNDimensionalArray() {
        System.out.println("\ntestNDimensionalArray: [[1,[7,[8]]],2,3,4] ");
        int[] flat = SimpleFlattenArray.flattenIntegerArray(new Object[] {new Object[] {1,new Object[] {7,new Object[] {8}}},2,3,4});
        System.out.println("flatten: "+ Arrays.toString(flat));
        assert isMatchingDimension(flat,6);
    }

    private boolean isMatchingDimension(int[] array,int capacity) {
        return array!=null &&  array.length == capacity;
    }


}
