package basic.knapsackProblem;

import java.util.*;

public class FractionalKnapsack {

    public static void main(String[] args) {
        int[] value =new int[]{6,33,10,28,42,7};
        int[] capacity =new int[]{9,3,6,8,3,6};
        System.out.println(fractionalKnapSack(value,capacity,4));

        /*Scanner scanner=new Scanner(System.in);
        int n =scanner.nextInt();
        int[] value=new int[n];
        int[] capacity=new int[n];
        for(int i=0;i<value.length;i++){
            value[i]=scanner.nextInt();
        }
        for(int i=0;i<value.length;i++){
            capacity[i]=scanner.nextInt();
        }
        int maxCapacity=scanner.nextInt();*/
       // System.out.println(fractionalKnapSack(value,capacity,maxCapacity));
     }


    public static class Item {

        private Double valueCapRatio;
        int capacity;
        int value;

        public Item(int capacity, int value) {
            this.capacity = capacity;
            this.value = value;
            this.valueCapRatio=Double.valueOf(value)/Double.valueOf(capacity);
        }

        public Double getValueCapRatio() {
            return valueCapRatio;
        }

        public void setValueCapRatio(Double valueCapRatio) {
            this.valueCapRatio = valueCapRatio;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static double fractionalKnapSack(int[] value,int[] capacity,int maxCapacity){

       List<Item> items=new ArrayList<>();
        for(int i=0;i<value.length;i++){
            items.add(new Item(capacity[i],value[i]));
        }
        items.sort(Comparator.comparing(Item::getValueCapRatio).reversed());
        double maxValue=0d;
        int remainingCapacity=maxCapacity;
        for(Item item:items){
            if(remainingCapacity-item.getCapacity()>=0){
                if(remainingCapacity==0){
                    break;
                }
                maxValue+=item.getValue();
                remainingCapacity=remainingCapacity-item.getCapacity();
            }else{
                maxValue+=(Double.valueOf(remainingCapacity)* item.getValueCapRatio());
                remainingCapacity=0;
                break;
            }
        }
        return maxValue;
    }
}


