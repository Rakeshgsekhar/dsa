class SolutionLSFOP {
    public String smallestString(String s) {
        String result = "";
        String[] parts = s.split("a");
        System.out.println(parts.length);
        String toChange = "";
        //for(String p : parts) System.out.println(p);

        for(String p : parts) {
            if(!p.isEmpty()&&!p.isBlank()){
                toChange = p;
                break;
            }
        }

        if(parts.length == 0) {
            System.out.println("all a's");
            char[] newChar = s.toCharArray();
            newChar[newChar.length-1] = 'z';
            System.out.println(new String(newChar));
            return new String(newChar);
        }
       // System.out.println(toChange);
        char[] newChar = toChange.toCharArray();
        for(int i = 0;i<newChar.length;i++){
            newChar[i]--;
        }
        String newString = new String(newChar);

        result = s.replaceFirst(toChange,newString);

        System.out.println(result);
        return result;
    }
}
public class LexicographicalllySmallestAfterOp {
    public static void main(String[] args) {
        SolutionLSFOP ts = new SolutionLSFOP();
        ts.smallestString("leetcode");
        ts.smallestString("cbabc");
        ts.smallestString("acbbc");
        ts.smallestString("aaaaaa");
        ts.smallestString("bab");
    }
}
