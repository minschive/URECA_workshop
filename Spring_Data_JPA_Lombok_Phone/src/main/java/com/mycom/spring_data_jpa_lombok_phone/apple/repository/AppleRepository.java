package com.mycom.spring_data_jpa_lombok_phone.apple.repository;

import com.mycom.spring_data_jpa_lombok_phone.apple.entity.Apple;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppleRepository extends JpaRepository<Apple, Integer> {
    List<Apple> findByModel(String model);
    List<Apple> findByModelLike(String model);
}
