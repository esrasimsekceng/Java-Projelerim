import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Oku=new Scanner(System.in);
        int maksimumBoyut=10;
        MusteriYoneticisiLinkList musteriYoneticisiLinkList =new MusteriYoneticisiLinkList(maksimumBoyut);
        while (true){
            System.out.println("Müşteri Yönetimi Menüsü: ");
            System.out.println("1. Müşteri Ekle");
            System.out.println("2.Müşterileri Sıralı Listele(Müşteri Numarasına göre)");
            System.out.println("3.Müşterileri Normal listele");
            System.out.println("4. Müşteri Ara");
            System.out.println("5.Müşteri Sil");
            System.out.println("6.Çıkış ");
            System.out.println("Bir seçenek seçin");
            int secim=Oku.nextInt();
            Oku.nextLine();
            switch (secim){
                case 1:
                    System.out.println("Adınızı girin: ");
                    String ad=Oku.nextLine();
                    System.out.println("Soyadınızı girin: ");
                    String soyad=Oku.nextLine();
                    System.out.println("E-posta adresinizi  girin: ");
                    String eposta=Oku.nextLine();
                    System.out.println("Telefon numaranızı girin: ");
                    String telefon=Oku.nextLine();

                    Musteri yeniMusteri=new Musteri(ad,soyad,eposta,telefon);
                    musteriYoneticisiLinkList.MusteriEkle(yeniMusteri);
                    break;
                case 2:
                    musteriYoneticisiLinkList.musterileriSiralamaListele();
                    break;
                case 3:
                    musteriYoneticisiLinkList.musterileriListele();
                    break;
                case 4:
                    System.out.println("Aranacak müşteri bilgisini girin: ");
                    String anahtarKelime=Oku.nextLine();
                    musteriYoneticisiLinkList.musteriAra(anahtarKelime);
                    break;
                case 5:
                    System.out.println("silinecek müşterinin numarasını girin: ");
                    int silinecekMusteriNo=Oku.nextInt();
                    musteriYoneticisiLinkList.musteriSil(silinecekMusteriNo);
                    break;
                case 6:
                    System.out.println("Müşteri Yönetimi Uygulaması'ndan Çıkılıyor.");
                    Oku.close();
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
            }
        }
    }
}