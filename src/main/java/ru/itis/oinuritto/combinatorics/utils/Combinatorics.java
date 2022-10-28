package ru.itis.oinuritto.combinatorics.utils;

import java.math.BigInteger;

public class Combinatorics {
    private static BigInteger Factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    public static String permutationNonRepeat(int n) {
        return Factorial(n).toString();
    }

    public static String permutationRepeat(int n, int[] arr) {
        BigInteger denominator = BigInteger.ONE;
        for (int i = 0; i < arr.length; i++) {
            denominator = denominator.multiply(Factorial(arr[i]));
        }
        BigInteger result = Factorial(n).divide(denominator);

        return result.toString();
    }

    public static String variationsNonRepeat(int n, int m) {
        return Factorial(n).divide(Factorial(n - m)).toString();
    }

    public static String variationsRepeat(int n, int m) {
        return String.valueOf(BinaryPower(n, m));
    }

    public static String combinationsNonRepeat(int n, int m) {
        return Factorial(n).divide(Factorial(n - m).multiply(Factorial(m))).toString();
    }

    public static String combinationsRepeat(int n, int m) {
        return Factorial(n + m - 1).divide(Factorial(n - 1).multiply(Factorial(m))).toString();
    }

    public static int sumArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static double BinaryPower(double b, long e) {
        double v = 1d;
        while(e > 0) {
            if((e & 1) != 0) {
                v *= b;
            }
            b *= b;
            e >>= 1;
        }
        return v;
    }
}
