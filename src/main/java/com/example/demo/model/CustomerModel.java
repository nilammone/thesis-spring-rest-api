package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cus_data")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "birth_date")
    private String birth_date;
    @Column(name = "e_mail")
    private String e_mail;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;

    public CustomerModel() {
    }

    public CustomerModel(String first_name, String last_name, String birth_date, String e_mail, String phone,
            String address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.e_mail = e_mail;
        this.phone = phone;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerModel [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", birth_date="
                + birth_date + ", e_mail=" + e_mail + ", phone=" + phone + ", address=" + address + "]";
    }

}
