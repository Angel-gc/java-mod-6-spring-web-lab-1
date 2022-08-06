package controller;

import dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ActivityService;
import service.SignupService;

@RestController
@RequestMapping("/signups")
public class SignupController {
    @Autowired
    private SignupService signupService;

    @Autowired
    private ActivityService activityService;

    // If the Signup is created successfully, send back a response with the data related to the Activity:
    @PostMapping
    public SignupDTO createSignup(@RequestBody SignupDTO signupDTO){
        return signupService.createSignup(signupDTO);
    }
}
