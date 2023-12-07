package com.example.c_h_e_s_s;


public class Knight extends Pieces{
    public Knight(int type, int color, int col, int row) {
        super(1, color, col, row);
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
        return new Knight(this.getType(), this.getColor(), this.getCol(), this.getRow());
    }

    @Override
    public Pieces[][] move(Pieces[][] board, int desiredCol, int desiredRow) {
        if (desiredRow == row + 2 && desiredCol == col + 1){
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }

        if (desiredRow == row + 1 && desiredCol == col - 2){
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }

        if (desiredRow == row - 1 && desiredCol == col + 2){
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }

        if (desiredRow == row - 2 && desiredCol == col + 1){
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }

        if (desiredRow == row + 2 && desiredCol == col - 1){
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }

        if (desiredRow == row - 2 && desiredCol == col - 1){
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }
        if (desiredRow == row + 1 && desiredCol == col + 2){
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }

        if (desiredRow == row - 1 && desiredCol == col - 2){
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }

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
