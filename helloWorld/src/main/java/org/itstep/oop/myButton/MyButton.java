package org.itstep.oop.myButton;

public class MyButton implements IClick, IDoubleClick
{

    private IClick click;
    private IDoubleClick dblClick;

    public MyButton(){}

    public MyButton(
            IClick click)
    {
        this();
        this.click = click;
    }

    public MyButton(
            IClick click,
            IDoubleClick dblClick)
    {
        this(click);
        this.dblClick = dblClick;
    }

    @Override
    public void click() {
        if(this.click != null)
            this.click.click();
    }

    @Override
    public void dblClick() {
        if(this.dblClick != null)
            this.dblClick.dblClick();
    }
}
