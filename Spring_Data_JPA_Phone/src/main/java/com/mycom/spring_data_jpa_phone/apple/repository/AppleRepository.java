package com.mycom.spring_data_jpa_phone.apple.repository;

import com.mycom.spring_data_jpa_phone.apple.entity.Apple;
import com.mycom.spring_data_jpa_phone.phone.dto.PhoneDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppleRepository extends JpaRepository<Apple, Long> {
    List<Apple> findByModel(String model);
    List<Apple> findByModelLike(String model);

    @Query("SELECT new com.mycom.spring_data_jpa_phone.phone.dto.PhoneDto(a.id, a.model, a.size, a.memory, a.price, 'Apple') FROM Apple a")
    List<PhoneDto> findAllPhoneDetails();
}
