package com.chetan.project3_a2;

public class ChicagoRestaurant {
    String place_name;
    String url;

    public ChicagoRestaurant(String place_name, String url) {
        this.place_name = place_name;
        this.url = url;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
