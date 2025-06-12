import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionCBSS {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<candidates.length;i++) {
            List<Integer> arr = new ArrayList<>();
            arr.add(candidates[i]);
            compute(candidates, i, candidates[i], target, arr, result);
        }
        return result;
    }

    private void compute(int[]candidates,int index,int sum,int target,List<Integer> comb,List<List<Integer>> result){
        if(sum>target) return;
        if(sum == target) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for(int i = index;i<candidates.length;i++){
            comb.add(candidates[i]);
            sum+=candidates[i];
            compute(candidates,i,sum,target,comb,result);
            sum-=candidates[i];
            comb.remove(comb.size()-1);
        }
    }
}
public class CombinationSum {

    public static void main(String[] args) {
        SolutionCBSS cbs = new SolutionCBSS();
        System.out.println(cbs.combinationSum(new int[]{2,3,6,7},7));
    }
}
