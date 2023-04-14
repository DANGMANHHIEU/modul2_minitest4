package views;

import controller.PhoneBookManage;
import model.Contact;
import model.Type;
import storage.ReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static List<Contact> contacts = ReadFile.readFile();
//    public static List<Contact> contacts = new ArrayList<>();
    public static PhoneBookManage phoneBookManage = new PhoneBookManage(contacts);


    //search theo tên
    public static void  search(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên cần tìm kiếm:");
        String name = sc.nextLine();
        phoneBookManage. searchPhone(name);

    }

    //hàm sắp xếp
    public static void sort(){
        phoneBookManage.sort();
    }

    // hàm hiển thị
    public static void display(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID:");
        String id=sc.nextLine();
        System.out.println("Nhập tên công ty:");
        String name=sc.nextLine();
        Type type=new Type(id,name);
        phoneBookManage.display(type);
    }

    //hàm xóa
    public static void delete(){
        System.out.println("Nhập tên cần xóa:");
        Scanner sc=new Scanner(System.in);
        String name = sc.nextLine();
        phoneBookManage.removePhone(name);
    }

    //hàm sửa số theo tên
    public static void editPhone(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhập tên:");
        String name = sc.nextLine();
        System.out.println("Nhập số điện thoại:");
        String newPhone=sc.nextLine();
        phoneBookManage.updatePhone(name,newPhone);
    }

// hàm chèn số điện thoại
    public static void insert(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập tên:");
        String name = sc.nextLine();
        System.out.println("Nhập số điện thoại:");
        String phoneNumber= sc.nextLine();
        System.out.println("Nhập type:");
        System.out.println("Nhập ID:");
        String id=sc.nextLine();
        System.out.println("Nhập tên công ty:");
        String n_ame=sc.nextLine();
        Type type=new Type(id,n_ame);

        Contact contact=new Contact(name,phoneNumber,type);

        phoneBookManage.insertPhone(contact);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Vui lòng chọn chức năng:");
            System.out.println(
                    "1.Tìm kiếm số theo tên.\n"
                            + "2.Sắp xếp danh bạ. \n"
                            + "3.Hiển thị theo type.\n"
                            + "4.Xóa số.\n"
                            + "5.Sửa số điện thoại theo tên.\n"
                            + "6.Thêm số điện thoại.\n"
                            + "0.Exit");
            System.out.println();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    search();
                case 2:
                    sort();
                case 3:
                    display();
                case 4:
                    delete();
                case 5:
                    editPhone();
                case 6:
                    insert();
                default:
                    System.out.println("Mời chọn lại chức năng!!!");
            }
        }while (choice !=0);
    }
}
