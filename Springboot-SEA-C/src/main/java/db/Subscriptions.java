package db;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private int phoneNumber;
    private int planSelection;
    private List<Integer> mealType;
    private List<Integer> deliveryDays;
    private String pesan;

    public Subscriptions(){

    }

    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getPhoneNumber(){
        return this.phoneNumber;
    }

    public int getPlanSelection(){
        return this.planSelection;
    }

    public List<Integer> getMealType(){
        return this.mealType;
    }

    public List<Integer> getDeliveryDays(){
        return this.deliveryDays;
    }

    public String getPesan(){
        return this.pesan;
    }

    //Setter

    public void setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setPlanSelection(int planSelection){
        this.planSelection = planSelection;
    }

    public void setMealType(List<Integer> mealType){
        this.mealType = mealType;
    }

    public void setDeliveryDays(List<Integer> deliveryDays){
        this.deliveryDays = deliveryDays;
    }

    public void setPesan(String pesan){
        this.pesan = pesan;
    }


}
