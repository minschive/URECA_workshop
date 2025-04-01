package com.mycom.myapp.slcalc.all;

public interface StringService {
	int getLength(String str);              // 문자열 길이 계산
    void printLength(String str);           // 문자열 길이 출력
    String toggleCase(String str);          // 대소문자 변환
    String removeSpaces(String str);        // 공백 제거
    int countWords(String str);             // 단어 수 세기
}
