class SolutionRP {

    public int reversePairs(int[] nums) {
        int count = 0;
        int left = 0;
        int right = nums.length;

       count = mergeAndSort(left,right-1,nums);

        return count;
    }

    private int mergeAndSort(int left,int right,int[]nums){
        if(left>=right) return 0;
        int mid = left+(right-left)/2;
        int c1 = mergeAndSort(left,mid,nums);
        int c2 = mergeAndSort(mid+1,right,nums);
        int pairs = c1+c2;
        System.out.println(pairs);
        int k = mid+1;
        for(int i = left;i<=mid;i++){
            while(k<=right && nums[i] > 2L*nums[k]){
                k++;
            }
            pairs+= k-(mid+1);
        }
        merge(left,mid,right,nums);
        return pairs;
    }
    private void merge(int left,int mid,int right,int[] nums){
        int ln = mid-left+1;
        int rn = right-mid;
        int[] lArr = new int[ln];
        int[] rArr = new int[rn];

        System.arraycopy(nums,left,lArr,0,ln);
        System.arraycopy(nums,mid+1,rArr,0,rn);

        int i = 0,j=0,k=left;

        while(i<ln && j<rn){
            if(lArr[i]<rArr[j]){
                nums[k++] = lArr[i++];
            }else{
                nums[k++] = rArr[j++];
            }
        }

        while(i<ln){
            nums[k++] = lArr[i++];
        }

        while(j<rn){
            nums[k++] = rArr[j++];
        }

    }
}
public class ReversePairs {
    public static void main(String[] args) {
        SolutionRP rp = new SolutionRP();
        System.out.println(rp.reversePairs(new int[]{1,3,2,3,1}));
    }
}
