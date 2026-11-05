class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                if(board[i][j]=='.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
            set.clear();
        }
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                if(board[j][i]=='.') continue;
                if(set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
            set.clear();
        }
        for(int i=0; i<board.length; i+=3) {
            for(int j=0; j<board.length; j+=3) {
                for(int x=0; x<3; x++){
                    for(int y=0; y<3; y++){
                        char val = board[i+x][j+y];
                        if(val=='.') continue;
                        if(set.contains(val)) return false;
                        set.add(val);
                    }
                }
            set.clear();
            }
        }
        return true;

    }
}
