class SolutionMPOS {
    public boolean canChange(String start, String target) {
        if(start.equals(target)){
            return true;
        }
        char[] st = start.toCharArray();
        char[] tt = target.toCharArray();
      /*  //DO Left
        for(int i = 0;i<tt.length;i++){
            if(tt[i] == 'L'){
                for(int j = 0;j<st.length;j++){
                    if(st[j]== 'L'){
                        if(i<j){
                            int k = j;
                            while(k>i){
                                char temp = st[k];
                                st[k] = st[k-1];
                                st[k-1] = temp;
                                k--;
                            }
                        }
                    }
                }
            }
        }
        //DO Right

        for(int i = tt.length-1;i>=0;i--){
            if(tt[i] == 'R'){
                for(int j = st.length-1;j>=0;j--){
                    if(st[j] == 'R'){
                        if(i>j){
                            int k = j;
                            while(k<i){
                                char temp = st[k];
                                st[k] = st[k+1];
                                st[k+1] = temp;
                                k++;
                            }
                        }
                    }
                }
            }
        }

       // validate
        for(int i =0;i<st.length;i++){
            if(tt[i] != st[i]) return false;
        }*/

        int Lcount = 0;
        int Rcount = 0;
        for(int i = 0;i<st.length;i++){
            char str = st[i];
            char tar = tt[i];
            if(str == 'R'){
                if(Lcount>0){
                    return false;
                }
                Rcount++;
            }
            if(tar == 'L'){
                if(Rcount>0){
                    return false;
                }
                Lcount++;
            }

            if(tar == 'R'){
                if(Rcount == 0){
                    return false;
                }
                Rcount--;
            }

            if(str == 'L'){
                if(Lcount == 0){
                    return false;
                }
                Lcount--;
            }
        }


        return Lcount==0 && Rcount==0;
    }
}
public class MovePieces {
    public static void main(String[] args) {
        SolutionMPOS mpos = new SolutionMPOS();
        System.out.println(mpos.canChange("_L__R__R_","L______RR"));
        System.out.println(mpos.canChange("R_L_","__LR"));
        System.out.println(mpos.canChange("_R","R_"));
    }
}
