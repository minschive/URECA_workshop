package com.mycom.spring_data_jpa_lombok_phone.lg.repository;

import com.mycom.spring_data_jpa_lombok_phone.lg.entity.Lg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LgRepository extends JpaRepository<Lg, Integer> {
    List<Lg> findByModel(String model);
    List<Lg> findByModelLike(String model);
}
