package com.example.admin.movieappv2;



import java.net.URL;



public class Movie {
    public int Rate;
    public String Name;
    public String description;
    public String imageUrl;
    public String movie_id;
    public int popularity;


    public void setRate(int rate) {Rate = rate;}

    public void setName(String name) {Name = name;}

    public void setDescription(String description) {this.description = description;}

    public void setImageUrl(String url) {imageUrl=url;}

    public void setMovie_id(String id) {
        movie_id = id;
    }

    public void setPopularity(int popularity){this.popularity=popularity;}

    public int getRate() {return Rate;}

    public String getName() {return Name;}

    public String getDescription() {
        return description;
    }

    public String getImageUrl(){return imageUrl;}

    public String getMovie_id() {return movie_id;}

    public int getPopularity(){return popularity;}
}
