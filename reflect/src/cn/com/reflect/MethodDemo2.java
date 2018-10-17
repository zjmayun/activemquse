package cn.com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunshine on 2018/10/17.
 */
public class MethodDemo2 {
    public static void main(String[] args) {
        List list=new ArrayList();
        List<String> list1=new ArrayList<>();
        list1.add("hello");
//      list1.add(123);会报错
        Class c=list.getClass();
        Class c1=list1.getClass();
        System.out.println(c1==c);

        try {
            Method method=c1.getMethod("add",Object.class);
            method.invoke(list1,23);
            System.out.println(list1.size());
            System.out.println(list1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
