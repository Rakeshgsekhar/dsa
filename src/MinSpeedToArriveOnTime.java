import java.util.Arrays;

class SolutionMSTT {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (n - 1 >= hour) return -1;
        int idealSpeed = 1;
        int maxSpeed = (int) 1e7;
        int minSpeed = -1;
        while(idealSpeed<=maxSpeed){
            int speed = idealSpeed+(maxSpeed-idealSpeed)/2;
            if(canArraiveOnTimeWithSpeedK(dist,hour,speed)){
                minSpeed=speed;
                maxSpeed=speed-1;
            }else{
                idealSpeed=speed+1;
            }
        }
        return minSpeed;
    }
    private int[] minMax(int[] dis){
        int[] minMax = new int[2];
        minMax[0] = Integer.MAX_VALUE;
        minMax[1] = Integer.MIN_VALUE;
        for(int d : dis){
            minMax[0] = Math.min(minMax[0],d);
            minMax[1] = Math.max(minMax[1],d);
        }
        return minMax;
    }
    private boolean canArraiveOnTimeWithSpeedK(int[] dist,double hour, int speed){
        double timeTaken = 0.0;
        for(int i = 0;i<dist.length;i++){
            timeTaken+= (i!=dist.length-1? Math.ceil(dist[i])*1.0/speed:dist[i]*1.0/speed);
            if(timeTaken>hour) return false;
        }
        return true;
    }
}
public class MinSpeedToArriveOnTime {
    public static void main(String[] args) {
        SolutionMSTT mstt = new SolutionMSTT();
        System.out.println(mstt.minSpeedOnTime(new int[]{1,3,2},6));
        System.out.println(mstt.minSpeedOnTime(new int[]{1,3,2},2.7));
        System.out.println(mstt.minSpeedOnTime(new int[]{1,3,2},1.9));

    }
}
