import java.util.Arrays;
import java.util.Scanner;

        public class Main {

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // Kullanıcıdan kelimeleri al
                System.out.print("Birinci kelimeyi girin: ");
                String word1 = scanner.nextLine().toLowerCase();

                System.out.print("İkinci kelimeyi girin: ");
                String word2 = scanner.nextLine().toLowerCase();

                //Anagram olup olmadığına bakılır
                if (areAnagrams(word1, word2)) {
                    System.out.println("Girilen kelimeler anagramdır.");
                } else {
                    System.out.println("Girilen kelimeler anagram değildir.");
                }

                scanner.close();
            }

            // Recursive anagram kontrol fonksiyonu
            private static boolean areAnagrams(String str1, String str2) {
                //  boş diziler anagramdır
                if (str1.length() == 0 && str2.length() == 0) {
                    return true;
                }

                // Boyutlarını kontrol ederiz çünkü eşit olması gerekir
                if (str1.length() != str2.length()) {
                    return false;
                }

                // Karakter dizilerini sırala
                char[] charArray1 = str1.toCharArray();
                char[] charArray2 = str2.toCharArray();
                Arrays.sort(charArray1);
                Arrays.sort(charArray2);

                // Sıralanmış dizileri karşılaştır
                return Arrays.equals(charArray1, charArray2);
            }
        }

