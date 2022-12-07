// 1st approach

class Solution {

    public boolean isSafeToPlace(char [][]board, int r, int c, int num){
        char n = (char)(num + '0');

        for(int i=0; i<9; i++){
            if(board[r][i] == n){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            if(board[i][c] == n){
                return false;
            }
        }

        r = (r / 3) * 3;
        c = (c / 3) * 3;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[r + i][c + j] == n){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solve(char [][]board, ArrayList<Integer> emptyIndex, int i){
        if(i == emptyIndex.size()){
            return true;
        }

        int idx = emptyIndex.get(i);
        int r = idx / 9, c = idx % 9;

        for(int num=1; num<=9; num++){
            if(isSafeToPlace(board,r,c,num)){
                board[r][c] = (char)(num + '0');

                if(solve(board,emptyIndex,i+1)){
                    return true;
                }

                board[r][c] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {

        ArrayList<Integer> emptyIndex = new ArrayList<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    emptyIndex.add(i * 9 + j);
                }
            }
        }

        solve(board,emptyIndex,0);
    }
}

// 2nd approach

class Solution {

    public boolean solve(char [][]board, ArrayList<Integer> emptyIndex, int i, boolean [][]row,
    boolean [][]col, boolean [][][]mat){

        if(i == emptyIndex.size()){
            return true;
        }

        int idx = emptyIndex.get(i);
        int r = idx / 9, c = idx % 9;

        for(int num=1; num<=9; num++){
            if(!row[r][num] && !col[c][num] && !mat[r/3][c/3][num]){
                row[r][num] = true;
                col[c][num] = true;
                mat[r/3][c/3][num] = true;
                board[r][c] = (char)(num + '0');

                if(solve(board,emptyIndex,i+1,row,col,mat)){
                    return true;
                }

                row[r][num] = false;
                col[c][num] = false;
                mat[r/3][c/3][num] = false;
                board[r][c] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        boolean [][]row = new boolean[9][10];
        boolean [][]col = new boolean[9][10];
        boolean [][][]mat = new boolean[3][3][10];

        ArrayList<Integer> emptyIndex = new ArrayList<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    emptyIndex.add(i * 9 + j);
                }else{
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    mat[i/3][j/3][num] = true;
                }
            }
        }

        solve(board,emptyIndex,0,row,col,mat);
    }
}

// 3rd approach

class Solution {

    public boolean solve(char [][]board, ArrayList<Integer> emptyIndex, int i, int []row,
    int []col, int [][]mat){

        if(i == emptyIndex.size()){
            return true;
        }

        int idx = emptyIndex.get(i);
        int r = idx / 9, c = idx % 9;

        for(int num=1; num<=9; num++){
            int mask = (1 << num);
            
            if(((row[r] & mask) == 0) && ((col[c] & mask) == 0) && ((mat[r/3][c/3] & mask) == 0)){
                row[r]^=mask;
                col[c]^=mask;
                mat[r/3][c/3]^=mask;
                board[r][c] = (char)(num + '0');

                if(solve(board,emptyIndex,i+1,row,col,mat)){
                    return true;
                }

                board[r][c] = '.';
                row[r]^=mask;
                col[c]^=mask;
                mat[r/3][c/3]^=mask;
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        int []row = new int[9];
        int []col = new int[9];
        int [][]mat = new int[3][3];

        ArrayList<Integer> emptyIndex = new ArrayList<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    emptyIndex.add(i * 9 + j);
                }else{
                    int num = board[i][j] - '0';
                    int mask = (1 << num);
                    row[i]^=mask;
                    col[j]^=mask;
                    mat[i/3][j/3]^=mask;
                }
            }
        }

        solve(board,emptyIndex,0,row,col,mat);
    }
}
