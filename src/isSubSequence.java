import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class isSubSequence {
    public static void main(String[] args) {
       boolean val =  isSubsequence("axc","ahbgdc");
    }
    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        int sLength = s.length();
        int tLength = t.length();
        while(sIndex<sLength && tIndex<tLength){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == sLength;
    }
}
