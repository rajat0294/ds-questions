import java.util.Stack;

public class SortStackUsingRecursion {

    public static void sortStack(Stack<Integer> stack) {
        if (!stack.empty()) {
            int x = stack.pop();
            sortStack(stack);
            sortedinsert(stack,x);
        }
    }
    public static void sortedinsert(Stack<Integer> stack,Integer ele){
        if(stack.empty()||ele>stack.peek())
        {
            stack.push(ele);
            return;
        }
        int temp=stack.pop();
        sortedinsert(stack,ele);
        stack.push(temp);
  }

    public static void main(String[] args) {
        Stack<Integer> s=new Stack<Integer>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
        sortStack(s);
        while(!s.empty()){
            System.out.println(s.pop());
        }
    }
}


