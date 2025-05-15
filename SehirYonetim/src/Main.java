import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoubleLinkList doubleLinkListManager =new DoubleLinkList();
        Scanner Oku=new Scanner(System.in);
        while (true){
            System.out.println("Uygulama Menüsü: ");
            System.out.println("1. Şehir Ekle");
            System.out.println("2.Şehir Listele İleriye Doğru: ");
            System.out.println("3.Şehir Listele Geriye Doğru: ");
            System.out.println("4. Şehir Listele:");
            System.out.println("5. Şehir Ara Şehir Adına Göre:");
            System.out.println("6. Şehir Ara Plaka Numarasına Göre:");
            System.out.println("7. Şehir Sil Şehir Adına Göre:");
            System.out.println("8. Şehir Sil Plaka Numarasına Göre:");
            System.out.println("9. Tüm Şehirleri Sil:");
            System.out.println("0. Çıkış ");
            System.out.println("Bir seçenek seçin");
            int secim=Oku.nextInt();
            Oku.nextLine();
            switch (secim){
                case 1:
                    System.out.println("Şehir Adını girin: ");
                    String ad=Oku.nextLine();
                    System.out.println("Nüfus Bilgilerini Giriniz: ");
                    Long nufus=Oku.nextLong();
                    doubleLinkListManager.insert(new Sehir(nufus,ad));
                    break;
                case 2:
                    doubleLinkListManager.displayFormard();
                    break;

                case 3:
                    doubleLinkListManager.displayBackward();
                    break;
                case 4:
                    doubleLinkListManager.sortList();
                    doubleLinkListManager.displayFormard();

                    break;

                case 5:
                    System.out.println(" Şehir Adını girin: ");
                    String sehirAdForFinding=Oku.nextLine();
                    Link tempSehirAd = doubleLinkListManager.find(sehirAdForFinding);
                    if(tempSehirAd!=null)
                        System.out.println(tempSehirAd.sehir);
                    break;
                case 6:
                    System.out.println(" Şehir Plaka Numarası girin: ");
                    Integer plakaNoForFinding=Oku.nextInt();
                    Link temp = doubleLinkListManager.find(plakaNoForFinding);
                    if(temp!=null)
                        System.out.println(temp.sehir);
                    break;

                case 7:
                    System.out.println(" Şehir Adını girin: ");
                    String sehirAdForDeleting=Oku.nextLine();
                    Link tempDeleteUsingCityName = doubleLinkListManager.delete(sehirAdForDeleting);
                    if(tempDeleteUsingCityName!=null)
                        System.out.println(tempDeleteUsingCityName.sehir);
                    break;
                case 8:
                    System.out.println(" Şehir Plaka Numarası girin: ");
                    Integer plakaNoForDeleting=Oku.nextInt();
                    Link tempDeleteUsingPlaka = doubleLinkListManager.delete(plakaNoForDeleting);
                    if(tempDeleteUsingPlaka!=null)
                        System.out.println(tempDeleteUsingPlaka.sehir);
                    break;

                case 9:
                    doubleLinkListManager.delete();
                    System.out.println("Tümü silindi.");
                    break;
                default:
                    System.out.println("Çıkış Yapılıyor...");

            }

        }
    }
}




