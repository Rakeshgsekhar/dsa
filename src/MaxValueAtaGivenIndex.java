class SolutionMVGIBA {
    public int maxValue(int n, int index, int maxSum) {
        int min = 1;
        int ans = 0;
        int max = maxSum;
        while(min<max){
            int mid = min+(max-min)/2;
            if(validateMid(n,index,maxSum,mid)){
                min = mid;
            }else{
                max = mid-1;
            }
        }
        return min;
    }
    private boolean validateMid(int n,int index,int maxSum,int val){
        long sum = val;

        sum+= sideSum(val-1,index);
        sum+= sideSum(val-1,n-index-1);

        return sum <= maxSum;
    }

    private long sideSum(int peak,int index){
        if(peak>=index){
            long first = peak-index+1;
            long last = peak;
            return (first+last)*index/2;
        }else{
            long first = (long)(peak+1)*peak/2;
            long last = index-peak;
            return first+last;
        }
    }
}
public class MaxValueAtaGivenIndex {
    public static void main(String[] args) {
        SolutionMVGIBA mv = new SolutionMVGIBA();
        System.out.println(mv.maxValue(4,2,6));
        System.out.println(mv.maxValue(6,1,10));
        System.out.println(mv.maxValue(4 ,0,4));
    }
}
