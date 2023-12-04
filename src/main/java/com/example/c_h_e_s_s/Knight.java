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
}
