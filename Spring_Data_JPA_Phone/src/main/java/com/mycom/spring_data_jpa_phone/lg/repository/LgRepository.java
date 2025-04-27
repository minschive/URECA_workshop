package com.mycom.spring_data_jpa_phone.lg.repository;

import com.mycom.spring_data_jpa_phone.lg.entity.Lg;
import com.mycom.spring_data_jpa_phone.phone.dto.PhoneDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LgRepository extends JpaRepository<Lg, Long> {
    List<Lg> findByModel(String model);
    List<Lg> findByModelLike(String model);

    @Query("SELECT new com.mycom.spring_data_jpa_phone.phone.dto.PhoneDto(l.id, l.model, l.size, l.memory, l.price, 'LG') FROM Lg l")
    List<PhoneDto> findAllPhoneDetails();
}
