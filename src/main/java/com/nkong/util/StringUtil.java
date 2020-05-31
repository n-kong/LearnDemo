package com.nkong.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: nkong
 * @Date: 2020/5/30 21:50
 * @Version 1.0
 */
public class StringUtil {

    public static void main(String[] args) {
        StringUtil util = new StringUtil();
        System.out.println(util.numFormat(11, 5));
        System.out.println(util.numAddOneFormat(20,"00000"));
        System.out.println(util.replaceStr("aa\rbb\rcc\n"));
    }

    /**
     * 数字格式化，不足n位前面补0
     * 0:代表前面补充0, length:代表长度为4, d:代表参数为正数型
     * 例： 输入：11,5  输出：00011
     * @param inNum 输入字符
     * @param length 补充后字符长度
     */
    public String numFormat(int inNum, int length) {
        return String.format("%0"+length+"d", inNum);
    }

    /**
     * 数字格式化， 输入字符加1， 然后格式化
     * 例： 输入：20,00000  输出：00021
     * @param inNum 输入字符
     * @param STR_FORMAT 格式化字符
     */
    public String numAddOneFormat(int inNum, String STR_FORMAT){
        DecimalFormat df = new DecimalFormat(STR_FORMAT);
        return df.format(++inNum);
    }

    /**
     * 替换\r \t \n字符
     * @param inStr 输入字符
     * @return 替换后的字符
     */
    public String replaceStr(String inStr) {
        if (StringUtils.isNoneEmpty(inStr)) {
            Pattern p = Pattern.compile("\t|\r|\n");
            Matcher m = p.matcher(inStr);
            inStr = m.replaceAll("");
        }
        return inStr;
    }

}
