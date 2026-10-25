class Solution {
    // pos will be row of values from 2 sides
    public Set<List<Integer>> bfs(int[][] heights, List<int[]> pos) {

        Queue<int[]> que = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();
        for(int[] x : pos) {
            que.add(x);
            visited.add(Arrays.asList(x[0], x[1]));
        }

        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i=-1; i<2; i++) {
                for(int j=-1; j<2; j++) {
                    int nextx = cx+i;
                    int nexty = cy+j;
                    if((i!=0 && j!=0) || (i==0 && j==0)
                        || nextx<0 || nextx>=heights.length 
                        || nexty<0 || nexty>=heights[0].length 
                        || visited.contains(Arrays.asList(nextx,nexty)) ) continue;
                    
                    int val = heights[nextx][nexty];
                    
                    if(val>=heights[cx][cy]) {
                        que.add(new int[]{nextx, nexty});
                        visited.add(Arrays.asList(nextx,nexty));
                    }
                } 
            } 
        }

        return visited;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length==1 && heights[0].length==1) return Arrays.asList(List.of(0, 0));
        Set<int[]> pacific = new HashSet<>();
        Set<int[]> atlantic = new HashSet<>();

        List<int[]> edge = new ArrayList<>();

        for(int i=0; i<heights[0].length; i++) {
            edge.add(new int[]{0,i}); 
        }
        for(int i=0; i<heights.length; i++) {
            edge.add(new int[]{i,0}); 
        }

        Set<List<Integer>> visitedPacific = bfs(heights, edge);
        edge.clear();

        for(int i=0; i<heights[0].length; i++) {
            edge.add(new int[]{heights.length-1,i}); 
        }
        for(int i=0; i<heights.length; i++) {
            edge.add(new int[]{i,heights[0].length-1}); 
        }
        Set<List<Integer>> visitedAtlantic = bfs(heights, edge);

        visitedPacific.retainAll(visitedAtlantic);
        return new ArrayList<>(visitedPacific);
    }
}