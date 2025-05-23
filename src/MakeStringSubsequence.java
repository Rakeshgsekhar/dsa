class SolutionMSS {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i =0,j=0;
        char[] st1 = str1.toCharArray();
        char[] st2 = str2.toCharArray();

        int n1 = st1.length;
        int n2 = st2.length;

        while(i<n1 && j<n2){
            if(st1[i] == st2[j]){
                //i++;
                j++;
            }else{
                char nextI = st1[i];
                if(nextI == 'z'){
                    nextI = 'a';
                }else{
                    nextI+=1;
                }
                if(nextI == st2[j]){
                    //i++;
                    j++;
                }
            }
            i++;
        }

        return j>=n2;
    }
}
public class MakeStringSubsequence {
    public static void main(String[] args) {
        SolutionMSS mss = new SolutionMSS();
        System.out.println(mss.canMakeSubsequence("abc","ad"));
        System.out.println(mss.canMakeSubsequence("zc","ad"));
       System.out.println(mss.canMakeSubsequence("ab","abc"));
    }
}
