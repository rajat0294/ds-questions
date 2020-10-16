package underscorifyString;

import java.util.*;

class Program {
    public static String underscorifySubstring(String str, String substring) {
        // Write your code here.
        //findindex

        MatchFinder matchFinder=new MatchFinder(str,substring);
        int[] pattern = matchFinder.builPattern();
        List<Integer> indexRecord=matchFinder.findMatchIndexes(pattern);

        //collapse index
        List<Integer[]> indx=collapseIndexes(indexRecord,substring.length());
        //underscorify
        return underScorify(str,indx);
    }

    public static List<Integer[]> collapseIndexes(List<Integer> indexRecord,int patternLength){
        List<Integer[]> collpasedPositions=new ArrayList<Integer[]>();
        for(int i=0;i<indexRecord.size();i++){
            Integer[] pair=new Integer[2];
            pair[0]=indexRecord.get(i);
            pair[1]=indexRecord.get(i)+patternLength;
            collpasedPositions.add(pair);
        }

        List<Integer[]> newLocations=new ArrayList<Integer[]>();
        newLocations.add(collpasedPositions.get(0));
        Integer[] previous=newLocations.get(0);
        for(int i=1;i<collpasedPositions.size();i++){
            Integer[] current=collpasedPositions.get(i);
            if(current[0]<=previous[1]){
                previous[1]=current[1];
            }else{
                newLocations.add(current);
                previous=current;
            }
        }
        return newLocations;
    }



    public static String underScorify(String str,List<Integer[]> collpasedPositions){
        int undescorePlaced=0;
        StringBuilder sb = new StringBuilder(str);
        for(int k=0;k<collpasedPositions.size();k++){
            Integer[] l=collpasedPositions.get(k);
            sb.insert(l[0]+undescorePlaced,'_');
            undescorePlaced++;
            sb.insert(l[1] + undescorePlaced+1, '_');
            undescorePlaced++;
        }
        return sb.toString();
    }


    public static class MatchFinder{

        private String longString;
        private String patternString;

        public MatchFinder(String longString,String patternString){
            this.longString=longString;
            this.patternString=patternString;
        }

        public int[] builPattern(){

            int[] pattern=new int[this.patternString.length()];
            for(int i=0;i<this.patternString.length();i++){
                pattern[i]=-1;
            }
            int i=1;
            int j=0;
            while(i<pattern.length){
                if(this.patternString.charAt(i)== this.patternString.charAt(j)){
                    pattern[i]=j;
                    i++;
                    j++;
                }else if(j>0){
                    j=pattern[j-1]+1;
                }else{
                    i++;
                }
            }
            return pattern;
        }

        public List<Integer> findMatchIndexes(int[] pattern){
            int i=0;
            int j=0;
            List<Integer> indexRecord=new ArrayList<Integer>();
            while(i<this.longString.length()){
                if(this.longString.charAt(i)==this.patternString.charAt(j)){
                    if(j==this.patternString.length()-1)
                    {
                        indexRecord.add(i-j);
                        j=-1;
                        if(this.patternString.length()>1) {
                            i = i - 1;
                        }
                    }
                    i++;
                    j++;
                }else if(j>0){
                    j=pattern[j-1]+1;
                }else{
                    i++;
                }
            }
            return indexRecord;
        }
    }
}
