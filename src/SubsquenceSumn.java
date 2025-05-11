import java.util.ArrayList;
import java.util.List;

public class SubsquenceSumn {
    public static int subsequenceSum(int index, int[] arr, List<Integer> list,int sum,int target){
        if(sum>target) return 0;
        if(index == arr.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        list.add(arr[index]);
        int pick = subsequenceSum(index+1,arr,list,sum+arr[index],target);
        list.remove(list.size()-1);
        int notPick = subsequenceSum(index+1,arr,list,sum,target);
        return  pick+notPick;
    }

    public static boolean sub(int index, int[] arr, List<Integer> list,int sum,int target){
        if(index == arr.length){
            if(sum == target){
                System.out.println(list);
                return true;
            }
            return false;
        }
        list.add(arr[index]);
        if(sub(index+1,arr,list,sum+arr[index],target)) return true;
        list.remove(list.size()-1);
        if(sub(index+1,arr,list,sum,target)) return true;

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1};
        int target = 2;
        int count = subsequenceSum(0,arr,new ArrayList<>(),0,target);
        System.out.println(count);
        if(sub(0,arr,new ArrayList<>(),0,target)) {
            System.out.println("finised");
        }else {
            System.out.println("Not subsequence found");
        }
    }
}
