import java.util.PriorityQueue;

class PairST{
    char ch;
    int fq;
    PairST(char ch, int fq){
        this.ch = ch;
        this.fq = fq;
    }
}
class SolutionRGST {
    public String reorganizeString(String s) {
        PriorityQueue<PairST> pq = new PriorityQueue<>((a,b)->b.fq-a.fq);
        int[] feq = new int[26];
        for(char ch : s.toCharArray()){
            feq[ch-'0']++;
        }
        for(int a:feq){
            if(a>(s.length()+1)/2) return "";
        }

        StringBuilder sb = new StringBuilder();
        PairST st = new PairST('*',0);
        while(!pq.isEmpty()){
            PairST temp = pq.poll();
            sb.append(temp.ch);
            temp.fq-=1;
            if(st.fq>0){
                pq.offer(st);
            }
            st = temp;
        }
        return sb.toString();


    }
}
public class ReArragneString {
}
