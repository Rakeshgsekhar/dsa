import java.util.Arrays;

class SolutionSP {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;
        return Arrays.stream(spells).map(spell->{
            int low = potions[0];
            int high = potions[m-1];
            while(low<high){
                int mid = low+(high-low)/2;
                if(spell*potions[mid] >= success){
                    high = mid;
                }else{
                    low = mid+1;
                }
            }
            return m-low;
        }).toArray();

    }
}
public class SpellAndPotions {
    public static void main(String[] args) {
        SolutionSP sp = new SolutionSP();
        int[]pairs = sp.successfulPairs(new int[]{5,1,3},new int[]{1,2,3,4,5},7);
        for(int n : pairs){
            System.out.println(n);
        }
    }
}
