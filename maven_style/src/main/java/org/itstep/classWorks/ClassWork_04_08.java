package org.itstep.classWorks;

import org.itstep.models.Group;
import org.itstep.models.User;
import org.itstep.services.Password;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class ClassWork_04_08 implements Runnable
{
    public ClassWork_04_08(){
        buildGroup();
    }
    // данные для обработки
    int[] numbers = { 0, 1, 2, 3, 4, 5};
// -5, -4, -3, -2, -11,
    @Override
    public void run() {
        outGroup();
        buildEmails();
        outGroup();

        System.out.println(getByYear(1978));

//        testA();
//        System.out.println("Fin by for: " + findMinByFor());
//        System.out.println("Fin by stream: " + finMinByStream());
    }

    private List<User> getByYear(int year) {
        return spu
                .getUsers()
                .stream()
                .filter(u-> u.getYear() > year )
                .collect(Collectors.toList());
    }

    private void buildEmails(){
        spu.getUsers().stream().forEach(u -> u.setEmail(u.getName() + "@students.itstep.org"));
        spu.getUsers().stream().forEach(u -> u.setPassword(Password.generatePassword(8)));
    }

    private void outGroup() {
        for (User u: spu.getUsers()
        ) {
            System.out.println(u);
        }
        System.out.println("-----\n");
        //System.out.println(spu);
    }

    Group spu = new Group();

    private void buildGroup()
    {
        spu.setName(" СПУ-011 ");

        User a = new User();
        a.setName("Oleksandr");
        a.setYear(1977);
        spu.getUsers().add(a);

        User b = new User();
        b.setName("Boris");
        b.setYear(1979);
        spu.getUsers().add(b);

        User s = new User();
        s.setGroup(spu);
        s.setName("Sergey");
        s.setYear(2000);
        spu.getUsers().add(s);

        a.setGroup(spu);
        b.setGroup(spu);
        s.setGroup(spu);
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
