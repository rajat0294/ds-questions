package coinChangePC;

public class CoinChangeCombination {
    public static void main(String[] args) {
        int[] coins=new int[]{2,3,5,6};
        coinChangeCombinations(coins,10,"",0);
    }

    public static void coinChangeCombinations(int[] coins, int amt, String answerSofar, int lastIndex) {
        if (amt == 0) {
            System.out.println(answerSofar);
            return;
        }
        for (int i = lastIndex; i < coins.length; i++) {
            if(amt>=coins[i]) {
                coinChangeCombinations(coins, amt - coins[i], answerSofar + coins[i], i);
            }
        }
    }
}
