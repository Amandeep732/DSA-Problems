package DFS;

import java.util.ArrayList;
import java.util.List;


// problem number = 207 on leetcode
// level = medium
// topic = graph, TS, DFS

public class Couse_schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] num : prerequisites){
            adj.get(num[0]).add(num[1]);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(dfsHelper(numCourses, vis, stack, i, adj)){
                return false;
            }
        }
        return true;
    }
     boolean dfsHelper(int numCourses, boolean[] vis, boolean[] stack, int curr, List<List<Integer>> adj) {
          vis[curr] = true;
         stack[curr] = true;
         
        for(int des : adj.get(curr)){
           if(stack[des]){ // means detect cycle
               return true;
           }else if(!vis[des]){
               if(dfsHelper(numCourses, vis, stack, des, adj)){
                   return true;
               }
           }
        }
        stack[curr] = false;
        return false;  // not found any cycle 
    }
}
