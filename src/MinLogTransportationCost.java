class SolutionMCC {
    public long minCuttingCost(int n, int m, int k) {
        long cost = Long.MAX_VALUE;
        if(m<=k && n<=k) return 0l;
        while(m>k && n>k){
            int mWeight = Math.min(k,m-k);
            int nWeight = Math.min(k,n-k);
            cost = Math.min(cost,(mWeight*k)+(nWeight*k));
            m-=k;
            n-=k;
        }

        while(m>k){
            int mWeight = m-k;
            cost = Math.min(cost,(mWeight*(m-k)));
            m-=k;
        }
        while(n>k){
            int nWeight = n-k;
            cost= Math.min(cost,(nWeight*(n-k)));
            n-=k;
        }
        return cost;
    }
}
public class MinLogTransportationCost {
}
