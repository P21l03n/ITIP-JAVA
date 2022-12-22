package Labs.Lab5;

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {

    public String toString() {
        return "Mandelbrot";
    }

    @Override
    public void getInitialRange(Rectangle2D.Double range){ /**метод позволяет генератору
        фракталов определить наиболее «интересную» область комплексной плоскости
        для конкретного фрактала**/
        range.x = -2;
        range.y = -1.5;
        range.width = 3; /**изменить поля
         прямоугольника для отображения правильного начального диапазона для
         фрактала**/
        range.height = 3;
    }

    public static final int MAX_ITERATIONS = 2000; //максимум, final - константа

    @Override
    public int numIterations(double x, double y) { /**реализует итеративную
        функцию для фрактала Мандельброта**/
        int iteraion = 0;
        double x1 = 0;
        double y1 = 0;
        while (x1*x1 + y1*y1 < 4 && iteraion < MAX_ITERATIONS) {
            double temp1 = x1 * x1 - y1 * y1 + x;
            double temp2 = 2 * x1 * y1 + y;
            x1 = temp1;
            y1 = temp2;
            iteraion++;
        }
        if (iteraion >= MAX_ITERATIONS)return -1; //точка не выходит за границы
        return iteraion;
    }
}
