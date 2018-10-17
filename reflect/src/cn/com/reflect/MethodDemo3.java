package cn.com.reflect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/**
 * Created by sunshine on 2018/10/17.
 */
public class MethodDemo3 {
    public static void main(String[] args) {
        UserService u=new UserService();
        try{
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("please input a action:");
            String action=bufferedReader.readLine();
            Class c=u.getClass();
            Method method=c.getMethod(action);
            method.invoke(u);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
