/* Задание 1. Точка координат
 * Создайте сущность Точка, расположенную на двумерной плоскости, которая описывается:
 * Координата Х: число
 * Координата Y: число
 * Может возвращать текстовое представление вида “{X;Y}”
 * Необходимо создать три точки с разными координатами и вывести на экран их текстовое
 * представление.
 * Создаем Точку.
 * Измените сущность Точка из задачи 1.1. В соответствии с новыми требованиями создать объект
 * Точки можно только путем указания обеих координат:X и Y.
 * Необходимо выполнить следующие задачи:
 * Создайте и выведите на экран точку с координатами 3;5
 * Создайте и выведите на экран точку с координатами 25;6
 * Создайте и выведите на экран точку с координатами 7;8
 */


package ru.mikova.point;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        if (Double.isNaN(x) || Double.isNaN(y)) {
            System.out.println("Координаты не могут быть NaN");
            return;
        }
        this.x = x;
        this.y = y;
    }

    public void setValue(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public void setX(double x) {
        if (Double.isNaN(x)) {
            System.out.println("X не может быть NaN");
            return;
        }
        this.x = x;
    }

    public void setY(double y) {
        if (Double.isNaN(y)) {
            System.out.println("Y не может быть NaN");
            return;
        }
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}