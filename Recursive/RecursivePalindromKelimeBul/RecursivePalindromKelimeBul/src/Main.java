import java.util.Scanner;

 public class Main {
     public static void main(String[] args) {
         Scanner oku=new Scanner(System.in);
         System.out.println("Kelimeyi giriniz:");
         String word=oku.nextLine();

         if (isPalindrome(word)){
             System.out.println("Kelime palindromdur.");

         }else {
             System.out.println("Kelime palindrom değildir!!!");
         }
     }
     public static boolean isPalindrome (String word){
             // Küçük harflere çevirme ve boşlukları temizleme
             String cleanedWord = word.toLowerCase().replaceAll("\\s", "");
             return isPalindromeRecursive(cleanedWord, 0, cleanedWord.length() - 1);
         }

         public static boolean isPalindromeRecursive(String word,int start, int end){
             if (start >= end) {
                 return true;
             }

             return (word.charAt(start) == word.charAt(end)) && isPalindromeRecursive(word, start + 1, end - 1);
         }
     }

