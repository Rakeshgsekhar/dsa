
class SortL {
    public int[] sortSelection(int[] nums) {
        /**
         * find min and swap
         */
        int n = nums.length;
        for (int i = 0; i <= n - 2; i++) { //n
            int min = i;
            int j = i;
            while (j <= n - 1) {//n-1
                if (nums[j] < nums[min]) {
                    min = j;
                }
                j++;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }

        return nums;
        /**+
         * n(n+1)/2 -> (n2+n)/2 ~ O(n^2) best avg worst
         */
    }

    public int[] sortBubble(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 1; i--) {
            int didSwap = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    didSwap = 1;
                }
            }
            if (didSwap == 0) break;
        }
        return nums;
        /**
         * n+n-1+n-2+n-3....1 -> n(n+1)/2 = (n2+n)/2 ~ n2
         */
    }

    public int[] sortInsertion(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n - 1; i++) {
            int j = i;
            while (j > 0 && nums[j - i] > nums[j]) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
        }
        return nums;
        /**
         * 0+1+2+3+5+6...n-1 => n (n+1)/2 => (n2+n)/2 ~ n2 (worst and Avg) O(n) best case
         */
    }
}
public class LinearSort {
    public static void main(String[] args) {
        SortL sl = new SortL();
        int[]nums4 = new int[]{-49500,-4,2,5,7,9,1,3};
        int[] res = sl.sortSelection(nums4);

        for(int num:res){
            System.out.println(num);
        }

        int[] res2 = sl.sortBubble(nums4);

        for(int num:res2){
            System.out.println(num);
        }

        int[] res3 = sl.sortInsertion(nums4);

        for(int num:res3){
            System.out.println(num);
        }

    }
}
