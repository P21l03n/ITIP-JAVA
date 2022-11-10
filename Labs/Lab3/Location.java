package Lab3;

import java.util.Objects;

/**
 * Этот класс представляет определенное местоположение на 2D-карте. Координаты - это целочисленные значения.
 **/
public class Location
{
    /** Координата X этого местоположения.**/
    public int xCoord;

    /** Y-координата этого местоположения. **/
    public int yCoord;


    /** Создает новое местоположение с указанными целочисленными координатами. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Создает новое местоположение с координатами (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    /**
     * В метод equals() нам нужно поместить проверку — сравнение объектов двух одинаковых классов. 
     * 1.мы сравниваем два объекта одного класса
     * 2.это не один и тот же объект
     * 3.мы сравниваем наш объект не c null
     **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //Любой объект должен быть equals() самому себе (рефлексивность)
        if (o == null || getClass() != o.getClass()) return false; //
        Location location = (Location) o;
        return xCoord == location.xCoord && yCoord == location.yCoord;
    }

    /**
     * Хэш-функция, которая представлена в Java  методом hashCode(), 
     * возвращает числовое значение фиксированной длины для любого объекта. 
     * В случае с Java метод hashCode() возвращает для любого объекта 32-битное число типа int. 
     */
    @Override
    public int hashCode() {
        return Objects.hash(xCoord, yCoord);
    }
}