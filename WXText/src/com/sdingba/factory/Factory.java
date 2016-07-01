package com.sdingba.factory;

import java.io.FileReader;
import java.util.Properties;

public class Factory {
    private static Factory factory = new Factory();
    private static Properties prop = null;
    private Factory(){}

    static{
        try {
            prop = new Properties();
            prop.load(
                    new FileReader(
                            Factory.class.getClassLoader()
                                    .getResource("config.properties")
                                    .getPath()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static Factory getFactory(){
        return factory;
    }

    /**
     *  后期开发 , 进行注解管理事物
     */





    /**
     * @param clazz
     * @return
     */

    public <T> T getInstance(Class<T> clazz){
        try{
            String infName = clazz.getSimpleName();
            String implName = prop.getProperty(infName);
            return (T) Class.forName(implName).newInstance();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
