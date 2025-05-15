import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class RandomExample {
    public static void main(String[] args) {
        Scanner giris=new Scanner(System.in);
        System.out.println("Bir sayı giriniz:");
        giris.nextInt();
        Random rand = new Random();
        // 1 ile 20 arasında bir rastgele sayı üretelim
        int randomNumber = rand.nextInt(20) + 1;
        // Olası değerler 1 ile 20 arasındadır
        int[] deger = new int[20];
        for (int i = 0; i < 20; i++) {
            deger[i] = i + 1;
        }
        if (giris.nextInt()==randomNumber){
            System.out.println("true");
        }else
            System.out.println(false);

        System.out.println("Rastgele sayı: " + randomNumber);
        System.out.println("Olası değerler: " + Arrays.toString(deger));
    }
}