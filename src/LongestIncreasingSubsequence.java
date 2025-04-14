import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int n:nums){
            if(res.isEmpty() || res.get(res.size()-1)<n){
                res.add(n);
            }else{
                int index = binarySearch(res,n);
                res.set(index,n);
            }
        }

        return  res.size();
    }
    public int binarySearch(List<Integer>res,int target){
        int left = 0,right=res.size()-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(res.get(mid)==target) return mid;
            else if(res.get(mid)<target) left = mid+1;
            else right = mid-1;
        }
        return left;
    }
}
