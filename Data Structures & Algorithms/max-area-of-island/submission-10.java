class Solution {
    // Set<String> visited = new HashSet<>();

    // public int bfsIterative(int[][] grid, int x, int y) {
    //     Queue<int[]> que = new LinkedList<>();

    //     que.add(new int[]{x,y});
    //     visited.add(x+","+y);
    //     int area = 1;

    //     while(!que.isEmpty()){
    //         int[] node = que.poll();
    //         for(int i=-1; i<2; i++) {
    //             for(int j=-1; j<2; j++) {
    //                 int newX = node[0]+i;
    //                 int newY = node[1]+j;
    //                 if(!(i==0 || j==0) || 
    //                     newX<0 || newX>=grid.length ||
    //                     newY<0 || newY>=grid[0].length || visited.contains(newX+","+newY)) continue;
    //                 int val = grid[newX][newY];
    //                 if(val == 1) {
    //                     area++;
    //                     visited.add(newX+","+newY);
    //                     que.add(new int[]{newX, newY});
    //                 }
    //             }
    //         }
    //     }
    //     return area;
    // }

    public int bfs(int[][] grid, int x, int y, boolean[][] visited) {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]==0 || visited[x][y]) return 0;

        visited[x][y] = true;
        int area = 1 +
            bfs(grid,x+1,y,visited) +
            bfs(grid,x-1,y,visited) +
            bfs(grid,x,y+1,visited) +
            bfs(grid,x,y-1,visited);
        
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length==0) return 0;
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int x=0; x<grid.length; x++) {
            for(int y=0; y<grid[0].length; y++) {
                int val = grid[x][y];
                if(val == 1 && !visited[x][y]) {
                    int area = bfs(grid,x,y, visited);
                    if(area>maxArea) maxArea = area;
                }
            }
        }

        return maxArea;
    }
}
