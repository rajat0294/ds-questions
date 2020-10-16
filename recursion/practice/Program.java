package practice;

import java.util.*;

class Program {
    public static boolean interweavingStrings(String one, String two, String three) {
        // Write your code here.
        return interString(one,two,three,0,0,0);
    }

    public static void main(String[] args) {
        System.out.println(interweavingStrings("algoexpert","your-dream-job","your-algodream-expertjob"));
    }

    private static boolean interString(String one,String two,String three,int p1,int p2,int p3){
        if(p1==one.length() && p2==two.length() && p3==three.length()){
            return true;
        }
        else if(p3==three.length()){
            return false;
        }
        if(p1<one.length() && p2<two.length()&& one.charAt(p1)!=two.charAt(p2)){
            if(p3<three.length() && one.charAt(p1)==three.charAt(p3)){
                return interString(one,two,three,p1+1,p2,p3+1);
            }
            else if(p2<two.length() && p3<three.length() && two.charAt(p2)==three.charAt(p3)){
                return interString(one,two,three,p1,p2+1,p3+1);
            }else{
                return false;
            }
        }
        else if(p1<one.length() && p2<two.length()&& one.charAt(p1)==two.charAt(p2)){
            if(interString(one,two,three,p1+1,p2,p3+1)){
                return true;
            }else{
                return interString(one,two,three,p1,p2+1,p3+1);
            }
        }
        else if(p2<two.length() && two.charAt(p2)==three.charAt(p3))
        {
            return interString(one,two,three,p1,p2+1,p3+1);
        }
        else if(p1<one.length() && one.charAt(p1)==three.charAt(p3)){
            return interString(one,two,three,p1+1,p2,p3+1);
        }
        else{
            return false;
        }

    }
}