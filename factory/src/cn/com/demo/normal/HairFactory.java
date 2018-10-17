package cn.com.demo.normal;

import java.util.Map;

/**
 * Created by sunshine on 2018/10/17.
 */
public class HairFactory {

//    public static HairInterface getHair(String hair){
//        if("left".equals(hair)){
//            return new LeftHair();
//        }
//        if("right".equals(hair)){
//            return new RightHair();
//        }
//        return null;
//    }

//     public static HairInterface getClassByName(String className){
//         try {
//             HairInterface hairInterface= (HairInterface) Class.forName(className).newInstance();
//             return hairInterface;
//         } catch (InstantiationException e) {
//             e.printStackTrace();
//         } catch (IllegalAccessException e) {
//             e.printStackTrace();
//         } catch (ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//         return null;
//     }

    public static HairInterface getInformation(String name){
        Map<String,String> map=new PropertyUtil().getInformation();
        try {
            HairInterface hairInterface= (HairInterface) Class.forName(map.get(name)).newInstance();
            return hairInterface;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
