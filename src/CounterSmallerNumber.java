import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class SolutionCSN {
    int[] count;
    private int findInversionX(List<Integer> arr,int x){
        int left = 0;
        int right = arr.size()-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr.get(mid)>=x){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
       /* List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(arr);

        for(int n : nums){
            int count = findInversionX(arr,n);
            result.add(count);
            arr.remove(count);
        }*/
        int n = nums.length;
        count = new int[n];
        int [] indexs = new int[n];

        for(int i =0;i<n;i++){
            indexs[i] = i;
        }
        mergeAndSort(0,n-1,nums,indexs);

        for(int c : count){
            result.add(c);
        }
        return result;

    }

    private void mergeAndSort(int left,int right, int[]nums,int[] indexs){
        if(left>=right) return;
        int mid = left+(right-left)/2;
        mergeAndSort(left,mid,nums,indexs);
        mergeAndSort(mid+1,right,nums,indexs);

        mergeArray(left,mid,right,nums,indexs);
    }

    private void mergeArray(int left,int mid,int right,int[]nums,int[]indexs){
        int leftSize = mid-left+1;
        int rightSize = right-mid;
        int [] lArray = new int[leftSize];
        int [] rArray = new int[rightSize];

        System.arraycopy(indexs,left,lArray,0,leftSize);
        System.arraycopy(indexs,mid+1,rArray,0,rightSize);

        int i = 0,j=0,k=left,rightCount = 0;
        while(i<leftSize && j<rightSize){
            if(nums[lArray[i]]<= nums[rArray[j]]){
                indexs[k] = lArray[i];
                count[lArray[i]] += rightCount;
                i++;
            }else{
                indexs[k] = rArray[j];
                rightCount++;
                j++;
            }
            k++;
        }

        while(i<leftSize){
            indexs[k] = lArray[i];
            count[lArray[i]] += rightCount;
            i++;
            k++;
        }

        while(j<rightSize){
            indexs[k] = rArray[j];
            rightCount++;
            j++;
            k++;
        }
    }

}
public class CounterSmallerNumber {
    public static void main(String[] args) {
        SolutionCSN csn = new SolutionCSN();
        int[] nums = new int[]{5,2,6,1};
        List<Integer> result = csn.countSmaller(nums);
        System.out.println(result);
        for(int num : nums)
            System.out.println(num);
    }
}
