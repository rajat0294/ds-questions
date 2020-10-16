package practice;

import java.util.*;

class Test6 {
    public static List<Integer> rightSmallerThan(List<Integer> array) {
        // Write your code here.
        BST tree=new BST(array.get(array.size()-1),0);
        for(int i=array.size()-2;i>=0;i--){
            tree.insert(array.get(i));
        }
        ArrayList<Integer> result=new ArrayList<>();
        for(int j=0;j<array.size()-1;j++){
            BST node=tree.getNode(array.get(j));
            result.add(j,node.leftsubtreeLength);
        }
        return result;
    }

    public static class BST{
        int value;
        int leftsubtreeLength;
        BST left;
        BST right;
        BST(int value,int leftsubtreeLength){
            this.value=value;
            this.leftsubtreeLength=leftsubtreeLength;;
        }

        void insert(int value){
            if(right!=null && left !=null){
                if(this.value<=value){
                    this.right.insert(value);
                }else{
                    this.left.insert(value);
                }
            }else if(left!=null){
                if(this.value<=value){
                    this.right=new BST(value,this.leftsubtreeLength+1);
                }else{
                    this.left.insert(value);
                }
            }else if(right!=null){
                if(this.value>value){
                    this.left=new BST(value,this.leftsubtreeLength);
                }else{
                    this.right.insert(value);
                }
            }else{
                if(this.value<=value){
                    this.right=new BST(value,this.leftsubtreeLength+1);
                }else{
                    this.left=new BST(value,this.leftsubtreeLength);
                }
            }
        }

        BST getNode(int val){
            if(this.value==val){
                return this;
            }
            else if(this.value>val){
                return this.left.getNode(val);
            }else{
                return this.right.getNode(val);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(rightSmallerThan(List.of(8,5,11,-1,3,4,2)));
    }
}
