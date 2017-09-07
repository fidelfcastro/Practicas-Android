package com.androidapp.fidel.firstandroidapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fidel on 8/25/2017.
 */

public class Movies implements Parcelable{
    private String name;
    private String duration;
    private String director;
    private String genre;
    private String year;

    public Movies(String name, String duration, String director, String genre, String year) {
        this.name = name;
        this.duration = duration;
        this.director = director;
        this.genre = genre;
        this.year = year;
    }

    public Movies(Parcel in) {
        name=in.readString();
        duration=in.readString();
        director=in.readString();
        genre=in.readString();
        year=in.readString();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(duration);
        dest.writeString(director);
        dest.writeString(genre);
        dest.writeString(year);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        @Override
        public Movies createFromParcel(Parcel in){
            return new Movies(in);
        }
        @Override
        public Movies[] newArray(int size){
            return new Movies[size];
        }
    };
}

