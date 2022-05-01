package Main;

import java.io.Serializable;

/**
 *
 * @author An Dang
 */
public class Injection implements Serializable{
    String injectionID;
    String studentID;
    String vaccineID;
    String iPlace1;
    String iPlace2;
    String iDate1;
    String iDate2;

    public Injection() {
    }

    public Injection(String injectionID, String studentID, String vaccineID, String iDate1,String iPlace1, String iDate2, String iPlace2) {
        this.injectionID = injectionID;
        this.studentID = studentID;
        this.vaccineID = vaccineID;
        this.iPlace1 = iPlace1;
        this.iPlace2 = iPlace2;
        this.iDate1 = iDate1;
        this.iDate2 = iDate2;
    }

    public String getInjectionID() {
        return injectionID;
    }

    public void setInjectionID(String injectionID) {
        this.injectionID = injectionID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getiPlace1() {
        return iPlace1;
    }

    public void setiPlace1(String iPlace1) {
        this.iPlace1 = iPlace1;
    }

    public String getiPlace2() {
        return iPlace2;
    }

    public void setiPlace2(String iPlace2) {
        this.iPlace2 = iPlace2;
    }

    public String getiDate1() {
        return iDate1;
    }

    public void setiDate1(String iDate1) {
        this.iDate1 = iDate1;
    }

    public String getiDate2() {
        return iDate2;
    }

    public void setiDate2(String iDate2) {
        this.iDate2 = iDate2;
    }

    @Override
    public String toString() {
        return "\t- Injection ID: " + injectionID + ", student ID: " + studentID + ", vaccine ID: " + vaccineID + 
                "\n\t- First injection date: " + iDate1 + ", first injection place: " + iPlace1 +
                "\n\t- Second injection date: " + iDate2 + ", second injection place: " + iPlace2 + 
                "\n------------------------------------------------------------------------------------------------\n";
    }
    
    
}
