import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionSMR {
    public List<String> summaryRanges(int[] nums) {
       /* if(nums.length == 0) return new ArrayList<>();
        if(nums.length == 1) Arrays.asList(nums);

        List<String> result = new ArrayList<>();
        int i = 0,j=1;
        int n = nums.length;
        List<String>nm = new ArrayList<>();
        while(i<n){
            if(j >= n){
                nm.add(String.valueOf(nums[i]));
                String r = "";
                if(nm.size() != 1)
                    r = nm.get(0)+"->"+nums[i];
                else{
                    r = String.valueOf(nums[i]);
                }
                result.add(r);
                i = j;
                j=i+1;
                nm = new ArrayList<>();
            }
            else if(nums[j]-nums[i] == 1){
                nm.add(String.valueOf(nums[i]));
                i++;
                j = i+1;
            }else{
                nm.add(String.valueOf(nums[i]));
                String r = "";
                if(nm.size() != 1)
                    r = nm.get(0)+"->"+nums[i];
                else{
                    r = String.valueOf(nums[i]);
                }
                result.add(r);
                i = j;
                j=i+1;
                nm = new ArrayList<>();

            }
        }
        return result;
        */

        List<String> result = new ArrayList<String>();
        int i = 0;
        while(i < nums.length){
            int start = i;
            i++;
            while(i < nums.length && nums[i] == nums[i - 1] + 1){
                i++;
            }
            int end = i - 1;
            StringBuilder tmp = new StringBuilder();
            if(start == end){
                tmp.append(nums[start]);
            }else{
                tmp.append(nums[start]).append("->").append(nums[end]);
            }
            result.add(tmp.toString());
        }

        return result;
    }
}
public class SummaryRanges {
    public static void main(String[] args) {
        SolutionSMR sr = new SolutionSMR();
        System.out.println(sr.summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println(sr.summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
}
