import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class SolutionFOKAG {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] course : prerequisites){
            adjList.get(course[1]).add(course[0]);
        }

        int[] inDegree = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            for(int idg : adjList.get(i)){
                inDegree[idg]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(inDegree[i] ==0) queue.offer(i);
        }
        int idx = 0;
        while (!queue.isEmpty()){
            int preCourse = queue.poll();
            order[idx++] = preCourse;
            for(int course : adjList.get(preCourse)){
                inDegree[course]--;
                if(inDegree[course] == 0) queue.offer(course);
            }
        }
        //for(int i = 0;i<numCourses;i++) if(inDegree[i]!=0) return new int[]{};
        if(idx!=numCourses) return new int[]{};
        return order;
    }
}
public class CourseScheduleII {
    public static void main(String[] args) {
        SolutionFOKAG fk = new SolutionFOKAG();
        fk.findOrder(3,new int[][]{{1,0},{1,2},{0,1}});
    }
}
