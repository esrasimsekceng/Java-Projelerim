import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner giris=new Scanner(System.in);
        System.out.println(" Çemberin Yaricapini giriniz:");
        double yaricap=giris.nextDouble();
        System.out.println("Girilen çemberin cevresi:"+cevrehesap((yaricap)));
        System.out.println("girilen çemberin alanı: " +alanHesap(yaricap));
    }
    static double cevrehesap(double yaricap){
       return 2*Math.PI*yaricap;
    }
    static double alanHesap(double yaricap){
        return Math.PI*Math.pow(yaricap,2);
    }

}