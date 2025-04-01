package com.mycom.myapp.slcalc.all;

import org.springframework.stereotype.Component;

@Component
public class StringServiceImpl implements StringService {

	@Override
    public int getLength(String str) {
        return str.length();
    }

    @Override
    public void printLength(String str) {
        System.out.println("String length: " + getLength(str));
    }

    @Override
    public String toggleCase(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }

    @Override
    public String removeSpaces(String str) {
        return str.trim().replaceAll("\\s+", " "); // 앞뒤 공백 제거하고 중간 공백을 하나로
    }

    @Override
    public int countWords(String str) {
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

}
