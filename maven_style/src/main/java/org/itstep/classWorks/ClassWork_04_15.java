package org.itstep.classWorks;

import org.itstep.threads.MyRandThread;

public class ClassWork_04_15 implements Runnable {

    @Override
    public void run() {
        mySelf();

        MyRandThread tRand = new MyRandThread();
        // tRand.run(); // Запуск будет произведен в этом же потоке

        // Запуск потока
        Thread myThread = new Thread(tRand, "tRand");
        myThread.start();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // Обработка ситуации - когда нельзя дождаться
        }

    }

    private void mySelf(){
        Thread t = Thread.currentThread(); // получаем главный поток
        System.out.println("Main: " + t.getName()); // main
    }
}
