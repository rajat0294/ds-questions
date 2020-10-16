package src.patternMatch;
import java.util.*;

class Program {
    public static String[] patternMatcher(String pattern, String str) {
        // Write your code here.
        char[] patternArray=pattern.toCharArray();
        int xCount=0;
        int yCount=0;
        int firstIndexOfyinPattern=-1;
        for(int k=0;k<patternArray.length;k++){

            if(patternArray[k]=='x'){
                xCount++;
            }else if(firstIndexOfyinPattern==-1){
                firstIndexOfyinPattern=k;
                yCount++;
            }else{
                yCount++;
            }
        }
        int maxLengthOfx=(str.length()-yCount)/xCount;
        for(int i=1;i<=maxLengthOfx;i++){
            int lengthOfX=i;
            int lengthOfY=0;
            if(yCount>0){
                lengthOfY=(str.length()-(xCount*i))/yCount;
            }
            if(lengthOfY<0 || (yCount>0 && (str.length()-(xCount*i))%yCount>0)){
                continue;
            }
            String xString="";
            String yString="";
            if(firstIndexOfyinPattern>0) {
                xString = str.substring(0, lengthOfX);
                yString = "";
                if (yCount > 0) {
                    yString = str.substring((i * firstIndexOfyinPattern), (i * firstIndexOfyinPattern) + lengthOfY);
                }
            }
            StringBuilder strBuilder=new StringBuilder();
            for(int j=0;j<pattern.length();j++){
                if(patternArray[j]=='x'){
                    strBuilder.append(xString);
                }else{
                    strBuilder.append(yString);
                }
            }

            if(strBuilder.toString().equalsIgnoreCase(str)){
                return new String[]{xString,yString};
            }
        }
        return new String[0];
    }
}
