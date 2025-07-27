import java.util.ArrayList;
import java.util.Arrays;

class SolutionCSD {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<numCourses;i++) adjList.add(new ArrayList<>());
        for(int[] course : prerequisites){
            adjList.get(course[1]).add(course[0]);
        }
        int[] completed = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            if(completed[i] == 0){
                if(cannotCompleteAllCourseDFS(adjList,completed,i)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean cannotCompleteAllCourseDFS(ArrayList<ArrayList<Integer>> adjList,int[] completed,int course){
        completed[course] = 1;
        for(int prerequisiteCourse : adjList.get(course)){
            if(completed[prerequisiteCourse] == 0){
                if(cannotCompleteAllCourseDFS(adjList,completed,prerequisiteCourse)) return true;
            }else if(completed[prerequisiteCourse] == 1) return true;
        }
        completed[course] = 2;
        return false;
    }
}
public class CourseSchedule {
}
