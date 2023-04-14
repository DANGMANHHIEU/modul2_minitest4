package storage;

import model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile<T> {
  public static List<Contact> readFile(){
    File file =new File("F:\\modul2\\minitest4\\src\\file.txt");
    List<Contact> contacts=new ArrayList<>();
    try {
      InputStream is= new FileInputStream(file);
      ObjectInputStream fis= new ObjectInputStream(is);
      contacts=(List<Contact>) fis.readObject();
      is.close();
      fis.close();
    }catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    return contacts;
  }
}
