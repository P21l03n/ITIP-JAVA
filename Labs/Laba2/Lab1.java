import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] str1 = in.nextLine().split(" ");
        Point3d p1 = new Point3d(Double.parseDouble(str1[0]),
        Double.parseDouble(str1[1]),
        Double.parseDouble(str1[2]));

        String[] str2 = in.nextLine().split(" ");
        Point3d p2 = new Point3d(Double.parseDouble(str2[0]),
        Double.parseDouble(str2[1]),
        Double.parseDouble(str2[2]));

        String[] str3 = in.nextLine().split(" ");
        Point3d p3 = new Point3d(Double.parseDouble(str3[0]),
        Double.parseDouble(str3[1]),
        Double.parseDouble(str3[2]));
        

        in.close();
        if(p1.isEqual(p2) || p1.isEqual(p3) || p2.isEqual(p3))System.out.println("Please enter different points");
        else System.out.println("The area of this triangle: S = " + computeArea(p1,p2,p3));

    }
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3){//принимает три объекта типа Point3d и вычисляет площадь треугольника, образованного этими точками
        double a = p1.distanceTo(p2);
        double b = p1.distanceTo(p3);
        double c = p2.distanceTo(p3);

        double p = (a + b + c)/2; //формула полупериметра

        return Math.sqrt(p*(p-a)*(p-b)*(p-c)); //формула площади

    }
}
