package com.lyzx.flume.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author hero.li
 *
 */
public class Conf{
    public static final int okCode = 200;
    public static final String monitorHost;
    public static final int monitorPort;
    public static final int monitorInterval;

    static{
        Properties prop = new Properties();
        String path = new File("conf"+File.separator+"conf.properties").getAbsolutePath();

        try{
            FileInputStream in = new FileInputStream(path);
            prop.load(in);

            monitorHost = prop.getProperty("monitor.host");
            monitorPort     = Integer.parseInt(prop.getProperty("monitor.port"));
            monitorInterval = Integer.parseInt(prop.getProperty("monitor.interval"));
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("config file load exception:"+path);
        }


    }
}
