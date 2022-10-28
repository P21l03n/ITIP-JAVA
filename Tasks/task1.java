public class task1 {
    public static void main(String[] args) {
        System.out.println("task 1_1");
        System.out.println(remainder(1,3));
        System.out.println(remainder(3,4));
        System.out.println(remainder(-9,45));
        System.out.println(remainder(5,5));
        
        System.out.println("task 1_2");
        System.out.println(triArea(3,2));
        System.out.println(triArea(7,4));
        System.out.println(triArea(10,10));

        System.out.println("task 1_3");
        System.out.println(animals(2,3,5));
        System.out.println(animals(1,2,3));
        System.out.println(animals(5,2,8));

        System.out.println("task 1_4");
        System.out.println(profitableGamble(0.2,50,9));
        System.out.println(profitableGamble(0.9,1,2));
        System.out.println(profitableGamble(0.9,3,2));

        System.out.println("task 1_5");
        System.out.println(operation(24, 15, 9));
        System.out.println(operation(24, 26, 2));
        System.out.println(operation(15, 11, 11));

        System.out.println("task 1_6");
        System.out.println(ctoa('A'));
        System.out.println(ctoa('m'));
        System.out.println(ctoa('['));
        System.out.println(ctoa('/'));

        System.out.println("task 1_7");
        System.out.println(addUpTo(3));
        System.out.println(addUpTo(10));
        System.out.println(addUpTo(7));

        System.out.println("task 1_8");
        System.out.println(nextEdge(8,10));
        System.out.println(nextEdge(5,7));
        System.out.println(nextEdge(9,2));

        System.out.println("task 1_9");
        System.out.println(sumOfCubes(new int[] {1,5,9}));
        System.out.println(sumOfCubes(new int[] {3,4,5}));
        System.out.println(sumOfCubes(new int[] {2}));
        System.out.println(sumOfCubes(new int[] {}));

        System.out.println("task 1_10");
        System.out.println(abcmath(42, 5, 10));
        System.out.println(abcmath(5, 2, 1));
        System.out.println(abcmath(1, 2, 3));

    }
    public static int remainder(int a, int b){
        return(a%b);
    }
    public static double triArea(double x, double y){
        return(x*y*0.5);
    }
    public static int animals(int ch, int c, int p){
        return(ch*2+c*4+p*4);
    }
    public static boolean profitableGamble(double prob, double prize, double pay){
        if (prob*prize > pay) return true;
        return false;
    }
    public static String operation(int n, int a, int b){
        if (a*b==n)
        return ("multiply");
        if (a/b==n)
        return ("divide");
        if (a+b==n)
        return ("added");
        if (a-b==n)
        return ("substracted");
        else
        return ("none");
    }
    public static int ctoa(char s){
        int ascii = s;
        return(ascii);
    }
    public static int addUpTo(int len){
        int s = 0;
        for(int i=1; i<=len; i++){
            s+=i;
        }
        return s;
    }
    public static int nextEdge(int x, int y){
        return(x+y-1);
    }
    public static int sumOfCubes(int[] a){
        int len = a.length;
        int s=0;
        for(int i=0; i<len; i++){
           s+=a[i]*a[i]*a[i]; 
        }
        return s;
    }
    public static boolean abcmath(int a, int b, int c){
        for(int i=0; i<b; i++){
           a+=a;
        }
        if (a%c==0) return true;
        return false;
    }
}
