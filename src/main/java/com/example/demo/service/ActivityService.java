package com.example.demo.service;

import com.example.demo.Model.Activity;
import com.example.demo.dto.ActivityDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.repository.ActivityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository; // field injection

    @Autowired
    private ModelMapper mapper;

    public ActivityDTO createActivity(ActivityDTO createDTO) {
        // Convert the HospitalCreateDTO to a Hospital entity
        Activity activity = mapper.map(createDTO, Activity.class);
        activity = activityRepository.save(activity);
        return mapper.map(activity, ActivityDTO.class);
    }

    public ActivityDTO getActivity(long id) {
        Activity activity =
                activityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return mapper.map(activity, ActivityDTO.class);
    }

    public List<ActivityDTO> getAllActivities() {
        return activityRepository.findAll()
                .stream()
                .map(activity -> mapper.map(activity, ActivityDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteActivity(Long id) {
        Activity activity =
                activityRepository.findById(id).orElseThrow(() -> new ExpressionException("Activity not found"));
        activityRepository.deleteById(activity.getId());
    }
}
