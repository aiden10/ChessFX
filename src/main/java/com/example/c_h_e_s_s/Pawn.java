package com.example.c_h_e_s_s;

public class Pawn extends Pieces{
    boolean hasMoved;
    public Pawn(int type, int color, int col, int row, boolean hasMoved) {
        super(0, color, col, row);
        this.hasMoved = hasMoved;
    }

    @Override
    public int getColor() {
        return super.getColor();
    }

    @Override
    public int getCol() {return super.getCol();}

    @Override
    public int getRow() {return super.getRow();}
    public int getType(){return super.getType();}
    @Override
    public Pieces copy() {
        return new Pawn(this.getType(), this.getColor(), this.getCol(), this.getRow(), this.hasMoved);
    }
    @Override
    public Pieces[][] move(Pieces[][] board, int desiredCol, int desiredRow) {
    // don't need to worry about going out of bounds because you can only select valid squares
        if (color == 1){ // black
            if (!hasMoved){ // move 2 spaces
                if (desiredCol == col + 2 && desiredRow == row && board[col+1][row] == null){
                    board[col][row] = null; // set old position to be empty
                    col = desiredCol;
                    board[col][row] = this;
                    hasMoved = true;
                    return board;
                }
            }
            if (desiredCol == col + 1 && desiredRow == row){ // move 1 space
                if (board[col + 1][row] == null){ // make sure there's nothing there
                    board[col][row] = null;
                    col = desiredCol;
                    board[col][row] = this;
                    hasMoved = true;
                    return board;
                }
            }
            if (desiredCol == col + 1){ // capturing
                if (board[desiredCol][desiredRow] != null){
                    if (desiredRow == row + 1 || desiredRow == row - 1){
                        board[col][row] = null; // set old position to be empty
                        col = desiredCol;
                        row = desiredRow;
                        board[col][row] = this;
                        hasMoved = true;
                        return board;
                    }
                }
            }
        }
        else{ // white
            if (!hasMoved){ // move 2 spaces
                if (desiredCol == col - 2 && desiredRow == row && board[col-1][row] == null){
                    board[col][row] = null; // set old position to be empty
                    col = desiredCol;
                    board[col][row] = this;
                    hasMoved = true;
                    return board;
                }
            }
            if (desiredCol == col - 1 && desiredRow == row){ // move 1 space
                if (board[col - 1][row] == null){
                    board[col][row] = null;
                    col = desiredCol;
                    board[col][row] = this;
                    hasMoved = true;
                    return board;
                }
            }
            if (desiredCol == col - 1){
                if (board[desiredCol][desiredRow] != null){
                    if (desiredRow == row + 1 || desiredRow == row - 1){
                        board[col][row] = null; // set old position to be empty
                        col = desiredCol;
                        row = desiredRow;
                        board[col][row] = this;
                        hasMoved = true;
                        return board;
                    }
                }
            }
        }
        return board;
    }
    @Override
    public Integer[][] getValidMoves(Pieces[][] board) {
        Integer[][] moves = new Integer[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int currentRow = row;
                int currentCol = col;
                boolean currentState = hasMoved;
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
                hasMoved = currentState;
            }
        }
        return moves;
    }
}
