import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> cStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int num = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num*10+(ch-'0');
            }else if(ch == '['){
                /*
                if(ch == ']'){
                    //main string build happenes
                    int num = numStack.pop();
                    System.out.println("num = "+num);
                    char ch = cStack.pop();
                    StringBuilder sr = new StringBuilder();
                    while(ch != '['){
                        sr.append(ch);
                        ch = cStack.pop();
                    }
                    sr.append(result);
                    System.out.println("value after apend = "+sr.toString());
                    //sr = sr.reverse();

                    StringBuilder repS = new StringBuilder();
                    for(int rep = 0;rep<num;rep++){
                        System.out.println("val>"+rep+"-"+sr);
                        repS.append(sr);
                    }
                    System.out.println("Current result After rep= "+repS.toString());
                    result=repS;
                    System.out.println("Current result = "+result.toString());
                    System.out.println("rr->"+result);
                }else{
                    cStack.push(s.charAt(i));
                }
                 */
                numStack.push(num);
                cStack.push(result);
                result = new StringBuilder();
                num = 0;
            }else if(ch == ']'){
                int count = numStack.pop();
                StringBuilder rep = cStack.pop();
                for(int i = 0;i<count;i++){
                    rep.append(result);
                }
                result = rep;
            }else{
                result.append(ch);
            }
        }
        return result.toString();
    }
}
