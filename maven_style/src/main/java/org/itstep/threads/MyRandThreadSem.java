package org.itstep.threads;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class MyRandThreadSem implements Runnable {

    final Semaphore semaphore;
    public MyRandThreadSem(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    static Random rnd = new Random();
    String threadName;
    @Override
    public void run() {
        try {
            semaphore.acquire(); // Ожидание возможности запуска
            whenStart();
            baseLoad();
            whenFinish();
            semaphore.release(); // Сообщение о окончании работы
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Нагрузка - то что поток должен сделать
     */
    void baseLoad(){
        try {
            Thread.sleep(rnd.nextLong(100,500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // Исключение - когда поток не возможно усыпить
        }
    }

    void whenStart(){
        Thread t = Thread.currentThread(); // получаем мой поток
        threadName = t.getName();
        System.out.println(threadName + " Start"); // выведем имя
    }

    void whenFinish() {
        System.out.println(threadName + " Finish");
    }
}
