class Solution {

    public void bfs(int[][] grid, int x, int y) {
        // bfs if we encounter a 0 then spread
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{x,y});
        int distance = 1;

        int curLevel = 1;
        while(!que.isEmpty()) {
            int levelSize = que.size();
            for(int z=0; z<levelSize; z++) {
                int[] cur = que.poll();
                int cx = cur[0];
                int cy= cur[1];
                for(int i=-1; i<2; i++) {
                    for(int j=-1; j<2; j++) {
                        int nextx = cx+i;
                        int nexty = cy+j;
                        if((i!=0 && j!=0) 
                            || nextx<0 || nextx>=grid.length
                            || nexty<0 || nexty>=grid[0].length
                            || grid[nextx][nexty] == -1
                            || grid[nextx][nexty] == 0) continue;
                        int val = grid[nextx][nexty];
                        if(val>distance) {
                            grid[nextx][nexty] = distance;
                            que.add(new int[]{nextx,nexty});
                        }
                    }
                }
            }
            distance++;    
        }
        
    }
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    bfs(grid,i,j);
                }
            }
        }
    }
}
