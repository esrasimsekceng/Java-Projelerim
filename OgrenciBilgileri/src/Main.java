public class Main {
    public static void main(String[] args) {
        Ogrenci [] ogrenciler={
                new Ogrenci("Gökhan","Bilgisayar Müh",1985,15,2.3,104),
                new Ogrenci("Elif","Elektrik-Elektronik Müh",2020,551,1.98,140),
                new Ogrenci("Ayşe","Makine Müh",1985104032),
                new Ogrenci("Esra", "Siyasal Bilimler",2015,150,3 )
        };

        for (int i = 0; i < ogrenciler.length; i++) {
            System.out.println("OGR " +(i+1) + "  "+ ogrenciler[i]);
        }

        for (int i = 0; i < ogrenciler.length; i++) {
            Integer dersSayisi  = (int) (Math.random()*10);
            double odenecek = ogrenciler[i].harcHesapla(dersSayisi,75.33);
            if(odenecek>0)
                System.out.println("" +(i+1) + ". Ogrencinin odeyeceği harc "+ odenecek);
        }
    }
}