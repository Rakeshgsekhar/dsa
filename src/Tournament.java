import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Collectors;

public class Tournament {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 0;i<tc;i++){
            int n = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int m = 0;m<n;m++){
                arr[m] = sc.nextInt();
            }
            Arrays.sort(arr);

            Set<Integer> set = new HashSet<>();
            for(int s:arr){
                set.add(s);
            }

             List<Integer> lsa = set.stream().collect(Collectors.toList());
            System.out.println(playTournament(lsa,j,k));
        }

    }

        private static void reverse(int[] arr) {
            for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
    }
    private static String playTournament(List<Integer>lsa,int j,int k){
        int n = lsa.size();
        int targetStrength = j;  // j is 1-based

        int weaker = 0;
        for (int strength : lsa) {
            if (strength < targetStrength) weaker++;
        }

        return weaker > (n - k) ? "YES" : "NO";

    }
}
