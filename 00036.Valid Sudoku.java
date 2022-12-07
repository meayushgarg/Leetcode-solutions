// 1st approach

class Solution {

    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    if(!isTheNumberIsSafe(board,i,j,board[i][j])){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isTheNumberIsSafe(char [][]board, int r, int c, char num){
        int rc = 0, cc = 0, mc = 0;

        for(int i=0; i<9; i++){
            if(board[r][i] == num){
                rc++;
            }
        }

        for(int i=0; i<9; i++){
            if(board[i][c] == num){
                cc++;
            }
        }

        r = (r / 3) * 3;
        c = (c / 3) * 3;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[r + i][c + j] == num){
                    mc++;
                }
            }
        }

        return ((rc == 1) && (cc == 1) && (mc == 1));
    }
}


// 2nd approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int [][]row = new int[9][10];
        int [][]col = new int[9][10];
        int [][][]mat = new int[3][3][10];

        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                if(board[r][c] != '.'){
                    int num = board[r][c] - '0';
                    if((row[r][num] == 0) && (col[c][num] == 0) && (mat[r/3][c/3][num] == 0)){
                        row[r][num] = 1;
                        col[c][num] = 1;
                        mat[r/3][c/3][num] = 1;
                    }else{
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

// 3rd approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int []row = new int[9];
        int []col = new int[9];
        int [][]mat = new int[3][3];

        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                if(board[r][c] != '.'){
                    int num = board[r][c] - '0';
                    int mask = (1 << num);

                    if(((row[r] & mask) == 0) && ((col[c] & mask) == 0) && ((mat[r/3][c/3] & mask) == 0)){

                        row[r]^=mask;
                        col[c]^=mask;
                        mat[r/3][c/3]^=mask;

                    }else{
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
