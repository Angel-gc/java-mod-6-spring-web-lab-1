package com.example.demo.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.demo.Model.*;
import com.example.demo.dto.CamperDTO;
import com.example.demo.dto.CreateCamperDTO;
import org.apache.catalina.connector.Response;
import org.modelmapper.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CamperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CamperService {
    @Autowired
    private CamperRepository camperRepository;
    @Autowired
    private ApiError apiError;
    @Autowired
    private ModelMapper mapper;

    public CreateCamperDTO createCamper(CreateCamperDTO camperDTO) {
            Camper camper = mapper.map(camperDTO, Camper.class);
            camper = camperRepository.save(camper);
            return mapper.map(camper, CreateCamperDTO.class);
    }
    public CamperDTO getCamper(Long id){
        Camper camper =
                camperRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Camper not found"));
      List<Signup> signups = camper.getSignUps();
      List<Activity> activities = signups.stream().map(Signup::getActivity).collect(Collectors.toList());

      return mapper.map(camper, CamperDTO.class);
//      camperDTO.setActivities(activities);
    }
    public List<CamperDTO> getAllCampers(){
        return camperRepository.findAll()
                .stream()
                .map(camper -> mapper.map(camper, CamperDTO.class))
                .collect(Collectors.toList());
    }
}
