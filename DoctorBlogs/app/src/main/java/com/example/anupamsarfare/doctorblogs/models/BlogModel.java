package com.example.anupamsarfare.doctorblogs.models;

/**
 * Created by pratikgadekar on 12/21/15.
 */
public class BlogModel {

    String id;
    String blogName;
    String blogPicUrl;
    String blogDiscriptions;


    public BlogModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogPicUrl() {
        return blogPicUrl;
    }

    public void setBlogPicUrl(String blogPicUrl) {
        this.blogPicUrl = blogPicUrl;
    }

    public String getBlogDiscriptions() {
        return blogDiscriptions;
    }

    public void setBlogDiscriptions(String blogDiscriptions) {
        this.blogDiscriptions = blogDiscriptions;
    }
}
