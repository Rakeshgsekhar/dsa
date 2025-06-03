import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class Pair{
    String s;
    int index;
    Pair(String s,int index){
        this.s = s;
        this.index = index;
    }

}
class SolutionAN {
    public String countOfAtoms(String formula) {
        StringBuilder result = new StringBuilder();
        /*TreeMap<String,Integer> map = new TreeMap<>();
        Map<String,Integer> mapCounter = new HashMap<>();
        boolean multi = false;
        Stack<Character> el = new Stack<>();
        for(int i = 0;i<formula.length();i++){
            String first = "";
            char second = formula.charAt(i);
            if(Character.isLowerCase(second)){
                first += formula.charAt(i-1);
            }
            String key = first+second;
            mapCounter.put(key,mapCounter.getOrDefault(key,0)+1);
        }


        for(int i = 0;i<formula.length();i++){
            char ch = formula.charAt(i);
            if(Character.isDigit(ch)){
                char tp = el.pop();
                if(tp == ')'){
                    multi = true;
                    Stack<Character> tempStack = new Stack<>();
                    while(el.peek() != '('){
                        tempStack.push(el.pop());
                    }
                    el.pop();
                    while(!tempStack.isEmpty()){
                        char tmpCh = tempStack.pop();
                        String first = "";
                        if(Character.isLowerCase(tmpCh)){
                            first += tempStack.pop();
                        }
                        String key = first+tmpCh;
                        map.put(key, map.getOrDefault(key,1)*(ch-'0'));

                        if(!first.equals(""))
                            el.push(first.charAt(0));

                        if(!el.contains(tmpCh))
                            el.push(tmpCh);
                    }
                }else if(Character.isLowerCase(tp)){
                    String first = "";
                    first+=el.pop();
                    String key = first+tp;
                    if(!first.equals(""))
                        el.push(first.charAt(0));

                    if(!el.contains(tp))
                        el.push(tp);

                    map.put(key,map.getOrDefault(key,1)*(ch-'0'));
                }else{
                    String key = ""+tp;
                    el.push(tp);
                    map.put(key,map.getOrDefault(key,1)*(ch-'0'));
                }
            } else if (Character.isLowerCase(ch)) {
                String first = "";
                first+=el.pop();
                String key = first+ch;
                map.put(key,map.getOrDefault(key,1)*1);
            } else{
                el.push(ch);
            }

        }
        for(String key : map.keySet()){
            int count = map.get(key) + ((mapCounter.get(key) == 1)?0:mapCounter.get(key));
            result.append(key);
            if(count != 1){
                result.append(count);
            }
        }

        return result.toString();*/
        Stack<TreeMap<String,Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        int n = formula.length();
        for(int i = 0;i<n;){
            char ch = formula.charAt(i);
            if(ch == '('){
                stack.push(new TreeMap<>());
                i++;
            }else if(ch == ')'){
                TreeMap<String,Integer> map = stack.pop();
                i++;
                int start = i;
                while(i<n && Character.isDigit(formula.charAt(i))) i++;
                int multi = start<i?Integer.parseInt(formula.substring(start,i)):1;
                for(String key : map.keySet()){
                    stack.peek().put(key,stack.peek().getOrDefault(key,0)+ map.get(key)*multi);
                }
            }else{
                int start = i;
                i++;
                while(i<n && Character.isLowerCase(formula.charAt(i)))i++;

                String element = formula.substring(start,i);
                start=i;
                while(i<n && Character.isDigit(formula.charAt(i))) i++;

                int count = start<i?Integer.parseInt(formula.substring(start,i)):1;

                stack.peek().put(element,stack.peek().getOrDefault(element,0)+count);
            }
        }
        TreeMap<String,Integer> map = stack.pop();
        for(String key : map.keySet()){
            result.append(key);
            int count = map.get(key);
            if(count>1) result.append(count);
        }
        return result.toString();
    }
}
public class AtomicNumber {
    public static void main(String[] args) {
        SolutionAN an = new SolutionAN();
        System.out.println(an.countOfAtoms( "K4(ON(SO3)2)2"));
        System.out.println(an.countOfAtoms("Mg(OH)2"));
        System.out.println(an.countOfAtoms("((CH3)2(C2H5)3)2(Mg(CO3)2)"));
        System.out.println(an.countOfAtoms("Ca(OH)2Mg(OH)2"));
        System.out.println(an.countOfAtoms("K4(ON(SO3)2)3(Fe(CN)6)2"));
        System.out.println(an.countOfAtoms("(((K4(ON(SO3)2)3(Fe(CN)6)2)4(Mg(OH)2)10)2(H2O)5)3"));
        System.out.println(an.countOfAtoms("(((K4(ON(SO3)2)3(Fe(CN)6)2)10(Mg(OH)2)20)5(H2O)50)6"));
        System.out.println(an.countOfAtoms("((((H2SO4)50(NaCl)30)10(Cu(NO3)2)40)20(Mg(OH)2)60)5"));
        /*






         */
    }
}
