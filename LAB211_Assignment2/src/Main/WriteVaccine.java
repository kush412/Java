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
public class WriteVaccine {

    public static void main(String[] args) {
        try {
            String fileName = "vaccine.dat";
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            List<Vaccine> list = new ArrayList<>();
            list.add(new Vaccine("COVID-V001", "AstraZeneca"));
            list.add(new Vaccine("COVID-V002", "SPUTNIK V"));
            list.add(new Vaccine("COVID-V003", "Vero Cell"));
            list.add(new Vaccine("COVID-V004", "Pfizer"));
            list.add(new Vaccine("COVID-V005", "Moderna"));
            for (Vaccine vc: list){
                oStream.writeObject(vc);
            }
            oStream.close();
            file.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
