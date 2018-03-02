package com.example.venkatesh.coverflow;

/**
 * Created by Venkatesh on 29-Aug-17.
 */

public class Movie {
    private String Name,ImageURL;

    public Movie(String name, String imageURL) {
        Name = name;
        ImageURL = imageURL;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public String getName() {
        return Name;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public void setName(String name) {
        Name = name;
    }
}
