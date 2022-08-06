package service;


import Model.Signup;
import dto.ActivityDTO;
import dto.SignupDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repository.SignupRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SignupService {
    @Autowired
    private SignupRepository signupRepository; // field injection
    @Autowired
    private ModelMapper mapper;

    public SignupDTO createSignup(SignupDTO signupDTO) {
        // Convert the HospitalCreateDTO to a Hospital entity
        Signup signup = mapper.map(signupDTO, Signup.class);
        signup = signupRepository.save(signup);
        return mapper.map(signup, SignupDTO.class);
    }
    public SignupDTO getSignup(long id) {
        Signup signup =
                signupRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return mapper.map(signup, SignupDTO.class);
    }
    public void deleteSignup(Long id) {
        signupRepository.deleteById(id);
    }
    public List<SignupDTO> getAllSignups() {
        return signupRepository.findAll().stream().map(camp -> mapper.map(camp, SignupDTO.class)).collect(Collectors.toList());
    }
}