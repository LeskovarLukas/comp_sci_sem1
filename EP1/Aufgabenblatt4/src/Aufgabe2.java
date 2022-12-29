/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void printArray(int[] array, char space) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(space);
            }
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        //a
        int[] arrayOne = new int[] {6, 1, 8, 2, 5, 3, 4, 7, 9, 0};
        printArray(arrayOne, '#');

        //b
        int[] arrayTwo = new int[12];
        int number = 6;

        for (int i = 0; i < arrayTwo.length; i++) {
            arrayTwo[i] = number;
            if (arrayTwo[i] % 9 == 0)
                arrayTwo[i] = 0;

            number += 6;
        }
        printArray(arrayTwo, ' ');

        //c
        int[] arrayThree = new int[] {7, 3, 2, 7, 6, 7, 7, 8, 9, 5};
        int countSeven = 0;

        for (int i = 0; i < arrayThree.length; i++) {
            if (arrayThree[i] == 7)
                countSeven++;
        }

        int[] newArray = new int[arrayThree.length + countSeven];
        int current = 0;
        for (int j = 0; j < arrayThree.length; j++) {
            newArray[current] = arrayThree[j];
            if (arrayThree[j] == 7) {
                newArray[++current] = -1;
            }
            current++;
        }
        printArray(newArray, ' ');

        //d
        int[] arrayFour = new int[11];
        for (int i = 0; i < arrayFour.length; i++) {
            arrayFour[i] = i + 1;
        }

        System.out.print("for-schleife: ");
        for (int i = arrayFour.length - 1; i >= 0; i--) {
            System.out.print(arrayFour[i]);
            if (i > 0)
                System.out.print(',');
        }

        System.out.print("\nwhile-schleife: ");
        current = arrayFour.length - 1;
        while (current >= 0) {
            System.out.print(arrayFour[current]);
            if (current-- > 0)
                System.out.print(',');
        }
    }
}

