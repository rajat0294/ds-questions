package knapsack;


import java.util.List;

class ProgramTest {

    public static void main(String[] args) {
        int[][] input = {{2, 1}, {70, 70}, {30, 30}, {69, 69}, {100, 100}};
        int[][] expected = {{10}, {1, 3}};
        System.out.println("calling knapsack ......  ");
        Program.knapsackProblem(input, 100);
    }

    private static boolean compare(List<List<Integer>> arr1, int[][] arr2) {
        if (arr1.get(0).get(0) != arr2[0][0]) {
            return false;
        }
        if (arr1.get(1).size() != arr2[1].length) {
            return false;
        }
        for (int i = 0; i < arr1.get(1).size(); i++) {
            if (arr1.get(1).get(i) != arr2[1][i]) {
                return false;
            }
        }
        return true;
    }
}
