package Labs.Lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class FractalExplorer extends JFrame {
    private final int size;//размер экрана
    private JImageDisplay imageDisplay;//Ссылка JImageDisplay, для обновления отображения в разных методах в процессе вычисления фрактала.
    private FractalGenerator fractal;//ссылка на базовый класс для отображения других видов фракталов
    private Rectangle2D.Double range;//диапозон комплексной плоскости
    private int rowRemaining;//использовать его, чтобы узнать, когда будет завершена перерисовка
    JButton resetButton;
    JButton saveButton;
    JComboBox<FractalGenerator> comboBox;


    public static void main(String[] args) {
        FractalExplorer fractalExplorer = new FractalExplorer(600);
        fractalExplorer.creatAndShowGUI();
        fractalExplorer.drawFractal();
    }


    FractalExplorer(int size){//размер как аргумент принят, сохранение его в поле, инициализация объектов диапозона и фрактального генератора
        this.size = size;
        range = new Rectangle2D.Double();
        fractal = new Mandelbrot();
        fractal.getInitialRange(range);
        imageDisplay = new JImageDisplay(size,size);
    }

    private void creatAndShowGUI(){
        Mandelbrot mandelbrot = new Mandelbrot();
        Tricorn tricorn = new Tricorn();
        BurningShip burningShip = new BurningShip();

        JFrame frame = new JFrame("Fractal");// заголовок окна
        resetButton = new JButton("Reset");//кнопка сброса
        saveButton = new JButton("Save Image");//кнопка сохраниня изображения
        JLabel label = new JLabel("Fractal:");
        comboBox = new JComboBox<FractalGenerator>();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        /*Добавляем элементы в список элементов */
        comboBox.addItem(mandelbrot);
        comboBox.addItem(tricorn);
        comboBox.addItem(burningShip);
        
        /*Задаем имя команды для события действия, запускаемого этой кнопкой. */
        resetButton.setActionCommand("reset");
        saveButton.setActionCommand("save");

        EventHandler eventHandler = new EventHandler();// объект для отслеживания всех нажатий
        MouseHandler mouseHandler = new MouseHandler();

        imageDisplay.addMouseListener(mouseHandler);
        resetButton.addActionListener(eventHandler);
        saveButton.addActionListener(eventHandler);
        comboBox.addActionListener(eventHandler);

        panel1.add(label);
        panel1.add(comboBox);
        panel2.add(saveButton);
        panel2.add(resetButton);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//операция закрытия окна по умолчанию
        frame.add(imageDisplay,BorderLayout.CENTER);// добавили изображение фрактала в окно и установили место вывода изображения фрактала
        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.SOUTH);
        frame.setSize(size,size + 100);
        frame.setVisible(true);
        frame.setResizable(false);//запрет изменения размеров окна
    }

    private void drawFractal(){//для каждой строки в отображении создаем отдельный рабочий объект, а затем вызваем для него метод execute ()
        rowRemaining = size;//установливаем значение «rows remaining» равным общему количеству строк, которые нужно нарисовать.
        enableUI(false);//отключает все элементы пользовательского интерфейса во время рисования
        for(int i = 0; i < size; i++){
            FractalWorker fractalWorker = new FractalWorker(i);
            fractalWorker.execute();
        }
    }

    private void enableUI(boolean val){//будет включать или отключать кнопки с выпадающим списком в пользовательском интерфейсе на основе указанного параметра.
        resetButton.setEnabled(val);
        saveButton.setEnabled(val);
        comboBox.setEnabled(val);
    }

    private class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object object = e.getSource();
            /*если событие поступило от выпадающего списка, вы можете извлечь выбранный элемент из виджета
             и установить его в качестве текущего генератора фракталов. */
            if(object instanceof JComboBox){
                fractal = (FractalGenerator) ((JComboBox) object).getSelectedItem();
                fractal.getInitialRange(range);// запускаем генератор, который задает диапозон построения фрактала
                drawFractal();// рисуем фрактал
            }
            else if(object instanceof JButton) {
                JButton button = (JButton) object;
                if(button.getActionCommand().equals("reset")){
                    fractal.getInitialRange(range);
                    drawFractal();
                }
                else if (button.getActionCommand().equals("save")){
                    /*настраиваем средство выбора файлов, чтобы сохранять изображения только в формате PNG */
                    JFileChooser fileChooser = new JFileChooser();
                    FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                    fileChooser.setFileFilter(filter);
                    fileChooser.setAcceptAllFileFilterUsed(false);

                    if(fileChooser.showSaveDialog(button.getParent())
                            != JFileChooser.APPROVE_OPTION)return;
                    try {
                        ImageIO.write(imageDisplay.getBufferedImage(),"png",
                                fileChooser.getSelectedFile());
                    } catch (IOException ex) {//Перехватывает все исключения и выводит сообщение с этим исключением.
                        JOptionPane.showMessageDialog(button.getParent(), ex.getMessage(),
                                "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    private class MouseHandler extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if(rowRemaining != 0)return;//возвращается в предыдущее состояние, если значение «rows remaining» не равно нулю
            int x = e.getX();
            int y = e.getY();
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, size, x);
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, size, y);

            /*Обновляет текущий диапазон, чтобы он был центрирован по указанным координатам 
            и увеличивался или уменьшался на указанный коэффициент масштабирования. */
            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }

    private class FractalWorker extends SwingWorker<Object, Object>{//вычисление значений цвета для одной строки фрактала
        private int y;//целочисленная y-координата вычисляемой строки
        private int[] pixelRow;//массив чисел типа int для хранения вычисленных значений RGB для каждого пикселя в этой строке

        FractalWorker(int yCoord){//Конструктор должен будет получать y-координату в качестве параметра и сохранять это.
            y = yCoord;
        }

        @Override
        protected Object doInBackground() throws Exception {
            pixelRow = new int[size];
            for(int i = 0; i < size; i++){//сохранияем каждое значение RGB в соответствующем элементе целочисленного массива.
                    double xCoord = FractalGenerator.getCoord(range.x,range.x + range.width, size, i);
                    double yCoord = FractalGenerator.getCoord(range.y,range.y + range.height, size, y);
                    int iter = fractal.numIterations(xCoord,yCoord);
                    if (iter == -1)pixelRow[i] = 0;
                    else {
                        float hue = 0.7f + (float) iter / 200f;
                        pixelRow[i] = Color.HSBtoRGB(hue, 1f, 1f);
                    }
            }
            return null;
        }

        @Override
        protected void done() {//в этом методе перебираем массив строк данных, рисуя пиксели, которые были вычислены в doInBackground ().
            for(int i = 0; i < size; i++){
                imageDisplay.drawPixel(i,y,pixelRow[i]);
            }
            imageDisplay.repaint(0,0,y,size,1);
            rowRemaining--;
            if(rowRemaining == 0) enableUI(true);

        }
    }

}
