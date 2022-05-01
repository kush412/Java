/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

/**
 *
 * @author dangp
 */
public class Student {
    String name;
    String classCode;
    double mark;
    String rank;

    public Student(String name, String classCode, double mark, String rank) {
        this.name = name;
        this.classCode = classCode;
        this.mark = mark;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
    @Override
    public String toString(){
        return "\t- Class: " + classCode + ", name: " + name + ", GPA: " + mark + ", rank: " + rank;
    }
}
