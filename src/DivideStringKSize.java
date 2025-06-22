class SolutionDSK {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length()%k == 0 ? s.length()/k : (s.length()/k)+1;
        String [] res = new String[n];
        int idx = 0;
        int temp = k;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(temp == 0){
                res[idx++] = sb.toString();
                sb = new StringBuilder();
                temp = k;
            }
            sb.append(s.charAt(i));
            temp--;
        }

        if(temp!=0){
            while(temp>0){
                sb.append(fill);
                temp--;
            }
        }
        res[n-1] = sb.toString();

        return res;
    }
}
public class DivideStringKSize {
    public static void main(String[] args) {
        SolutionDSK dsk = new SolutionDSK();
        dsk.divideString("abcdefghij",3,'x');
    }
}
