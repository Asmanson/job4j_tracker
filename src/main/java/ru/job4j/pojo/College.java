package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Асманов Иван Алексеввич");
        student.setGroup("1мУТП");
        student.setDataenter("29.07.2022");
        System.out.println(student.getFio() + ", " + student.getGroup() + ", " + student.getDataenter());
    }
}
