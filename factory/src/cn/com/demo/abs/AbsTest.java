package cn.com.demo.abs;

/**
 * Created by sunshine on 2018/10/17.
 */
public class AbsTest {
    public static void main(String[] args) {
        PersonFactory personFactory=new MCFactory();
        personFactory.getBoy().dranMan();
    }
}
