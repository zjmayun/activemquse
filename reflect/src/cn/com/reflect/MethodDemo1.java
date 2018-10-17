package cn.com.reflect;

import java.lang.reflect.Method;

/**
 * Created by sunshine on 2018/10/17.
 */
public class MethodDemo1 {

    public static void main(String[] args) {
        A a1=new A();
        Class c=a1.getClass();
        try{
//            Method method=c.getDeclaredMethod("print",int.class,int.class);
//            Object object=method.invoke(a1,10,20);
//            System.out.println(object);
//              Method method=c.getDeclaredMethod("print");
//              method.invoke(a1);
              Method method=c.getDeclaredMethod("print",String.class,String.class);
              Object object=method.invoke(a1,"AAA","aaa");
            System.out.println(object);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class A{
    void print(){
        System.out.println("hello A");
    }
    int print(int a,int b){
        return a+b;
    }
    String print(String a,String b){
        return a.toLowerCase()+b.toUpperCase();
    }
}
