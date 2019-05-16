package com.galin;
import java.util.*;


class Student{       // Клас за съсздаване на обекти от тип студент
    private String name;     // Поле за запомняне на име
    private int[] marks = new int[5];      // Поле за запомняне на 5 оценки (масив)

    public String getName(){      // Метод, който връща стпъността на полето  Name
        return name;
    }       // Getter за свойството име. Връща стойността

    public void setName(String name){       // Метод за назначаване на полето име
        this.name = name;
    }       // Setter на свойството име, задаваме стойноост на име

    public int[] getMarks(){        // Метод който връща масива с оценките
        return marks;
    }        // Връща масива с оценките

    public void setMarks(int[] marks) {        // Метод, който назначава масива с оценките
        this.marks = marks;
    }        // Задаваме стойността на масива
}

public class Main {       // Основен клас

    public static void main(String[] args) {      // Главен метод, входна точка на прилижението

        Student[] students = new Student[10];      // Създаваме масив от 10 студента. Масивът е празен. Масивът е референтен тип.
        inputdata(students);      // Попълване на масива със студенти
        sortByMarks(students);        // Сортиране на масива по среден успех
        outputData(students);       // Извеждане елементите на масива на конзолата

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

    static void sortByMarks(Student[] students){       // Метод за сортиране на масива студенти по средно аритметично по метода на мехурчето
        Student swap;        // Потготвяме допълнителна променлива за размяна позициите на студентите
        for (int i = 0; i < students.length; i++){         // Преминаваме през всеки студент в масива
           for (int j = i + 1; j < students.length; j++){         // Сравняваме студента от външния цикъл със всички следващи
               if (calculateaveragemarks(students[i].getMarks()) < calculateaveragemarks(students[j].getMarks())){         // Ако средното аритметично е по - малко им разменяме местата им, за да се подредят в низходящ ред
                   // Разменяме местата
                   swap = students[i];
                   students[i] = students[j];
                   students[j] = swap;
               }
           }
        }
    }


    static double calculateaveragemarks(int[] marks){ // Метод за изчисляване на средно аритметично

        int sum = 0;     //Подготвяме променлива за натрупване на сумата от оценките
        // Сумираме всички оценки
        for (int i = 0; i < marks.length; i++){
            sum += marks[i];
        }
        return sum / 5.0;      // Намираме и връщаме средното аритметично
    }

    static void outputData(Student[] students){        // Метод за отпечатване елементите на масива със студенти
        for (int i = 0; i < students.length; i++){        // Минаваме през всеки от елементите на масива
            System.out.printf("%s. ", i);          // Първо отпечатваме поредния номер
            System.out.print(students[i].getName() + " ");       // Отпечатваме името на студента
            for (int j = 0; j < students[i].getMarks().length; j++){        // Минаваме през всички оценки на студента
                System.out.print(students[i].getMarks()[j] + ", ");         // Отпечатваме всяка оценка
            }
            System.out.print(calculateaveragemarks(students[i].getMarks()));         // Отпечатваме средното аритметично на оценките
            System.out.println();         // Минаваме на нов ред
        }
    }
}
