import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class SolutionNOFBK {
    public int getNumberOfBacklogOrders(int[][] orders) {
        /*
        order -> [n][3]
        order[i] -> [price,amount,orderType]

        at price p amount noOf order of type oderAType was ordered
        order type is 0(buy) or 1(sell);

        sequential placement of orders
        backlog[][3] if(empty)

        bcakloag can be a heap, map
        0-> list
        1-> list

        when buy order comes check sell log
        when sell order comes check buy list
        */

        PriorityQueue<int[]> buyBackLog = new PriorityQueue<>((a,b)->b[0]-a[0]);
        PriorityQueue<int[]> sellBackLog = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int[] order : orders){
            int OrderType = order[2];

            if(OrderType == 0){
                buyOrder(order,buyBackLog,sellBackLog);
            }else{
                sellOrder(order,buyBackLog,sellBackLog);
            }
        }

        int ans = 0;
        while (!buyBackLog.isEmpty()){
            ans += buyBackLog.remove()[1];
        }

        while (!sellBackLog.isEmpty()){
            ans += sellBackLog.remove()[1];
        }

        return ans;


    }

    private void buyOrder(int[] order, PriorityQueue<int[]> bugBackLog, PriorityQueue<int[]> sellBackLog){

        if(sellBackLog.isEmpty()){
            bugBackLog.add(order);
            return;
        }
        while(!sellBackLog.isEmpty() && order[0]>=sellBackLog.peek()[0] && order[1] > 0){
            int[] sellOrder = sellBackLog.remove();

            if(order[1]>=sellOrder[1]){
                order[1]-=sellOrder[1];
                sellOrder[1] = 0;
            }else{
                sellOrder[1]-=order[1];
                sellBackLog.add(sellOrder);
                order[1] = 0;
            }
        }


        if(order[1] >0){
            bugBackLog.add(order);
        }
    }

    private void sellOrder(int[] order, PriorityQueue<int[]> bugBackLog, PriorityQueue<int[]> sellBackLog){
        if(bugBackLog.isEmpty()){
            sellBackLog.add(order);
            return;
        }
        while(!bugBackLog.isEmpty() && order[0]<=bugBackLog.peek()[0] && order[1] > 0){
            int[] buyOrder = bugBackLog.remove();

            if(order[1]>=buyOrder[1]){
                order[1]-=buyOrder[1];
                buyOrder[1] = 0;
            }else{
                buyOrder[1]-=order[1];
                bugBackLog.add(buyOrder);
                order[1] = 0;
            }
        }


        if(order[1] >0){
            sellBackLog.add(order);
        }
    }
}
public class NoOfOrderInBackLog {
    public static void main(String[] args) {
        SolutionNOFBK sc = new SolutionNOFBK();
    }
}
