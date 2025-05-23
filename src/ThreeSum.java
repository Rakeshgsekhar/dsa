import java.util.*;

class Solution3SM {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
       /* Set<List<Integer>> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i =0;i<n;i++){
            map.put(nums[i],i);
        }

        for(int i = 0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = nums[i];
            for(int j = 0;j<n;j++){
                if(i!=j) {
                    int sum = nums[j]+target;
                    int key = -1*sum;
                    int kId = map.getOrDefault(key,-1);
                    if(kId != -1 && kId!=j && kId!= i ){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[kId]);
                        temp.sort(null);
                        set.add(temp);
                    }
                }
            }
        }*/

        Arrays.sort(nums);
        for(int i = 0;i< nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while(nums[j] == nums[j-1] && j<k){
                        j++;
                    }
                    while(nums[k] == nums[k+1]) k--;
                }
            }
        }

       /* for(List<Integer> ls : set)
            res.add(ls);*/
        return res;
    }
}
public class ThreeSum {

    public static void main(String[] args) {
        Solution3SM sm = new Solution3SM();
        System.out.println(sm.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
