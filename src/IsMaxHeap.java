class SolutionisMaxHeap {

    public boolean countSub(long arr[], long n) {
        // Your code goes here
        for(int i = 0;i<n/2;i++){
            if(!isValidMaxHeap(i,arr)) return false;
        }
        return true;
    }
    public static boolean isValidMaxHeap(int i, long[] arr)
    {

        int leftChild=2*i+1;
        int rightChild=2*i+2;

        if(leftChild < arr.length && arr[leftChild]>arr[i])
        {
            return false;
        }
        if(rightChild < arr.length && arr[rightChild]>arr[i])
        {
            return false;
        }

        return true;
    }
}
public class IsMaxHeap {
}
