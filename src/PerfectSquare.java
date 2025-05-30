class SolutionPS {
    public boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1) return true;

        int left = 1;
        int right = num/2;
        while(left<=right){
            int mid = left+ (right-left)/2;
            if(mid*mid == num) return true;
            else if(mid*mid < num){
                left++;
            }else{
                right--;
            }
        }
        System.out.println(left);
        System.out.println(Math.sqrt(num));
        return false;
    }
}
public class PerfectSquare {
    public static void main(String[] args) {
        SolutionPS ps = new SolutionPS();
        System.out.println(ps.isPerfectSquare(808201));
    }
}
