import java.util.Arrays;
import java.util.Collections;

class SolutionRA {
    public int minSetSize(int[] arr) {
        int len = arr[0];
        for(int i = 1;i<arr.length;i++){
            len = Math.max(len,arr[i]);
        }

        int[] freq = new int[len+1];
        int n = arr.length;
        for(int i = 0;i<arr.length;i++){
            freq[arr[i]]++;
        }

        Arrays.sort(freq);
        int sum = n;
        int index = freq.length-1;
        int count = 0;
        while(sum>n/2){
            sum-=freq[index--];
            count++;
        }

        return count;
    }
}
public class ReduceArray {
    public static void main(String[] args) {
        SolutionRA ra = new SolutionRA();
        System.out.println(ra.minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
        System.out.println(ra.minSetSize(new int[]{7,7,7,7,7,7}));
    }
}
