public class MergeSortedArray {
    /*
    LeetCode easy .88 Top interview 150
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        int i =0,j=0;
        int k =0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                nums[k] = nums1[i];
                i++;
            }else{
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }

        if(i<m){
            while(i<m){
                nums[k++] = nums1[i++];
            }
        }

        if(j<n){
            while(j<n){
                nums[k++] = nums2[j++];
            }
        }
        for(int s = 0;s<m+n;s++)
            nums1[s] = nums[s];

    }

    /*

    int midx = m - 1;
        int nidx = n - 1;
        int right = m + n - 1;

        while (nidx >= 0) {
            if (midx >= 0 && nums1[midx] > nums2[nidx]) {
                nums1[right] = nums1[midx];
                midx--;
            } else {
                nums1[right] = nums2[nidx];
                nidx--;
            }
            right--;
        }
     */
}
