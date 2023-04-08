package org.itstep.classWorks;

import org.itstep.models.User;
import org.itstep.repository.UserRepository;
import org.itstep.repository.exceptions.EntityNotFindException;
import org.itstep.repository.interfaces.IEntity;
import org.itstep.repository.interfaces.IFindByEmail;

import java.util.UUID;

public class ClassWork_04_01 implements Runnable {

    @Override
    public void run() {
        repA();
    }

    void repA() {
////        User a = new User(UUID.randomUUID(), "keeper@ninydev.com", "Qwerty123");
////        User b = new User(UUID.randomUUID(), "nikitn_a@itstep.academy", "Qwerty123");
////
////        UserRepository users = new UserRepository();
////        users.add(a);
////        users.add(a);
////        users.add(b);
//
//        if(users instanceof IFindByEmail<?>) {
//            System.out.println(users.findByEmail(a.getEmail()));
//        }

//        for (Object u : users.data) {
//            System.out.println(u);
//        }
    }

    void rep() {


//        User findUser = users.findByStream(UUID.randomUUID());
//        System.out.println(findUser);

//        try {
//            User findUser = users.findByStream(UUID.randomUUID());
//            System.out.println(findUser.getEmail());
//        } catch (EntityNotFindException ex) {
//            System.out.println("Not Find");
//        }

//        try {
//            User findUser = users.findByForEach(UUID.randomUUID());
//            System.out.println(findUser.getEmail());
//        } catch (EntityNotFindException ex) {
//            System.out.println("Not Find");
//        }

    }
}
