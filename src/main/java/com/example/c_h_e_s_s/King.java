package com.example.c_h_e_s_s;

public class King extends Pieces{
    boolean inCheck;
    public King(int type, int color, int col, int row, boolean inCheck) {
        super(5, color, col, row);
        this.inCheck = inCheck;
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

        if (inCheck){
            return board;
        }

        if (Math.abs(col - desiredCol) > 1 || Math.abs(row - desiredRow) > 1){ // trying to move to a spot which is too far
            return board;
        }

        else{
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
        }
        return board;
    }
}
