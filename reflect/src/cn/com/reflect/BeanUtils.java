package cn.com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by sunshine on 2018/10/17.
 */
public class BeanUtils {

    public static void getValue(Object object,String propertyName){
        String name="get"+propertyName.substring(0,1).toUpperCase()+
                propertyName.substring(1);
        Class c=object.getClass();
        try {
            Method method=c.getMethod(name);
            Object object1=method.invoke(object);
            System.out.println(object1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
