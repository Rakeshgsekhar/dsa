class SolutionCDIOI {
    public boolean hasSameDigits(String s) {
        if(s.length() == 2){
            return s.charAt(0)==s.charAt(1);
        }
        StringBuilder st = new StringBuilder();
        for(int i = 1;i<s.length();i++){
            int r = ((s.charAt(i-1)-'0')+s.charAt(i)-'0')%10;
            st.append(r);
        }
        return hasSameDigits(st.toString());
    }
}
public class DeigitsEqualAfterOperation {
    public static void main(String[] args) {
        SolutionCDIOI cd = new SolutionCDIOI();
        System.out.println(cd.hasSameDigits("3902"));
        System.out.println(cd.hasSameDigits("34789"));

    }
}
