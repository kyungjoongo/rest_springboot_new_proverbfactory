package com.kyungjoon.rest.receipe;

import org.springframework.web.multipart.MultipartFile;

public class Receipe {

    private String title;
    private String material;
    public  MultipartFile image;
    private String url;
    private String create_dt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreate_dt() {
        return create_dt;
    }

    public void setCreate_dt(String create_dt) {
        this.create_dt = create_dt;
    }


    @Override
    public String toString() {
        return "Receipe{" +
                "title='" + title + '\'' +
                ", material='" + material + '\'' +
                ", image=" + image +
                ", url='" + url + '\'' +
                ", create_dt='" + create_dt + '\'' +
                '}';
    }


}
