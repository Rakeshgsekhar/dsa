class SolutionPW4 {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        /*while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
        */

        int k = n>9? n%100:n;
        while(k%4==0){
            k/=4;
        }
        return k==1;


    }
}
public class PowerOfFour {
}
