import java.util.Arrays;

public class MaxProductContest {
    public static int maxProduct(int n) {
        int maxProduct = 1;
        if(n>10 && n<99){
            int k = n%10;
            n = n/10;
            return n*k;
        }else{
            String s = String.valueOf(n);
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            int len = ch.length-1;
            return (int)(ch[len]-'0')*(int)(ch[len-1]-'0');
//            System.out.println(ch);
        }
        //return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(89798112));
    }
}
