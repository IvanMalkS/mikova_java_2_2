/*
 * Задание 3
 * Студент.
 * Создайте сущность Студент, которая описывается:
 * Имя: строка
 * Оценки: массив целых чисел.
 * Может возвращать текстовое представление вида “Имя: [оценка1, оценка2,…,оценкаN]”
 * Необходимо выполнить следующие задачи:
 * 1. Создать студента Васю с оценками: 3,4,5.
 * 2. Создать студента Петю и скопировать оценки Васи, присвоив содержимое поля с
 * оценками Васи полю с оценками Пети.
 * 3. Заменить первую оценку Пети на число 5. Вывести на экран строковое представление
 * Васи и Пети. Объяснить результат
 * 4. Создать студента Андрея и скопировать ему оценки Васи так, чтобы изменение оценок
 * Васи не влияло на Андрея.
 * Студент отличник.
 * Измените сущность Студент из задачи 4.7. Новые требования включают:
* Студент может возвращать значение своей средней оценки (вещественное число). Если
* оценок нет, то среднее – 0.
* Студент может возвращать информацию о том, является ли он отличником или нет.
* Студент является отличником если у него есть хотя бы одна оценка и все оценки только
* отличные.
* Необходимо выполнить следующие задачи:
* 1. Создайте студента Васю с оценками 3,4,5,4
* 2. Создайте студента Петю с оценками 5,5,5,5
* 3. Выведите для обоих студентов информацию о среднем балле и являются ли они
* отличниками
 */

package ru.mikova.student;

public class Student {
    private final String name;
    private final int[] marks;

    public Student(String name, int... marks) {
        this.name = name;
        this.marks = marks.length > 0 ? marks.clone() : new int[0];
    }

    public int[] getMarks() {
        return marks.clone();
    }

    public String getName() {
        return name;
    }

    public double averageMark() {
        if (marks.length == 0) return 0;
        double sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    public boolean isExellent() {
        if (marks.length == 0) return false;
        for (int mark : marks) {
            if (mark != 5) return false;
        }
        return true;
    }

    public void changeMark(int n, int newMark) {
        if (n < 1 || n > marks.length) {
            System.out.println("Неверный номер оценки");
            return;
        }
        if (newMark < 1 || newMark > 5) {
            System.out.println("Оценка должна быть от 1 до 5");
            return;
        }
        this.marks[n-1] = newMark;
    }

    public void changeAllMarks(int[] newMarks) {
        for (int i = 0; i < newMarks.length; i++) {
            this.marks[i] = newMarks[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder array_out = new StringBuilder();
        for (int mark : marks) {
            array_out.append(" ").append(mark);
        }
        return name + ":" + array_out;
    }
}