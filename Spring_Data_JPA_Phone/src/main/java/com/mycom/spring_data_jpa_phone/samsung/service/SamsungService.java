package com.mycom.spring_data_jpa_phone.samsung.service;

import com.mycom.spring_data_jpa_phone.samsung.entity.Samsung;

import java.util.List;
import java.util.Optional;

public interface SamsungService {

    // crud
    List<Samsung> listSamsung();
    Optional<Samsung> detailSamsung(long id);

    Samsung insertSamsung(Samsung samsung);
    Optional<Samsung> updateSamsung(Samsung samsung);
    void deleteSamsung(long id);

    long countSamsung();
    List<Samsung> listSamsung(int pageNumber, int pageSize);

    // find
    List<Samsung> findByModel(String model);
    List<Samsung> findByModelLike(String model);

}
