class Solution {
    public int minStable(int[] nums, int maxC) {
        int l = 0;
        int r = nums.length+1;
        int n = nums.length;

        while(l+1<r){
            int mid = l+(r-l)/2;
            if(stableSubArrayLen(nums,n,mid)>=maxC){
                r = mid;
            }else {
                l = mid;
            }
        }
        return l;
    }

    private int stableSubArrayLen(int[] nums,int n,int len){
        int count = 0;
        for(int i = 0;i+len-1<n;){
            int temp =  nums[i],j=i+1;
            while(j<i+len && temp >1){
                temp = gcd(temp,nums[j]);
                j++;
            }
            if(temp>1){
                count++;
                i+=len;
            }else{
                i++;
            }
        }
        return count;
    }

    private int gcd(int a, int b){
        while (b!=0){
            int t = a%b;
            a=b;
            b=t;
        }
        return a;
    }
}
public class MinStabilityFactor {
}
