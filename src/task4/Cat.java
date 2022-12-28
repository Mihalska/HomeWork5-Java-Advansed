package task4;

import java.lang.reflect.Field;

public class Cat {
    private static final class Animal {
        public int weight = 5;
        private int age = 2;
        String colour = "black";
    }
    public static void main(String[] args) {
        try {
            Class<?> c1 = Animal.class;
            Animal animal = new Animal();
            Field field = c1.getField("weight");
            Field field2 = c1.getDeclaredField("age");
            Field field3 = c1.getDeclaredField("colour");

            field.setAccessible(true);
            System.out.println(field.getInt(animal));
            System.out.println(field2.getInt(animal));
            System.out.println(field3.get(animal));
            System.out.println("----------");
            field.setInt(animal, 7);
            field2.setInt(animal, 5);
            field3.set(animal, "white") ;
            System.out.println(field.getInt(animal));
            System.out.println(field2.getInt(animal));
            System.out.println(field3.get(animal));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
