package com.Ynt.common;

import java.io.*;
import java.util.Properties;

public class ParseProperties {
    private Properties pro = new Properties();
    private String value = null;

    public ParseProperties(String propertiespath){
        this.loadProperties(propertiespath);
    }

    private void loadProperties(String propertiespath){
        try {
            InputStream in = new FileInputStream(propertiespath);
            InputStreamReader inr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(inr);
            pro.load(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //to get value of specific keyname
    public String getValue(String keyname){
        value = pro.getProperty(keyname).trim();
        try {
            //value = new String(value.getBytes("UTF-8"),"UTF-8");
            String encode = "GB2312";
            if (value.equals(new String(value.getBytes(encode), encode))) {
                //String s = value+encode;
                //System.out.println(s);
                return value;
            }
            encode = "ISO-8859-1";
            if (value.equals(new String(value.getBytes(encode), encode))) {
                //String s1 = value+encode;
                //System.out.println(s1);
                return value;
            }
            encode = "UTF-8";
            if (value.equals(new String(value.getBytes(encode), encode))) {
                //String s2 = value+encode;
                //System.out.println(s2);
                return value;
            }
            encode = "GBK";
            if (value.equals(new String(value.getBytes(encode), encode))) {
                String s3 = value+": "+encode;
                System.out.println(s3);
                return value;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
