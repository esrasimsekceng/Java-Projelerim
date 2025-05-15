
import java.util.Scanner;

        public class Main {

            public static void main(String[] args) {

                System.out.println("Lütfen Parola Giriniz..");
                Scanner stringScanner = new Scanner(System.in);
                String password = stringScanner.next();

                boolean isOk = isPasswordOk(password);

                if (isOk) {
                    System.out.println("Parola Geçerlidir.");
                } else {
                    System.out.println("Parola Geçersizdir.");
                }

            }

            static boolean isPasswordOk(String password) {


                if (password.length() < 8) {
                    System.out.println("Parola 8 karakterden küçük olamaz.");
                    return false;
                }
                String[] passwordArr = password.split("");
                int harfSayisi = 0;
                int rakamSayisi = 0;
                for (int i = 0; i < passwordArr.length; i++) {
                    if (passwordArr[i].matches("[a-zA-Z]+")) {
                        harfSayisi++;
                    } else if (passwordArr[i].matches("[0-9]+")) {
                        rakamSayisi++;
                    } else {
                        System.out.println("Geçersiz karakter kullanılmıştır.");
                        return false;
                    }
                }
                if (rakamSayisi < 2) {
                    System.out.println("Rakam Sayısı 2 den küçüktür.");
                    return false;
                }
                return true;
            }
        }

