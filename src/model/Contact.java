package model;

import model.Type;

import java.io.Serializable;

public class Contact implements Serializable  {
    private String name;
    private String phoneNumber;
    private Type type;

    public Contact() {
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String phoneNumber, Type type) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //lấy tên để sắp xếp
//    public String get_name(){
//        String n_ame= this.name .trim();//cắt khoảng trắng 2 đầu
//        if(n_ame.indexOf(" ")>=0){
//            int index= n_ame.lastIndexOf(" ");
//            return n_ame.substring(index+1);
//        }else {
//            return n_ame;
//        }
//    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name= " + name +
                ", phoneNumber= " + phoneNumber +
                ", type= " + type +
                "}";
    }


}
