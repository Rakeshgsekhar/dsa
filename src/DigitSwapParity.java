import java.util.PriorityQueue;

class SolutionDSP {
    public int largestInteger(int num) {
        PriorityQueue<Integer> evenPq = new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> oddPq = new PriorityQueue<>((a,b)->b-a);
        int temp = num;
        while(temp>0){
            int dt = temp%10;
            if(dt%2 == 0) evenPq.offer(dt);
            else oddPq.offer(dt);
            temp = temp/10;
        }

        char[] ch = String.valueOf(num).toCharArray();
        for(int i = 0;i<ch.length;i++){
            int val = ch[i]-'0';
            if(val%2==0){
                char tmp = (char) (evenPq.poll()+'0');
                ch[i] = tmp;
            }else{
                char tmp = (char) (oddPq.poll()+'0');
                ch[i] = tmp;
            }
        }
        int res = 0;
        for(int i = 0 ;i<ch.length;i++){
            res = res*10+(ch[i]-'0');
        }
        return res;

    }
}
public class DigitSwapParity {
    public static void main(String[] args) {
        SolutionDSP dp = new SolutionDSP();
        dp.largestInteger(65875);
    }
}
