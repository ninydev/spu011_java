package org.itstep.ai;

public class Semaphore
{
    public Neuron neuron;

    public Semaphore() {
        neuron = new Neuron(3);
    }

    public void eduStep(){
        neuron.backpropagation(ledRed, 0, 0.1);
        neuron.backpropagation(ledYellow, 0, 0.1);
        neuron.backpropagation(ledGreen, 1, 0.1);
    }

    double[] ledRed = {1,0,0};
    double[] ledYellow = {0,1,0};
    double[] ledGreen = {0,0,1};

    public void goRed()
    {
        System.out.println("Red   => \t" + neuron.feedForward(ledRed));
    }
    public void goGreen()
    {
        System.out.println("Green => \t" + neuron.feedForward(ledGreen));
    }
}
