package com.example.scrolling_cardview;

public class AppsModel {

    //step - 1 - variables

    private String name;
    private int numofDownloads;
    private int thumbail;

    //step2 : constructors
public AppsModel(){

}
    public AppsModel(String name, int numofDownloads, int thumbail) {
        this.name = name;
        this.numofDownloads = numofDownloads;
        this.thumbail = thumbail;
    }

    //step3 : getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumofDownloads() {
        return numofDownloads;
    }

    public void setNumofDownloads(int numofDownloads) {
        this.numofDownloads = numofDownloads;
    }

    public int getThumbail() {
        return thumbail;
    }

    public void setThumbail(int thumbail) {
        this.thumbail = thumbail;
    }
}
