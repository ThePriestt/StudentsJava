package com.galin;
import java.util.*;


class Student{       // Клас за съсздаване на обекти от тип студент
    private String name;   // Поле за запомняне на име
    private int[] marks = new int[5];      // Поле за запомняне на 5 оценки (масив)

    public String getName(){      // Метод, който връща стпъността на полето  Name
        return name;
    }

    public void setName(String name){       // Метод за назначаване на полето име
        this.name = name;
    }

    public int[] getMarks(){        // Метод който връща масива с оценките
        return marks;
    }

    public void setMarks(int[] marks) {        // Метод, който назначава масива с оценките
        this.marks = marks;
    }
}

public class Main {       // Основен клас

    public static void main(String[] args) {      // Главен метод, входна точка на прилижението

        Student[] students = new Student[10];      // Създаваме масив от 10 студента
        inputdata(students);
        sortByMarks(students);
        outputData(students);

    }

    static void inputdata(Student[] students){       // Метод за въвеждане на студенти
        Scanner input = new java.util.Scanner(System.in);      // Създаваме обект от тип Scanner за прочитане от конзолата

        for (int i = 0; i < students.length; i++){      // Цикъл за въвеждане на студентите един по един
            Student student = new Student();      // Създаваме нов студент
            int[] marks = new int[5];       // Създаваме масив за оценки

            System.out.println("Моля въведете име");       // Отпечатваме молба за въвеждане името на студента
            student.setName(input.nextLine());       // въвеждаме името и го назначаваме на студент

            for (int j = 0; j < 5; j++){       // Цикъл за въвеждане на оценките
                System.out.println("Моля въведете оценка");      // Отпечатване на молба за въвеждане на оценка
                marks[j] = input.nextInt();      // Въвеждане на оценката и назначаването и на елемент от масива с оценки
            }

            student.setMarks(marks);       // Назначаване на оценките на студента

            students[i] = student;       // Добавяне на поредния студент към масива със студенти
        }
    }

    static void sortByMarks(Student[] students){
        Student swap;
        for (int i = 0; i < students.length; i++){
           for (int j = i + 1; j < students.length; j++){
               if (calculateaveragemarks(students[i].getMarks()) > calculateaveragemarks(students[j].getMarks())){
                   swap = students[i];
                   students[i] = students[j];
                   students[j] = swap;
               }
           }
        }
    }


    static double calculateaveragemarks(int[] marks){ // Метод за изчисляване на средно аритметично

        int sum = 0;

        for (int i = 0; i < marks.length; i++){
            sum += marks[i];
        }
        return sum / 5.0;
    }

    static void outputData(Student[] students){
        for (int i = 0; i < students.length; i++){
            System.out.println(students[i].getName());
            System.out.println(calculateaveragemarks(students[i].getMarks()));
        }
    }
}
