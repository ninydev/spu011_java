package org.itstep.classWorks;

import org.itstep.threads.CurrencyThread;
import org.itstep.threads.MyRandThread;
import org.itstep.threads.MyRandThreadSem;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class ClassWork_04_15 implements Runnable {

    @Override
    public void run() {
        mySelf();
        doSem();

    }

    void doSem(){
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 20; i++) {
            new Thread(new MyRandThreadSem(semaphore)).start();
        }
    }

    void doEx(){
        Exchanger<String> myEx = new Exchanger<>();
        CurrencyThread uah = new CurrencyThread("UAH", myEx);
        CurrencyThread usd = new CurrencyThread("USD", myEx);
        CurrencyThread euro = new CurrencyThread("EUR", myEx);
        CurrencyThread yen = new CurrencyThread("YEN", myEx);
        CurrencyThread zl = new CurrencyThread("ZL", myEx);
        CurrencyThread frn = new CurrencyThread("FRN", myEx);

        new Thread(uah).start();
        new Thread(euro).start();
        new Thread(yen).start();
        new Thread(zl).start();
        new Thread(frn).start();

        System.out.println(" Валютчик застрял в пробке ");
        try {
            Thread.sleep(200);
        } catch (Exception ex){

        }


        new Thread(usd).start();

    }


    void doJoin(){
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
