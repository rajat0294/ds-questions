package smallestsubstring;

import java.util.*;

class Program {
    public static String smallestSubstringContaining(String bigString, String smallString) {
        // Write your code here.
        Map<Character,Integer> smallStringMap=new HashMap<>();

        Map<Character,Integer> stringMap=new HashMap<>();

        for(int i=0;i<smallString.length();i++){
            if(smallStringMap.containsKey(smallString.charAt(i))){
                smallStringMap.put(smallString.charAt(i),smallStringMap.get(smallString.charAt(i))+1);
            }else{
                smallStringMap.put(smallString.charAt(i),1);
            }
        }

        int l=0;
        int r=0;
        int match=0;
        int minStartIndex=0;
        int minEndIndex=bigString.length()-1;
        while(r<bigString.length()){
            char c=bigString.charAt(r);
            if(match<smallStringMap.size()){
                if(smallStringMap.containsKey(c)){
                    if(stringMap.containsKey(c)){
                        stringMap.put(c,stringMap.get(c)+1);
                    }else{
                        stringMap.put(c,1);
                    }
                    if(smallStringMap.get(c)==stringMap.get(c)){
                        match++;
                    }
                    r++;
                }else if(match<smallStringMap.size()){
                    r++;
                }
            }else if(match==smallStringMap.size()) {
                if ((minEndIndex - minStartIndex) > (r - l)) {
                    minStartIndex = l;
                    minEndIndex = r;
                }
                    char lc = bigString.charAt(l);
                    if (smallStringMap.containsKey(lc)) {
                        stringMap.put(lc, stringMap.get(lc) - 1);
                        if (smallStringMap.get(lc) > stringMap.get(lc)) {
                            match--;
                        }
                    }
                    l++;
                }
        }
        return bigString.substring(minStartIndex,minEndIndex);
    }
}

