public class Solution {
    List<Integer>[] adj;
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj=new List[numCourses];
        visited=new int[numCourses]; //0=white; -1=gray; 1=black;
        for(int i=0;i<numCourses;i++)
            adj[i]=new ArrayList<Integer>();
        for(int i=0;i<prerequisites.length;i++)
        {
            int from=prerequisites[i][0];
            int to=prerequisites[i][1];
            adj[from].add(to);
            
        }
        
        for(int i=0;i<numCourses;i++){
            boolean b;
            if(visited[i]==0){
                b=dfs(i);
            if(b==false) return false; 
            }
        }
        return true;
                
    }
    public boolean dfs(int c){
        visited[c]=-1;
        for(int i:adj[c]){
            if(visited[i]==-1) return false;
            if(visited[i]==0&&dfs(i)==false) return false;
        }
        visited[c]=1;
        return true;
    }
}