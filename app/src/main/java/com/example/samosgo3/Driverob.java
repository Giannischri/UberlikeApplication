package com.example.samosgo3;

public class Driverob extends Userob {

    private String license;
    private String plates;
    private int rating;

    public Driverob(String id,String name,String profile,String email,double x,double y,String license,String plates,int rating) {

        super(id,name,profile,email, x, y);

        this.license = license;
        this.plates = plates;
        this.rating = rating;

    }


    public String getLicense() {
        return license;
    }

    public String getPlates() {
        return plates;
    }

    public int getRating() {
        return rating;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Driverob{" +
                "license='" + license + '\'' +
                ", plates='" + plates + '\'' +
                ", rating=" + rating +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", email='" + email + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

