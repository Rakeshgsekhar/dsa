import java.util.*;

class SolutionSN {
    public int singleNumber(int[] nums) {
        int result = 0;
        int[] res = new int[2];
        for(int i = 0;i<nums.length;i++){
            result = result^nums[i];
        }
        return result;
    }
    public int[] singleNumberiii(int[] nums) {
       //Arrays.sort(nums);
        int i = 0,j=1,k=2,n=nums.length;
        while(i<n && j<n ){
            if((nums[i]^nums[j]) == 0 ){
                nums[i] = 0;
                nums[j] = 0;
            }
            i++;
            j=i+1;
        }
        int[] ans = new int[2];
        for(int id = 0 ;id<n;id++){
            if(nums[id] != 0){
                ans[0] = nums[id];
            }
        }
        return ans;
        /*int result = 0;
        int[] res = new int[2];
        for(int i = 0;i<nums.length;i++){
            result = result^nums[i];
        }
        int diff = result & (-result);
        System.out.println(diff);
        int a = 0,b=0;
        for(int num : nums){
            if((num & diff) == 0){ a^=num;
                System.out.println(a);}
            else{
                b^=num;
                System.out.println(b);
            }
        }
        res[0] = a;
        res[1] = b;
        return res;*/
    }

    public int singleNumberii(int[] nums) {
       /* Arrays.sort(nums);
        int i = 0,j=1,k=2,n=nums.length;
        while(i<n && j<n && k<n){
            if((nums[i]^nums[j]) == 0 && (nums[j]^nums[k]) == 0){
                nums[i] = 0;
                nums[j] = 0;
                nums[k] = 0;
            }
            i++;
            j=i+1;
            k = j+1;
        }
        int ans = 0;
        for(int id = 0 ;id<n;id++){
            if(nums[id] != 0){
                ans = nums[id];
            }
        }
        return ans;*/

        int singleO = 0,double0 =0;
        for(int num : nums){
            singleO = (singleO^num) & ~double0;
            double0 = (double0^num) & ~singleO;
        }
        return singleO;
    }
}
public class SingleNumber {
    public static int[] generateLargeTestCase() {
        int tripleCount = 9999;
        int unique = Integer.MIN_VALUE; // or any distinct number
        Set<Integer> used = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        Random rand = new Random();

        // Generate 9999 unique values and repeat them 3 times
        while (used.size() < tripleCount) {
            int val = rand.nextInt();  // full 32-bit range
            if (val == unique || used.contains(val)) continue;
            used.add(val);
            list.add(val);
            list.add(val);
            list.add(val);
        }

        // Add the unique number
        list.add(unique);

        // Shuffle
        Collections.shuffle(list);

        // Convert to array
        return list.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {
        SolutionSN sn = new SolutionSN();
        System.out.println(sn.singleNumberiii(new int[]{1,2,2,3}));
        System.out.println(sn.singleNumberiii(new int[]{4,1,2,1,2,5}));
        System.out.println(sn.singleNumberiii(new int[]{1,0}));
//        System.out.println(sn.singleNumberii(new int[]{4,1,1,1}));
//        System.out.println(sn.singleNumberii(new int[]{0,1,0,1,0,1,99}));
//        System.out.println(sn.singleNumberii(new int[]{0,1,1,1}));
//        System.out.println(sn.singleNumberii(new int[]{2,2,2,3,4,4,4}));
//        System.out.println(sn.singleNumberii(new int[]{30000,500,100,30000,100,30000,100}));
//        System.out.println(sn.singleNumberii(new int[]{5, 7, -1, 5, 9, 5, -1, 9, 9, -1, 7, 7, 42}));
//        System.out.println(sn.singleNumberii(new int[]{7,7,7,2,2,2,4,4,4,6,6,6,1}));
//        System.out.println(sn.singleNumberii(new int[]{-3,-3,-3,-10}));
//        System.out.println(sn.singleNumberii(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 7}));
//        /*
//        Input: [1001, 1001, 1001, ..., 123456789]
//Output: 123456789
//
//         */
//        int[] test = generateLargeTestCase();
//        System.out.println(sn.singleNumberii(test));
    }
}
