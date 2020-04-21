package coinChangePC;

public class CoinChangePermutation {

    public static void main(String[] args) {
        int[] coins=new int[]{2,3,5,6};
        coinChangePermutations(coins,10,"");
    }

    public static void coinChangePermutations(int[] coins, int amt, String answerSofar) {
        if (amt == 0) {
            System.out.println(answerSofar);
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            if(amt>=coins[i]) {
                coinChangePermutations(coins, amt - coins[i], answerSofar + coins[i]);
            }
        }
    }
}
