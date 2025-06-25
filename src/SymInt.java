import java.util.ArrayList;
import java.util.List;

class SolutionCountSym {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        int n = high - low+1;
        List<String>arr = new ArrayList<>();
        for(int i = low;i<=high;i++){
            arr.add(String.valueOf(i));
        }

        for(String s : arr){
            if(s.isEmpty()) continue;
            if(s.length()%2 !=0 )continue;
            int k = s.length()/2;
            if(sum(s.substring(0,k))== sum(s.substring(k,s.length()))) count++;
        }
        return count;
    }

    private int sum(String s){
        int sm = 0;
        for(char ch : s.toCharArray()){
            sm+=ch-'0';
        }
        return sm;
    }
}
public class SymInt {
    public static void main(String[] args) {
        SolutionCountSym sym = new SolutionCountSym();
        System.out.println(sym.countSymmetricIntegers(1,100));
    }
}
