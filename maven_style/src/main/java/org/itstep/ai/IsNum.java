package org.itstep.ai;

/*
 -
| |
 -
| |
 -

 0
1 2
 3
4 5
 6
 */

public class IsNum {
    private static final int eduSteps = 1000;
    double[] led1 = {0,0,1,0,0,1,0,1};
    double[] led2 = {1,0,1,1,1,0,1,1};

    double[] led7 = {1,0,1,0,0,1,0,1};
    double[] led8 = {1,1,1,1,1,1,1,1};

    public void printAll()
    {
        print(led1);
        print(led2);
        print(led8);
    }


    public Neuron is1 = new Neuron(8);
    public Neuron is2 = new Neuron(8);
    public Neuron is8 = new Neuron(8);

    public void edu1() {
        for (int i = 0; i < eduSteps; i++) {
            is1.backpropagation(led1,1, 0.1);
            is1.backpropagation(led2,0, 0.1);
            is1.backpropagation(led7,0, 0.1);
            is1.backpropagation(led8,0, 0.1);
        }
    }
    public void edu2() {
        for (int i = 0; i < eduSteps; i++) {
            is2.backpropagation(led1,0, 0.1);
            is2.backpropagation(led2,1, 0.1);
            is2.backpropagation(led7,0, 0.1);
            is2.backpropagation(led8,0, 0.1);
        }
    }

    public void edu8() {
        for (int i = 0; i < eduSteps; i++) {
            is8.backpropagation(led1,0, 0.1);
            is8.backpropagation(led2,0, 0.1);
            is8.backpropagation(led7,0, 0.1);
            is8.backpropagation(led8,1, 0.1);
        }
    }

    public void is1(){
        System.out.println("1 => " + is1.feedForward(led1));
        System.out.println("2 => " + is1.feedForward(led2));
        System.out.println("8 => " + is1.feedForward(led8));
    }

    public void is2(){
        System.out.println("1 => " + is2.feedForward(led1));
        System.out.println("2 => " + is2.feedForward(led2));
        System.out.println("8 => " + is2.feedForward(led8));
    }

    public void is8(){
        System.out.println("1 => " + is8.feedForward(led1));
        System.out.println("2 => " + is8.feedForward(led2));
        System.out.println("8 => " + is8.feedForward(led8));
    }

    public void test(double[] led){
        print(led);
        System.out.println("1 => " + is1.feedForward(led));
        System.out.println("2 => " + is2.feedForward(led));
        System.out.println("8 => " + is8.feedForward(led));

        if(is1.feedForward(led) > 0.5) {
            System.out.println(" 1 ");
        }
        if(is2.feedForward(led) > 0.5) {
            System.out.println(" 2 ");
        }
        if(is8.feedForward(led) > 0.5) {
            System.out.println(" 8 ");
        }
    }


    public void print (double[] leds)
    {
        char[] str = {' ', ' ', ' ', ' ', ' '};

        // Первая полоса
        if(leds[0] == 1)
            System.out.println(" *** ");
        else
            System.out.println("     ");

        // Вторая полоса
        if(leds[1] == 1)
            str[0] = '*';
        else
            str[0] = ' ';

        if(leds[2] == 1)
            str[4] = '*';
        else
            str[4] = ' ';

        for (int i = 0; i < 3; i++) {
            System.out.println(str);
        }

        // Третья полоса
        if(leds[3] == 1)
            System.out.println(" *** ");
//        else
//            System.out.println("     ");

        // Четвертая полоса
        if(leds[4] == 1)
            str[0] = '*';
        else
            str[0] = ' ';

        if(leds[5] == 1)
            str[4] = '*';
        else
            str[4] = ' ';
        for (int i = 0; i < 3; i++) {
            System.out.println(str);
        }

        // Пятая полоса
        if(leds[6] == 1)
            System.out.println(" *** ");
        else
            System.out.println("     ");

        System.out.println("\n --- \n");
    }



}
