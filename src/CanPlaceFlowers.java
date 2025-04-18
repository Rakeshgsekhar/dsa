public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int newSlots = 0;
        int nb = flowerbed.length;
        if(n == 0) return true;
        if(nb==1){
            if(n==1)
                return flowerbed[0] == 0;
            else return false;
        }
        for(int i = 0;i<nb;i++){
            if(i==0) {
                if(flowerbed[i] == 0 && flowerbed[i+1] == 0){
                    newSlots++;
                    flowerbed[i] = 1;
                }
            }
            else if(i==nb-1){
                if(flowerbed[nb-1]==0 && flowerbed[nb-1-1] == 0){
                    newSlots++;
                }
            }
            else{
                if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                    newSlots++;
                    flowerbed[i] =1;
                }
            }
        }
        return newSlots>=n;

    }
}
