package com.mycom.spring_data_jpa_lombok_phone.samsung.service;

import com.mycom.spring_data_jpa_lombok_phone.samsung.entity.Samsung;

import java.util.List;
import java.util.Optional;

public interface SamsungService {

    // crud
    List<Samsung> listSamsung();
    Optional<Samsung> detailSamsung(int id);

    Samsung insertSamsung(Samsung samsung);
    Optional<Samsung> updateSamsung(Samsung samsung);
    void deleteSamsung(int id);

    long countSamsung();
    List<Samsung> listSamsung(int pageNumber, int pageSize);

    // find
    List<Samsung> findByModel(String model);
    List<Samsung> findByModelLike(String model);

}
