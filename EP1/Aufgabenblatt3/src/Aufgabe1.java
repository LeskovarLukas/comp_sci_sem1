/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {
    //TODO zu Punkt a): Beschreiben Sie hier in wenigen Sätzen was der Spaghetticode macht
    // Es wird ein Muster mit Breite 12 und Höhe 22 wird auf der Console ausgegeben
    // Das Muster zwischen der Ersten und Letzten Zeile wiederholt sich nach 10 Zeilen bzw nach 5 (jeder zweite Block gespiegelt)
    //

    //TODO zu Punkt b): Beschreiben Sie in wenigen Sätzen was Sie ändern würden und warum
    // Eine Schleife zwischen 0 und 22 für alle zeilen des Musters
    // die position von / und \ wird hoch bzw runtergezählt
    // bei jedem Viertel des Musters wird die richtung umgekehrt (/ wird nun runter- und \ dementsprechend hochgezählt)


    //TODO zu Punkt c): Implementieren Sie hier die Methoden Ihrer Lösung

    public static void printHeaderFooter(int width) {
        for (int i = 1; i <= width; i++) {
            if (i == 1 || i == width) {
                System.out.print('#');
            } else {
                 System.out.print("|");
            }
        }
        System.out.print('\n');
    }

    public static void printPattern() {
        printPattern(12);
    }

    public static void printPattern(int width) {
        printHeaderFooter(width);

        int line = 1;
        int increment = 1;
        for (int i = 1; i < width * 2; i++) {
            if (i % (width / 2) == 0) {
                increment *= -1;
            } else {
                for (int j = 0; j < width; j++) {
                    if (j < line || j > width - 1 - line) {
                        System.out.print('+');
                    } else if ((increment > 0 && j == line) || (increment < 0 && j == width - 1 - line)) {
                        System.out.print('\\');
                    } else if ((increment > 0 && j == width - 1 - line) || (increment < 0 && j == line)) {
                        System.out.print('/');
                    } else {
                        System.out.print('*');
                    }
                }
                System.out.print('\n');
            }
            line += increment;
        }

        printHeaderFooter(width);
    }



    public static void main(String args[]) {
        //********************************************************
        //TODO zu Punkt d): Implementieren Sie hier Ihre Lösung für die Angabe
        System.out.println("Ihre Ausgabe:");

        printPattern(14);

        //********************************************************

        System.out.println();
        System.out.println("Ausgabe Spaghetticode:");
        System.out.print("#");
        for (int i = 1; i <= 10; i++) {
        System.out.print("|");
        }
        System.out.println("#");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }            System.out.print("\\");
        for (int j = 1; j <= (10 - 2 * i); j++) {System.out.print("*");
            }
            System.out.print("/");
        for (int j = 1; j <= i; j++) {System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= (10/2-i+1); j++) {
                System.out.print("+");            }
        System.out.print("/");
            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("*");
            }System.out.print("\\");
            for (int j = 1; j <= (10/2-i+1); j++) { System.out.print("+");
            }
            System.out.println();        }
        for (int i = 1; i < 6; i++) {
                for (int j = 1; j <= i; j++) {
                System.out.print("+");            }
            System.out.print("\\");
                for (int j = 1; j <= (10-2*i); j++) {System.out.print("*");     }
            System.out.print("/");
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
        for (int j = 1; j <= (10/2-i+1); j++) {
                    System.out.print("+");
            }
            System.out.print("/");
            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("*");
            }
                System.out.print("\\");
            for (int j = 1; j <= (10/2-i+1); j++) {System.out.print("+");
            }
            System.out.println();
        }
        System.out.print("#");        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
        }
        System.out.println("#");
    }
}


