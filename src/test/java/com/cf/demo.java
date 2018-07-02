package com.cf;

public class demo {




    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("----------------");

        for (int i : arr) {

            System.out.println(arr[i]);
        }
//        InputStream in = new FileInputStream("a");

    }
}
