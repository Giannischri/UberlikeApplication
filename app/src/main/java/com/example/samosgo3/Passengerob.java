package com.example.samosgo3;

public class Passengerob extends Userob {
    public Passengerob(String id,String name,String profile,String email,double x,double y){

        super(id,name , profile ,email,x , y );


    }

    @Override
    public String toString() {
        return "Passengerob{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", email='" + email + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
