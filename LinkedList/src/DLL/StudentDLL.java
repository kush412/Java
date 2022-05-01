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
public class StudentDLL extends DoublyLinkedList<Student> {

    public StudentDLL() {
        super();
    }

    private String getRank(double mark) {
        if (mark < 5) {
            return "Yếu";
        } else if (mark >= 5 && mark <= 6) {
            return "TB";
        } else if (mark > 6 && mark <= 8) {
            return "Khá";
        } else {
            return "Giỏi";
        }
    }

    public void add() {
        String name, classCode, rank;
        double mark;
        int NoS = MyValidation.inputInteger("Enter the number of students add to list: ");
        for (int i = 0; i < NoS; i++) {
            name = MyValidation.inputStringNonBlank("Student name: ");
            classCode = MyValidation.inputStringNonBlank("Class: ");
            mark = MyValidation.inputDouble("Average mark: ", 0.0, 10.0);
            rank = getRank(mark);
            Student stu = new Student(name, classCode, mark, rank);
            this.addLast(stu);
            System.out.println("Student " + name + " has been added.");
        }
    }

    public void countStud() {
        if (this.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            String code = MyValidation.inputString("Counting the number of students in class: ");
            Node<Student> st;
            int count = 0;
            for (st = head; st != null; st = st.next) {
                if (st.getData().getClassCode().equals(code)) {
                    count++;
                }
            }
            System.out.println("Number of student in class " + code + " is: " + count);
        }
    }

    private void printList() {
        if (this.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            Node<Student> i = head;
            while (i != null) {
                System.out.println(i.getData().toString());
                i = i.next;
            }
        }
    }

    public void sortMark() {
        if (this.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            Node<Student> ref, index;
            Student tmp;
            for (ref = head; ref.next != null; ref = ref.next) {
                for (index = ref.next; index != null; index = index.next) {
                    if (ref.data.mark > index.data.mark) {
                        tmp = ref.data;
                        ref.data = index.data;
                        index.data = tmp;
                    }
                }
            }
            this.printList();
        }
    }

    public void printByClass() {
        if (this.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            Node<Student> ref, index;
            Student tmp;
            for (ref = head; ref.next != null; ref = ref.next) {
                for (index = ref.next; index != null; index = index.next) {
                    if (ref.getData().getClassCode().compareTo(index.getData().getClassCode()) > 0) {
                        tmp = ref.data;
                        ref.data = index.data;
                        index.data = tmp;
                    }
                }
            }
            this.printList();
        }
    }

}
