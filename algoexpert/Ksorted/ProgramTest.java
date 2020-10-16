package Ksorted;

import java.util.*;
public class ProgramTest {
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<List<Integer>>();
        arrays.add(Arrays.asList(new Integer[] {1, 5, 9, 21}));
        arrays.add(Arrays.asList(new Integer[] {-1, 0}));
        arrays.add(Arrays.asList(new Integer[] {-124, 81, 121}));
        arrays.add(Arrays.asList(new Integer[] {3, 6, 12, 20, 150}));
        var actual = Program.mergeSortedArrays(arrays);
        System.out.println(actual);
    }
}



