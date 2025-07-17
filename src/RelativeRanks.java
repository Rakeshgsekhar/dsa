import java.util.HashMap;
import java.util.Map;

class SolutionRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        /*Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<score.length;i++){
            map.put(score[i],i);
        }
        heapSort(score);
        return new String[]{};*/
        int n = score.length;
        int maxScore = 0;
        for(int num:score){
            maxScore = Math.max(maxScore,num);
        }
        int [] scoreIndex = new int[maxScore+1];
        for(int i = 0;i<n;i++){
            scoreIndex[score[i]]=i+1;
        }
        String [] ans = new String[n];
        int rank = 0;
        for(int i = maxScore;i>=0;i--){
            if(scoreIndex[i] == 0) continue;
            int index = scoreIndex[i]-1;
            if(index==1){
                ans[rank] = "Gold Medal";
            }else if (index==2) ans[rank] = "Silver Medal";
            else if (index==3) ans[rank] = "Bronze Medal";
            else ans[rank] = String.valueOf(index);

            rank++;
        }
        return ans;
    }

    private void heapSort(int[] score){
        for(int i = (score.length-1)/2;i>=0;i--){
            heapify(score,i,score.length);
        }
    }
    private void heapify(int[]arr,int i,int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if(left<size && arr[left]>arr[largest]){
            largest = left;
        }
        if(right<size && arr[right]>arr[largest]){
            largest = right;
        }

        if(largest!=i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i]= temp;
            heapify(arr,largest,size);
        }
    }
}
public class RelativeRanks {
    public static void main(String[] args) {
        SolutionRelativeRanks rvr = new SolutionRelativeRanks();
        rvr.findRelativeRanks(new int[]{10,3,8,9,4});
    }
}
