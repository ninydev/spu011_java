package org.itstep.oop.patterns;

public class Singleton {
    private Singleton(){}

    private static Singleton instance;

    private static Singleton getInstance() {
        if (Singleton.instance == null)
            Singleton.instance = new Singleton();
        return instance;
    }
}
