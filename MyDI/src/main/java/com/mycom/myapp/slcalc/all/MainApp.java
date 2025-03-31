package com.mycom.myapp.slcalc.all;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) throws IOException {
        // Spring DI 를 통한 객체 생성
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/all-slcalc-annotation.xml");
        
        // StringService 인터페이스 타입으로 빈 주입
        StringService stringService = context.getBean(StringService.class);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("문자열을 입력하세요:");
        String input = br.readLine();
        
        // 길이 출력
        stringService.printLength(input);
        
        // 대소문자 변환
        String toggled = stringService.toggleCase(input);
        System.out.println("Toggled case: " + toggled);
        
        // 공백 제거
        String noSpaces = stringService.removeSpaces(input);
        System.out.println("No spaces: " + noSpaces);
        
        // 단어 갯수 세기
        int wordCount = stringService.countWords(input);
        System.out.println("Word count: " + wordCount);
        
        context.close();
    }
}
