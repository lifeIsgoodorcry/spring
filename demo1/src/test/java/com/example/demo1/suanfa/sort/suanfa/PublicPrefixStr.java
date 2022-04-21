package com.example.demo1.suanfa.sort.suanfa;

/**
 * 最长公共前缀
 */
public class PublicPrefixStr {

    public static void main(String[] args) {

        String[] strs = new String[5];
        strs[0]="123";
        strs[1]="1234";
        strs[2]="12345";
        strs[4]="125";
        strs[3]="12123";
        String prefix = findPrefix(strs);
        System.out.println(prefix);

    }

    public static String findPrefix(String[] strs) {

        String prefix = strs[0];
        String result=prefix;
        for (int i = 0; i < prefix.length(); i++) {
              char a= prefix.charAt(i);
             for (String str : strs) {
                    if(str.charAt(i)!=a){
                        result=result.substring(0,i);
                   }
            }
        }
        return result;
    }


}
