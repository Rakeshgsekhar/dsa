
class SolutionMINMAX {
    static void convertMinToMaxHeap(int N, int arr[]) {
        // code here
        int[] res = new int[N];
        for(int i = N/2-1;i>=0;--i){
            maxHeapify(arr,N,i);
        }
    }
    private static void maxHeapify(int[]arr,int size,int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if(left<size && arr[left]>arr[largest]){
            largest = left;
        }
        if(right<size && arr[right]>arr[largest]){
            largest = right;
        }

        if(largest!=i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i]= temp;
            maxHeapify(arr,size,largest);
        }

    }
}

public class MinToMaxHeap {
    public static void main(String[] args) {
        int[] minHeap = new int[]{1,2,3,4};
        SolutionMINMAX.convertMinToMaxHeap(4,minHeap);

    }
}
