class SolutionADR {
    public String resultingString(String s) {
        StringBuilder res = new StringBuilder(s);
        char ch [] = s.toCharArray();
        int start = 0;
        int end = 1;
        int n = s.length();
        while(end<res.length()){
            int cha = (res.charAt(start));
            int chr = (res.charAt(end));

            //? (int)'a': ? (int)'z':
//            if((res.charAt(start) == 'z' && res.charAt(end) == 'a'))
            if((res.charAt(start) == 'z' && res.charAt(end) == 'a')|| (res.charAt(start) == 'a' && res.charAt(end) == 'z') || Math.abs(cha-chr) == 1){
                res = new StringBuilder(res.subSequence(0, start) + res.substring(end + 1, res.length()));
                start=0;
                end=start+1;
            }else {
                start++;
                end = start + 1;
            }
        }

        return res.toString();
    }
}
public class AdjecentRemoval {
    public static void main(String[] args) {
        SolutionADR adr = new SolutionADR();
        System.out.println(adr.resultingString("abc"));
        System.out.println(adr.resultingString("adcb"));
        System.out.println(adr.resultingString("zadb"));
        System.out.println(adr.resultingString("azdb"));
    }
}
