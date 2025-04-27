package com.mycom.spring_data_jpa_phone.apple.service;

import com.mycom.spring_data_jpa_phone.apple.entity.Apple;
import com.mycom.spring_data_jpa_phone.apple.repository.AppleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppleServiceImpl implements AppleService {

    private final AppleRepository appleRepository;

    @Override
    public List<Apple> listApple() {
        return appleRepository.findAll();
    }

    @Override
    public Optional<Apple> detailApple(long id) {
        return appleRepository.findById(id);
    }

    @Override
    public Apple insertApple(Apple apple) {
        return appleRepository.save(apple);
    }

    @Override
    public Optional<Apple> updateApple(Apple apple) {
        Optional<Apple> exstingApple = appleRepository.findById(apple.getId());
        if(exstingApple.isPresent()) {
            return Optional.of(appleRepository.save(apple));
        }
        return Optional.empty();
    }

    @Override
    public void deleteApple(long id) {
        appleRepository.deleteById(id);
    }

    @Override
    public long countApple() {
        return appleRepository.count();
    }

    @Override
    public List<Apple> listApple(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Apple> page = appleRepository.findAll(pageable);
        return page.toList();
    }

    @Override
    public List<Apple> findByModel(String model) {
        return appleRepository.findByModel(model);
    }

    @Override
    public List<Apple> findByModelLike(String model) {
        return appleRepository.findByModel("%" + model + "%");
    }
}
