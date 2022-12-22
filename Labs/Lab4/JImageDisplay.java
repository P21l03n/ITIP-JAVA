package Labs.Lab4;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends javax.swing.JComponent{ // создали класс JImageDisplay, производный от javax.swing.JComponent.
    private BufferedImage image; 
    public JImageDisplay(int width, int height){  //Целочисленные ширина и высота
        /*
         * Новое изображение с новой шириной и высотой, и типом изображения TYPE_INT_RGB.
         * Тип определяет, как цвета каждого пикселя будутпредставлены в изображении;
         * значение TYPE_INT_RGB обозначает, что красные, зеленые и синие компоненты имеют по 8 битов, 
         * представленные в формате int в указанном порядке.
         */
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        super.setPreferredSize(new Dimension(width, height)); //вызвали метод родительского класса с указанной шириной и высотой
    }

    @Override
    public void paintComponent (Graphics g){ //Отображение объекта
        super.paintComponent(g);  //вызов версии суперкласса(производный класс от текущего)
        g.drawImage (image, 0, 0, image.getWidth(), image.getHeight(), null); //Мы передаем значение null для ImageObserver, поскольку данная функциональность не требуется
    }

    public void clearImage(){ //устанавливает все пиксели изображения в черный цвет (значение RGB 0)
        for (int x=0; x<image.getWidth(); x++){
            for (int y = 0; y<image.getHeight(); y++){
                this.drawPixel(x, y, new Color(0, 0, 0, 0).getRGB());
            }
        }
    }

    public void drawPixel(int x, int y, int rgbColor){ //устанавливает пиксель в определенный цвет
        image.setRGB(x, y, rgbColor);
    }
}
