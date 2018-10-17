package cn.com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by sunshine on 2018/10/17.
 */
public class ClassUtils {
    /**
     * 根据传入的参数，获取该参数对应
     * 的类的相关方法的信息
     * @param object
     */
    public static void printMethodInformation(Object object){
        Class cls=object.getClass();
        //该方法为获取所以该类公有的方法，包括从父类继承而来的
        Method[] methods=cls.getMethods();
        for(Method method:methods){
            Class returnType=method.getReturnType();
            System.out.print(returnType.getName()+" "+method.getName()+" (");
            Class[] parameters=method.getParameterTypes();
            for(int i=0;i<parameters.length;i++){
                if(i==(parameters.length-1)){
                    System.out.print(parameters[i].getName());
                }else {
                    System.out.print(parameters[i].getName() + ",");
                }
            }
            System.out.print(")");
            System.out.println();
        }
    }

    /**
     * 获取objecct相对应的类的
     * 成员变量的信息
     * @param object
     */
    public static void printFieldMessage(Object object){
        Class c=object.getClass();
        Field[] fields=c.getDeclaredFields();
        for(Field field:fields){
            Class c1=field.getType();
            String type=c1.getName();
            String name=field.getName();
            System.out.println(type+" "+name);
        }
    }

    /**
     * 获取object相对应的类的对象的
     * 构造方法的想应的数据
     * @param object
     */
    public static void printConMessage(Object object){
         Class c=object.getClass();
         Constructor[] constructors=c.getDeclaredConstructors();
         for(Constructor constructor:constructors){
             System.out.print(constructor.getName()+" (");
             Class[] classes=constructor.getParameterTypes();
             for(int i=0;i<classes.length;i++){
                 if(i==(classes.length-1)){
                     System.out.print(classes[i].getName());
                 }else {
                     System.out.print(classes[i].getName()+",");
                 }
             }
             System.out.print(")");
             System.out.println();
         }
    }
}
