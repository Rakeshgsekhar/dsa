import java.util.Arrays;

class SolutionC {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n==1){
            return 1;
        }
        int[] candies = new int[n];
        Arrays.fill(candies,1);
        int peak = n;
        int valley = n;
        // First iteration\
        for(int i = 1;i<n;i++){
            if(ratings[i] > ratings[i-1] && candies[i]<=candies[i-1] ){
                int candy = Math.min(candies[i-1]+1,candies[i-1]+candies[i]);
                if(candy> candies[i-1])
                    candies[i] = candy;
                else
                    candies[i]+=candies[i-1];
            }
        }
        //second
        for(int i = n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1] && candies[i]<=candies[i+1]){
                int candy = Math.min(candies[i+1]+1,candies[i+1]+candies[i]);
                if(candy > candies[i+1])
                    candies[i] = candy;
                else
                    candies[i]+=candies[i+1];
            }
        }
        int totalCandies=0;
        for(int i = 0;i<n;i++){
            totalCandies+=candies[i];
        }


        return totalCandies;
    }
}
public class Candy {
    public static void main(String[] args) {
        int[] t1 = new int[]{1,0,2,3,4,5,6,1,0,1,1,5};
        int[] t2 = new int[]{1,6,10,8,7,3,2};

        SolutionC candy = new SolutionC();

        System.out.println(candy.candy(t1));
        System.out.println(candy.candy(t2));

    }
}
