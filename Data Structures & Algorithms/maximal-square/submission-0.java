class Solution {
    public int maximalSquare(char[][] matrix) {
        int mland = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                int val=Character.getNumericValue(matrix[i][j]);
                if(val==0) continue;
                int cur = search(matrix, i+1,j+1,1);
                if(cur>mland) mland=cur;
            }
        }
        return mland*mland;
    }

    public static int search(char[][] land,int x,int y,int size) {
        if(x>=land.length || y>=land[0].length || x<0 ||y<0 || land[x][y]=='0') return size;

        int val =Character.getNumericValue(land[x][y]);
        if(val>size+1) return search(land, x+1,y+1,size+1);

        for(int i=1; i<=size; i++) {
            if(land[x-i][y]=='0' || land[x][y-i]=='0') return size;
        }
        return search(land, x+1, y+1, size+1);
    }
}