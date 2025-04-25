package com.mycom.spring_data_jpa_lombok_phone.apple.controller;

import com.mycom.spring_data_jpa_lombok_phone.apple.entity.Apple;
import com.mycom.spring_data_jpa_lombok_phone.apple.service.AppleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apple")
public class AppleController {

    private final AppleService appleService;

    @GetMapping("/list")
    public List<Apple> listApple() {
        return appleService.listApple();
    }

    @GetMapping("/detail/{id}")
    public Optional<Apple> detailApple(@PathVariable("id") Integer id) {
        return appleService.detailApple(id);
    }

    @PostMapping("/insert")
    public Apple insertApple(Apple apple) {
        return appleService.insertApple(apple);
    }

    @PostMapping("/update")
    public Optional<Apple> updateSamsung(Apple apple) {
        return appleService.updateApple(apple);
    }

    @GetMapping("/delete/{id}")
    public  void deleteApple(@PathVariable("id") Integer id) {
        appleService.deleteApple(id);
    }

    @GetMapping("/count")
    public long countApple() {
        return appleService.countApple();
    }

    @GetMapping("/find/model")
    public List<Apple> findByModel(@RequestParam("model") String model) {
        return appleService.findByModel(model);
    }

    @GetMapping("/find/modelLike")
    public List<Apple> findByModelLike(@RequestParam("model") String model) {
        return appleService.findByModelLike(model);
    }
}
