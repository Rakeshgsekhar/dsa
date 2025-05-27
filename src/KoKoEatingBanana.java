class SolutionKOEB {
    public int minEatingSpeed(int[] piles, int h) {
        int[] minMax = findMinMax(piles);
        int left = 1;
        int right = minMax[1];
        while(left<right){
            int midSpeed = left+(right-left)/2;
            if(canEatAllBanana(piles,midSpeed,h)){
                right = midSpeed;
            }else{
                left = midSpeed+1;
            }
        }

        return left;
    }

    private boolean canEatAllBanana(int[] piles,int speed,int h){
        int timeLeft = 0;
        for(int bananas:piles){
            timeLeft+=(bananas+speed-1)/speed;
            if(timeLeft>h) return false;
        }
        return true;
    }
    private int[] findMinMax(int[]nums){
        int[] minMax = new int[2];
        minMax[0] = Integer.MAX_VALUE;
        minMax[1] = Integer.MIN_VALUE;
        for(int num:nums){
            minMax[0] = Math.min(minMax[0],num);
            minMax[1] = Math.max(minMax[1],num);
        }
        return minMax;
    }
}
public class KoKoEatingBanana {
}
