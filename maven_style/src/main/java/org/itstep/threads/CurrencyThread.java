package org.itstep.threads;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CurrencyThread implements Runnable{

    String code;
    Exchanger<String> exchanger;
    public CurrencyThread(String code, Exchanger<String> exchanger){
        this.code = code;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        // System.out.println("I have: " + code);
        try {
            String newCode = exchanger.exchange(code, 1000, TimeUnit.MILLISECONDS);
            System.out.println("I put: " + this.code + " => " + newCode );
        } catch (InterruptedException e) {
            System.err.println("Can't change");
            // throw new RuntimeException(e);
        } catch (TimeoutException e) {
            System.err.println("TimeOut: " + this.code);
            // throw new RuntimeException(e);
        }
    }
}
