import java.util.*;

class SolutionSTC {
    static int index = 0;
    class Task{
        int id = 0;
        int enqueueTime;
        int processingTime;

        public Task(int id,int enqueueTime, int processingTime) {
            this.id = id;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }

        public Task() {
        }
    }
    public int[] getOrder(int[][] tasks) {
        //Task task = new Task();
        int n = tasks.length;
        int[] ans = new int[tasks.length];
        Task [] arr = new Task[n];
        for(int i = 0 ;i<n;i++){
            arr[i] = new Task(i, tasks[i][0],tasks[i][1]);
        }


        PriorityQueue<Task> pq = new PriorityQueue<Task>((a,b)-> {
            if(a.processingTime == b.processingTime) return a.id-b.id;
            return a.processingTime - b.processingTime;
        });

//        Map<Integer, List<Task>> map = new HashMap<>();
//        for(int i = 0;i<tasks.length;i++){
//            map.getOrDefault(tasks[i][0],new ArrayList<>()).add(new Task(tasks[i][0],tasks[i][1]));
//        }
        int ct = 0;
        int ansIndex = 0;
        int taskIndx = 0;
        int tIndex = 1;
//       // for(int i =0;i<tasks.length;i++){
//            pq.offer(new Task(tasks[0][0],tasks[0][1]));
//           // holdTime = ct+tasks[0][1];
//            while(!pq.isEmpty()){
//                if(ct>=holdTime) {
//                    Task tk = pq.poll();
//                    ans[ansIndex++] = tk.id;
//                    holdTime = ct + tk.processingTime;
//                }
//                if(tIndex<tasks.length){
//                    //if(ct == tasks[])
//                   // for(int i = )
//                    pq.offer(new Task(tasks[tIndex][0],tasks[tIndex][1]));
//                    tIndex++;
//                }
//                ct++;
//
//            }
//       // }
        while(ansIndex<n){
            while (taskIndx<n && arr[taskIndx].enqueueTime<=ct){
                pq.offer(arr[taskIndx++]);
            }
            if(pq.isEmpty()){
                ct = arr[taskIndx].enqueueTime;
            }else{
                ct+=pq.peek().processingTime;
                ans[ansIndex++] = pq.poll().id;
            }
        }
        return ans;
    }
}
public class SingleThreadCPU {
    public static void main(String[] args) {
//        int[][] tasks = new int[][]{{1,2},{2,4},{3,2},{4,1}};
        int[][] tasks = new int[][]{{7,10},{7,12},{7,5},{7,4},{7,2}};
        SolutionSTC stc = new SolutionSTC();
        stc.getOrder(tasks);
    }
}
