import java.util.HashSet;
import java.util.Set;

class SolutionCNSNS {
    public long countNoZeroPairs(long n) {
        /*Set<String> pairs = new HashSet<>();
        for(long i = 1;i<n;i++){
            BSearchFind(1,(n-1)/2,i,n,pairs);
        }
        System.out.println(pairs.size());
        System.out.println(pairs);*/

//        String s = "(()(";
//        StringBuilder sb = new StringBuilder("(()(");
//        String toRemove = "()";
//        do{
//            s = s.replace(toRemove,"");
//            System.out.println(s);
//        }while(s.contains(toRemove));
//        System.out.println(s);
        return 0L;
    }

    private void BSearchFind(long left,long right, long a,long target,Set<String> pairs){
        while(left<=right){
            long mid = left + (right-left)/2;
            if(a+mid > target) right = mid;
            else if((a+mid) < target) left = mid+1;
            else {
                if(nonZero(mid) && nonZero(a)){
                    pairs.add(a+","+mid);
                }
                return;
            }
        }
    }

    private boolean nonZero(long n){
        return Long.toString(n).indexOf("0") == -1;
    }
}
public class NonZeroSumN {
    public static void main(String[] args) {
        SolutionCNSNS s = new SolutionCNSNS();
        s.countNoZeroPairs(11l);
        s.countNoZeroPairs(2l);
        s.countNoZeroPairs(3l);
    }
}
