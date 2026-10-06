class Solution {
    private Set<String> visited = new HashSet<>();

    private void bfs(char[][] grid, int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        que.add(new int[]{x,y});

        while(!que.isEmpty()) {
            int[] cur = que.poll();

            // for(int[] dir : directions) {
            for(int i=-1;i<=1;i++) {
                for(int j=-1; j<=1;j++) {
                    if(i!=0 && j!=0) continue;

                    int nextX = cur[0]+j;
                    int nextY = cur[1]+i;
                    
                    if(nextX<0 || nextX>=grid.length 
                    || nextY<0 || nextY>=grid[0].length) continue;

                    int val = grid[nextX][nextY];
                    if(val == '1' 
                    && !visited.contains(nextX+","+nextY)) {
                        visited.add(nextX+","+nextY);
                        que.add(new int[]{nextX,nextY});
                    }
                }
            }
            // }
        }
    }

    public int numIslands(char[][] grid) {
        if(grid.length<1) return 0;
        int islands = 0;

        int row = grid.length, col=grid[0].length;

        for(int x=0; x<row; x++) {
            for(int y=0; y<col; y++) {
                int val = grid[x][y];
                if(val=='1' && !this.visited.contains(x+","+y)) {
                    bfs(grid, x, y);
                    islands++;
                }
            }
        }
        return islands;

    }
}
