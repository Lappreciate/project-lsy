package com.lsy.learn.projectlsy;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityFileGenerator {

    public static Map<String, String> map = new HashMap<>();

    public static final String TEMPLATE_ABSOLUTE_PATH = "/Users/yanhui/Desktop/baseinfo/classTemplate/";
    public static final String ABSOLUTE_PATH = "/Users/yanhui/IdeaProjects/mico-activity/operation/src/main/java/com/mico/";

    static {
        map.put("activityId", "10453");//新主播月榜
        map.put("className", "NewAnchorMonthlyList2022");
        map.put("activityName", "new_anchor_monthly_list_2022");
        map.put("serviceVariableName", "newAnchorMonthlyList2022");
        map.put("controllerUrl", "new/anchor/monthly/list/2022");
        map.put("openArea", "kh");
        map.put("directoryDate", "conventional");//conventional || 2022_04
    }

    public static void main(String[] args) {

        /**
         * configs文件生成
         */
        generateFile(
                TEMPLATE_ABSOLUTE_PATH + "configTemplate.txt",
                ABSOLUTE_PATH + "operation/common/activity_" + map.get("directoryDate") + "/",
                map.get("className") + "Configs" + ".java");
        /**
         * interfaceImpl生成
         */
        generateFile(
                TEMPLATE_ABSOLUTE_PATH + "serviceTemplate.txt",
                ABSOLUTE_PATH + "operation/service/activity_" + map.get("directoryDate") + "/",
                map.get("className") + "Service" + ".java");

        /**
         * interface实现文件生成
         */
        generateFile(
                TEMPLATE_ABSOLUTE_PATH + "serviceImplTemplate.txt",
                ABSOLUTE_PATH + "operation/service/impl/activity_" + map.get("directoryDate") + "/",
                map.get("className") + "ServiceImpl" + ".java");

        /**
         * controller文件生成
         */
        generateFile(
                TEMPLATE_ABSOLUTE_PATH + "controllerTemplate.txt",
                "/Users/yanhui/IdeaProjects/mico-activity/api/src/main/java/com/mico/api/activity/resources/activity_" + map.get("directoryDate") + "/",
                map.get("className") + "Resource" + ".java");

        /**
         * schedule文件生成
         */
        generateFile(
                TEMPLATE_ABSOLUTE_PATH + "scheduleTemplate.txt",
                "/Users/yanhui/IdeaProjects/mico-activity/schedule/src/main/java/com/mico/schedule/activity/activity_" + map.get("directoryDate") + "/",
                map.get("className") + "Schedule" + ".java");


    }


    public static String getMatchInfo(StringBuilder sb) {
        String content = sb.toString();
        String res;
        String regex = "\\[(.*?)]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            res = matcher.group(1);
            if (res.equals("openArea")) {

                map.put("openArea", dealArea(res));

            }
            content = content.replace("[" + res + "]", map.get(res));
//            System.out.println(content);

        }
        return content;
    }

    public static String dealArea(String res) {
        String finalArea = "";
        String areaStr = map.get(res);
        String[] areas = areaStr.split(",");
        for (int i = 0; i < areas.length; i++) {
            if (i == areas.length - 1) {
                finalArea = finalArea + "CommonConfigs." + areas[i].toUpperCase();
            } else {
                finalArea = finalArea + "CommonConfigs." + areas[i].toUpperCase() + ",";
            }
        }

        return finalArea;
    }

    public static void generateFile(String fromFilepath, String toDirectory, String fileName) {
        try {
            File toFilepath = new File(toDirectory); //
            if (!toFilepath.exists()) {
                toFilepath.mkdir();
            }
            FileReader fis = new FileReader(fromFilepath); // 创建文件输入流
            char[] data = new char[1024]; // 创建缓冲字符数组
            int rn = 0;
            StringBuilder sb = new StringBuilder(); // 创建字符串构建器
            // fis.read(data)：将字符读入数组。在某个输入可用、发生 I/O
            // 错误或者已到达流的末尾前，此方法一直阻塞。读取的字符数，如果已到达流的末尾，则返回 -1
            while ((rn = fis.read(data)) > 0) { // 读取文件内容到字符串构建器
                String str = String.valueOf(data, 0, rn);// 把数组转换成字符串
                sb.append(str);
            }
            fis.close();// 关闭输入流
            // 从构建器中生成字符串，并替换搜索文本
            FileWriter fout = new FileWriter(toDirectory + "/" + fileName);// 创建文件输出流
            fout.write(getMatchInfo(sb).toCharArray());// 把替换完成的字符串写入文件内
            fout.close();// 关闭输出流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
