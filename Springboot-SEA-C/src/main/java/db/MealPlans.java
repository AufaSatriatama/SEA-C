package db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class MealPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String planName;
    private int planPrice;
    private String description;
    private String imageLink;

    public MealPlans(){

    }

    public long getId(){
        return this.id;
    }

    public String getPlanName(){
        return this.planName;
    }

    public int getPlanPrice(){
        return this.planPrice;
    }

    public String getDescription(){
        return this.description;
    }

    public String getImageLink(){
        return this.imageLink;
    }

    //Setter

    public void setId(long id){
        this.id = id;
    }

    public void setPlanName(String planName){
        this.planName = planName;
    }

    public void setPlanPrice(int planPrice){
        this.planPrice = planPrice;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setImageLink(String imageLink){
        this.imageLink = imageLink;
    }


}
