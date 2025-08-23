
class SolutionRSR {
    public void reverseString(char[] s) {
        char rs[] = new char[s.length];
        reverseString(s,rs,s.length-1,0);
        System.out.println(s);
        System.out.println(rs);
    }
    private void reverseString(char[]s,char rs[],int n,int idx){
        if(n<0) return;
        rs[idx++] = s[n--];
        reverseString(s,rs,n,idx);
    }
}
public class ReverseStringRecuraion {
    public static void main(String[] args) {
        SolutionRSR rs = new SolutionRSR();
        rs.reverseString(new char[]{'a','b','c','d'});
    }
}
