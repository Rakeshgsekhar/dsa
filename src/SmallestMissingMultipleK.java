import java.util.ArrayList;
import java.util.List;

class SolutionSMMK {
    public int missingMultiple(int[] nums, int k) {
       List<Integer> multi = new ArrayList<>();
        for(int i=1;i<=100;i++){
            multi.add(i*k);
        }
        for(int num : nums){
            if(num>=k && num%k ==0 && !multi.contains(num)){
                return num;
            }
        }
        return k;

    }
}
public class SmallestMissingMultipleK {
    public static void main(String[] args) {
        SolutionSMMK sm = new SolutionSMMK();
        System.out.println(sm.missingMultiple(new int[]{1,4,7,10,15},5));
    }
}
