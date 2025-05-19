import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class SolutionCD3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        /*if(valueDiff<0) return false;
        int n = nums.length;
        if (n<=1) return false;
        Map<Long,Long> map = new HashMap<>();

        long bucketWidth = (long) valueDiff+2;
        for(int i = 0;i<n;i++){
            long id = getId(nums[i],bucketWidth);
            if(map.containsKey(id)) return true;
            if(map.containsKey(id-1l) && Math.abs(map.get(id-1l) - nums[i])<bucketWidth){
                return true;
            }
            if(map.containsKey(id+1l) &&  Math.abs(map.get(id+1l) - nums[i])<bucketWidth) {
                return true;
            }
            map.put(id,(long)nums[i]);
            if(i>=indexDiff){
                long removeid = getId(nums[i-indexDiff],bucketWidth);
                map.remove(removeid);
            }
        }
        return false;*/
    /*
        if(valueDiff == 0){
            HashMap<Integer,Integer> lookUp = new HashMap<>();
            for(int i = 0;i<nums.length;i++){
                if(lookUp.containsKey(nums[i]) && Math.abs(lookUp.get(nums[i]-i))<= valueDiff) return true;
                lookUp.put(nums[i],i);
            }
            return false;
        }

        int base = (int) Math.pow(10,9);
        HashMap<Integer,Integer> buckets = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            int key = (nums[i]+base)/valueDiff;
            if(buckets.containsKey(key)) return true;
            if(buckets.containsKey(key+1) && Math.abs(buckets.get(key+1) - nums[i]) <= valueDiff) return true;
            if(buckets.containsKey(key-1) && Math.abs(buckets.get(key-1) - nums[i]) <= valueDiff) return true;

            buckets.put(key,nums[i]);
            if(buckets.size()>indexDiff){
                int keyToRemvoe = (nums[i-indexDiff]+base)/valueDiff;
                buckets.remove(keyToRemvoe);
            }
        }

        return false;

     */

        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0;i<nums.length;i++){
            Long floorValue = set.ceiling((long)nums[i] - (long) valueDiff);
            if(floorValue != null && floorValue<=(long)nums[i] + (long) valueDiff){
                return true;
            }
            set.add((long)nums[i]);
            if(i>=indexDiff){
                set.remove((long)nums[i-indexDiff]);
            }
        }
        return false;
    }

    private long getId(int val,long bucketWidth){
        long id = Math.floorDiv(val,bucketWidth); //val<0?(val+1L)/(bucketWidth-1l):val/bucketWidth;
        return id;
    }
}
public class ContainsDuplicate3 {
}
