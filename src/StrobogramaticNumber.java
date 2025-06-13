import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionSTG {
    /**
     * @param n: the length of strobogrammatic number
     * @return: All strobogrammatic numbers
     *          we will sort your return value in output
     */
    public List<String> findStrobogrammatic(int n) {
        // write your code here
        if(n == 0)
        if(n == 1) return new ArrayList<>(Arrays.asList("0","1","8"));
        List<String> result = new ArrayList<>();
        String[] strNum = new String[]{"0","1","6","8","9"};
        for(int i = 0;i<strNum.length;i++) {
            List<String> sb = new ArrayList<>();
            sb.add(strNum[i]);
            compute(strNum, result, n, sb, 0);
        }
        return result;
    }

    private void compute(String[]strNum,List<String> res,int n,List<String>  sb,int j){

    }

    private boolean isStrobogramatic(List<String> num){

        String number = String.join("",num);
        int n = number.length();
        int left = 0,right =n-1;
        while(left<right){
            if((number.charAt(left) == '6' && number.charAt(right) == '9') || (number.charAt(left) == '9' && number.charAt(right) == '6') ){
                left++;
                right--;
            }else if(number.charAt(left) == '0' && number.charAt(right) == '0'){
                left++;
                right--;
            }else if(number.charAt(left) == '1' && number.charAt(right) == '1'){
                left++;
                right--;
            }else if(number.charAt(left) == '8' && number.charAt(right) == '8'){
                left++;
                right--;
            }
            else{
                left++;
            }
        }

        if(right > 0) return false;
        return true;
    }
}
public class StrobogramaticNumber {
    public static void main(String[] args) {
        SolutionSTG stg = new SolutionSTG();
        System.out.println(stg.findStrobogrammatic(2));
    }
}
