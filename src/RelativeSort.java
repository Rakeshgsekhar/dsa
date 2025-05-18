class SolutionRS {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len = arr1[0];
        for(int i = 1;i<arr1.length;i++){
            len = Math.max(len,arr1[i]);
        }

        int[] count = new int[len+1];
        for(int i = 0;i<arr1.length;i++){
            count[arr1[i]]++;
        }

        int[] ans = new int[arr1.length];
        int index = 0;
        for(int i = 0;i<arr2.length;i++){
            while(count[arr2[i]]>0){
                ans[index++] = arr2[i];
                count[arr2[i]]--;
            }
        }
        for(int i = 0;i<count.length;i++){
            while(count[i]>0){
                ans[index++] = i;
                count[i]--;
            }
        }
        return ans;
    }
}
public class RelativeSort {
    public static void main(String[] args) {
        SolutionRS rs = new SolutionRS();
        int[]ans = rs.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},new int[]{2,1,4,3,9,6});
        for(int i : ans){
            System.out.println(i);
        }
    }
}
