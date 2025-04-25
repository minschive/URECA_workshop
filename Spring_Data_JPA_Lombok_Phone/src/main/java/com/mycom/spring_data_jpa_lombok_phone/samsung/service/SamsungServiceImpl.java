package com.mycom.spring_data_jpa_lombok_phone.samsung.service;

import com.mycom.spring_data_jpa_lombok_phone.samsung.entity.Samsung;
import com.mycom.spring_data_jpa_lombok_phone.samsung.repository.SamsungRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SamsungServiceImpl implements SamsungService {

    private final SamsungRepository samsungRepository;

    @Override
    public List<Samsung> listSamsung() {
        return samsungRepository.findAll();
    }

    @Override
    public Optional<Samsung> detailSamsung(int id) {
        return samsungRepository.findById(id);
    }

    @Override
    public Samsung insertSamsung(Samsung samsung) {
        return samsungRepository.save(samsung);
    }

    @Override
    public Optional<Samsung> updateSamsung(Samsung samsung) {
        Optional<Samsung> exstingSamsung = samsungRepository.findById(samsung.getId());
        if(exstingSamsung.isPresent()) {
            return Optional.of(samsungRepository.save(samsung));
        }
        return Optional.empty();
    }

    @Override
    public void deleteSamsung(int id) {
        samsungRepository.deleteById(id);
    }

    @Override
    public long countSamsung() {
        return samsungRepository.count();
    }

    @Override
    public List<Samsung> listSamsung(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Samsung> page = samsungRepository.findAll(pageable);
        return page.toList();
    }

    @Override
    public List<Samsung> findByModel(String model) {
        return samsungRepository.findByModel(model);
    }

    @Override
    public List<Samsung> findByModelLike(String model) {
        return samsungRepository.findByModel("%" + model + "%");
    }
}
