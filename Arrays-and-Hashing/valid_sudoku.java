// LeetCode#36: https://leetcode.com/problems/valid-sudoku/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
            Step 1: create Lists to store rows columns and squares.
                    use row/3, col/3 to find index of square
        */
        Set<Character>[] rows = new Set[9];
        Set<Character>[] cols = new Set[9];
        Set<Character>[][] squares = new Set[3][3];
        /*
            step 2: For each cell(board[r][c]) of the board.
                    check for duplicates in cols[c],rows[r] and squares[r/3][c/3].
                    return false if duplicate found.
                    else add board[r][c] to cols[c], rows[r] and squares[r/3][c/3].
        */
        for (int r=0;r<9;r++){
            if(rows[r]== null) rows[r] = new HashSet<>();
            for(int c=0; c<9; c++){
                if(board[r][c] == '.') continue;
                if(cols[c] == null) cols[c] = new HashSet<>();
                if(squares[r/3][c/3] == null) squares[r/3][c/3] = new HashSet<>();

                if(rows[r].contains(board[r][c]) ||
                    cols[c].contains(board[r][c]) ||
                    squares[r/3][c/3].contains(board[r][c])) return false;

                rows[r].add(board[r][c]);
                cols[c].add(board[r][c]);
                squares[r/3][c/3].add(board[r][c]);
            }
        }
        //Return true on successful interation of the board.
        return true;
    }
}