package com.javajob.myjob.model;

public class Job {
    private String title;
    private String company;
    private String location;
    private String link;

    public Job(String title, String company, String location, String link) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.link = link;
    }

    public String getTitle() { return title; }
    public String getCompany() { return company; }
    public String getLocation() { return location; }
    public String getLink() { return link; }
}
