package com.example.samosgo3;

public class Routeob {
    private String id;
    private String StartLocation;
    private String EndLocation;
    private String Date;
    private String Hour;
    private String Price;
    private String Passenger1;
    private String Passenger2;
    private String Passenger3;
    private String Passenger4;


    public Routeob(String id,String startLocation, String endLocation, String date, String hour, String price, String passenger1, String passenger2, String passenger3, String passenger4) {
        this.StartLocation = startLocation;
        this.id=id;
        this.EndLocation = endLocation;
        this.Date = date;
        this.Hour = hour;
        this.Price = price;
        this.Passenger1 = passenger1;
        this.Passenger2 = passenger2;
        this.Passenger3 = passenger3;
        this.Passenger4 = passenger4;
    }

    public void setStartLocation(String startLocation) {
        StartLocation = startLocation;
    }

    public void setEndLocation(String endLocation) {
        EndLocation = endLocation;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setHour(String hour) {
        Hour = hour;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setPassenger1(String passenger1) {
        Passenger1 = passenger1;
    }

    public void setPassenger2(String passenger2) {
        Passenger2 = passenger2;
    }

    public void setPassenger3(String passenger3) {
        Passenger3 = passenger3;
    }

    public void setPassenger4(String passenger4) {
        Passenger4 = passenger4;
    }

    public String getStartLocation() {
        return StartLocation;
    }

    public String getEndLocation() {
        return EndLocation;
    }

    public String getDate() {
        return Date;
    }

    public String getHour() {
        return Hour;
    }

    public String getPrice() {
        return Price;
    }

    public String getPassenger1() {
        return Passenger1;
    }

    public String getPassenger2() {
        return Passenger2;
    }

    public String getPassenger3() {
        return Passenger3;
    }

    public String getPassenger4() {
        return Passenger4;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Routeob{" +
                "id='" + id + '\'' +
                ", StartLocation='" + StartLocation + '\'' +
                ", EndLocation='" + EndLocation + '\'' +
                ", Date='" + Date + '\'' +
                ", Hour='" + Hour + '\'' +
                ", Price='" + Price + '\'' +
                ", Passenger1='" + Passenger1 + '\'' +
                ", Passenger2='" + Passenger2 + '\'' +
                ", Passenger3='" + Passenger3 + '\'' +
                ", Passenger4='" + Passenger4 + '\'' +
                '}';
    }
}
