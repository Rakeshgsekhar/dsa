class SolutionRB {
    // you need treat n as an unsigned value
    public int reverseBits(long n) {
        /*StringBuilder res = new StringBuilder(Long.toBinaryString(n));
        System.out.println(res.length());
        String reverse = res.reverse().toString();
        int i = res.length();
        while(i<32){
            reverse = reverse.concat("0");
            i++;
        }

        System.out.println(reverse);

        int revN = reverse.length()-1;
        int reverseN = 0;
        int base = 1;
        while(revN>=0){
            int l = reverse.charAt(revN--)-'0';
            reverseN += l*base;
            base = base*2;

        }
        return  reverseN;

         */
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;          // Left shift result to make room for next bit
            System.out.println(result);
            result |= (n & 1);     // Add last bit of n to result
            System.out.println(result);
            n >>= 1;               // Right shift n to get next bit
        }
        return result;
    }
}
public class ReverseBits {
    public static void main(String[] args) {
        SolutionRB rb = new SolutionRB();
        System.out.println(rb.reverseBits(43261596));;
    }
}
