package cn.com.reflect;

/**
 * Created by sunshine on 2018/10/17.
 */
public class ClassDemo2 {
    public static void main(String[] args) {
        Class c1=int.class;
        Class c2=Integer.class;
        Class c3=void.class;
        Class c4=String.class;

        System.out.println(c1.getName()+" "+c1.getSimpleName());
        System.out.println(c2.getName()+" "+c2.getSimpleName());
        System.out.println(c1==c2);
        System.out.println(c3.getName());
    }
}
