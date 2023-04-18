package com.codecool.aafindtheuniquenumber;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.print("kata: find the unique number: ");
        double[] arr = {0, 0, 1, 0, 0};
        double result = findUniq(arr);
        System.out.println(result);
    }

    public static double findUniq(double[] arr) {
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
    }
}
