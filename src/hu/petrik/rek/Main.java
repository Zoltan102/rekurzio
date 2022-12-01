package hu.petrik.rek;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //System.out.println(factorial(4));
        //System.out.println(power(2, 2));
        //int max = 90;
        //int pcs = 5;
        //int[] array = new int[5];
        //lottery(array, max, pcs);
        //for (int x : array) {
        //    System.out.println(x + "; ");
        //}
        int[] array = new int[100];
        for(int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        int num = 21;
        System.out.println(array[logarithmicSearch(array, 0, array.length - 1, num)]);
    }

    public static int factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1);
        }
        return 1;
    }

    public static int power(int a, int n) {
        if (n > 0) {
            return power(a, n - 1) * a;
        }
        return 1;
    }

    public static int lottery(int[] drewLots, int max, int pcs) {
        if (pcs > 0) {
            int test = (int) (Math.random() * max + 1);
            boolean contains = Arrays.stream(drewLots).anyMatch(num -> num == test);
            if (contains) {
                lottery(drewLots, max, pcs - 1);
            } else {
                drewLots[pcs - 1] = test;
                lottery(drewLots, max, pcs - 1);
            }
        }
        return 1;
    }

    public static int logarithmicSearch(int[] x, int left, int right, int item) {
        if (left > right) {
            return 0;
        } else {
            int center = Math.abs((left + right) / 2);
            if (x[center] == item) {
                return center;
            } else if(x[center] > item) {
                return logarithmicSearch(x, left, center - 1, item);
            } else {
                return logarithmicSearch(x, center + 1, right, item);
            }
        }
    }
}