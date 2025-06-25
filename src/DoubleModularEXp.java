import java.util.ArrayList;
import java.util.List;

class SolutionDMEP {
    public boolean validate(int index, int[]variable,int target, int length){

      /*  long aPowerbModTen = 1;//(int) (Math.pow(variable[0],variable[1])%10);
        for(int i = 0;i<variable[1];i++){
            aPowerbModTen = aPowerbModTen*variable[0]%10;
        }
        long modTenPowerC = 1;//(int) Math.pow(aPowerbModTen,variable[2]);
        for(int i = 0;i<variable[2];i++){
            modTenPowerC = modTenPowerC*aPowerbModTen%variable[3];
        }
        //int formula3 = (int)(modTenPowerC%variable[3]);
//        System.out.println(index+"::::"+formula3);
        if(modTenPowerC == target ) return true;
        return false;*/
        int aPowerbModTean = modBasePow(variable[0],variable[1],10);
        int modTenPowerC = modBasePow(aPowerbModTean,variable[2],variable[3]);
        if(modTenPowerC == target ) return (true && (index>=0) && (index<length));
        return false;
    }
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> result = new ArrayList<>();
        int n = variables.length;
        for(int i =0 ;i<variables.length;i++){
            if(validate(i,variables[i],target,n)){
                result.add(i);
            }
        }
        return result;
    }

    private int modBasePow(int base, int exp, int mod){
        if (mod == 0) return 0;
        if (mod == 1) return 0;
        int result = 1;
        base = base % mod;

        while (exp > 0) {
            if ((exp & 1) == 1)
            {
                result = (int)(((long) result * base) % mod);
            }
            base = (int)(((long) base * base) % mod);
            exp >>= 1;
        }

        return result;
    }
}
public class DoubleModularEXp {
    public static void main(String[] args) {
        SolutionDMEP dm = new SolutionDMEP();
        int[][] ip = new int[][]{
                {30,5,43,2},{15,50,35,41},{45,34,41,32},{14,37,33,13},{6,8,1,53},{37,1,12,52},{42,37,2,52},{9,2,15,3},{31,12,21,24},{52,24,6,12},{51,35,21,52},{30,18,10,2},{27,31,50,27},{29,25,26,32},{15,38,43,17},{22,12,16,43},{48,9,15,6},{41,26,22,21},{41,49,52,26},{53,38,9,33}};
        System.out.println(dm.getGoodIndices(ip,1));
    }
}
