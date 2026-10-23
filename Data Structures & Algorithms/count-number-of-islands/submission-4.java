class Solution {

    public void check(char[][]grid, boolean[][] visited, int x, int y) {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || (grid[x][y] == '0') || visited[x][y]) return;

        visited[x][y] = true;
        check(grid, visited, x+1, y);
        check(grid, visited, x-1, y);
        check(grid, visited, x, y+1);
        check(grid, visited, x, y-1);
        return;
    }



    public int numIslands(char[][] grid) {
        int islands = 0;
        if(grid.length==0) return islands;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                char val = grid[i][j];

                if(val == '1' && !visited[i][j]) {
                    islands++;
                    check(grid,visited,i,j);
                }
            }
        }
        return islands;



    }
}
