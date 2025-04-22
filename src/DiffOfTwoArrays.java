import java.util.*;
import java.util.stream.Collectors;

public class DiffOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
       List<List<Integer>> result = new ArrayList<>();
       Set<Integer> n1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
       Set<Integer> n2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
       for(int n : n2){
           if(!n1.contains(n)){
               l2.add(n);
           }
       }

        for(int n : n1){
            if(!n2.contains(n)){
                l1.add(n);
            }
        }

        result.add(l1);
        result.add(l2);

       return result;
    }
}
