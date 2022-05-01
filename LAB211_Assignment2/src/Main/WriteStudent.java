/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author An Dang
 */
public class WriteStudent {
    public static void main(String[] args) {
        try {
            String fileName = "student.dat";
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            List<Student> list = new ArrayList<>();
            list.add(new Student("SE15000", "Dang Phuc An"));
            list.add(new Student("SE15001", "Nguyen Van A"));
            list.add(new Student("SE15002", "Nguyen Van B"));
            list.add(new Student("SE15003", "Nguyen Van C"));
            list.add(new Student("SE15004", "Nguyen Van D"));
            list.add(new Student("SE15005", "Nguyen Van E"));
            list.add(new Student("SE15006", "Nguyen Van F"));
            list.add(new Student("SE15007", "Nguyen Van G"));
            list.add(new Student("SE15008", "Nguyen Van H"));
            list.add(new Student("SE15009", "Nguyen Van J"));
            for(Student st: list){
                oStream.writeObject(st);
            }
            oStream.close();
            file.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
