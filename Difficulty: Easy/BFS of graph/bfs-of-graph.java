class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q=new LinkedList<>();
        boolean[] visitedArray=new boolean[adj.size()];
        ArrayList<Integer> list=new ArrayList<>();
        
        q.add(0);// intial state
        visitedArray[0]=true;
        
        while(!q.isEmpty()){
         Integer node=q.poll();
         list.add(node);
         for(int i: adj.get(node)){
            if(visitedArray[i]==false){
              visitedArray[i]=true;
              q.add(i);  
            }
        }   
      }
      return list;
    }
}