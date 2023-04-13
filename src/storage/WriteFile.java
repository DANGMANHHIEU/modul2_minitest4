package storage;

import model.Contact;

import java.io.*;
import java.util.List;

public class WriteFile<T> {
    public static void writeFile(List<Contact> contactList){
        File file=new File("F:\\modul2\\minitest4\\src\\file.txt");
        try {
            OutputStream os=new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(os);
            oos.writeObject(contactList);
            os.close();
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
