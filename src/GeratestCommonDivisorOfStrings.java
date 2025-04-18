import com.sun.source.tree.UsesTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GeratestCommonDivisorOfStrings {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC","ABC"));
        System.out.println(gcdOfStrings("ABABAB","ABAB"));
        System.out.println(gcdOfStrings("LEET","CODE"));
        System.out.println(gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX","TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        // a+b == b+a if not equal return ""
        //else find gcd of two staring length, get substring return ans
        //Euclid's algorithm

        if(!(str1+str2).equals(str2+str1)) return "";
        int gcd = 0;
        int l1 = str1.length(),l2 = str2.length();
        while (l2 != 0){
            int temp = l1%l2;
            l1 = l2;
            l2 = temp;
        }
        gcd = l1;

        return str1.substring(0,gcd);
    }
}
