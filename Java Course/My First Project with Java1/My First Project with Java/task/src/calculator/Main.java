package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum=0;
        int val1 = 202, val2 = 118, val3 = 2250, val4 = 1680, val5 = 1075, val6 = 80;
        System.out.println("Earned amount:");
        System.out.printf("Bubblegum: &%d\n", val1);
        System.out.printf("Toffee: $%d\n",val2);
        System.out.printf("Ice cream: $%d\n", val3);
        System.out.printf("Milk chocolate: $%d\n", val4);
        System.out.printf("Doughnut: $%d\n", val5);
        System.out.printf("Pancake: $%d\n", val6);
        System.out.println();
        sum= val1+val2+val3+val4+val5+val6;
        System.out.printf("Income: $%d", sum);
        System.out.println("Staff expenses:");
        int staff = scanner.nextInt();
        System.out.println("Other expenses:");
        int other = scanner.nextInt();
        System.out.println("Net income: " + (sum-staff-other));
    }
}