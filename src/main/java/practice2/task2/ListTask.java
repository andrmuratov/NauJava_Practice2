package practice2.task2;

import java.util.ArrayList;
import java.util.Random;

public class ListTask {

    public static void main(String[] args) {
        int n = 10;
        ArrayList<Double> list = genList(n);

        System.out.println("Iskhodniy: " + list);
        sort(list);
        System.out.println("Sortirovanniy: " + list);
    }

    private static ArrayList<Double> genList(int n) {
        ArrayList<Double> l = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            l.add(r.nextDouble() * 100);
        }
        return l;
    }

    private static void sort(ArrayList<Double> l) {
        for (int i = 0; i < l.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < l.size(); j++) {
                if (l.get(j) < l.get(min)) {
                    min = j;
                }
            }
            Double tmp = l.get(i);
            l.set(i, l.get(min));
            l.set(min, tmp);
        }
    }
}