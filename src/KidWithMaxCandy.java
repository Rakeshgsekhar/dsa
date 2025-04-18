import java.util.ArrayList;
import java.util.List;

public class KidWithMaxCandy {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int l1 = candies.length;
        int max = 0;
        for(int candy:candies){
            max = candy>max?candy:max;
        }
        List<Boolean> ans  = new ArrayList<>();
        for(int candy : candies){
            ans.add(candy+extraCandies >= max);
        }

        return ans;
    }
}
