package practice;

import java.util.*;

class Program3 {
    public static String shortenPath(String path) {
        // Write your code here;
        String[] s=path.split("/");
        Stack<String> stack=new Stack<String>();
        int startIndex=0;
        if(path.startsWith("/")){
            stack.push("/");
            startIndex=1;
        }
        for(int i=startIndex;i<s.length;i++){
            if(s[i].equals("..") && !stack.isEmpty()){
                stack.pop();
            }else if(!s[i].equals(".") && !s[i].equalsIgnoreCase("")){
                stack.push(s[i]);
            }
        }

        return printPath(stack);
    }

    private static String printPath(Stack<String> stack){
        if(stack.isEmpty()){
            return "";
        }
        String top=stack.pop();
        String res=printPath(stack);
        if("".equals(res) || "/".equals(res)){
            return res+top;
        }
        return res+"/"+top;
    }

    public static void main(String[] args) {
        System.out.println(shortenPath("/foo/../test/../test/../foo//bar/./baz"));
    }
}
