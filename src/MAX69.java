class SolutionMx69 {
    public int maximum69Number (int num) {
            int result = 0;
            char [] s = String.valueOf(num).toCharArray();
            for (int i = 0;i<s.length;i++){
                if(s[i] == '6'){
                    s[i] = '9';
                    break;
                }
            }
            for(char ch : s){
                result = (result*10+ ch-'0');
            }
            return result;
    }
}
public class MAX69 {
    public static void main(String[] args) {
        SolutionMx69 mx69 = new SolutionMx69();
        System.out.println(mx69.maximum69Number(9669));
    }
}
