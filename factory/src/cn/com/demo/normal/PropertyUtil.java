package cn.com.demo.normal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by sunshine on 2018/10/17.
 */
public class PropertyUtil {

    /**
     * 读取属性数据
     * @return
     */
    public Map<String,String> getInformation(){
        Properties props=new Properties();
        Map<String,String> map=new HashMap<>();
        try {
            InputStream in=getClass().getResourceAsStream("type.properties");
            props.load(in);
            Enumeration en=props.propertyNames();
            while (en.hasMoreElements()){
                String key= (String) en.nextElement();
                String value=props.getProperty(key);
                map.put(key,value);
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
