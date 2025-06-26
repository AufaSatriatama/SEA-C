package db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Testimonials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private String message;
    private int rating;

    public Testimonials(){

    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getMessage(){
        return message;
    }

    public int getRating(){
        return rating;
    }

    //Setter

    public void setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

}
