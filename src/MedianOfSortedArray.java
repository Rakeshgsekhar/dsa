import java.util.Arrays;

class SolutionMSA {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
        double median = 0.0;
        int n = nums1.length;
        int m = nums2.length;
        int [] arr = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                arr[k++] = nums1[i++];
            }else{
                arr[k++] = nums2[j++];
            }
        }

        while(i<n){
            arr[k++] = nums1[i++];
        }

        while(j<m){
            arr[k++] = nums2[j++];
        }
        Arrays.sort(arr);
        int mn = m+n;
        if(mn%2 !=0){
            median = (double) arr[mn/2];
        }else{
            int index = mn/2;
            median = (double)(arr[index]+arr[index-1])/2;
        }
        return median;
        Brute force O(m+n);
         */

        double median = 0.0;
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);
        int n = nums1.length;
        int m = nums2.length;;
        int left = 0;
        int right = n;
        while(left<=right){
            int partitionN = (right+left)/2;
            int partitionM = (n+m+1)/2 - partitionN;
            int maxLeftN = (partitionN == 0)?Integer.MIN_VALUE:nums1[partitionN-1];
            int minRightN = (partitionN == n)?Integer.MAX_VALUE:nums1[partitionN];
            int maxLeftM = (partitionM == 0)?Integer.MIN_VALUE:nums2[partitionM-1];
            int minRightM = (partitionM == m)?Integer.MAX_VALUE:nums2[partitionM];

            if(maxLeftN<=minRightM && maxLeftM<=minRightN){
                if((n+m)%2==0) {
                    median = (double) (Math.max(maxLeftM, maxLeftN) + Math.min(minRightN, minRightM)) / 2;
                    break;
                }
                else {
                    median = (double) Math.max(maxLeftM, maxLeftN);
                    break;
                }
            }else if(maxLeftN>minRightM){
                right = partitionN-1;
            }else{
                left = partitionN+1;
            }
        }
        return median;
    }
}
public class MedianOfSortedArray {
    public static void main(String[] args) {
        SolutionMSA msa = new SolutionMSA();
        System.out.println(msa.findMedianSortedArrays(new int[]{1,3},new int[]{2}));
        System.out.println(msa.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }
}
