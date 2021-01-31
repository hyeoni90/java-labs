package com.hyeonah.studyjava.algorithm.top50coding.stringAndArray;

/**
 * keyword: String, StringBuilder
 *
 * String: + or concat 연산 시 새로운 String 객체를 new로 만든다. 메모리 사용량 증가!
 * StringBuffer: 멀티 스레드 환경에서는 synchronized
 * StringBuilder: asynchronized 싱글 스레드
 */
public class LicenseKeyFormatting {

    public static void main(String[] args) {
        String str = "8F3Z-2e-9-wabcdef";
        int k = 4;
//        String str2 = "8-5g-3-J";
//        int k = 2;
        System.out.println(new LicenseKeyFormatting().solution(str, k)); // 8F-3Z2E-9WAB-CDEF
    }

    private String solution(String str, int k) {
        //  1. 하이픈 제거
        String newStr = str.replace("-", "");
        System.out.println("newStr: " + newStr);

        newStr = newStr.toUpperCase();
        System.out.println("newStr toUpperCase: " + newStr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < newStr.length(); i++) {
            sb.append(newStr.charAt(i));
        }

        // 4, 8, 12 .. 전체 길이에서 뒤에서 k 번째 씩
        for (int i = k; i < newStr.length(); i=i+k) {
            sb.insert(newStr.length() - i, "-");
        }

        System.out.println("-sb: " + sb);
        return newStr;
    }
}
