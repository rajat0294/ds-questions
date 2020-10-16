package practice;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

class Program1 {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        ArrayList<List<Integer>> permutations=new ArrayList<List<Integer>>();
        if(array.size()==1){
            permutations.add(new ArrayList<Integer>(array));
            return permutations;
        }
        for(Integer val:array){
            ArrayList<Integer> perm=new ArrayList<Integer>();
            perm.add(val);
            List<Integer> arrayCopy=new ArrayList<>(array);
            arrayCopy.remove(val);
            List<List<Integer>> subPermList=getPermutations(arrayCopy);
            for(List<Integer> subPerm:subPermList){
                List<Integer> per=new ArrayList<>(perm);
                per.addAll(subPerm);
                permutations.add(per);
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(getPermutations(list));
    }
}