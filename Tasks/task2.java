public class task2 {
    public static void main(String[] args) {
        System.out.println("task 2_1");
        System.out.println(repeat("mice",5));
        System.out.println(repeat("hello",3));
        System.out.println(repeat("stop",1));

        System.out.println("task 2_2");
        System.out.println(differenceMaxMin(new int [] {10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(differenceMaxMin(new int [] {44, 32, 86, 19}));

        System.out.println("task 2_3");
        System.out.println(isAvgWhole(new int []{1, 3}));
        System.out.println(isAvgWhole(new int []{1, 2, 3, 4}));
        System.out.println(isAvgWhole(new int []{1, 5, 6}));
        System.out.println(isAvgWhole(new int []{1, 1, 1}));
        System.out.println(isAvgWhole(new int []{9, 2, 2, 5}));

        System.out.println("task 2_4");
        System.out.println(cumulativeSum(new int []{1, 2, 3}));
        System.out.println(cumulativeSum(new int []{1, -2, 3}));
        System.out.println(cumulativeSum(new int []{3, 3, -2, 408, 3, 3}));

        System.out.println("task 2_5");
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));

        System.out.println("task 2_6");
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(7));
        System.out.println(Fibonacci(12));

        System.out.println("task 2_7");
        System.out.println(isValid("59001"));
        System.out.println(isValid("853a7"));
        System.out.println(isValid("732 32"));
        System.out.println(isValid("393939"));

        System.out.println("task 2_8");
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
    
        System.out.println("task 2_9");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));

        System.out.println("task 2_10");
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));
    }
    public static String repeat(String s, int n){ // task 1; функцию, которая повторяет каждый символ в строке n раз.
        int len=s.length();
        String rep = new String();
        for (int i = 0; i < len; i++){
            for (int j=0; j<n; j++){
                rep += s.charAt(i);}
        }
        return rep;
    }
    public static int differenceMaxMin(int [] a){// task 2; функцию, которая принимает массив и возвращает разницу между
        //самыми большими и самыми маленькими числами.
        int max = a[0];
        int min = a[0];
    for (int i = 0; i < a.length; i++) {
        if (a[i] > max) {max = a[i];}
        if(a[i] < min){min = a[i];}
    }
    return (max -min);}
    public static boolean isAvgWhole(int [] a){
        int s=0;
        int k=a.length;
        for (int i = 0; i < k; i++) {
            s+=a[i];
        }
        if (s%k==0)return true;
        return false;
    }

    public static String cumulativeSum(int [] a){
        int len =a.length;
        String anew = new String();
        int s = 0;
        for (int i = 0; i < len; i++){
            s+= a[i];
            anew += s + " ";
        }
        return anew;
    } 
    public static int getDecimalPlaces(String s){
        int num=0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '.'){num=i;
            return (s.length() - num - 1);}
        }
        return num;
    }
    public static int Fibonacci(int x){
        int a1 = 1;
        int a2 = 1;
        for (int i=1; i<x; i++){
            int a=a1;
            a1=a2;
            a2+= a;
        }
        return a2;
    }
    public static boolean isValid(String s){
        if (s.length()==5){
            char[] ch = s.toCharArray();
            int k=0;
            for (int i=0; i<s.length(); i++){
                int ascii = ch[i];
                if (47<ascii && ascii<58)k+=1;
            }
            if (k==s.length())return true;
        }
        return false;
    }
    public static boolean isStrangePair(String x, String y){
        int lenx=x.length();
        int leny=y.length();
        if (x.charAt(0)==y.charAt(leny-1) && y.charAt(0)==x.charAt(lenx-1))return true;
        return false;
    }
    public static boolean isPrefix(String x, String y){
        int k=0;
        for (int i=0; i<y.length()-1; i++){
            if (x.charAt(i)==y.charAt(i)) k+=1;
        }
        if (k==y.length()-1)return true;
        return false;
    }
    public static boolean isSuffix(String x, String y){
        int k=0;
        int len=x.length()-y.length();
        for (int i=1; i<y.length(); i++){
            if (x.charAt(len+i)==y.charAt(i)) k+=1;
        }
        if (k==y.length()-1)return true;
        return false;
    }
    public static int boxSeq(int a){
        int s = 0;
        for (int i=1; i<=a; i++){
            if (i%2!=0) s+=3;
            else s-=1;
        }
        return s;
    }
}
