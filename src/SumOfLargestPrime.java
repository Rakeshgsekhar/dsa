import java.util.TreeSet;

class SolutionSLP {
    public long sumOfLargestPrimes(String s) {
        long sum = 0L;
        char[] cr = s.toCharArray();
        int start =0,end=0;
        int n = s.length();
        TreeSet<String> set = new TreeSet<>();
        StringBuilder sb = new StringBuilder(s);
        int k = 0;
        while(end<n){
            Long num = 0l;
            num = num*10+(s.charAt(end)-'0');
            if(isPrime(num)){

                while(isPrime(num)){
                    if(k<3) {
                        set.add(sb.substring(end++, n));
                        k++;
                    }else{
                        end++;
                    }
                }
            }
            n--;

        }

        for(String prime:set){
            sum+=Long.valueOf(prime);
        }

        return sum;
    }

    private boolean isPrime(long sl){
        if(sl<2) return false;
        long i = 2;
        while(i<sl/2){
            if(sl%i == 0) return false;

            i++;
        }
        return true;
    }
}
public class SumOfLargestPrime {
    public static void main(String[] args) {
        SolutionSLP slp = new SolutionSLP();
        System.out.println(slp.sumOfLargestPrimes("12234"));
        System.out.println(slp.sumOfLargestPrimes("111"));
    }
}
