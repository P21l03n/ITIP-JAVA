import java.util.ArrayList;
import java.util.Arrays;

public class task4 {
    public static void main(String[] args) {
        System.out.println("task 4_1");
        System.out.println(esse(10, 7, "hello my name is Bessie and this is my essay"));

        System.out.println("task 4_2");
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));

        System.out.println("task 4_3");
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("getColor"));

        System.out.println("task 4_4");
        System.out.println(overTime(new double[]{9, 17, 30, 1.5}));
        System.out.println(overTime(new double[]{16, 18, 30, 1.8}));
        System.out.println(overTime(new double[]{13.25, 15, 30, 1.5}));

        System.out.println("task 4_5");
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(BMI("154 pounds", "2 meters"));

        System.out.println("task 4_6");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));

        System.out.println("task 4_7");
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(toStarShorthand("abc"));
        System.out.println(toStarShorthand(""));

        System.out.println("task 4_8");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));

        System.out.println("task 4_9");
        System.out.println(trouble(451999277, 417772299));
        System.out.println(trouble(1222345, 12345));
        System.out.println(trouble(666789, 12345667));
        System.out.println(trouble(33789, 12345337));

        System.out.println("task 4_10");
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));


    }

    public static String esse(int n, int k, String s){ // каждая строка должна содержать не более K символов, не считая пробелов
        String[] words = s.split(" ");
        String rezult = "";
        int len=0;
        for (String word : words) {
            if (len+word.length()<=k){
                len+=word.length();
                rezult+= word + " ";
            }
            else{
                len=word.length();
                rezult+= "\n" + word + " ";
            }
        }
        return rezult;
    }

    /*функцию, которая группирует строку в кластер скобок. Каждый кластер
должен быть сбалансирован. */
    public static ArrayList<String> split(String s){
        ArrayList<String> rezult = new ArrayList<String>();
        int a = 0;
        int b = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') a++;
            else b++;

            if(a==b){
                String claster = s.substring(start, i+1);
                start = i+1;
                rezult.add(claster);            
            }
        }
        return rezult;
    }

    /*Snake case — стиль написания составных слов, при котором несколько слов разделяются
символом подчеркивания (_), и не имеют пробелов в записи, причём каждое слово обычно
пишется с маленькой буквы — «foo_bar» */
    public static String toSnakeCase(String s){
        String result = "";
        char[] ch = s.toCharArray();
        int finish = 0;
        for (int i=0; i<s.length(); i++){
            int ascii = ch[i];
            if (64<ascii && ascii<91) {
                int start = finish;
                finish = i;
                String let = String.valueOf(s.charAt(i));
                result+= s.substring(start, finish) + '_' + let.toLowerCase();
            }
        }
        return  result + s.substring(finish+1);
    }

    /*CamelCase — стиль написания составных слов, при котором несколько слов пишутся
слитно без пробелов, при этом каждое слово внутри фразы пишется с прописной буквы. */
    public static String toCamelCase(String s){
        String result = String.valueOf(s.charAt(0));
        for (int i=1; i<s.length(); i++){
            if(s.charAt(i)!='_'){
                String let = String.valueOf(s.charAt(i));
                if(s.charAt(i-1)=='_') result+= let.toUpperCase();
                else result += let;
            }
        }
        return result;
    }

    /*функцию, которая вычисляет сверхурочную работу и оплату, связанную
с сверхурочной работой. */
    public static String overTime(double [] a) { 
        double sum = 0;
        double start = a[0];
        double finish = a[1];
        if (a[0] < 9) { 
            sum += (9 - a[0]) * a[2] * a[3];
            start = 9;
        }
        if (a[1] > 17) { 
            sum += (a[1] - 17) * a[2] * a[3];
            finish = 17;
        } 
        sum += (finish - start)* a[2];
        return "$" + sum;
    }

    /*Функция, которая возвращает ИМТ и связанную  с ним категорию */
    public static String BMI(String weight, String growth){
        String result = "";
        double kg =0;
        double meters =0;
        for(int i=0; i<weight.length(); i++){
            if(weight.charAt(i)==' '){
                if (weight.charAt(i+1)=='p') kg = Integer.parseInt(weight.substring(0, i)) * 0.45;
                if (weight.charAt(i+1)=='k') kg = Integer.parseInt(weight.substring(0, i));
            }
        }

        for(int i=0; i<growth.length(); i++){
            if(growth.charAt(i)==' '){
                if (growth.charAt(i+1)=='i') meters = Integer.parseInt(growth.substring(0, i)) * 0.025;
                if (growth.charAt(i+1)=='m') meters = Double.parseDouble(growth.substring(0, i));
            }
        }

        double imt = kg / (meters*meters);
        double scale = Math.pow(10, 1);
        imt = Math.ceil(imt * scale) / scale;
        if(imt < 18.5) result = imt + " Underweight";
        if(imt > 24.9) result = imt + " Overweight";
        else result = imt + " Normal weight";
        return result;
    }

    /*функцию, которая принимает число и возвращает его мультипликативное
постоянство, которое представляет собой количество раз, которое вы должны
умножать цифры в num, пока не достигнете одной цифры. */
    public static int bugger(int x){
        int k = 0;
        while (x>9){
            int y = 1;
            while (x>0){
                y*=(x%10);
                x/=10;
            }
            x = y;
            k+=1;
        }
        return k;
    }

    /*функция, которая преобразует строку в звездную стенографию. Если
символ повторяется n раз, преобразуйте его в символ*n. */
    public static String toStarShorthand(String s){
        if (s.isEmpty())
            return "''";
        String result = "";
        s+=".";
        int k = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1)==s.charAt(i)) k++;
            else{
                if(k==1) result+=s.charAt(i-1);
                else {result+=s.charAt(i-1)+"*"+k;
                k=1;}
            }}
        return result;
    }

    /*функция, которая возвращает true, если две строки рифмуются, и false в
противном случае. */
    public static boolean doesRhyme(String x, String y){
        String vowels="AaOoEeIiUu";
        String xvowels = "";
        String yvowels = "";
        int xspace = x.lastIndexOf(" ");
        int yspace = y.lastIndexOf(" ");
        for(int i=xspace+1; i<x.length(); i++){
            for(int j=0; j<vowels.length(); j++){
                if(x.charAt(i)==vowels.charAt(j)) xvowels+=x.charAt(i);
            }
        }
        for(int i=yspace+1; i<y.length(); i++){
            for(int j=0; j<vowels.length(); j++){
                if(y.charAt(i)==vowels.charAt(j)) yvowels+=y.charAt(i);
            }
        }
        yvowels=yvowels.toLowerCase();
        if(xvowels.equals(yvowels)) return true;
        return false;
    }

    /* функция, которая принимает два целых числа и возвращает true, если
число повторяется три раза подряд в любом месте в num1 и то же самое число
повторяется два раза подряд в num2.*/
public static boolean trouble(long x, long y){
    String x1 = Long.toString(x);
    String y1 = Long.toString(y);
    char numx = 0;
    for (int i=2; i<x1.length(); i++){
        if(x1.charAt(i-1)==x1.charAt(i-2) && x1.charAt(i-1)==x1.charAt(i)) numx = x1.charAt(i-1);
    }
    for (int i=1; i<y1.length(); i++){
        if(y1.charAt(i-1)==y1.charAt(i) && y1.charAt(i-1)==numx) return true;
    }
    return false;
    }

    /*функция, которая возвращает общее количество
уникальных символов (книг, так сказать) между всеми парами концов книги. */
    public static int countUniqueBooks(String x, char a){
        int ka = 0;
        String books = "";
        int start = 0;
        int finish;
        int result = 0;
        for(int i=0; i<x.length(); i++){
            if (x.charAt(i)==a){
                ka+=1;
                if(ka%2==0) {
                    finish = i;
                    books+=x.substring(start+1, finish);}
                else start = i;
            }
        }
        char[] chars = books.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        for(int i=1; i<sorted.length(); i++){
            if(sorted.charAt(i-1)!=sorted.charAt(i)){
                result+=1;
                if(i+1==sorted.length()) result+=1;
            }
        }
        return result;
    }
}
