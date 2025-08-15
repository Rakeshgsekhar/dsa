import java.util.*;

class SolutionMaxKSort {
    public int sortPermutation(int[] nums) {
        int n  = nums.length;
        boolean isSorted = true;
        for(int i = 1;i<n;i++){
            if(nums[i]>nums[i-1]){
                isSorted = false;
                break;
            }
        }

        if(isSorted) return 0;

        /*for(int k = n-1;k>=0;k--){
            boolean[] visited = new boolean[n];
            boolean sort = true;
            for(int i = 0; i<n && sort;i++){
                if(!visited[i]){
                    int temp = i;
                    int AND = nums[i];
                    while(!visited[temp]){
                        visited[temp] = true;
                        temp = nums[temp];
                        if(!visited[temp]){
                            AND &= nums[temp];
                        }
                    }
                    if(AND != k){
                        sort = false;
                    }
                }
            }
            if(sort) return k;
        }
        return -1;*/
       /* boolean[] visited = new boolean[n];
        int maxK = -1;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cur = i;
                int AND = nums[cur];

                while (!visited[cur]) {
                    visited[cur] = true;
                    AND &= nums[cur];
                    cur = nums[cur];
                }

                if (maxK == -1) {
                    maxK = AND;
                } else {
                    maxK &= AND;
                }
            }
        }

        return maxK;*/
        int maxVal = n - 1;
        for (int k = maxVal; k >= 0; k--) {
            int[] arr = nums.clone();
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    List<Integer> index = new ArrayList<>();
                    Queue<Integer> queue = new ArrayDeque<>();
                    queue.offer(i);
                    visited[i] = true;

                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        index.add(cur);
                        for (int j = 0; j < n; j++) {
                            if (!visited[j] && (arr[cur] & arr[j]) == k) {
                                visited[j] = true;
                                queue.offer(j);
                            }
                        }
                    }
                    List<Integer> values = new ArrayList<>();
                    for (int idx : index) values.add(arr[idx]);
                    Collections.sort(values);
                    Collections.sort(index);
                    for (int t = 0; t < index.size(); t++) {
                        arr[index.get(t)] = values.get(t);
                    }
                }
            }

            if (isSorted(arr)) return k;
        }
        return 0;
    }
    private boolean isSorted(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
}
public class MaxKToSortPermutaiton {

    public static void main(String[] args) {
        SolutionMaxKSort mk = new SolutionMaxKSort();
        int[] nums3 = {0, 3, 2, 1};
        System.out.println(mk.sortPermutation(nums3));
        System.out.println(mk.sortPermutation(new int[]{0,1,3,2}));
        System.out.println(mk.sortPermutation(new int[]{3,2,1,0}));
    }
}
