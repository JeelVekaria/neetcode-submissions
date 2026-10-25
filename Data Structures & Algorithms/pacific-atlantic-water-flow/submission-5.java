class Solution {
    // dfs recursive
    public void dfs(int[][] heights, int x, int y, Set<List<Integer>> visited) {
        visited.add(Arrays.asList(x,y));

        // check adjacent cells
        for(int i=-1; i<2; i++) {
            for(int j=-1; j<2; j++) {
                int nextx = x+i;
                int nexty = y+j;

                if((i!=0 && j!=0) 
                || nextx<0 || nexty<0 
                || nextx>=heights.length || nexty>=heights[0].length 
                || visited.contains(Arrays.asList(nextx,nexty))
                || heights[nextx][nexty] < heights[x][y]) continue;

                dfs(heights, nextx, nexty, visited);

            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length==1 && heights[0].length==1) return Arrays.asList(List.of(0, 0));

        Set<List<Integer>> visitedPacific = new HashSet<>();
        Set<List<Integer>> visitedAtlantic = new HashSet<>();
        
        for(int i=0; i<heights[0].length; i++) {
            dfs(heights, 0, i, visitedPacific);
            dfs(heights, heights.length-1, i, visitedAtlantic);
        }
        for(int i=0; i<heights.length; i++) {
            dfs(heights, i, 0, visitedPacific);
            dfs(heights, i, heights[0].length-1, visitedAtlantic);
        }

        visitedPacific.retainAll(visitedAtlantic);
        
        return new ArrayList<>(visitedPacific);

        
    }
}
