package com.example.c_h_e_s_s;

import javafx.scene.Group;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public abstract class Pieces {
    int type;
    int color;
    int col;
    int row;
    public Pieces(int type, int color, int col, int row){
        this.type = type;
        this.color = color;
        this.col = col;
        this.row = row;
    }
    public abstract Pieces[][] move(Pieces[][] board, int desiredCol, int desiredRow); // the position the player wants to move to

    public int getColor() {
        return color;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getType() {return type;}

    public Group draw() throws FileNotFoundException {
        ImageView imageView = new ImageView();
        Group chessImages = new Group();

        if (color == 0){ // white
           if (type == 0){ // pawn
               InputStream stream = new FileInputStream("src/main/resources/com/example/c_h_e_s_s/white pawn.png");
               Image pawn = new Image(stream);
               imageView.setImage(pawn);
               imageView.setX(100 * row);
               imageView.setY(100 * col);
               imageView.setPreserveRatio(true);
               chessImages.getChildren().add(imageView);
               return chessImages;
           }
           else if (type == 1){ // knight
               InputStream stream = new FileInputStream("src/main/resources/com/example/c_h_e_s_s/white knight.png");
               Image knight = new Image(stream);
               imageView.setImage(knight);
               imageView.setX(100 * row);
               imageView.setY(100 * col);
               imageView.setPreserveRatio(true);
               chessImages.getChildren().add(imageView);
               return chessImages;

           }
           else if (type == 2){ // bishop
               InputStream stream = new FileInputStream("src/main/resources/com/example/c_h_e_s_s/white bishop.png");
               Image bishop = new Image(stream);
               imageView.setImage(bishop);
               imageView.setX(100 * row);
               imageView.setY(100 * col);
               imageView.setPreserveRatio(true);
               chessImages.getChildren().add(imageView);
               return chessImages;

           }
           else if (type == 3){ // rook
               InputStream stream = new FileInputStream("src/main/resources/com/example/c_h_e_s_s/white rook.png");
               Image rook = new Image(stream);
               imageView.setImage(rook);
               imageView.setX(100 * row);
               imageView.setY(100 * col);
               imageView.setPreserveRatio(true);
               chessImages.getChildren().add(imageView);
               return chessImages;

           }
           else if (type == 4){ // queen
               InputStream stream = new FileInputStream("src/main/resources/com/example/c_h_e_s_s/white queen.png");
               Image queen = new Image(stream);
               imageView.setImage(queen);
               imageView.setX(100 * row);
               imageView.setY(100 * col);
               imageView.setPreserveRatio(true);
               chessImages.getChildren().add(imageView);
               return chessImages;

           }
           else if (type == 5){ // king
               InputStream stream = new FileInputStream("src/main/resources/com/example/c_h_e_s_s/white king.png");
               Image king = new Image(stream);
               imageView.setImage(king);
               imageView.setX(100 * row);
               imageView.setY(100 * col);
               imageView.setPreserveRatio(true);
               chessImages.getChildren().add(imageView);
               return chessImages;

           }
        }

        else{ // black
            if (type == 0){ // pawn
                InputStream stream = new FileInputStream("src/main/resources/com/example/c_h_e_s_s/black pawn.png");
                Image pawn = new Image(stream);
                imageView.setImage(pawn);
                imageView.setX(100 * row);
                imageView.setY(100 * col);
                imageView.setPreserveRatio(true);
                chessImages.getChildren().add(imageView);
                return chessImages;
            }
            else if (type == 1){ // knight
                InputStream stream = new FileInputStream("src/main/resources/com/example/c_h_e_s_s/black knight.png");
                Image knight = new Image(stream);
                imageView.setImage(knight);
                imageView.setX(100 * row);
                imageView.setY(100 * col);
                imageView.setPreserveRatio(true);
                chessImages.getChildren().add(imageView);
                return chessImages;

            }
            else if (type == 2){ // bishop
                InputStream stream = new FileInputStream("src/main/resources/com/example/c_h_e_s_s/black bishop.png");
                Image bishop = new Image(stream);
                imageView.setImage(bishop);
                imageView.setX(100 * row);
                imageView.setY(100 * col);
                imageView.setPreserveRatio(true);
                chessImages.getChildren().add(imageView);
                return chessImages;

            }
            else if (type == 3){ // rook
                InputStream stream = new FileInputStream("src/main/resources/com/example/c_h_e_s_s/black rook.png");
                Image rook = new Image(stream);
                imageView.setImage(rook);
                imageView.setX(100 * row);
                imageView.setY(100 * col);
                imageView.setPreserveRatio(true);
                chessImages.getChildren().add(imageView);
                return chessImages;

            }
            else if (type == 4){ // queen
                InputStream stream = new FileInputStream("src/main/resources/com/example/c_h_e_s_s/black queen.png");
                Image queen = new Image(stream);
                imageView.setImage(queen);
                imageView.setX(100 * row);
                imageView.setY(100 * col);
                imageView.setPreserveRatio(true);
                chessImages.getChildren().add(imageView);
                return chessImages;

            }
            else if (type == 5){ // king
                InputStream stream = new FileInputStream("src/main/resources/com/example/c_h_e_s_s/black king.png");
                Image king = new Image(stream);
                imageView.setImage(king);
                imageView.setX(100 * row);
                imageView.setY(100 * col);
                imageView.setPreserveRatio(true);
                chessImages.getChildren().add(imageView);
                return chessImages;
            }
        }
        return chessImages;
    }

    public Integer[][] getValidMoves(Pieces[][] board) {
        return new Integer[8][8];
    }
    public abstract Pieces copy();
    public Pieces[][] deepCopy(Pieces[][] board){
        Pieces[][] copy = new Pieces[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) {
                    copy[i][j] = (board[i][j]).copy();
                }
            }
        }
        return copy;
    }
    public boolean checkEquality(Pieces[][] board1, Pieces[][] board2){
        for (int i = 0; i < board1.length; i++){
            for (int j = 0; j < board1[0].length; j++){
                if (board1[i][j] == null && board2[i][j] != null || board1[i][j] != null && board2[i][j] == null){
                    return true;
                }
                else if (board1[i][j] != null && board2[i][j] != null){
                    if (board1[i][j].getType() != board2[i][j].getType()){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
