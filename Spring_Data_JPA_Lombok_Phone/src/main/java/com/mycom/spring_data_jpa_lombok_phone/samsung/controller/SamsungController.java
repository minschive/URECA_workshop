package com.mycom.spring_data_jpa_lombok_phone.samsung.controller;

import com.mycom.spring_data_jpa_lombok_phone.samsung.entity.Samsung;
import com.mycom.spring_data_jpa_lombok_phone.samsung.service.SamsungService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/samsung")
public class SamsungController {

    private final SamsungService samsungService;

    @GetMapping("/list")
    public List<Samsung> listSamsung() {
        return samsungService.listSamsung();
    }

    @GetMapping("/detail/{id}")
    public Optional<Samsung> detailStudent(@PathVariable("id") Integer id) {
        return samsungService.detailSamsung(id);
    }

    @PostMapping("/insert")
    public Samsung insertSamsung(Samsung samsung) {
        return samsungService.insertSamsung(samsung);
    }

    @PostMapping("/update")
    public Optional<Samsung> updateSamsung(Samsung samsung) {
        return samsungService.updateSamsung(samsung);
    }

    @GetMapping("/delete/{id}")
    public  void deleteSamsung(@PathVariable("id") Integer id) {
        samsungService.deleteSamsung(id);
    }

    @GetMapping("/count")
    public long countSamsung() {
        return samsungService.countSamsung();
    }

    @GetMapping("/find/model")
    public List<Samsung> findByModel(@RequestParam("model") String model) {
        return samsungService.findByModel(model);
    }

    @GetMapping("/find/modelLike")
    public List<Samsung> findByModelLike(@RequestParam("model") String model) {
        return samsungService.findByModelLike(model);
    }
}
