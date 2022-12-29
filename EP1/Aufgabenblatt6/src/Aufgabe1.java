/*
    Aufgabe 1) Zweidimensionale Arrays und Methoden - Vier Gewinnt
*/

import codedraw.*;

import java.awt.*;

public class Aufgabe1 {

    private static int[][] genGameBoard(int row, int col) {
        return new int[row][col];
    }

    private static void drawGameBoard(CodeDraw myDrawObj, int[][] currentGameBoard, int oneSquareSize) {
        myDrawObj.setColor(Palette.MEDIUM_BLUE);
        myDrawObj.fillRectangle(0, 0, myDrawObj.getWidth(), myDrawObj.getHeight());

        for (int x = 0; x < myDrawObj.getWidth(); x += oneSquareSize) {
            for (int y = 0; y < myDrawObj.getHeight(); y += oneSquareSize) {
                Color circleColor = Palette.DARK_GRAY;
                int row = y / oneSquareSize;
                int col = x / oneSquareSize;
                int centering = oneSquareSize / 2;

                if (currentGameBoard[row][col] == 1) {
                    circleColor = Palette.RED;
                } else if (currentGameBoard[row][col] == 2) {
                    circleColor = Palette.YELLOW;
                }

                myDrawObj.setColor(circleColor);
                myDrawObj.fillCircle(x + centering, y + centering, oneSquareSize / 3);
            }
        }
        myDrawObj.show();
    }

    private static boolean isMovePossible(int[][] currentGameBoard, int col) {
        return currentGameBoard[0][col] == 0;
    }

    private static void makeMove(int[][] currentGameBoard, int player, int col) {
        for (int i = currentGameBoard.length - 1; i >= 0; i--) {
            if (currentGameBoard[i][col] == 0) {
                currentGameBoard[i][col] = player;
                return;
            }
        }
    }

    private static boolean existsWinner(int[][] currentGameBoard, int player) {
        int gameHeight = currentGameBoard.length;
        int gameWidth = currentGameBoard[0].length;

        for (int i = gameHeight - 1; i >= 0; i--) {
            for (int j = 0; j < gameWidth; j++) {
                if (currentGameBoard[i][j] == 0)
                    continue;

                boolean vertical = true;
                boolean horizontalLeft = true;
                boolean horizontalRight = true;
                boolean diagonalLeft = true;
                boolean diagonalRight = true;

                boolean yFloor = i - 3 >= 0;
                boolean xFloor = j - 3 >= 0;
                boolean xCeil = j + 3 < gameWidth;

                for (int k = 0; k <= 3; k++) {
                    vertical &= yFloor && currentGameBoard[i - k][j] == player;

                    horizontalLeft &= xFloor && currentGameBoard[i][j - k] == player;
                    horizontalRight &= xCeil && currentGameBoard[i][j + k] == player;
                    horizontalRight &= xCeil && currentGameBoard[i][j + k] == player;

                    diagonalLeft &= yFloor && xFloor && currentGameBoard[i - k][j - k] == player;
                    diagonalRight &= yFloor && xCeil && currentGameBoard[i - k][j + k] == player;

                }

                if (vertical || horizontalLeft || horizontalRight || diagonalLeft || diagonalRight) {
                    return true;
                }
            }
        }

        return false;
    }


    // Eigene Funktionen
    public static void printText(CodeDraw myDrawObj, Color color, String text, int duration) {
        int textX = myDrawObj.getWidth() / 2;
        int textY = myDrawObj.getHeight() / 2;
        myDrawObj.setColor(color);
        myDrawObj.drawText(textX, textY, text);
        myDrawObj.show(duration);
    }

    public static void animateEmptying(CodeDraw myDrawObj, int[][] currentGameBoard, int oneSquareSize) {
        for (int i = 0; i < currentGameBoard.length; i++) {
            for (int j = currentGameBoard.length - 1; j > i; j--) {
                currentGameBoard[j] = currentGameBoard[j - 1];
            }
            currentGameBoard[i] = new int[currentGameBoard[i].length];

            drawGameBoard(myDrawObj, currentGameBoard, oneSquareSize);
            myDrawObj.show(500);
        }
    }


    public static void main(String[] args) {

        // canvas settings
        int rowsGameBoard = 6;
        int colsGameBoard = 7;
        int oneSquareSize = 50;
        int width = oneSquareSize * colsGameBoard;
        int height = oneSquareSize * rowsGameBoard;

        CodeDraw myDrawObj = new CodeDraw(width, height);
        EventScanner myEventSC = myDrawObj.getEventScanner();

        // game variables
        int[][] myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
        int player = 1;
        int fieldsUsed = 0;
        boolean gameActive = true;

        // set font for text
        TextFormat font = new TextFormat();
        font.setFontSize(28);
        font.setFontName("Arial");
        font.setTextOrigin(TextOrigin.CENTER);
        font.setBold(true);
        myDrawObj.setTextFormat(font);

        // initial draw of the game board
        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);

        // game play starts
        System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " has to make a move");
        while (!myDrawObj.isClosed() && gameActive) {
            if(myEventSC.hasKeyPressEvent()){
                if(myEventSC.nextKeyPressEvent().getChar() == 'q'){
                    gameActive = false;
                }
            }
            else if (myEventSC.hasMouseClickEvent()) {
                MouseClickEvent currentClick = myEventSC.nextMouseClickEvent();
                int mouseX = currentClick.getX();
                int col = Math.min(mouseX / oneSquareSize, 6);

                if (!isMovePossible(myGameBoard, col)) {
                    printText(myDrawObj, Palette.ORANGE, "Column already full!", 1000);
                    drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                    continue;
                }

                makeMove(myGameBoard, player, col);
                drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                fieldsUsed++;

                if (existsWinner(myGameBoard, player)) {
                    printText(myDrawObj, Palette.GREEN,
                            "Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + "won!", 3000);
                    myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
                    drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                    printText(myDrawObj, Palette.ORANGE, "Next Round!", 1000);
                    fieldsUsed = 0;
                } else if (fieldsUsed >= rowsGameBoard * colsGameBoard) {
                    printText(myDrawObj, Palette.ORANGE, "Board full!", 1000);
                    animateEmptying(myDrawObj, myGameBoard, oneSquareSize);
                    printText(myDrawObj, Palette.ORANGE, "Try Again!", 1000);
                    fieldsUsed = 0;
                }

                drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                player = (player == 1 ? 2 : 1);
                System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " has to make a move");
            }
            else {
                myEventSC.nextEvent();
            }
        }
        myDrawObj.close();
    }
}


