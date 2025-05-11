import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SubSequence {
    public static Stack<List<Integer>> result;
    private static void getAllSubsequence(int index, int[] arr, List<Integer> list){
        if(index == arr.length){
            System.out.println(list);
            result.push(list);
            return;
        }
        list.add(arr[index]);
        getAllSubsequence(index+1,arr,list);
        list.remove(list.size()-1);
        getAllSubsequence(index+1,arr,list);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        result = new Stack<>();
        List<Integer> list = new ArrayList<>();
        getAllSubsequence(0,arr,list);

        System.out.println(result);
    }
}
