package cn.com.demo.normal;

/**
 * Created by sunshine on 2018/10/17.
 */
public class HairTest {
    public static void main(String[] args) {
//        HairInterface hair=HairFactory.getHair("right");
//        hair.draw();
//        HairInterface hair=HairFactory.getClassByName("cn.com.demo.normal.RightHair");
//        hair.draw();
          HairInterface hair=HairFactory.getInformation("left");
          hair.draw();
    }
}
