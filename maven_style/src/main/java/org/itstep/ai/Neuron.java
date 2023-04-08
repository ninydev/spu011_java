package org.itstep.ai;

import lombok.ToString;

import java.util.Random;

public class Neuron {
    private double[] weights; // Веса нейрона
    private double bias; // Смещение нейрона

    // Конструктор нейрона
    public Neuron(int numInputs) {
        Random rand = new Random();

        // Инициализируем веса случайными значениями
        weights = new double[numInputs];
        for (int i = 0; i < numInputs; i++) {
            weights[i] = rand.nextDouble();
        }

        // Инициализируем смещение случайным значением
        bias = rand.nextDouble();
    }

    // Метод вычисления выходного сигнала нейрона
    public double feedForward(double[] inputs) {
        double output = 0;

        // Суммируем произведения входов на соответствующие веса
        for (int i = 0; i < inputs.length; i++) {
            output += inputs[i] * weights[i];
        }

        // Добавляем смещение
        output += bias;

        // Применяем функцию активации (например, сигмоиду)
        output = 1 / (1 + Math.exp(-output));

        return output;
    }

    // Метод корректировки весов с помощью алгоритма обратного распространения ошибки
    public void backpropagation(double[] inputs,
                                double expectedOutput,
                                double learningRate) {
        double output = feedForward(inputs);

        // Вычисляем ошибку нейрона
        double error = expectedOutput - output;

        // Корректируем веса и смещение с помощью градиентного спуска
        for (int i = 0; i < weights.length; i++) {
            weights[i] += error * inputs[i] * learningRate;
        }
        bias += error * learningRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < weights.length; i++) {
            sb.append(i + " => " + weights[i] + "\n");
        }
        sb.append("-----\n");
        return  sb.toString();
    }
}