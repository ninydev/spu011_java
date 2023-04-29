package org.itstep;

public class Main {
    public static void main(String[] args) {
        checkMySql();
        DBWork w = new DBWork();
        w.run();
        System.out.println("Bye!");
    }

    public static void checkMySql(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Connection succesfull!");
        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
}