package org.Info;

import org.Jdbc.DataDase;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Author:WangQian
 * Date: 18-6-25 下午8:37
 */
public class DriverCarMess {
    private int id ;
    private String owner_id;
    private String car_owner;
    private String owner_age;
    private String gender ;
    private String tele_num ;
    private String owner_dress;
    private String drive_time;
    private String register_date;
    private String car_id;
    private String car_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getCar_owner() {
        return car_owner;
    }

    public void setCar_owner(String car_owner) {
        this.car_owner = car_owner;
    }

    public String getOwner_age() {
        return owner_age;
    }

    public void setOwner_age(String owner_age) {
        this.owner_age = owner_age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTele_num() {
        return tele_num;
    }

    public void setTele_num(String tele_num) {
        this.tele_num = tele_num;
    }

    public String getOwner_dress() {
        return owner_dress;
    }

    public void setOwner_dress(String owner_dress) {
        this.owner_dress = owner_dress;
    }

    public String getDrive_time() {
        return drive_time;
    }

    public void setDrive_time(String drive_time) {
        this.drive_time = drive_time;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

}
