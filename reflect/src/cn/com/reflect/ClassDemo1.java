package cn.com.reflect;

/**
 * Created by sunshine on 2018/10/17.
 */
public class ClassDemo1 {
    public static void main(String[] args) {
        Foo foo=new Foo();
        //c1,c2为Foo类的类类型  c1为第一种方式
        Class c1=Foo.class;
        //c2为已经建立好的对象进行构建
        Class c2=foo.getClass();
        System.out.println(c1==c2);
        Class c3=null;
        try {
            c3=Class.forName("cn.com.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Foo foo1= (Foo) c3.newInstance();
            foo1.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

}

class Foo{
    public void print(){
        System.out.println("hello reflect");
    }
}
