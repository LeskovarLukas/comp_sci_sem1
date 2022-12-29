/*
    Aufgabe 3) Zweidimensionale Arrays und CodeDraw - Bildverarbeitung "Finding Waldo"
*/

import codedraw.CodeDraw;
import codedraw.Palette;
import codedraw.Image;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Aufgabe3 {

    // converts RGB image into a grayscale array
    private static int[][] convertImg2Array(Image img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] imgArray = new int[height][width];
        Color tempColor;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tempColor = img.getPixel(col, row);
                imgArray[row][col] = (int) (tempColor.getRed() * 0.3 + tempColor.getGreen() * 0.59 + tempColor.getBlue() * 0.11);
            }
        }
        return imgArray;
    }

    //detect waldo by template matching
    private static void detectWaldo(CodeDraw myDrawObj, Image img, Image template) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        myDrawObj.setColor(Palette.DEEP_PINK);
        myDrawObj.setLineWidth(6);

        int[][] imgArray = convertImg2Array(img);
        int[][] templateArray = convertImg2Array(template);
        int minSum = Integer.MAX_VALUE;

        for (int x = 0; x <= img.getWidth() - template.getWidth(); x++) {
            for (int y = 0; y <= img.getHeight() - template.getHeight(); y++) {
                int sum = 0;

                for (int j = 0; j < template.getWidth(); j++) {
                    for (int i = 0; i < template.getHeight(); i++) {
                        int imagePixel = imgArray[y + i][x + j];
                        int templatePixel = templateArray[i][j];

                        sum += Math.abs(imagePixel - templatePixel);
                    }
                }

                if (sum < minSum) {
                    minSum = sum;
                    myDrawObj.clear();
                    myDrawObj.drawImage(0, 0, img);
                    myDrawObj.drawRectangle(x, y, template.getWidth(), template.getHeight());
                    myDrawObj.show(300);
                }
            }
        }
    }

    public static void main(String[] args) {

        //waldo1
//        String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/6NcsuQdriPbHcKN/download"; //waldo1.png
//        String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/AwlmIBqj2V1qGV7/download"; //template1.png

        //waldo2
//        String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/922nyXVsBkMKz6K/download"; //waldo2.png
//        String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/tqTFXxF2BkeKnhm/download"; //template2.png

        //waldo3
        String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/DR2u4Xf5muAZsWo/download"; //waldo3.png
        String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/xEMZlbdHJ4ZfLfz/download"; //template3.png

        // open image file
        Image img = Image.fromUrl(linkWaldo);

        // open template image file
        Image template = Image.fromUrl(linkTemplate);

        // set StdDraw window size based on the image size
        int width = img.getWidth();
        int height = img.getHeight();
        CodeDraw cd = new CodeDraw(width, height);

        //draw image
        cd.drawImage(0, 0, img);
        cd.show();

        //detect Waldo given in 'template' and show result in image 'img'
        detectWaldo(cd, img, template);
    }
}





