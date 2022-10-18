public class Palindrome {

        public static void main(String[] args) {
            for (int i = 0; i < args.length; i++) {
                String s = args[i];
                System.out.println(isPalindrome(s));
            }
        }
        public static String reverseString(String s)// метод переворачивает исходную строку
        {
            int len=s.length();
            String rever = new String();
            for (int i = 0; i < len; i++){
                rever += s.charAt(len - 1 - i);
            }
            return rever;
        }
        public static boolean isPalindrome(String s)//метод переворачивает строку и сравнивает с исходной
        {
            String rever = new String(reverseString(s));
            if (s.equals(rever))
            return true;
            else
            return false;
            }
}
