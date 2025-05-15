import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner giris=new Scanner(System.in);
        System.out.println("Birinci sayıyı giriniz:");
        int sayi1=giris.nextInt();
        System.out.println("İkinci sayıyı giriniz:");
        int sayi2=giris.nextInt();
        System.out.println("Hesaplanan EKOK Değeri:"+ekokBul(sayi1,sayi2));
    }
    public static int ekokBul(int sayi1,int sayi2){
        return (sayi1*sayi2) / recursiveEbob(sayi1,sayi2,2);
    }
    public static int recursiveEbob(int sayi1, int sayi2,int bolen){
        if (bolen>sayi1 || bolen>sayi2)
            return 1;
        else if (sayi1%bolen==0 && sayi2%bolen==0) {
            return bolen*recursiveEbob(sayi1/bolen,sayi2/bolen,bolen);
        }
        else
            return recursiveEbob(sayi1,sayi2,bolen+1);
    }




}