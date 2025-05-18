import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionSCF {
    public String frequencySort(String s) {
        int[] bucket = new int[128];
        for(char ch:s.toCharArray()){
            bucket[ch]+=1;
        }
        StringBuilder result = new StringBuilder();
        int n = s.length();
        for(int i = 0;i<n;i++){
            int max = getMaxValue(bucket);
            while(bucket[max]>0){
                char ch = (char) max;
                result.append(ch);
                bucket[max]--;
            }
            bucket[max] = 0;

        }
        return result.toString();
    }
    public static int getMaxValue(int[] bucket)
    {
        int maxi=0;
        int max=0;
        for(int i=0;i<bucket.length;i++)
        {
            if(bucket[i]>max)
            {
                maxi=i;
                max=bucket[i];
            }
        }
        return maxi;
    }
}
public class SortCharOnFreq {
    public static void main(String[] args) {
        SolutionSCF scf = new SolutionSCF();
        scf.frequencySort(new String("tree"));
        scf.frequencySort("Aabb");
    }
}
