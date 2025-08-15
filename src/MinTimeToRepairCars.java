class SolutionMTRC {
    public long repairCars(int[] ranks, int cars) {
        int[] minMax = minMax(ranks);
        long left = 1,right = minMax[0]*cars*cars;
        while(left<right){
            long mid = left+(right-left)/2;
            if(canRepairCarinTime(mid,ranks,cars)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    private int[] minMax(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for(int i = 1;i<arr.length;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        return new int[]{min,max};
    }

    private boolean canRepairCarinTime(long time,int[] ranks,int car){
        long totalCarsRepaired = 0;
        for(int rank : ranks){
            totalCarsRepaired+=Math.sqrt(time/rank);
            if(totalCarsRepaired>=car) return true;
        }
        return false;

    }
}
public class MinTimeToRepairCars {
}
