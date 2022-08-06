package service;

import Model.Camper;
import dto.CamperDTO;
import org.modelmapper.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
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

    public CamperDTO createCamper(CamperDTO camperDTO) throws ValidationException {
        Camper camper = mapper.map(camperDTO, Camper.class);
        camper = camperRepository.save(camper);
        return mapper.map(camper, CamperDTO.class);
    }
    public CamperDTO getCamper(Long id){
        Camper camper =
                camperRepository.findById(id)
                        .orElseThrow(() -> new ExpressionException("Camper not found"));
        return mapper.map(camper, CamperDTO.class);
    }
    public List<CamperDTO> getAllCampers(){
        return camperRepository.findAll()
                .stream()
                .map(camper -> mapper.map(camper, CamperDTO.class))
                .collect(Collectors.toList());
    }
}
