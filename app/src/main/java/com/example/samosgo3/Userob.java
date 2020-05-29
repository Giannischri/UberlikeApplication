package com.example.samosgo3;

public class Userob {
    String id;
    String name;
    String profile;
    String email;
    double x;
    double y;


    public Userob()
    {

    }

    public Userob(String id,String name,String profile,String email,double x, double y) {
        this.id=id;
        this.name = name;
        this.profile = profile;
        this.x = x;
        this.y = y;
        this.email=email;
    }
    public String getId(){return id;}

    public String getName() {
        return name;
    }

    public String getProfile() {
        return profile;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Userob{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", email='" + email + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
