/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static void printEvenNumbersAscending(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (start > end)
            return;
        if (start % 2 == 0)
            System.out.print(start + "; ");
        printEvenNumbersAscending(start + 1, end);
    }

    private static void printOddNumbersDescending(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (start > end)
            return;
        printOddNumbersDescending(start + 1, end);
        if (start % 2 != 0)
            System.out.print(start + "; ");
    }

    private static int sumSquaredDigits(int number) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (number == 1)
            return 1;
        else if (number == 0)
            return 0;

        int lastDigit = number % 10;
        int newNumber = number / 10;

        return (lastDigit * lastDigit) + sumSquaredDigits(newNumber);
    }

    private static String removeSpaces(String text) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (text.length() > 1)
            return removeSpaces(text.substring(0, text.length() / 2)) + removeSpaces(text.substring(text.length() / 2, text.length()));
        else if (!text.equals(" "))
            return text;
        else
            return "";
    }

    public static void main(String[] args) {
        printEvenNumbersAscending(10, 20);
        System.out.println();
        printOddNumbersDescending(5, 15);
        System.out.println();

        System.out.println(sumSquaredDigits(1));
        System.out.println(sumSquaredDigits(102));
        System.out.println(sumSquaredDigits(1234));
        System.out.println(sumSquaredDigits(10000));
        System.out.println(sumSquaredDigits(93842));
        System.out.println(sumSquaredDigits(875943789));
        assert (sumSquaredDigits(1) == 1);
        assert (sumSquaredDigits(102) == 5);
        assert (sumSquaredDigits(1234) == 30);
        assert (sumSquaredDigits(10000) == 1);
        assert (sumSquaredDigits(93842) == 174);
        assert (sumSquaredDigits(875943789) == 438);
        System.out.println();

        System.out.println(removeSpaces(" "));
        System.out.println(removeSpaces("+ +"));
        System.out.println(removeSpaces(" 12 3 45 "));
        System.out.println(removeSpaces("a  b   c    d"));
        assert (removeSpaces(" ").equals(""));
        assert (removeSpaces("+ +").equals("++"));
        assert (removeSpaces(" 12 3 45 ").equals("12345"));
        assert (removeSpaces("a  b   c    d").equals("abcd"));
    }
}

