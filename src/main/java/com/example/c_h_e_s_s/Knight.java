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
