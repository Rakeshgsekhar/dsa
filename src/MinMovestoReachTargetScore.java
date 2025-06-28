class SolutionMMTS {
    public int minMoves(int target, int maxDoubles) {
        int moves = 0;
        while(target>1){
            if(maxDoubles>0){
                while(target%2 != 0){
                    target--;
                    moves++;
                }
                target = target/2;
                moves+=1;
                maxDoubles-=1;
            }else{
                moves = moves+target-1;
            }
        }
        return target == 0 ? moves+1:moves;
    }
}
public class MinMovestoReachTargetScore {
}
