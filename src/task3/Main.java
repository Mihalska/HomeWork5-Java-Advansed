package task3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    private static final class Car {
        public String color = "red";
        private int speed = 250;
        byte age = 10;

        public Car() {
        }

        public Car(int speed ) {
            this.speed  = speed ;
        }

        public Car(String color, int speed, byte age) {
            this.color = color;
            this.speed = speed;
            this.age = age;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public byte getAge() {
            return age;
        }

        public void setAge(byte age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        String s = (char)27 + "[33m";
        String s1 = (char)27 + "[39m";
        String s2 = (char)27 + "[34m";
        Class <?> value = Car.class ;
        System.out.println(s + "Constructors:"+ s1);
        Constructor <?> [] constructors = value.getConstructors() ;
        int i = 0;
        for (Constructor <?> ctr : constructors ){
            System.out.print(s1 + "\tConstructor " + (++i) + ": ");
            Class <?> [] paramTypes = ctr.getParameterTypes() ;
            for (Class <?> paramType : paramTypes ){
                System.out.print(s1 + paramType.getName() + " ");
            }
            System.out.println();
        }
        try {
            Class <?> [] paramTypes = new Class<?>[]{
                    int.class
            } ;
            Constructor <?> ctr = value.getConstructor(paramTypes );
            Car car = (Car) ctr.newInstance(200);
            System.out.println(s + "Field: "+ s2 + " Age - " + car.getAge() + " Speed - "+ car.getSpeed() + " Color - " + car.getColor() );
        } catch (Exception e) {
            e.printStackTrace() ;
        }
        Method [] methods = value.getMethods();
        for (Method method : methods ){
            System.out.println(s + "Name: " + s2 + method.getName() );
            System.out.println(s + "\tReturn type: " + s1 + method.getReturnType().getName() );
            Class <?> [] paramTypes = method.getParameterTypes() ;
            System.out.print(s + "\tParam types:" + s1);
            for (Class <?> paramType : paramTypes ){
                System.out.print(" "+ paramType.getName() );
            }
            System.out.println();
        }
        Class<Car> value1 = Car.class;
        System.out.println(s + "Class name: " + s1 + value1.getName() );
        System.out.print(s + "Modifiers of class: " + s1);
        int mods= value1.getModifiers() ;
        if (Modifier.isPrivate(mods ) ){
            System.out.print("Private ");
        }
        if (Modifier.isAbstract(mods ) ){
            System.out.print("Abstract ");
        }
        if (Modifier.isStatic(mods ) ){
            System.out.print("Static ");
        }
        if (Modifier.isFinal(mods ) ){
            System.out.print("Final ");
        }



    }
}
