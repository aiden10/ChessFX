package com.example.c_h_e_s_s;

public class Rook extends Pieces{

    public Rook(int type, int color, int col, int row) {
        super(3, color, col, row);
    }
    @Override
    public int getColor() {
        return super.getColor();
    }
    @Override
    public int getCol() {
        return super.getCol();
    }

    @Override
    public int getRow() {
        return super.getRow();
    }
    public Pieces copy() {
        return new Rook(this.getType(), this.getColor(), this.getCol(), this.getRow());
    }

    @Override
    public Pieces[][] move(Pieces[][] board, int desiredCol, int desiredRow) {
        if (desiredCol != col && desiredRow != row){ // this would mean you want to move illegally
            return board;
        }

        if (desiredCol == col && desiredRow != row){ // moving left or right
            if (desiredRow > row){ // moving right
                for (int right = row + 1; right < desiredRow; right++){ // move right one space at a time
                    if (board[col][right] != null){ // invalid move, because something was in the way
                        return board;
                    }
                }
                // at this point it has "made it" to the desired position
                board[col][row] = null;
                row = desiredRow;
                board[col][row] = this;
                return board;
            }
            else{ // moving left
                for (int left = row - 1; left > desiredRow; left--){ // move right one space at a time
                    if (board[col][left] != null){ // invalid move, because something was in the way
                        return board;
                    }
                }
                // at this point it has "made it" to the desired position
                board[col][row] = null;
                row = desiredRow;
                board[col][row] = this;
                return board;
            }
        }

        if (desiredCol != col){ // moving up or down
            if (desiredCol > col){ // moving down
                for (int down = col + 1; down < desiredCol; down++){ // move right one space at a time
                    if (board[down][row] != null){ // invalid move, because something was in the way
                        return board;
                    }
                }
                // at this point it has "made it" to the desired position
            }
            else{ // moving up
                System.out.println("trying to move up");
                for (int up = col - 1; up > desiredCol; up--){ // move up one space at a time
                    System.out.println("up: " + up + " desiredCol: " + desiredCol);
                    if (board[up][row] != null){ // invalid move, because something was in the way
                        return board;
                    }
                }
                // at this point it has "made it" to the desired position
            }
            board[col][row] = null;
            col = desiredCol;
            board[col][row] = this;
            return board;
        }
        return board;
    }
    public Integer[][] getValidMoves(Pieces[][] board) {
        // maybe compare piece types instead of deepEquals?
        Integer[][] moves = new Integer[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int currentRow = row;
                int currentCol = col;
                if (board[i][j] != null){
                    if (color == 1) {
                        if (!checkEquality(move(deepCopy(board), i, j), board) && (board[i][j].getColor() != 1)) {
                            moves[i][j] = 1;
                            System.out.println("true");
                        }
                    }
                    else{
                        if (!checkEquality(move(deepCopy(board), i, j), board) && (board[i][j].getColor() != 0)) {
                            moves[i][j] = 1;
                            System.out.println("true");
                        }
                    }
                }
                else{
                    if (!checkEquality(move(deepCopy(board), i, j), board)) {
                        System.out.println("true");
                        moves[i][j] = 1;
                    }
                }
                row = currentRow;
                col = currentCol;
            }
        }
        return moves;
    }
}
