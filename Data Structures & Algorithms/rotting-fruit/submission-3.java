class Solution {

    public int bfs(int[][] grid, Set<int[]> set) {
        Queue<int[]> que = new LinkedList<>();
        boolean inf = false;

        for(int[] val : set) {
            que.add(new int[]{val[0],val[1]});
        }
        int min = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            for(int z=0; z<size; z++) {
                int[] cur = que.poll();
                int cx = cur[0];
                int cy = cur[1];

                for(int i=-1; i<2; i++) {
                    for(int j=-1; j<2; j++) {
                        int nextx = cx+i;
                        int nexty = cy+j;
                        if((i!=0 && j!=0) || nextx<0 || nextx>=grid.length
                            || nexty<0 || nexty>=grid[0].length
                            || grid[nextx][nexty]!=1) continue;

                        grid[nextx][nexty] = 2;
                        inf = true;
                        que.add(new int[]{nextx, nexty});
                    }
                }
            }
            if(inf) min++;
            else {
                break;
            }
            inf = false;
        }

        return min;
    }


    public int orangesRotting(int[][] grid) {
        Set<int[]> arr = new HashSet<>();

        for(int i=0; i<grid.length; i++ ) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==2) {
                    arr.add(new int[]{i,j});
                }
            }
        }
        int val = bfs(grid, arr);

        for(int i=0; i<grid.length; i++ ) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    return -1;
                }
            }
        }



        return val;
    }
}
