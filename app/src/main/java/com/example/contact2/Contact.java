package com.example.contact2;

public class Contact {
    String image_url;
    String contact_name;
    String contact_phone;

    public Contact(String image_url, String contact_name, String contact_phone) {
        this.image_url = image_url;
        this.contact_name = contact_name;
        this.contact_phone = contact_phone;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }
}
