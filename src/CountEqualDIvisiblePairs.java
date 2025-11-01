import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionCEDP {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        int pairs = 0;
        for(int i = 0;i<n;i++){
            if(map.containsKey(nums[i])){
                List<Integer> indices = map.get(nums[i]);
                for(int index : indices){
                    if(index<i && (index*i)%k ==0) pairs++;
                }
                map.get(nums[i]).add(i);
            }else{
                map.computeIfAbsent(nums[i],K->new ArrayList<>()).add(i);
            }
        }
        return pairs;
    }
}
public class CountEqualDIvisiblePairs {
    public static void main(String[] args) {
        SolutionCEDP cedp = new SolutionCEDP();
        System.out.println(cedp.countPairs(new int[]{3,1,2,2,2,1,3},2));
    }
}
