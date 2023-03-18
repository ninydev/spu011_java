package org.itstep;

public class ArrayModel implements Runnable
{
    @Override
    public void run() {
        int arr[] = new int[10];
        System.out.println(arr[0]);
        try {
            System.out.println(arr[100]);
        }catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println(arr.length);
        System.out.println(arr.getClass());


    }
}
