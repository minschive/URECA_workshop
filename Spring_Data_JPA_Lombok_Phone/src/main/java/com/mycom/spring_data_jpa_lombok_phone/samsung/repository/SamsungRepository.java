package com.mycom.spring_data_jpa_lombok_phone.samsung.repository;

import com.mycom.spring_data_jpa_lombok_phone.samsung.entity.Samsung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SamsungRepository extends JpaRepository<Samsung, Integer> {
    List<Samsung> findByModel(String model);
    List<Samsung> findByModelLike(String model);
}
