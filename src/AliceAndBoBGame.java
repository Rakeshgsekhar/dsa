import java.util.Scanner;

public class AliceAndBoBGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 0;i<tc;i++){
            int n = sc.nextInt();
            System.out.println(playGame(n));
        }
    }
    private static String playGame(int n){
        if(n%4 == 0 ) return "BOB";
        else return "ALICE";
    }
}
