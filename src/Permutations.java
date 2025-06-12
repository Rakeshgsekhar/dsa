import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionP {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            Set<Integer> set = new HashSet<>();
            set.add(i);
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            compute(nums,i,set,temp,result);
        }

        return result;
    }

    private void compute(int[] nums, int index, Set<Integer> collected,List<Integer> perm,List<List<Integer>> result){
        if(perm.size() == nums.length){
            result.add(new ArrayList<>(perm));
            return;
        }
        for(int i = 0;i< nums.length;i++){
            if(!collected.contains(i)){
                collected.add(i);
                perm.add(nums[i]);
                compute(nums,i,collected,perm,result);
                collected.remove(i);
                perm.remove(perm.size()-1);
            }
        }
    }
}
public class Permutations {
    public static void main(String[] args) {
        SolutionP perm = new SolutionP();
        System.out.println(perm.permute(new int[]{1,2,3}));
        System.out.println(perm.permute(new int[]{0,1}));
        System.out.println(perm.permute(new int[]{1}));
    }
}
