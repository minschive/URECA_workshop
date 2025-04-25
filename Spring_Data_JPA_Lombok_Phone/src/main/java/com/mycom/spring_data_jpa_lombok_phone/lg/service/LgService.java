package com.mycom.spring_data_jpa_lombok_phone.lg.service;

import com.mycom.spring_data_jpa_lombok_phone.lg.entity.Lg;

import java.util.List;
import java.util.Optional;

public interface LgService {

    // crud
    List<Lg> listLg();
    Optional<Lg> detailLg(int id);

    Lg insertLg(Lg lg);
    Optional<Lg> updateLg(Lg lg);
    void deleteLg(int id);

    long countLg();
    List<Lg> listLg(int pageNumber, int pageSize);

    // find
    List<Lg> findByModel(String model);
    List<Lg> findByModelLike(String model);

}
