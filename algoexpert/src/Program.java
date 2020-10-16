package src;

import java.util.*;

class Program {
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.
        int[][] br=new int[blocks.size()][reqs.length];
        for(int i=0;i<blocks.size();i++){
            for(int j=0;j<reqs.length;j++){
                if(blocks.get(i).get(reqs[j])){
                    br[i][j]=0;
                }else{
                    br[i][j]=getMinimumDistanceForj(blocks,i,reqs[j]);
                }
            }
        }
        int minValue=Integer.MAX_VALUE;
        int minIndex=-1;

        for(int i=0;i<blocks.size();i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<reqs.length;j++){
                if(br[i][j]>max){
                    max=br[i][j];
                }
            }
            if(minValue>max){
                minIndex=i;
                minValue=max;
            }
        }
        return minIndex;
    }

    public static int getMinimumDistanceForj(List<Map<String, Boolean>> blocks,int block,String req){
        int upCount=Integer.MAX_VALUE;
        int downCount=Integer.MAX_VALUE;
        int blocksLength=blocks.size();
        if(block!=blocksLength-1){
            downCount=block+1;
        }
        if(block!=0){
            upCount=block-1;
        }

        while(upCount>=0 && upCount!=Integer.MAX_VALUE ){
            if(!blocks.get(upCount).get(req)){
                upCount--;
            }else{
                break;
            }
        }
        while(downCount<blocksLength && downCount!=Integer.MAX_VALUE){
            if(!blocks.get(downCount).get(req)){
                downCount++;
            }else{
                break;
            }
        }
        if(downCount==blocksLength || downCount==Integer.MAX_VALUE){
           return block-upCount;
        }
        if(upCount==-1 || upCount==Integer.MAX_VALUE){
            return downCount-block;
        }
        return Math.min(block-upCount,downCount-block);
    }
}
