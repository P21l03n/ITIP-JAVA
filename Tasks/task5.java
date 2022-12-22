import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;

public class task5 {
    public static void main(String[] args) {
        System.out.println("task 5_1");
        System.out.println(encrypt("Hello"));
        System.out.println(decrypt(new int[] {72, 33, -73, 84, -12, -3, 13, -13, -68 }));
        System.out.println(encrypt("Sunshine"));

        System.out.println("task 5_2");
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));

        System.out.println("task 5_3");
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(canComplete("butlz", "beautiful"));
        System.out.println(canComplete("tulb", "beautiful"));
        System.out.println(canComplete("bbutl", "beautiful"));

        System.out.println("task 5_4");
        System.out.println(sumDigProd(new int []{16, 28}));
        System.out.println(sumDigProd(new int []{0}));
        System.out.println(sumDigProd(new int [] {1, 2, 3, 4, 5, 6}));

        System.out.println("task 5_5");
        System.out.println(sameVowelGroup(new String [] {"toe", "ocelot", "maniac"}));
        System.out.println(sameVowelGroup(new String [] {"many", "carriage", "emit", "apricot", "animal"}));
        System.out.println(sameVowelGroup(new String [] {"hoops", "chuff", "bot", "bottom"}));

        System.out.println("task5_6");
        System.out.println(validateCard(1234567890123456L));
        System.out.println(validateCard(1234567890123452L));

        System.out.println("task5_7");
        System.out.println(numToEng(0));
        System.out.println(numToEng(18));
        System.out.println(numToEng( 126));
        System.out.println(numToEng( 909));

        System.out.println("task5_8");
        System.out.println(getSha256Hash("password123"));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(getSha256Hash( "Hey dude!"));


        System.out.println("task5_9");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle( "TYRION LANNISTER, HAND OF THE QUEEN."));

        System.out.println("task5_10");
        System.out.println(hexLattice(1));
        System.out.println(hexLattice(7));
        System.out.println(hexLattice(19));
        System.out.println(hexLattice(21));

    }
    public static String encrypt(String s){//две функции, которые принимают строку и массив и возвращают закодированное или декодированное сообщение.
        char[] ch = s.toCharArray();
        int ascii1 = ch[0];
        String result = "";
        result += ascii1 + " ";
        int x = ascii1;
        for(int i=1; i<s.length(); i++){
            int ascii = ch[i];
            result += (ascii-x) + " ";
            x = ascii;
        }
        return result;
    }

    public static String decrypt(int []a){
        String result = "";
        result = result + (char)a[0];
        for (int i=1; i<a.length; i++){
            int x = a[i]+a[i-1];
            result = result + (char)x;
            a[i]=x;
        }
        return result;
    }

    public static boolean canMove(String x, String a, String b){//функцию, которая принимает имя шахматной фигуры, ее положение и целевую позицию.
        char [] aMas = new char[a.length()];
        char [] bMas = new char[b.length()];
        for (int i=0; i<2; i++){
            aMas[i]=a.charAt(i);
            bMas[i]=b.charAt(i);
        }

        int x1=aMas[0];
        int x2=bMas[0];
        int y1=aMas[1];
        int y2=bMas[1];

        if (x=="Rook"){//ладья
            return(x1==x2 || y1==y2);
        }
        if (x=="King"){
            return ((x2 - x1 >= -1 && x2 - x1<=1) && (y2 - y1 >= -1 && y2 - y1<=1));
        }
        if (a=="Bishop"){//слон
            return (x1-y1==x2-y2|| x1+y1==x2+y2);
        }
        if(a=="Queen"){
            return (x1-y1==x2-y2 || x1+y1==x2+y2 || x1==x2||y1==y2);
        }
        if(a=="Pawn"){//пешка
            return (y2==y1+1);
        }
        if(a=="Knight"){//конь
            return ((Math.abs(x1-x2)==2 && Math.abs(y1-y2)==1)|| (Math.abs(x1-x2)==1 && Math.abs(y1-y2)==2));
        }
        
        return false;
    }

    public static boolean canComplete(String x, String y){//функцию, которая, учитывая входную строку, определяет, может ли слово быть завершено.
        int index = 0;
        int k = 0;
        for(int i=0; i<y.length(); i++){
            if(y.charAt(i)==x.charAt(index)){
                index++;
                k++;
            } 
        }
        if(k==x.length()) return true;
        return false;
    }

    public static int sumDigProd(int []a){/*функцию, которая принимает числа в качестве аргументов, складывает их
        вместе и возвращает произведение цифр до тех пор, пока ответ не станет длиной
        всего в 1 цифру.*/
        int p=0;
        int s = 0;
        for  (int i=0; i<a.length; i++){
            s += a[i];
        }
        while(s/10!=0){
            p=1;
            while (s!=0){
                p*= (s%10);
                s/=10;
            }
            s=p;
        }
        return p;
    }

    public static ArrayList<String> sameVowelGroup(String []a){/*функцию, которая выбирает все слова, имеющие все те же гласные (в
        любом порядке и / или количестве), что и первое слово, включая первое слово. */
        String vowels="AaOoEeIiUu";
        ArrayList<String> result = new ArrayList<>();
        String missingVowels = "";
        for (char ch : vowels.toCharArray()) {
            if (a[0].indexOf(ch) == -1) {
                missingVowels += ch;
            }
        }

        for (String word : a) {
            String missingVowels1 = "";
            for (char ch : vowels.toCharArray()) {
                if (word.indexOf(ch) == -1) {
                    missingVowels1 += ch;
                }
            }
            if(missingVowels.equals(missingVowels1)) result.add(word);
        }
        
        return result; 
    }

    public static boolean validateCard(Long n){/*функцию, которая принимает число в качестве аргумента и возвращает
        true, если это число является действительным номером кредитной карты */
        String number = "";
        number+=n;
        int len=number.length();
        long [] mass = new long[len-1];
        int s =0;
        if (len>=14 && len<=19){
            int kontrol = (int) (n % 10);
            number = Long.toString(n/10);
            len=number.length();
            String rever = new String();
            for (int i = 0; i < len; i++){
                rever += number.charAt(len - 1 - i);
            }
            for (int i=0; i<len; i++){
                mass[i]=rever.charAt(i);
            }
            for(int i=0; i<len; i=i+2){
                long x = mass[i];
                if (x*2/10!=0) x=(x%10)+(x/10);
                mass[i] = x;
            }
            for(int i=0; i<len; i=i+2){
                s+=mass[i];
            }
            if(10-(s%10)==kontrol) return true;
        }
        return false;
    }

    public static String numToEng(int x){/*функцию, которая принимает положительное целое число от 0 до 999
        включительно и возвращает строковое представление этого целого числа*/
        String result ="";
        String [] mas1 =new String[]{"one","two","three", "four", "five", "six", "seven", "eight", "nine"};
        String [] mas2 = new String[]{"ten", "eleven", "twelve", "thirteen","fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String [] mas3 = new String[]{"twenty", "thirty", "forty","fifty", "sixty", "seventy", "eighty", "ninety"};
        if (x / 100 > 0) result += mas1[x/100-1] + " hundred ";
        if (x % 100 / 10 == 1) result += mas2[x%10];
        if (x % 100 / 10 > 1) result += mas3[0] + " ";
        if (x%10 > 0 && x % 100 / 10!=1) result += mas1[x%10-1];
        if (x==0) return "zero";
        return result;
    }

    public static String getSha256Hash(String base) {/*функцию, которая возвращает безопасный хеш SHA-256 для данной строки */
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public static String correctTitle(String s){/*функцию, которая принимает строку и возвращает строку с правильным
        регистром для заголовков символов в серии "Игра престолов". */
        String result = "";
        String[] words = s.split(" ");
        for (String word : words) {
            word = word.toLowerCase();
            if (!(word.equals("and") || word.equals("the") || word.equals("of") || word.equals("in"))) {
                char first = Character.toUpperCase(word.charAt(0));
                word = first + word.substring(1);
            }
            result += word + " ";
        }
        return result;
    }

    public static String hexLattice(int x){/*функцию, которая принимает целое число n и возвращает "недопустимое", если
    n не является центрированным шестиугольным числом или его иллюстрацией в виде
    многострочной прямоугольной строки в противном случае. */
        String result="";
        int n = 1;
        int k = 1;
        while (n < x) {
            n += 6 * k;
            k++;
        }
        if (n!=x) return "Invalid"; 
        for(int i=0; i<k; i++){
            for(int j=0; j<k+i; j++){
                result+="*"; 
            }
            result += "\n";
        }
        for(int i=0; i<k-1; i++){
            for(int j=0; j<k*2-(2+i); j++){
                result+="*"; 
            }
            result += "\n";
        }
        return result;
    }
}
