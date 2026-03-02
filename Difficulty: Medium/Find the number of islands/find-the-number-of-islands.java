class Solution {
    public int countIslands(char[][] grid) {
        int n=grid.length, m=grid[0].length;
        boolean[][]vis=new boolean[n][m];
        int cnt = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!vis[row][col] && grid[row][col] == 'L') {
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return cnt;
    }

    void bfs(int row, int col, boolean[][] vis, char[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int[] node=new int[]{row, col};
        q.add(node);
        vis[row][col] = true;
        // in flood fill algoritm we have 6 options but here we have 8 as 45 degerees are allowed
        int[] dcol = {-1, -1, -1, 1, 1, 1, 0, 0};
        int[] drow = {1, 0, -1, 1, 0, -1, 1, -1};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r =cell[0], c=cell[1];
            for (int i=0; i<8; i++) {
                int nr = r+drow[i];
                int nc = c+dcol[i];
                if(nr>=0 && nr<grid.length &&
                    nc >= 0 && nc < grid[0].length &&
                    !vis[nr][nc] &&
                    grid[nr][nc] == 'L') {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}