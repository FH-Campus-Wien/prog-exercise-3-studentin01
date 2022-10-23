package at.ac.fhcampuswien;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class App {
    // Implement all methods as public static
    public static void main(String[] args) {
        //Beispiel 1.
        oneMonthCalendar(31, 3);

        // Beispiel 2.
        long[] results = lcg(70); // testen der Methode
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
        // Beispiel 3.
        int numToGuess = randomNumberBetweenOneAndHundred();
        guessingGame(numToGuess);

        // Beispiel 4.
        int[] array1 = new int[]{1, 2, 3, 4, 5};
        int[] array2 = new int[]{100, 99, 60, 44, 2};
        swapArrays(array1, array2);
    }

    public static void oneMonthCalendar(int amountOfDays, int startDay) {
        int arrayLength = (amountOfDays - 1) + startDay;
        int[] field = new int[arrayLength];
        int j = 1;

        for (int i = startDay - 1; i < field.length; i++) {
            field[i] = j;
            j++;
        }
        for (int i = 0; i < field.length; i++) {
            if (i % 7 == 0) {
                System.out.println();
            }
            if (field[i] == 0) {

                System.out.print("   ");
            } else {
                System.out.printf("%2d ", field[i]);
            }
        }
    }

    public static long[] lcg(long seed) {
        long[] resultArray = new long[10];
        for (int i = 0; i < resultArray.length; i++) {

            Double m = Math.pow(2, 31);
            long a = 1103515245;
            long ax = a * seed;
            long c = 12345;

            long result = (ax + c) % m.longValue();
            resultArray[i] = result;
            seed++;
        }
        return resultArray;
    }

    public static void guessingGame(int numToGuess) {
        if (numToGuess > 100 || numToGuess < 1) {
            System.out.println("Please enter number between 1 and 100");
            return;
        }
        Scanner scan = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            System.out.println("Guess number " + i + ":");
            int guessNum = scan.nextInt();
            if (guessNum == numToGuess) {
                System.out.println("You won wisenheimer!");
                return;
            } else if (guessNum > numToGuess) {
                System.out.println("The number AI picked is lower than your guess.");
            } else {
                System.out.println("The number AI picked is higher than your guess.");
            }
        }
        System.out.println("You lost! Have you ever heard of divide & conquer?");
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random rn = new Random();
        int randomNumber = rn.nextInt(100 - 1 + 1) + 1;  // Formel: (max-min+1)+min
        return randomNumber;
    }

    public static boolean swapArrays(int[] array1, int[] array2) {
        if (array1.length == array2.length) {
            int[] copyArray1 = new int[array1.length];

            for (int a = 0; a < array1.length; a++) {
                copyArray1[a] = array1[a];
                array1[a] = array2[a];
                array2[a] = copyArray1[a];
            }
            return true;
        } else {
            return false;
        }
    }
    // test your method implementations here
    // make method calls
    // print their results
    // etc.
}
