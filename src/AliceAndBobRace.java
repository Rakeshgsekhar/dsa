import java.util.Scanner;

public class AliceAndBobRace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i = 0;i<testCase;i++){
            int a = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(race(a,x,y));
        }
    }

    private static String race(int a,int x, int y){
        if((Math.abs(x-y)<Math.abs(a-y)) || (Math.abs(x-y)<Math.abs(a-x))) return "YES";
        else return "NO";
    }
}
