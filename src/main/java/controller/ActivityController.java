package controller;

import dto.ActivityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ActivityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ActivityDTO createActivity(@Valid @RequestBody ActivityDTO activityDTO){
        return activityService.createActivity(activityDTO);
    }

    @GetMapping
    public List<ActivityDTO> getActivities(){
        return activityService.getAllActivities();
    }

    @GetMapping("/{id}")
    public ActivityDTO getActivity(@PathVariable Long id){
        return activityService.getActivity(id);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id){
        activityService.deleteActivity(id);
    }
}
