package org.itstep.oop;

import org.itstep.oop.first.Children;
import org.itstep.oop.first.Parent;
import org.itstep.oop.myButton.IClick;
import org.itstep.oop.myButton.IDoubleClick;
import org.itstep.oop.myButton.MyButton;
import org.itstep.oop.myInterface.Samoble;

public class Work2503 implements Runnable
{

    @Override
    public void run() {
        myButton();
    }

    void myButton(){
        String data = "Hello World";
        MyButton btn = new MyButton(
                new IClick() {
                    @Override
                    public void click() {
                        System.out.println("Click: " + data);
                        this.inI();
                    }
                    private void inI(){
                        System.out.println("In I");
                    }
                },
                new IDoubleClick() {
                    @Override
                    public void dblClick() {
                        System.out.println("Double click: " + data);
                    }
                }
        );

        btn.click();
        btn.dblClick();

        btn.setClick(new IClick() {
            @Override
            public void click() {
                System.out.println("New Click");
            }
        });
        btn.click();

        MyButton newBtn = new MyButton(btn);
        btn.click();
        btn.dblClick();
    }

    void createInterface(){
        Samoble s = new Samoble() {
            @Override
            public void SomeFun() {
                System.out.println("Do");
            }
        };

        System.out.println(s);
    }



    void override(){
        Children c = new Children();
//        c.Do();
//        ((Parent) c).Do();
        Parent p = (Parent)c;
        p.Do();
    }
}
