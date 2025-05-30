import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class SolutionRDE {
    public int maxEnvelopes(int[][] envelopes) {
        int noOfEnvelopes = 0;
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int[] envelopedList = new int[envelopes.length+1];
        Arrays.fill(envelopedList,Integer.MAX_VALUE);
        envelopedList[0] = Integer.MIN_VALUE;
        for(int envelop[] : envelopes){
            int height = envelop[1];
            int indexInserted = canFitTheEnvelope(envelopedList,height);
            noOfEnvelopes = Math.max(noOfEnvelopes,indexInserted);
            if(envelopedList[indexInserted]>=height){
                envelopedList[indexInserted] = height;
            }
        }

        return noOfEnvelopes;
    }

    private int canFitTheEnvelope(int[] envelope, int target){
        int smallet = 0,largest = envelope.length-1,res = 0;
        while(smallet<=largest){
            int mid = smallet+(largest-smallet)/2;
            if(envelope[mid]<target){
                res = mid;
                smallet = mid+1;

            }else{
                largest = mid-1;
            }
        }

        return res+1;
    }
}
public class RussianDollEnvolops {
    public static void main(String[] args) {
        SolutionRDE rde = new SolutionRDE();
        System.out.println(rde.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
        System.out.println(rde.maxEnvelopes(new int[][]{{1,1},{1,1},{1,1}}));
        System.out.println(rde.maxEnvelopes(new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}}));
        System.out.println(rde.maxEnvelopes(new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1},{1,1}}));
    }
}
