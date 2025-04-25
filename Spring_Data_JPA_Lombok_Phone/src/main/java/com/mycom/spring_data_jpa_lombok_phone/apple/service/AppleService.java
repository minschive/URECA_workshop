package com.mycom.spring_data_jpa_lombok_phone.apple.service;

import com.mycom.spring_data_jpa_lombok_phone.apple.entity.Apple;

import java.util.List;
import java.util.Optional;

public interface AppleService {

    // crud
    List<Apple> listApple();
    Optional<Apple> detailApple(int id);

    Apple insertApple(Apple apple);
    Optional<Apple> updateApple(Apple samsung);
    void deleteApple(int id);

    long countApple();
    List<Apple> listApple(int pageNumber, int pageSize);

    // find
    List<Apple> findByModel(String model);
    List<Apple> findByModelLike(String model);

}
