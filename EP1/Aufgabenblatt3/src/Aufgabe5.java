/*
    Aufgabe 5) Kreismuster => Rekursiv vs. Iterativ
*/

import codedraw.CodeDraw;

import java.awt.*;

public class Aufgabe5 {

    private static void drawCirclePatternRecursively(CodeDraw myDrawObj, int x, int y, int r) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (r > 2) {
            drawCirclePatternRecursively(myDrawObj, x - r, y - r, r / 2);
            drawCirclePatternRecursively(myDrawObj, x + r, y - r, r / 2);
            drawCirclePatternRecursively(myDrawObj, x - r, y + r, r / 2);
            drawCirclePatternRecursively(myDrawObj, x + r, y + r, r / 2);

            myDrawObj.setColor(Color.RED);
            myDrawObj.drawCircle(x, y, r);
            myDrawObj.setColor(Color.ORANGE);
            myDrawObj.fillCircle(x, y, r);
        }
    }

    private static void drawCirclePatternIteratively(CodeDraw myDrawObj, int maxRadius) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int stages = (int) (Math.log(maxRadius) / Math.log(2));
        int r = myDrawObj.getWidth() / (int) Math.pow(2, stages);

        for (int i = 0; i < stages; i++) {
            for (int j = r * 2; j < myDrawObj.getWidth(); j += r * 4) {
                for (int k = r * 2; k < myDrawObj.getHeight(); k += r * 4) {
                    myDrawObj.setColor(Color.RED);
                    myDrawObj.drawCircle(j, k, r);
                    myDrawObj.setColor(Color.ORANGE);
                    myDrawObj.fillCircle(j, k, r);
                }
            }

            r *= 2;
        }
    }

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        CodeDraw myDrawObj = new CodeDraw(512, 512);

        drawCirclePatternRecursively(myDrawObj, 256, 256, 128);
        myDrawObj.show();

        drawCirclePatternIteratively(myDrawObj, 128);
        myDrawObj.show();

    }


    // Fragen:
    // 1) Wie oft wird die Methode drawCirclePatternRecursively aufgerufen, wenn die Rekursion bis zu einem Radius r > 2 aufgerufen wird?
    //    Sum(0, 5, 4^i) = 1365 Aufrufe bei denen Kreise gezeichnet werden plus 4^6 Aufrufe bei denen der Radius bereits < 2 ist
    //    => 5461 Aufrufe

    // 2) Wie viele Kreise werden auf der letzten Rekursionsstufe (die kleinsten Kreise) gezeichnet?
    //    4^5 = 1024

    // 3) Wie müssen Sie Ihre rekursive Implementierung abändern, um das Muster in Abbildung 1b zu erzeugen?
    //    den Aufruf der nach +x und -y gehen entfernen

}


