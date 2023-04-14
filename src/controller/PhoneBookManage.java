package controller;

import model.Contact;
import model.Iphone;


import model.Phone;
import model.Type;
import storage.WriteFile;

import java.util.*;


public class PhoneBookManage  extends Phone implements Iphone{
private List<Contact>contactList=new ArrayList<>();

    public PhoneBookManage() {
        this.contactList= new ArrayList<>();
    }


    public PhoneBookManage(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public void searchPhone(String name) {
        int index=-1;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        if(index != -1){
            System.out.println(contactList.get(index));
        }else {
            System.out.println("Không tồn tại số điện thoại này!!!");
        }
    }

    @Override
    public void sort() {
        Collections.sort(contactList, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for(Contact c:contactList){
            System.out.println(c);
        }
    }

    @Override
    public void display(Type type) {
       if(type==null){
           for (Contact c:contactList){
               System.out.println(c);
           }
       }
       else {
           for (Contact c:contactList){
               if(c.getType().equals(type)){
                   System.out.println(c);
               }
           }

       }

    }

    @Override
    public void insertPhone(Contact contact1) {
      boolean check = false;
      for(Contact c : contactList){
          if(c.getType().equals(contact1.getType())){
              check=true;//kiểm tra xem contact1 đã tồn tại chưa.
          }
      }
      if(check){
          for(Contact c:contactList){
              if(c.getType().equals(contact1.getType())){
                  c.setPhoneNumber(contact1.getPhoneNumber());
                  break;
              }
          }
      }
      else{
          contactList.add(contact1);
      }
        WriteFile.writeFile(contactList);
    }

    @Override
    public void removePhone(String name) {
     for(Contact c : contactList){
         if(c.getName().equals(name)){
             contactList.remove(c);
             break;
         }
     }
     WriteFile.writeFile(contactList);
    }



    @Override
   public void updatePhone(String name, String newPhone) {
        for(Contact c:contactList){
            if(c.getName().equals(name)){
                 c.setPhoneNumber(newPhone);
                 break;
            }
        }
        WriteFile.writeFile(contactList);
    }
}
