package basic;

import entity.User;

import java.lang.reflect.Field;

public class Demo1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        User user = new User();
        user.setId(1);
        user.setName("xxx");

        Class<?> clazz = user.getClass();
        Field field = clazz.getDeclaredField("name");
//        field.setAccessible(true);
        String val = (String) field.get(user);
        System.out.println("val=" + val);

        field.set(user,"zcy");

        System.out.println(user);
    }
}
