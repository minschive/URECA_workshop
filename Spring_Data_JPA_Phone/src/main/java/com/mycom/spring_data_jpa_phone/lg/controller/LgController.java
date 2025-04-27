package com.mycom.spring_data_jpa_phone.lg.controller;

import com.mycom.spring_data_jpa_phone.lg.entity.Lg;
import com.mycom.spring_data_jpa_phone.lg.service.LgService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lg")
public class LgController {

    private final LgService lgService;

    @GetMapping("/list")
    public List<Lg> listApple() {
        return lgService.listLg();
    }

    @GetMapping("/detail/{id}")
    public Optional<Lg> detailLg(@PathVariable("id") Integer id) {
        return lgService.detailLg(id);
    }

    @PostMapping("/insert")
    public Lg insertLg(Lg lg) {
        return lgService.insertLg(lg);
    }

    @PostMapping("/update")
    public Optional<Lg> updateLg(Lg lg) {
        return lgService.updateLg(lg);
    }

    @GetMapping("/delete/{id}")
    public  void deleteLg(@PathVariable("id") Integer id) {
        lgService.deleteLg(id);
    }

    @GetMapping("/count")
    public long countLg() {
        return lgService.countLg();
    }

    @GetMapping("/find/model")
    public List<Lg> findByModel(@RequestParam("model") String model) {
        return lgService.findByModel(model);
    }

    @GetMapping("/find/modelLike")
    public List<Lg> findByModelLike(@RequestParam("model") String model) {
        return lgService.findByModelLike(model);
    }
}
