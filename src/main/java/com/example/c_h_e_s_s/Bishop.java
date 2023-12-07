package com.example.c_h_e_s_s;
import java.lang.Math;
public class Bishop extends Pieces{
    public Bishop(int type, int color, int col, int row) {
        super(2, color, col, row);
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
        return new Bishop(this.getType(), this.getColor(), this.getCol(), this.getRow());
    }

    @Override
    public Pieces[][] move(Pieces[][] board, int desiredCol, int desiredRow) {
        if (desiredCol == col || desiredRow == row){ // invalid move
            return board;
        }
        else{ // different row and column
            int columnMovement = Math.abs(col - desiredCol);
            int rowMovement = Math.abs(row - desiredRow);
            if (columnMovement != rowMovement){ // but not moving diagonally
                return board; // so it's invalid
            }
        }

        // up left
        if (desiredCol < col && desiredRow < row){
            for (int i = 1; i < Math.abs(desiredCol - col); i++){ // Math.abs(desiredCol - col) could be row as well, but they're already equal if this is reached
                if (board[col - i][row - i] != null){ // there is a piece in the way
                    return board; // invalid
                }
            }
            // means the piece has made it to its desired position without encountering another piece
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }


        // up right
        if (desiredCol < col){
            for (int i = 1; i < Math.abs(desiredCol - col); i++){ // Math.abs(desiredCol - col) could be row as well, but they're already equal if this is reached
                // col down
                // row up
                if (board[col - i][row + i] != null){ // there is a piece in the way
                    return board; // invalid
                }
            }
            // means the piece has made it to its desired position without encountering another piece
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }


        // down left
        if (desiredRow < row){
            for (int i = 1; i < Math.abs(desiredCol - col); i++){ // Math.abs(desiredCol - col) could be row as well, but they're already equal if this is reached
                // col up
                // row down
                if (board[col + i][row - i] != null){ // there is a piece in the way
                    return board; // invalid
                }
            }
            // means the piece has made it to its desired position without encountering another piece
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }


        // down right
        for (int i = 1; i < Math.abs(desiredCol - col); i++) { // Math.abs(desiredCol - col) could be row as well, but they're already equal if this is reached
            // col up
            // row down
            if (board[col + i][row + i] != null) { // there is a piece in the way
                return board; // invalid
            }
        }
        // means the piece has made it to its desired position without encountering another piece
        board[col][row] = null;
        col = desiredCol;
        row = desiredRow;
        board[col][row] = this;
        return board;
    }
    public Integer[][] getValidMoves(Pieces[][] board) {
        Integer[][] moves = new Integer[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int currentRow = row;
                int currentCol = col;
                if (board[i][j] != null){ // not null

                    if (checkEquality(move(deepCopy(board), i, j), board) && (board[i][j].getColor() != color)) { // is enemy piece?
                        moves[i][j] = 1;
                        if (board[i][j].getType() == 5) { // is it enemy king?
                            King enemyKing = (King) board[i][j];
                            enemyKing.inCheck = true;
                        }
                    }
                }
                else{
                    if (checkEquality(move(deepCopy(board), i, j), board)) {
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
