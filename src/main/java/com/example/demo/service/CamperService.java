package com.example.demo.service;

import com.example.demo.Model.Camper;
import com.example.demo.dto.CamperDTO;
import com.example.demo.dto.CreateCamperDTO;
import org.modelmapper.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CamperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CamperService {
    @Autowired
    private CamperRepository camperRepository;
    @Autowired
    private ModelMapper mapper;

    public CreateCamperDTO createCamper(CreateCamperDTO camperDTO) throws ValidationException {
        Camper camper = mapper.map(camperDTO, Camper.class);
        camper = camperRepository.save(camper);
        return mapper.map(camper, CreateCamperDTO.class);
    }
    public CamperDTO getCamper(Long id){
        Camper camper =
                camperRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Camper not found"));
        return mapper.map(camper, CamperDTO.class);
    }
    public List<CamperDTO> getAllCampers(){
        return camperRepository.findAll()
                .stream()
                .map(camper -> mapper.map(camper, CamperDTO.class))
                .collect(Collectors.toList());
    }
}
