package com.example.online_clothing;

public class ItemModel {
    private String itemname;
    private String price;
    private String description;
    private int imagename;

    public ItemModel(String itemname, String price, String description, int imagename) {
        this.itemname = itemname;
        this.price = price;
        this.description = description;
        this.imagename = imagename;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImagename() {
        return imagename;
    }

    public void setImagename(int imagename) {
        this.imagename = imagename;
    }
}
