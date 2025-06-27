package db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})

@RestController
@RequestMapping("/MealPlans")

public class MealPlansController{
    @Autowired
    private MealPlansRepository repo;

    @GetMapping
    public List<MealPlans> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public MealPlans addTestimonials(@RequestBody MealPlans mealPlans) {
        if (mealPlans.getPlanName().isEmpty() || mealPlans.getDescription().isEmpty() || mealPlans.getPlanPrice() <= 0 || mealPlans.getImageLink().isEmpty()){
            throw new IllegalArgumentException();
        }
        return repo.save(mealPlans);
    }

    @DeleteMapping("/delete-invalid")
    public void deleteInvalidMealPlans() {
        List<MealPlans> all = repo.findAll();
        for (MealPlans t : all) {
            if (t.getPlanName() == null || t.getDescription() == null || t.getPlanPrice() == 0 || t.getImageLink() == null) {
                repo.delete(t);
            }
        }
    }

    //Hapus data terakhir 
    @DeleteMapping("/delete-last")
    public void deleteLastTestimonial() throws Exception{
        try {
            List<MealPlans> all = repo.findAll();
            MealPlans lastMealPlans = all.get(all.size()-1);
            repo.delete(lastMealPlans);  
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

