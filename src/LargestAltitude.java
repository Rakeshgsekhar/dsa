public class LargestAltitude {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;
        int n = gain.length;
        for(int i = 0;i<n;i++){
            currentAltitude+=gain[i];
            if(currentAltitude>maxAltitude){
                maxAltitude = currentAltitude;
            }
        }
        return maxAltitude;
    }
}
