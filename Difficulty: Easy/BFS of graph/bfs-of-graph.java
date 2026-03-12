class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // initial: Q
        // Q always has starting node
        Queue<Integer>q=new LinkedList<>();
        boolean[]vis=new boolean[adj.size()];
        q.add(0);
        vis[0]=true;
        
        
        ArrayList<Integer> list=new ArrayList<>();
        //keep taking it out till its not empty
        while(!q.isEmpty()){
             Integer node=q.poll();
             list.add(node);
             for(int i:adj.get(node)){
               if(!vis[i]){
                   vis[i]=true;
                q.add(i);
              } 
            }
        }
       return list;
    }
}