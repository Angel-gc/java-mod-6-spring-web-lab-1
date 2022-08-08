package com.example.demo.service;


import com.example.demo.Model.Camper;
import com.example.demo.Model.Signup;
import com.example.demo.dto.ActivityDTO;
import com.example.demo.dto.CreateCamperDTO;
import com.example.demo.dto.SignupDTO;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.repository.CamperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.repository.SignupRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SignupService {
    @Autowired
    private SignupRepository signupRepository; // field injection
    @Autowired
    private CamperRepository camperRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ModelMapper mapper;

    public ActivityDTO createSignup(SignupDTO signupDTO) {
        // Convert the signUpDTO to a signup entity
        Signup signup = mapper.map(signupDTO, Signup.class);
        signup.setCamper(camperRepository.findById(signupDTO.getCamperId()).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "[validation errors]")
        ));
        signup.setActivity(activityRepository.findById(signupDTO.getActivityId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "[validation errors]")));
        try {
            signup = signupRepository.save(signup);
            signupDTO = mapper.map(signup, SignupDTO.class);
            signupDTO.setActivityId(signup.getActivity().getId());
            signupDTO.setCamperId(signup.getCamper().getId());
            return activityService.getActivity(signupDTO.getActivityId());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "was not created");
        }
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