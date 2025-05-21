package ru.mikova;

import ru.mikova.inputhandler.InputHandler;
import ru.mikova.inputhandler.config.DoubleInputConfig;
import ru.mikova.inputhandler.config.IntInputConfig;
import ru.mikova.inputhandler.config.StringInputConfig;
import ru.mikova.line.Line;
import ru.mikova.point.Point;
import ru.mikova.student.Student;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> tasks = Arrays.asList(1, 2, 3, 4, 5);

        StringBuilder tasksPrompt = new StringBuilder("Задачи:\n");
        for (Integer task : tasks) {
            tasksPrompt.append(task).append("\n");
        }
        tasksPrompt.append("Введите номер задачи: ");

        IntInputConfig taskNumberConfig = new IntInputConfig.Builder()
                .setPrompt(tasksPrompt.toString())
                .setAllowedValues(tasks)
                .build();

        int selectedTask = InputHandler.getInt(taskNumberConfig);

        switch (selectedTask) {
            case 1:
            case 2:
            case 4:
                System.out.println("Поочередно введите 3 точки координат");
                double x1 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                        .setPrompt("Введите координату точки x1: ")
                        .build());
                double y1 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                        .setPrompt("Введите координату точки y1: ")
                        .build());
                double x2 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                        .setPrompt("Введите координату точки x2: ")
                        .build());
                double y2 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                        .setPrompt("Введите координату точки y2: ")
                        .build());
                double x3 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                        .setPrompt("Введите координату точки x3: ")
                        .build());
                double y3 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                        .setPrompt("Введите координату точки y3: ")
                        .build());
                double x4 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                        .setPrompt("Новое значение для x4: ")
                        .build());
                double y4 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                        .setPrompt("Новое значение для y4: ")
                        .build());

                Point point1 = new Point(x1, y1);
                Point point2 = new Point(x2, y2);
                Point point3 = new Point(x3, y3);
                Point point4 = new Point(x4, y4);

                System.out.println("Координаты точек: ");
                System.out.println(point1);
                System.out.println(point2);
                System.out.println(point3);
                System.out.println(point4);
                System.out.println();

                if (selectedTask == 4) {
                    Line line1 = new Line(point1, point2);
                    Line line2 = new Line(point3, point4);
                    Line line3 = new Line(line1.getStart(), line2.getEnd());
                    System.out.println("Координаты линий: ");
                    System.out.println(line1);
                    System.out.println(line2);
                    System.out.println(line3);
                    System.out.println("Теперь измените координаты линий: " +
                            "\nПоследовательно введите координаты точек первой линии: ");
                    x1 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                            .setPrompt("Новое значение для x1: ")
                            .build());
                    y1 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                            .setPrompt("Новое значение для y1: ")
                            .build());
                    x2 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                            .setPrompt("Новое значение для x2: ")
                            .build());
                    y2 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                            .setPrompt("Новое значение для y2: ")
                            .build());
                    System.out.println("Теперь точек второй линии: ");
                    x3 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                            .setPrompt("Новое значение для x1: ")
                            .build());
                    y3 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                            .setPrompt("Новое значение для y1: ")
                            .build());
                    x4 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                            .setPrompt("Новое значение для x2: ")
                            .build());
                    y4 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                            .setPrompt("Новое значение для y2: ")
                            .build());

                    point1.setValue(x1, y1);
                    point2.setValue(x2, y2);
                    point3.setValue(x3, y3);
                    point4.setValue(x4, y4);
                    System.out.println(line1);
                    System.out.println(line2);
                    System.out.println(line3);

                    System.out.println("Последовательно перезапишите координаты первой" +
                            " линии (третья линия не изменится): ");
                    x1 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                            .setPrompt("Новое значение для x1: ")
                            .build());
                    y1 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                            .setPrompt("Новое значение для y1: ")
                            .build());
                    x2 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                            .setPrompt("Новое значение для x2: ")
                            .build());
                    y2 = InputHandler.getDouble(new DoubleInputConfig.Builder()
                            .setPrompt("Новое значение для y2: ")
                            .build());

                    point1 = new Point(x1, y1);
                    point2 = new Point(x2, y2);
                    line1 = new Line(point1, point2);
                    System.out.println(line1);
                    System.out.println(line2);
                    System.out.println(line3);
                    System.out.println();
                }
                break;

            case 3:
            case 5:
                StringInputConfig studentNameConfig = new StringInputConfig.Builder()
                        .setPrompt("Введите имя студента: ")
                        .setMinLength(1)
                        .requireUppercaseFirstLetter()
                        .allowOnlyLettersAndSpaces()
                        .build();

                IntInputConfig marksConfig = new IntInputConfig.Builder()
                        .setPrompt("Введите новую оценку студента: ")
                        .setMin(1)
                        .setMax(5)
                        .build();

                int[] marks_1 = {3, 4, 5};
                Student student1 = new Student("Вася", marks_1);
                Student student2 = new Student("Петя", student1.getMarks());
                System.out.println("Изначальные оценки Васи и Пети: ");
                System.out.println(student1);
                System.out.println(student2);
                student2.changeMark(1, 5);
                System.out.println("Петя исправил первую оценку на 5," +
                        " а Вася списал у Пети и получил аналогичную оценку: ");
                System.out.println(student1);
                System.out.println(student2);
                Student student_3 = new Student("Андрей", student1.getMarks().clone());
                System.out.println("Учительница узнала о списывании и заставила Петю и Васю переписать все работы," +
                        " но они опять умудрились написать на одинаковые отметки. " +
                        "Пожалуйста, перезапишите оценки Васи и Пети: \n");
                int[] newMarks = new int[student1.getMarks().length];
                for (int i = 0; i < student1.getMarks().length; i++) {
                    newMarks[i] = InputHandler.getInt(marksConfig);
                }
                student1.changeAllMarks(newMarks);
                System.out.println("Также новому студенту Андрею были выставлены такие же оценки " +
                        "как у Васи и Пети до изменений: ");
                System.out.println(student1);
                System.out.println(student2);
                System.out.println(student_3);
                System.out.println();
                System.out.println("Новые студенты и их средние баллы: ");
                Student student_4 = new Student("Вася", 3, 4, 5, 4);
                Student student_5 = new Student("Петя", 5, 5, 5, 5);
                double avg_student_4 = student_4.averageMark();
                double avg_student_5 = student_5.averageMark();
                System.out.println(student_4 + ". Его средний балл: " + avg_student_4 + ". Данный студент - " +
                        (student_4.isExellent() ? "отличник" : "не отличник"));
                System.out.println(student_5 + ". Его средний балл: " + avg_student_5 + ". Данный студент - " +
                        (student_5.isExellent() ? "отличник" : "не отличник"));

                break;
        }
    }
}