package com.mycom.myapp.slcalc.all;

import org.springframework.stereotype.Component;

@Component
public class StringProcessingService {

    StringService stringService;

    // Spring DI #constructor injection (spring 추천 방식)
    public StringProcessingService(StringService stringService) {
        super();
        this.stringService = stringService;
    }
    
    // 문자열 길이 출력
    public void printLength(String input) {
        // StringService의 printLength 메서드를 호출
        stringService.printLength(input);
    }

    // 다른 문자열 처리 메서드들 추가 가능
    public void printToggledCase(String input) {
        String result = stringService.toggleCase(input);
        System.out.println("대소문자 변환: " + result);
    }

    public void printRemovedSpaces(String input) {
        String result = stringService.removeSpaces(input);
        System.out.println("공백 제거: " + result);
    }

    public void printWordCount(String input) {
        int count = stringService.countWords(input);
        System.out.println("단어 수: " + count);
    }
}
