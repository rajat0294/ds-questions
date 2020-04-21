package permutationsAndCombination;

public class Permutations {

    public static void permutaions(boolean[] visited, int totalqueen, int queenvisitedSofar, String answersofar) {
        if (queenvisitedSofar == totalqueen) {
            System.out.println(answersofar);
            return;
        }
        for (int block = 0; block < visited.length - 1; block++) {
            if (!visited[block]) {
                visited[block] = true;
                permutaions(visited, totalqueen, queenvisitedSofar + 1, answersofar + "[q" + queenvisitedSofar + 1 + "b" + block + "]");
                visited[block] = false;
            }
        }
    }
}
