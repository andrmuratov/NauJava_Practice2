package practice2.task1;

import java.util.Random;

public class ArrayTask {

    public static void main(String[] args) {
        int n = 20;
        int[] arr = genArr(n, -50, 50);

        System.out.print("Massiv: ");
        printArr(arr);

        Integer res = findLP(arr);

        if (res != null) {
            System.out.println("Posledniy polozhitelniy: " + res);
        } else {
            System.out.println("Polozhitelnih net");
        }
    }

    private static int[] genArr(int size, int min, int max) {
        Random rand = new Random();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt(max - min + 1) + min;
        }
        return a;
    }

    private static Integer findLP(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] > 0) {
                return a[i];
            }
        }
        return null;
    }

    private static void printArr(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}