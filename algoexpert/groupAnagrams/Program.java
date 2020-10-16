package groupAnagrams;

import java.util.*;

class Program {
    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.
        HashMap<String,List<String>> map=new HashMap<String,List<String>>();
        for(String word:words){
            char sortedWord[]=word.toCharArray();
            Arrays.sort(sortedWord);
            String sortedWordString=new String(sortedWord);
            if(map.get(sortedWordString)==null){
                List<String> l=new ArrayList<String>();
                l.add(word);
                map.put(sortedWordString,l);
            }else{
                List<String> l2=map.get(sortedWordString);
                l2.add(word);
                map.put(sortedWordString,l2);
            }
        }
        List<List<String>> resultList=new ArrayList<List<String>>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            resultList.add(entry.getValue());
        }
        return resultList;
    }
}
