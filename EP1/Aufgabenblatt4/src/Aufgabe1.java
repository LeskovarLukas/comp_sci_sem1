/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {

    private static void fillArray(int[] filledArray) {
        int number = 6;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 6;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 4 == 0) {
                copiedArray[i] = -1;
            }
        }
        printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[10];
        int number = 6;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 6;
        }
        workArray = helpArray;
        printArray(workArray);
    }

    private static void printArray(int[] workArray) {
        for (int i = 0; i < workArray.length; i++) {
            System.out.print(workArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] filledArray = new int[10];
        fillArray(filledArray);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 777;
        printArray(filledArray);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);

        filledArray.clone();
    }

    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //Frage 1:
    //Weil i dekrementiert wird. Nach dem ersten Schleifendurchlauf stünde i bei -1 was außerhalb des Arrays liegt
    //Frage 2:
    //Weil das Array per Referenz übergeben wird. Innerhalb der Funktion wird mittels Referenz auf das in main angelegt
    // array gearbeitet
    //Frage 3:
    //Es handelt sich um keine Deep-Copy. Es wird nur eine neue Referenz auf das Array in main angelegt
    //Frage 4:
    //Weil die Referenz der variable workArray auf das helpArray geändert wird. Somit gibt es keine Referenz mehr
    // auf das Array in main

    //Zusatzfrage 1:
    //Integer
    //Zusatzfrage 2:
    //Ja sonst habe ich nur eine Referenzvariable die auf nichts gesetzt ist. Ein Array wird bei der Definition mit
    // Werten befüllt
    //Zusatzfrage 3:
    //Neues Array anlegen. Werte kopieren. Referenz des alten Arrays auf das neue setzen.
    //Zusatzfrage 4:
    //Entweder Arrays.copyOf() oder Array durchlaufen und jeden Wert in das neue Array kopieren.
    //Zusatzfrage 5:
    //Ja. Aus C: Der Pointer x zeigt auf das erste Element. x+1 entspricht dem zweiten Element
    //Zusatzfrage 6:
    //Nein. == vergleicht nur ob die Referenzvariablen gleich sind
}
