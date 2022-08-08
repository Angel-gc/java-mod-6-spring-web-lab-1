package com.example.demo.controller;

import com.example.demo.dto.CamperDTO;
import com.example.demo.dto.CreateCamperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CamperService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/campers")
public class CamperController {
    @Autowired
    private CamperService camperService;

    @PostMapping
//    @ResponseStatus(reason = "Some Parameters are invalid")
    public CreateCamperDTO createCamper(@Valid @RequestBody CreateCamperDTO camper){
        return camperService.createCamper(camper);
    }

    @GetMapping
    public List<CamperDTO> getCampers(){
        return camperService.getAllCampers();
    }

    @GetMapping("/{id}")
    public CamperDTO getCamper(@PathVariable Long id){
        return camperService.getCamper(id);
    }
}
