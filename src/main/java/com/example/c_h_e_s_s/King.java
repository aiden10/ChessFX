package com.example.c_h_e_s_s;

public class King extends Pieces{
    boolean inCheck;
    public King(int type, int color, int col, int row, boolean inCheck) {
        super(5, color, col, row);
        this.inCheck = inCheck;
    }
    @Override
    public int getColor() {return super.getColor();}
    @Override
    public int getCol() {return super.getCol();}

    @Override
    public int getRow() {return super.getRow();}
    public int getType(){return super.getType();}

    public Pieces copy() {
        return new King(this.getType(), this.getColor(), this.getCol(), this.getRow(), this.inCheck);
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
    public Integer[][] getValidMoves(Pieces[][] board) {
        // maybe compare piece types instead of deepEquals?
        Integer[][] moves = new Integer[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int currentRow = row;
                int currentCol = col;
                boolean currentState = inCheck;
                if (board[i][j] != null){
                    if (color == 1) {
                        if (!checkEquality(move(deepCopy(board), i, j), board) && (board[i][j].getColor() != 1)) {
                            moves[i][j] = 1;
                        }
                    }
                    else{
                        if (!checkEquality(move(deepCopy(board), i, j), board) && (board[i][j].getColor() != 0)) {
                            moves[i][j] = 1;
                        }
                    }
                }
                else{
                    if (!checkEquality(move(deepCopy(board), i, j), board)) {
                        moves[i][j] = 1;
                    }
                }
                row = currentRow;
                col = currentCol;
                inCheck = currentState;
            }
        }
        return moves;
    }
}
