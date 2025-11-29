import java.util.ArrayList;
import java.util.List;

class SolutionDOSS {
    public int numberOfSubstrings(String s) {
        int zeros =0,ones=0,n = s.length();
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == '1') ones++;
            else zeros++;
        }
        int dominant = 0;

        int temp0 = zeros;
        int temp1 = ones;

        int l = 0;
        List<String> map = new ArrayList<>();
        boolean isDominantString = false;
        if(ones>=(zeros*zeros)) {
            dominant++;
            isDominantString = true;
            map.add(0+""+(n-1));
        }
       // int r = isDominantString?n-2:n-1;
        for(int r = n-2;r>=0;r--){
            String key = l+""+r;
            if(!map.contains(key)){
                if(s.charAt(r+1) == '1'){
                    temp1--;
                }else{
                    temp0--;
                }
            }

            //if(temp0>0 && temp1>0){
                if(temp1>=(temp0*temp0)) {
                    dominant++;
                    map.add(key);
                }

            //}
        }
        int rt = n-1;
        temp0 = zeros;
        temp1 = ones;
        for(int lt = 1;lt<n;lt++){
            String key = lt+""+rt;
            if(!map.contains(key)){
                if(s.charAt(lt-1) == '1'){
                    temp1--;
                }else{
                    temp0--;
                }
//            }

            //if(temp0>0 && temp1>0){
                if(temp1>=(temp0*temp0)) {
                    dominant++;
                    map.add(key);
                }

            }
        }

        int left = 1,right = n-2;
        temp0 = zeros;
        temp1 = ones;
        while(left<right){
            String key = left+""+right;
            if(!map.contains(key)) {
                if (s.charAt(left - 1) == '1') {
                    temp1--;
                } else {
                    temp0--;
                }
                if (s.charAt(right + 1) == '1') {
                    temp1--;
                } else {
                    temp0--;
                }


                //if(temp0>0 && temp1>0){
                if (temp1 >= (temp0 * temp0)) {
                    dominant++;
                    map.add(key);
                }
            }
            left++;
            right--;
            //}
        }

        return dominant;
    }
}
public class DominantOnesSubString {
    public static void main(String[] args) {
        SolutionDOSS doss = new SolutionDOSS();
        System.out.println(doss.numberOfSubstrings("00011"));
    }
}
