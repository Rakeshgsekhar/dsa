import java.util.Map;

class SolutionPWL {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] result = new long[queries.length];
        int idx = 0;
        for(int query:queries){
            long half = (intLength/2);
            long start = (long) Math.pow(10,half-1);
            long end = (long) Math.pow(10,half)-1;
            long upperLimit = end-start+1;
            if(query<=upperLimit){
                String firstHalf = ((start+query-1))+"";
                String secondHalf = new StringBuilder(firstHalf).reverse().toString();
                result[idx++] = Long.parseLong(firstHalf+secondHalf.substring(intLength%2));
            }else{
                result[idx++] = -1;
            }
        }
        return result;

    }
}
public class PaliandromWithFixedLength {
}
