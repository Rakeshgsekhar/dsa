import java.util.*;

public class ShrinkingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i = 0;i< testCase;i++){
            int size = sc.nextInt();
            Integer[] arr = new Integer[size];
            for(int k = 0;k<size;k++){
                arr[k] = sc.nextInt();
            }
            System.out.println(minOperations(arr));
        }
    }

    private static int minOperations(Integer[] a) {
        if (isBeautiful(a)) return 0;
        if (a.length == 2) return -1;

        Map<String, Integer> memo = new HashMap<>();
        return dfs(Arrays.asList(a),memo);
    }

    static int dfs(List<Integer> a, Map<String, Integer> memo) {
        if (a.size() < 2) return Integer.MAX_VALUE;
        if (isBeautiful(a)) return 0;

        String key = a.toString();
        if (memo.containsKey(key)) return memo.get(key);

        int minOps = Integer.MAX_VALUE;

        for (int i = 0; i < a.size() - 1; i++) {
            int x = (a.get(i) + a.get(i + 1)) / 2;
            int lo = Math.min(a.get(i), a.get(i + 1));
            int hi = Math.max(a.get(i), a.get(i + 1));

            for (int val = lo; val <= hi; val++) {
                List<Integer> next = new ArrayList<>();
                for (int j = 0; j < i; j++) next.add(a.get(j));
                next.add(val);
                for (int j = i + 2; j < a.size(); j++) next.add(a.get(j));

                int res = dfs(next, memo);
                if (res != Integer.MAX_VALUE) {
                    minOps = Math.min(minOps, 1 + res);
                }
            }
        }

        memo.put(key, minOps);
        return minOps;
    }

    public static boolean isBeautiful(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) <= 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBeautiful(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (Math.abs(arr.get(i) - arr.get(i + 1)) <= 1) {
                return true;
            }
        }
        return false;
    }
}
