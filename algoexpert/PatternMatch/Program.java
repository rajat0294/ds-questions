package PatternMatch;


import java.util.HashMap;

class Program {
    public static String[] patternMatcher(String pattern, String str) {
        // Write your code here.
        if(pattern.length()>str.length()){
            return new String[]{};
        }

        String newPattern=getNewPattern(pattern);
        boolean didSwitch=(newPattern.charAt(0)!=pattern.charAt(0))?true:false;
        HashMap<Character,Integer> counts=new HashMap<Character,Integer>();
        int firstYIndex=getCountsAndFirstYPosition(newPattern,counts);


        if(counts.get('y')!=0){
            for(int lengthOfX=1;lengthOfX<str.length();lengthOfX++){
                int lenOfY=(str.length()-lengthOfX*counts.get('x'))/counts.get('y');
                if(lenOfY<=0 || lenOfY%1!=0){
                    continue;
                }
                int yIdx= firstYIndex*lengthOfX;
                String xString=str.substring(0,lengthOfX);
                String yString=str.substring(yIdx,yIdx+lenOfY);
                StringBuilder strBuilder=new StringBuilder();
                for(int i=0;i<newPattern.length();i++){
                    if(newPattern.charAt(i)=='x'){
                        strBuilder.append(xString);
                    }else{
                        strBuilder.append(yString);
                    }
                }
                if(strBuilder.toString().equalsIgnoreCase(str)){
                    if(!didSwitch){
                        return new String[]{xString,yString};
                    }else{
                        return new String[]{yString,xString};
                    }
                }
            }
        }else{
            double lenOfX=str.length()/counts.get('x');
            if(lenOfX%1==0){
                String xString=str.substring(0,(int) lenOfX);
                StringBuilder potentialMatch=new StringBuilder();
                for(int i=0;i<newPattern.length();i++){
                    potentialMatch.append(xString);
                }
                if(potentialMatch.toString().equalsIgnoreCase(str)){
                    if(!didSwitch){
                        return new String[]{xString,""};
                    }else{
                        return new String[]{"",xString};
                    }
                }
            }
        }
        return new String[]{};
    }

    public static String getNewPattern(String pattern){
        if(pattern.charAt(0)=='x'){
            return pattern;
        }else{
            char[] arr=new char[pattern.length()];
            for(int i=0;i<pattern.length();i++){
                if(pattern.charAt(i)=='x'){
                    arr[i]='y';
                }else{
                    arr[i]='x';
                }
            }
            return new String(arr);
        }
    }

    public static int getCountsAndFirstYPosition(String newPattern,HashMap<Character,Integer> map){
        int firstYIndex=-1;
        int xCount=0;
        int yCount=0;
        for(int i=0;i<newPattern.length();i++){
            if(newPattern.charAt(i)=='x'){
                xCount++;
            }else{
                if(firstYIndex==-1){
                    firstYIndex=i;
                }
                yCount++;
            }
        }
        map.put('x',xCount);
        map.put('y',yCount);
        return firstYIndex;
    }

}
