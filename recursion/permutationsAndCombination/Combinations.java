package permutationsAndCombination;

public class Combinations {

    public static void combinations(boolean[] visited, int totalqueen, int queenPlacedSoFar, String answerSoFar) {
        if (totalqueen == queenPlacedSoFar) {
            System.out.println(answerSoFar);
            return;
        }
        for (int block = 0; block < visited.length - block; block++) {
            if (!visited[block]) {
                visited[block] = true;
                combinations(visited, totalqueen, queenPlacedSoFar + 1, answerSoFar+"[q"+queenPlacedSoFar+"b"+block+"]");
                visited[block] = false;
            }
        }
    }
}
