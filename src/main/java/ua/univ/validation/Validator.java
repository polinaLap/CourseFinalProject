package ua.univ.validation;

import org.apache.commons.lang.StringEscapeUtils;
import  java.util.regex.*;
public class Validator {
    public static boolean checkEmail(String email){
        String regex = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;" +
                ":\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\." +
                "[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches();
    }
    public static boolean antiIngection(String text){
        String res =StringEscapeUtils.escapeHtml(text);
        return text.equals(res);
    }
}
