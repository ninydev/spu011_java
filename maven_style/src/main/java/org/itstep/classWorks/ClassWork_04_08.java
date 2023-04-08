package org.itstep.classWorks;

import org.itstep.models.Group;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class ClassWork_04_08 implements Runnable
{
    // данные для обработки
    int[] numbers = { 0, 1, 2, 3, 4, 5};
// -5, -4, -3, -2, -11,
    @Override
    public void run() {

        testA();
//        System.out.println("Fin by for: " + findMinByFor());
//        System.out.println("Fin by stream: " + finMinByStream());
    }

    Group spu = new Group();

    private void buildGroup()
    {

    }



    // Найти все отрицательные и среди них найти среднее значение
    public void testA(){
        try {
            System.out.println(Arrays.stream(numbers).filter(el -> el < 0).average().getAsDouble());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        OptionalDouble res = Arrays.stream(numbers).filter(el -> el < 0).average();

        if(res.isEmpty()) {
            System.out.println(" No result ");
        } else {
            System.out.println(res.getAsDouble());
        }
    }

    public int finMinByStream(){
        return Arrays.stream(numbers).min().getAsInt();
    }

    public int findMinByFor(){
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (min > numbers[i])
                min = numbers[i];
        }
        return min;
    }



}
