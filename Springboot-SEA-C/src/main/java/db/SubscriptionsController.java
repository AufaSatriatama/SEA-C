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
@RequestMapping("/Subscriptions")

public class SubscriptionsController {
    @Autowired
    private SubscriptionsRepository repo;

    @GetMapping
    public List<Subscriptions> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Subscriptions addSubscriptions(@RequestBody Subscriptions subscriptions) {
        if (subscriptions.getName().isEmpty() || subscriptions.getPesan().isEmpty() || subscriptions.getPhoneNumber() <= 0 || subscriptions.getPlanSelection() <= 0 || subscriptions.getMealType() == null || subscriptions.getDeliveryDays() == null) {
            throw new IllegalArgumentException();
        }
        return repo.save(subscriptions);
    }

    @DeleteMapping("/delete-invalid")
    public void deleteInvalidSubscriptions() {
        List<Subscriptions> all = repo.findAll();
        for (Subscriptions t : all) {
            if (t.getName() == null || t.getPesan() == null || t.getPhoneNumber() == 0 || t.getPlanSelection() == 0 || t.getMealType() == null || t.getDeliveryDays() == null) {
                repo.delete(t);
            }
        }
    }

    //Hapus data terakhir 
    @DeleteMapping("/delete-last")
    public void deleteLastSubscription() throws Exception{
        try {
            List<Subscriptions> all = repo.findAll();
            Subscriptions lastSubscription = all.get(all.size()-1);
            repo.delete(lastSubscription);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
