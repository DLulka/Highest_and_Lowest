package com.company;

import com.sun.xml.internal.fastinfoset.util.CharArray;

public class Main {

    public static void main(String[] args) {
        Main.highAndLow("42 42");
    }

    public static String highAndLow(String numbers) {
        int i = 0, max = 0, min = 0, helper = 0, mult = 1, first = 0;
        String result;
        char[] numarray = numbers.toCharArray();
        while(i < numarray.length){
            switch(numarray[i]){
                case ' ':
                    i ++;
                    break;

                case '-':
                    helper = 0;
                    mult = 1;
                    while(Character.isDigit(numarray[i+1])) {
                        i++;
                        helper = helper * mult;
                        helper = helper + Integer.parseInt(String.valueOf(numarray[i]));
                        mult = 10;
                        if(i+1 >= numarray.length) {
                            helper = helper * -1;
                            if(helper < min){
                                min = helper;
                            }
                            if(first == 0){
                                max = helper;
                                min = helper;
                                first = 1;
                            }
                            break;
                        }
                    }
                    helper = helper * -1;
                    if(first == 0){
                        max = helper;
                        min = helper;
                        first = 1;
                    }
                    if(helper < min){
                        min = helper;
                    }
                    i++;
                    break;

                default:
                    helper = 0;
                    mult = 1;
                    while(Character.isDigit(numarray[i])) {
                        helper = helper * mult;
                        helper = helper + Integer.parseInt(String.valueOf(numarray[i]));
                        mult = 10;
                        i++;
                        if(i >= numarray.length) {
                            i++;
                            if(first == 0){
                                max = helper;
                                min = helper;
                                first = 1;
                            }
                            if(helper < min){
                                min = helper;
                            }else if(helper > max){
                                max = helper;
                            }
                            break;
                        }
                    }
                    if(first == 0){
                        max = helper;
                        min = helper;
                        first = 1;
                    }
                    if(helper < min){
                        min = helper;
                    }else if(helper > max){
                        max = helper;
                    }
                    break;
                    }
        }
        System.out.println(numarray);
        result = max + " " + min;
        System.out.println(result);
        return result;
    }

}
