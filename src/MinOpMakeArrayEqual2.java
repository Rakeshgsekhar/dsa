import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionMOMAE2 {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long operation = 0l;
        int n = nums1.length;
        int[] sub = new int[n];
        Map<Integer, List<Integer>> mapper = new HashMap<>();
        mapper.put(1,new ArrayList<>());
        mapper.put(-1,new ArrayList<>());
        for(int i = 0;i<n;i++){
            sub[i] = nums1[i]-nums2[i];
            if(sub[i] >0){
                mapper.get(1).add(i);
            }else if(sub[i]<0){
                mapper.get(-1).add(i);
            }
        }
        if(mapper.get(-1).size() == 0 || mapper.get(1).size() == 0) return -1;

        while(mapper.get(-1).size() != 0 && mapper.get(1).size() !=0){
            operation++;
            int addKIndex = mapper.get(-1).get(0);
            mapper.get(-1).remove(0);
            int addKResult = 0;
            if(sub[addKIndex]/k == 0) {
                addKResult=sub[addKIndex] + k;
                sub[addKIndex] = addKResult;
            }
            if(addKResult!=0) mapper.get(-1).add(addKIndex);

            int subKindex = mapper.get(1).get(0);
            mapper.get(1).remove(0);
            int subKResult = 0;
            if(sub[subKindex]/k == 0) {
                subKResult = sub[subKindex] - k;
                sub[subKindex] = subKResult;
            }else return -1;
            if(subKResult!=0) mapper.get(1).add(subKindex);

        }
        if(mapper.get(1).size()>0 || mapper.get(-1).size()>0) return -1;
        return operation;
    }

    private boolean hasNegative(int[] arr){
        for(int ar : arr){
            if(ar<0) return true;
        }
        return false;
    }

    private boolean allZeros(int[] nums){
        for(int num : nums){
            if(num!=0) return false;
        }
        return true;
    }
}
public class MinOpMakeArrayEqual2 {
    public static void main(String[] args) {
        SolutionMOMAE2 ssd = new SolutionMOMAE2();
        System.out.println(ssd.minOperations(new int[]{24,5,27,14,11,27},new int[]{20,14,20,33,22,15},6));
    }
}
