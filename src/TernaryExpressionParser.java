import java.util.Stack;

class SolutionTEP{
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        int n = expression.length();
        for(int i = n-1;i>=0;i--){
            Character ch = expression.charAt(i);
            if(!stack.isEmpty() && stack.peek() == '?'){
                stack.pop();
                Character trueXp = stack.pop();
                Character falseXp = stack.pop();
                if(ch == 'T') stack.push(trueXp);
                else stack.push(falseXp);
            }else{
                if(ch!=':') stack.push(ch);
            }
        }

        return String.valueOf(stack.peek());
    }
}
public class TernaryExpressionParser {
    public static void main(String[] args) {
        SolutionTEP tep = new SolutionTEP();
        System.out.println(tep.parseTernary("T?2:3"));
        System.out.println(tep.parseTernary("F?1:T?4:5"));
        System.out.println(tep.parseTernary("T?T?1:2:F?3:4"));
    }
}
