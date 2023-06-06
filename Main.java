package org.example;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // 1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
        Integer x = null;
        int[] arr = {2,7,4,1,3};
        //System.out.println(factorial(2));        // StackOverflowError
        //sum(x);                                 // NullPointerException
        //getElementArrayForIndex(arr, 8);        //ArrayIndexOutOfBoundsException

        // 2. Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
        String[][] arr3 = {
                {"1","3","4","5","7"},
                {"1","3","4","4","5"}
        };
        System.out.println(sum2d(arr3));

        // 3. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
        //    каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
        //    Если длины массивов не равны, необходимо как-то оповестить пользователя.
        int[] arr1 = {5,0,8,2,5};
        int[] arr2 = {2,7,4,1,3};
        System.out.println(Arrays.toString(diffArr(arr1, arr2)));


    }

    // 1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
    public static long  factorial (int n){
       // if (n == 1) return  n  Исключаем уловия выхода для получения StackOverflowError
        return n * factorial( n - 1 );
    }
    public static int sum (int x){  // Если вместе x передать ссылку которе веде в пустоту получаем NullPointerException.
        return  10 + x;
    }
    public static int getElementArrayForIndex(int[] arr, int index){ //Если передать индекс за паределами массива получи ArrayIndexOutOfBoundsException
        return arr[index];
    }


    // 2. Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
    public static int sum2d(String[][] arr) {
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < 5; j++) {                // 1.ArrayIndexOutOfBoundsException. (  Возникает если длина хотя бы одного авложенног массива  6 элементов )
                    int val = Integer.parseInt(arr[i][j]);  // 2.NumberFormatException (i / j не являются int, значение i / j выходят за пределы Integer.MAX_VALUE
                    sum += val;
                }
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            System.out.println("Exception!");
            e.printStackTrace();

        }
        return sum;
    }

    // 3. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
    //    каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
    //    Если длины массивов не равны, необходимо как-то оповестить пользователя.
    public static int[] diffArr(int[] arr, int[] arr2){
        if (arr.length != arr2.length)
            throw new RuntimeException("Array lengths do not match");
        int[] result = new int[arr.length];
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            result[i] = arr[i] - arr2[i];
        }
        return  result;
    }


}