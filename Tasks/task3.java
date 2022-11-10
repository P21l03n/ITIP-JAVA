import java.util.Arrays;

public class task3 {
    public static void main(String[] args) {
        System.out.println("task 3_1");
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));

        System.out.println("task 3_2");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));

        System.out.println("task 3_3");
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));

        System.out.println("task 3_4");
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));

        System.out.println("task 3_5");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));

        System.out.println("task 3_6");
        System.out.println(same(new int [] {1, 3, 4, 4, 4}, new int [] {2, 5, 7}));
        System.out.println(same(new int [] {9, 8, 7, 6}, new int [] {4, 4, 3, 1}));
        System.out.println(same(new int [] {2}, new int [] {3, 3, 3, 3, 3}));

        System.out.println("task 3_7");
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));

        System.out.println("task 3_8");
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));

        System.out.println("task 3_9");
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));

        System.out.println("task 3_10");
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));
        System.out.println(rightTriangle(70, 130, 110));
    }
    /*
     * Нахождение количества решений квадратного уравнения
     */
    public static int solutions(int a, int b, int c){
        int d = b*b - 4*a*c;
        if (d<0) return 0;
        if (d==0) return 1;
        return 2;
    }
    /*
     * Функция, которая возвращает позицию второго вхождения " zip " в
     * строку, или -1, если оно не происходит по крайней мере дважды.
     */
    public static int findZip(String s){
        int k=0;
        for (int i=0; i<s.length()-2; i++){
            if (s.charAt(i)=='z' && s.charAt(i+1)=='i' && s.charAt(i+2)=='p') k+=1;
            if (k==2) return i;
        }
        return -1;
    }
    /*
     * Функция, которая проверяет, является ли целое число совершенным
     * числом или нет. Совершенное число - это число, которое можно записать как
     * сумму его множителей, исключая само число.
     */
    public static boolean checkPerfect(int x){
        int s=0;
        for (int i=1;i<x;i++){
            if (x%i==0) s+=i;
        }
        if (s==x) return true;
        return false;
    }
    /*
     * Функция, которая принимает строку и возвращает новую строку с
     * заменой ее первого и последнего символов, за исключением трех условий:
     * – Если длина строки меньше двух, верните "несовместимо".".
     * – Если первый и последний символы совпадают, верните "два-это пара.".
     */
    public static String flipEndChars(String s){
        if(s.length()<2) return "Incompatible.";
        if (s.charAt(0)==s.charAt(s.length()-1)) return "Two's a pair.";
        return s.charAt(s.length()-1)+ s.substring(1, s.length()-1) + s.charAt(0);
    }
    /*
     * Функция, которая определяет, является ли строка допустимым шестнадцатеричным кодом.
     * Шестнадцатеричный код должен начинаться с фунтового ключа # и иметь длину ровно 6
     * символов. Каждый символ должен быть цифрой от 0-9 или буквенным символом от A-F.
     */
    public static boolean isValidHexCode(String s){
        if (s.length()==7){
            if (s.charAt(0)=='#'){
                char[] ch = s.toCharArray();
                int k=0;
                for (int i=1; i<s.length(); i++){
                    int ascii = ch[i];
                    if (47<ascii && ascii<58 || 64<ascii && ascii<71 || 96<ascii && ascii<103)k+=1;
            }
            if (k==s.length()-1)return true;
            }
        }
        return false;
    }
    /*
     * Функция, которая возвращает true, если два массива имеют одинаковое
     * количество уникальных элементов, и false в противном случае.
     */
    public static boolean same(int a[], int b[]){
        Arrays.sort(a);
        Arrays.sort(b);
        int arr1 = 1;
        int arr2 = 1;
        for (int i=1; i<a.length; i++){
            if (a[i]>a[i-1]) arr1+=1;
        }
        for (int i=1; i<b.length; i++){
            if (b[i]>b[i-1]) arr2+=1;
        }
        if (arr1==arr2) return true;
        return false;
    }
    /*
     * Функция, которая возвращает true, если это число Капрекара, и false, если это не так.
     */
    public static boolean isKaprekar(int n){
        n = n*n;
        String str=""+ n;
        int a = 0;
        int b = 0;
        String s1 = str.substring(0, str.length()/2);
        String s2 = str.substring(str.length()/2);
        try {
            a = Integer.parseInt(s1);
            b = Integer.parseInt(s2);
        } catch (NumberFormatException e) {
            a = 0;
            b = 0;
        }
        if (a + b == n) return true;
        return false;
    }
    /*
     * Функция, которая возвращает самую длинную последовательность последовательных нулей в двоичной строке.
     */
    public static String longestZero(String s){
        String rez="";
        int max = 0;
        for (int i=0; i<s.length(); i++){
            int k=0;
            String str = "";
            while (s.charAt(i)=='0' && i<s.length()){
                k+=1;
                str+='0';
                i++;
                if (i==s.length()) break;
            }
            if (k>max){
                max = k;
                rez = str;
            }
        }
        return rez;
        }
    /*
     * Функция, которая возвращает следующее простое число. Если число простое, верните само число.
     */
    public static int nextPrime(int x){
        boolean flag = false;
        while (flag==false){
            int k=0;
            for(int j=2; j<x; j++){
                if (x%j==0)
                k+=1;
                }
            if (k==0) flag = true;
            else x+=1;
        }
        return x;
    }
    /*
     * Учитывая три числа, x, y и z, определите, являются ли они ребрами
     * прямоугольного треугольника.
     */
    public static boolean rightTriangle(int x, int y, int z){
        int max=Math.max(x, y);
        max=Math.max(max, z);
        int min=Math.min(x, y);
        min=Math.min(min, z);
        int sr = z;
        if (x!=min && x!=max)
            sr = x;
        if (y!=min || y!=max)
            sr=y;
        if (sr*sr+min*min==max*max) return true;
        return false;
    }
}
