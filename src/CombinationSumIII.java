import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>result = new ArrayList<>();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        buildCombinations(result,new ArrayList<>(),nums,0,k,n);

        return result;
    }

    private void buildCombinations(List<List<Integer>>result,List<Integer> temp,int[] nums,int currentIndex,int k,int n){
        if(currentIndex == nums.length){
            if(n==0 && temp.size()==k){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        if(nums[currentIndex] <= n){
            temp.add(nums[currentIndex]);
            buildCombinations(result,temp,nums,currentIndex+1,k,n-nums[currentIndex]);
            temp.remove(temp.size()-1);
        }

        buildCombinations(result,temp,nums,currentIndex+1,k,n);



    }
}
