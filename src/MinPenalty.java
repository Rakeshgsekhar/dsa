class SolutionMP {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] pen = new int[n];
        int minPanalty = 0;
        for(int i = 0;i<n;i++){
            if(customers.charAt(i)=='Y'){
                pen[i] = 0;
            }else{
                pen[i] = 1;
            }
            minPanalty+=pen[i];
        }

        int minHour = n;
/*
        for(int i = 0;i<n;i++){
            int currPen =0;
            for(int j = 0;j<n;j++) {
                if(j<i){
                    currPen+=pen[j];
                }else {
                    currPen += Math.abs(pen[j] - 1);
                }
            }
            if(currPen<minPanalty){
                minPanalty = currPen;
                minHour = i;
            }else if(currPen == minPanalty){
                minHour = Math.min(minHour,i);
            }
        }

        */
        int[] minPenArr = new int[n+1];
        minPenArr[n] = minPanalty;
        for(int i = n-1;i>=0;i--){
            if(customers.charAt(i) == 'Y'){
                minPenArr[i] = Math.max(minPenArr[i+1],(minPenArr[i+1]+1));
            }else{
                minPenArr[i] = Math.min(minPenArr[i+1],(minPenArr[i+1]-1));
            }
        }

        for(int i = 0;i<=n;i++){
            if(minPenArr[i]<minPanalty){
                minPanalty = minPenArr[i];
                minHour = i;
            }else if(minPenArr[i] == minPanalty){
                minHour = Math.min(minHour,i);
            }
        }
        return minHour;

    }
}
public class MinPenalty {
    public static void main(String[] args) {
        SolutionMP mp  = new SolutionMP();
        System.out.println(mp.bestClosingTime("YYNY"));
        System.out.println(mp.bestClosingTime("NNNN"));
        System.out.println(mp.bestClosingTime("YYYY"));
        System.out.println(mp.bestClosingTime("YNYY"));
        System.out.println(mp.bestClosingTime("YN"));
    }
}
