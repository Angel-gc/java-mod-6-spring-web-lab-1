package service;

import Model.Camper;
import dto.CampersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repository.CamperRepository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CamperService {

    @Autowired
    private CamperRepository camperRepository;

    @Autowired
    private ModelMapper mapper;

    public CampersDTO createCamper(CampersDTO campersDTO){
        Camper camper = mapper.map(campersDTO, Camper.class);
        camper = camperRepository.save(camper);
        return mapper.map(camper, CampersDTO.class);
    }

    public CampersDTO getCamper(Long id){
        Camper camper =
                camperRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.
                                NOT_FOUND));
        return mapper.map(camper, CampersDTO.class);
    }
    public List<CampersDTO> getAllCampers(){
        return camperRepository.findAll()
                .stream()
                .map(camper -> mapper.map(camper, CampersDTO.class))
                .collect(Collectors.toList());
    }
}
