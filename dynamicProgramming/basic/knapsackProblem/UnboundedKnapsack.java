package basic.knapsackProblem;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] value =new int[]{15,14,10,45,30};
        int[] capacity =new int[]{2,5,1,3,4};

        System.out.println(unboundedKanpsack(value,capacity,7));
    }

    public static int unboundedKanpsack(int[] value,int[] capacity,int maxCapacity){
        int[] dp=new int[maxCapacity+1];
        for (int i=0;i<=maxCapacity;i++){
            int max=0;
            for(int j=0;j<capacity.length;j++){
                if(i-capacity[j]>=0){
                    if(max < (value[j]+dp[i-capacity[j]])){
                        max=value[j]+dp[i-capacity[j]];
                    }
                }
            }
            dp[i]=max;
        }
        return  dp[maxCapacity];
    }
}
