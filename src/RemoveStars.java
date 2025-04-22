import java.util.Stack;

public class RemoveStars {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                stack.pop();
            }
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char ch = stack.pop();
            sb.append(ch);
        }
        return sb.reverse().toString();

        /*

         StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(sb.length()>0 && ch == '*'){
                sb.setLength(sb.length()-1);
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
         */
    }
}
