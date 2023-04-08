package org.itstep.classWorks;

import org.itstep.ai.IsNum;
import org.itstep.ai.Semaphore;

public class ClassWork_04_08_ai implements Runnable
{
    Semaphore semaphore;
    @Override
    public void run() {
        IsNum isNum = new IsNum();
//        System.out.println(" Before Edu ");
//        isNum.is1();
        isNum.edu1();
        isNum.edu2();
        isNum.edu8();

        double[] led1 = {0,0,1,0,0,1,0,1};
        double[] led7 = {1,0,1,0,0,1,0,1};

        isNum.test(led1);
        isNum.test(led7);

//        System.out.println(" After Edu ");
//        isNum.is1();
//        isNum.is2();
//        isNum.is8();
        // isNum.printAll();
    }

    private void Sem ()
    {
        semaphore = new Semaphore();
        System.out.println(semaphore.neuron);

        semaphore.goRed();
        semaphore.goGreen();

        System.out.println(" ----- ");
        for (int i = 0; i < 100; i++) {
            semaphore.eduStep();
        }
        System.out.println(semaphore.neuron);
        semaphore.goRed();
        semaphore.goGreen();
    }
}
