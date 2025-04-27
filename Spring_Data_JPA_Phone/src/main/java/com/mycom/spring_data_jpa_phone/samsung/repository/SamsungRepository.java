package com.mycom.spring_data_jpa_phone.samsung.repository;

import com.mycom.spring_data_jpa_phone.phone.dto.PhoneDto;
import com.mycom.spring_data_jpa_phone.samsung.entity.Samsung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SamsungRepository extends JpaRepository<Samsung, Long> {
    List<Samsung> findByModel(String model);
    List<Samsung> findByModelLike(String model);

    @Query("SELECT new com.mycom.spring_data_jpa_phone.phone.dto.PhoneDto(s.id, s.model, s.size, s.memory, s.price, 'Samsung') FROM Samsung s")
    List<PhoneDto> findAllPhoneDetails();
}
