package cn.com.reflect;

/**
 * Created by sunshine on 2018/10/17.
 */
public class MethodDemo4 {
    public static void main(String[] args) {
        User user=new User("zj","zha124",22);
        BeanUtils.getValue(user,"username");
        BeanUtils.getValue(user,"password");
    }
}
