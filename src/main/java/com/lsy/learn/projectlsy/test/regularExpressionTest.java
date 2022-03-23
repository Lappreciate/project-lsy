package com.lsy.learn.projectlsy.test;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regularExpressionTest {



    public static void main(String[] args) {
//        String str = "filename12312312.txtsdadasdasfilename12312312.txtaaaafilename12312312.txt";
//        String pattern = "filename(\\d+).txt";

        String str = "[dasdad]sddd[dsda]dsd999[dsdsd]";
        String pattern = "\\[(.*?)]";


        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        while (m.find()) {
            System.out.println("m.group(0) : " + m.group(0) + "  " + "m.group(1) : " + m.group(1));
        }

    }

}
