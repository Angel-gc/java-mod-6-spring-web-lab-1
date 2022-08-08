package controller;

import Model.Camper;
import dto.CamperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CamperService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/campers")
public class CamperController {
    @Autowired
    private CamperService camperService;

    @PostMapping
    public CamperDTO createCamper(@Valid @RequestBody CamperDTO camper){
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
