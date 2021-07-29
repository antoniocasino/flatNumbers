package it.tony.pagopa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FlattenIntegerArrayTest {

    @Test
    public void testNullArray() {
        System.out.println("\ntestNullArray: ");
        int[] flat = Arrays.stream(FlattenArray.flattenIntegerArray(null)).toArray();
        System.out.println("flatten: "+ Arrays.toString(flat));
        assert (isOneSizeDimensionIntegerArray(flat));
    }

    @Test
    public void testEmptyArray() {
        System.out.println("\ntestEmptyArray: []");
        int[] flat = Arrays.stream(FlattenArray.flattenIntegerArray("[]")).toArray();
        System.out.println("flatten: "+ Arrays.toString(flat));
        assert (isOneSizeDimensionIntegerArray(flat));
    }

    @Test
    public void testOneDimensionArray() {
        System.out.println("\ntestMonoDimensionalArray: [1,2,3,4] ");
        int[] flat = Arrays.stream(FlattenArray.flattenIntegerArray("[1,2,3,4]")).toArray();
        System.out.println("flatten: "+ Arrays.toString(flat));
        assert (isOneSizeDimensionIntegerArray(flat));
    }

    @Test
    public void testTwoDimensionArray() {
        System.out.println("\ntestTwoDimensionalArray: [[1,7,8],2,3,4,[3,4,44,45]] ");
        int[] flat = Arrays.stream(FlattenArray.flattenIntegerArray("[[1,7,8],2,3,4,[3,4,44,45]]")).toArray();
        System.out.println("flatten: "+ Arrays.toString(flat));
        assert (isOneSizeDimensionIntegerArray(flat));
    }

    @Test
    public void testNDimensionalArray() {
        System.out.println("\ntestNDimensionalArray: [[1,[7,[8]]],2,3,4] ");
        int[] flat = Arrays.stream(FlattenArray.flattenIntegerArray("[[1,[7,[8]]],2,3,4]")).toArray();
        System.out.println("flatten: "+ Arrays.toString(flat));
        assert (isOneSizeDimensionIntegerArray(flat));
    }

    private boolean isOneSizeDimensionIntegerArray(Object array) {
        return array!=null &&  array instanceof int[];
    }


}
