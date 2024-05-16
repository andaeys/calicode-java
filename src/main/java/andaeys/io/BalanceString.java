package andaeys.io;

import java.util.Scanner;
import java.util.Stack;

class SolutionBalance{

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            System.out.println(isBalance(input));
        }
        sc.close();
    }

    static boolean isBalance(String s) {
        Stack<Character> cStack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c=='(' || c=='[' || c=='{') {
                cStack.push(c);
            } else if (c==')' && !cStack.empty() && cStack.peek()=='(') {
                cStack.pop();
            }else if (c==']' && !cStack.empty() && cStack.peek()=='[') {
                cStack.pop();
            }else if (c=='}' && !cStack.empty() && cStack.peek()=='{') {
                cStack.pop();
            } else {
                return false;
            }
        }
        return cStack.isEmpty();
    }
}
