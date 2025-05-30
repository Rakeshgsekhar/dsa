import java.util.Arrays;

class SolutionRPWW {
    int[] prob;
    int rangeLimit;
    int sum;
    public SolutionRPWW(int[] w) {
        int n = w.length;
        rangeLimit = n-1;
        prob = new int[n];
        sum = w[0];
        prob[0] = w[0];

        for(int i = 1;i<n;i++){
            prob[i] = prob[i-1]+w[i];
            sum+=w[i];
        }

    }

    public int pickIndex() {
//        Arrays.sort(prob);
        int target = (int)(Math.random()*sum)+1;
        System.out.println(target);
        int left = 0;
        int right = rangeLimit;
        int index = right;
        while(left<right){
            int mid = left+(right-left)/2;
            if(prob[mid]>= target){
                index = mid;
                right = mid;
            }else{
                left = mid+1;
            }
        }
//        System.out.println(sum);
        return index;
    }
}
public class RandumPickWithWeight {
    public static void main(String[] args) {
        SolutionRPWW s = new SolutionRPWW(new int[]{3,14,1,7});
        for(int i = 0;i<10000;i++) {
            s.pickIndex();
        }
//        System.out.println(s.pickIndex());
//        System.out.println(s.pickIndex());
//        System.out.println(s.pickIndex());
//        System.out.println(s.pickIndex());
//        System.out.println(s.pickIndex());


    }
}
