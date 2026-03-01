import java.util.*;
class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
          Queue<Integer>q=new LinkedList<>();
          ArrayList<Integer> list=new ArrayList<>();
          boolean[] vis=new boolean[adj.size()];
          vis[0]=true;
          q.add(0);
          
          while(!q.isEmpty()){
              Integer node=q.poll();
              list.add(node);
              for(int i: adj.get(node)){
                  while(vis[i]==false){
                      vis[i]=true;
                      q.add(i);
                  }
              }
          }
          return list;
    }
}