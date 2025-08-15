import java.util.Arrays;

class SolutionFIB {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unPlaced = 0;
        int[] st =  new int[4 * baskets.length];

        constructST(1, 0, baskets.length - 1, baskets,st);
        for(int fruit: fruits) {
            if(searchST(1, 0, baskets.length - 1, fruit,st) == -1) {
                unPlaced++;
            }
        }
        return unPlaced;
    }

    public void constructST(int n, int start, int end, int[] baskets,int[]st) {
        // Base case
        if(start == end) {
            st[n] = baskets[start];
            return;
        }
        int mid = start + (end-start)/2;
        constructST(2*n, start, mid, baskets,st);
        constructST(2*n+1, mid+1, end, baskets,st);
        st[n] = Math.max(st[2*n], st[2*n+1]);
    }

    public int searchST(int n, int start, int end, int val,int[] st) {
        if(st[n] < val) {
            return -1;
        }
        // Base case
        if(start == end) {
            st[n] = -1; // used the value
            return start;
        }
        int mid = start + (end-start)/2;
        int pos = -1;
        if(st[2*n] >= val) {
            pos = searchST(2*n, start, mid, val,st);
        } else {
            pos = searchST(2*n+1, mid+1, end, val,st);
        }
        st[n] = Math.max(st[2*n], st[2*n+1]);
        return pos;
    }
}
public class FruitsIntoBasket {
}
