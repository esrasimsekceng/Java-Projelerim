import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner oku=new Scanner(System.in);
        System.out.println("Girmek istediğiniz sayı:");
        int sayi=oku.nextInt();

        // asalKontrol fonksiyonunu kullanarak kontrol yapılır
        if (asalKontrol(sayi, sayi - 1)) {
            System.out.println("Girdiğiniz sayı asaldır.");
        } else {
            System.out.println("Girdiğiniz sayı asal değildir!!!");
        }
    }

             // Recursive fonksiyon
           public static boolean asalKontrol(int sayi, int bolen) {
                //  2'den küçük sayılar asal değildir
                if (sayi < 2) {
                    return false;
                }
                //  Asal sayılar sadece 1 ve kendisiyle tam bölünebilir
                if (bolen == 1) {
                    return true;
                }
                // Sayı bölünüyorsa asal değildir
                if (sayi % bolen == 0) {
                    return false;
                }
                // Recursive kısım: Diğer bölenleri kontrol etmek için fonksiyonu tekrar çağırır
                return asalKontrol(sayi, bolen - 1);
            }
}





