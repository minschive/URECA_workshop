package com.mycom.spring_data_jpa_lombok_phone.lg.service;

import com.mycom.spring_data_jpa_lombok_phone.lg.entity.Lg;
import com.mycom.spring_data_jpa_lombok_phone.lg.repository.LgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LgServiceImpl implements LgService {

    private final LgRepository lgRepository;

    @Override
    public List<Lg> listLg() {
        return lgRepository.findAll();
    }

    @Override
    public Optional<Lg> detailLg(int id) {
        return lgRepository.findById(id);
    }

    @Override
    public Lg insertLg(Lg lg) {
        return lgRepository.save(lg);
    }

    @Override
    public Optional<Lg> updateLg(Lg lg) {
        Optional<Lg> exstingLg = lgRepository.findById(lg.getId());
        if(exstingLg.isPresent()) {
            return Optional.of(lgRepository.save(lg));
        }
        return Optional.empty();
    }

    @Override
    public void deleteLg(int id) {
        lgRepository.deleteById(id);
    }

    @Override
    public long countLg() {
        return lgRepository.count();
    }

    @Override
    public List<Lg> listLg(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Lg> page = lgRepository.findAll(pageable);
        return page.toList();
    }

    @Override
    public List<Lg> findByModel(String model) {
        return lgRepository.findByModel(model);
    }

    @Override
    public List<Lg> findByModelLike(String model) {
        return lgRepository.findByModel("%" + model + "%");
    }
}
