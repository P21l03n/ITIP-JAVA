public class Point3d extends Point2d{
    private double zCoord;

    public Point3d (double x, double y, double z){
        super(x,y);
        zCoord = z;
    }
    public  Point3d(){ //создание нового объекта Point3d со значениями (0.0, 0.0, 0.0) по умолчанию
        this(0.0,0.0,0.0);
    }
    //возможность получения и изменения всех трех значений по отдельности;
    public double getZ () {
        return zCoord;
        }
    public void setZ ( double val) {
        zCoord = val;
    }
    public boolean isEqual(Point3d p){ //метод для сравнения значений двух объектов Point3d.
        if(this.getX() == p.getX() && this.getY() == p.getY() && zCoord==p.zCoord)return true;
        return false;
        }
    public double distanceTo(Point3d p){//вычисляет расстояние между двумя точками
        return Math.sqrt(Math.pow(this.getX()-p.getX(), 2) + Math.pow(this.getY()-p.getY(), 2) + Math.pow(zCoord-p.zCoord, 2));
    }
}
