package db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity

public class UsersTestimonials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nama;
    private String pesan;
    private String bintang;

    public UsersTestimonials(){

    }

    public long getId(){
        return id;
    }

    public String getNama(){
        return nama;
    }

    public String getPesan(){
        return pesan;
    }

    public String getBintang(){
        return bintang;
    }

    //Setter

    public void setId(long idBaru){
        id = idBaru;
    }

    public void setNama(String namaBaru){
        nama = namaBaru;
    }

    public void setPesan(String pesanBaru){
        pesan = pesanBaru;
    }

    public void setBintang(String bintangBaru){
        bintang = bintangBaru;
    }

}
