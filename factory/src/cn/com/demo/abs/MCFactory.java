package cn.com.demo.abs;

/**
 * Created by sunshine on 2018/10/17.
 */
public class MCFactory implements PersonFactory {
    @Override
    public Boy getBoy() {
        return new MCBoy();
    }

    @Override
    public Girl getGirl() {
        return new MCGirl();
    }
}
