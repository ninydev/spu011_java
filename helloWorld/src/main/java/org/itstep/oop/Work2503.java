package org.itstep.oop;

import org.itstep.oop.first.Children;
import org.itstep.oop.first.Parent;
import org.itstep.oop.myButton.IClick;
import org.itstep.oop.myButton.IDoubleClick;
import org.itstep.oop.myButton.MyButton;
import org.itstep.oop.myInterface.Samoble;
import org.itstep.oop.myRepository.CrudRepository;
import org.itstep.oop.myRepository.models.User;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

public class Work2503 implements Runnable {

    @Override
    public void run() {
        myUsers();
    }

    void myUsers() {
        CrudRepository<UUID, User> users = new CrudRepository<>();
        users.create(new User("keeper@ninydev.com"));
        users.create(new User("nikitin_a@itstep.academy"));

        User toFind = new User("oleksandr.nykytin@tech.lab325.com");
        users.create(toFind);

        for (User user : users.readAll()
        ) {
            System.out.println(user);
        }
        System.out.println("Find by Id");
        System.out.println(users.findById(toFind.getId()));

        System.out.println("Find by Id1");
        System.out.println(users.findById1(toFind.getId()));

        System.out.println("Find by Id2");
        System.out.println(users.findById2(toFind.getId()));
    }


    void myCollection() {
        Collection<String> list = new Collection<String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
    }

    void repositoryCrud() {
        CrudRepository<Long, String> rep = new CrudRepository<>();
        rep.create("first");
        rep.create("second");
        rep.create("last");

        for (String str : rep.readAll()
        ) {
            System.out.println(str);
        }
    }

    void myButton() {
        String data = "Hello World";
        MyButton btn = new MyButton(
                new IClick() {
                    @Override
                    public void click() {
                        System.out.println("Click: " + data);
                        this.inI();
                    }

                    private void inI() {
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

    void createInterface() {
        Samoble s = new Samoble() {
            @Override
            public void SomeFun() {
                System.out.println("Do");
            }
        };

        System.out.println(s);
    }


    void override() {
        Children c = new Children();
//        c.Do();
//        ((Parent) c).Do();
        Parent p = c;
        p.Do();
    }
}
