package com.gorbatenko.palindrome.util;

public class PalindromUtil {
    public static long findMinValue(long value) {
        value--;
        for(long i = value; i > 0; i--) {
            if(isPalindrome(i)) {
                return i;
            }
        }
        return 0;
    }

    public static long findMaxValue(long value) {
        value++;
        for(long i = value; i < Long.MAX_VALUE; i++) {
            if(isPalindrome(i)) {
                return i;
            }
        }
        return 0;
    }

    public static boolean isPalindrome(long value) {
        String val = String.valueOf(value);
        if(val.length() == 1) {
            return true;
        } else {
            String begStr = "";
            String endStr = "";
            int len = val.length();
            if(val.length() % 2 == 0) {
                begStr = val.substring(0, len / 2);
                StringBuilder sb = new StringBuilder(val.substring(len / 2 ));
                endStr = sb.reverse().toString();
            }  else {
                begStr = val.substring(0, (len-1) / 2);
                StringBuilder sb = new StringBuilder((val.substring((len+1) / 2)));
                endStr = sb.reverse().toString();
            }
            if(begStr.equals(endStr)) {
                return true;
            }
        }
        return false;
    }
}
