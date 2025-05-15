import java.time.LocalDate;

public class Ogrenci {
   private String ad;
   private String bolum;
   private Integer girisYili;
   private Integer ogrNo;

   private double gano;
   private Integer bolumKodu;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public Integer getGirisYili() {
        return girisYili;
    }

    public void setGirisYili(int girisYili) {
        if(girisYili>9999 || girisYili<1000){ //4 Rakam gelsin diye..
            throw new IllegalArgumentException("Geçersiz giriş yılı girilmiştir.");
        }
        this.girisYili = girisYili;
    }

    public Integer getOgrNo() {
        return ogrNo;
    }

    public void setOgrNo(int ogrNo) {

        this.ogrNo = ogrNo;
    }

    public double getGano() {

        return gano;
    }

    public void setGano(double gano) {
        if(gano>4 || gano<0){ // 0 ile 4 aralığında olmadığında geçersiz sayılması
            throw new IllegalArgumentException("Geçersiz Genel ağırlıklı not ortalaması girilmiştir.");
        }
        this.gano = gano;
    }

    public Integer getBolumKodu() {

        return bolumKodu;
    }

    public void setBolumKodu(int bolumKodu) {
        if(bolumKodu<0 || bolumKodu>999){ // bölüm kodu negatif ve dört basamaklı olamaz
            throw new IllegalArgumentException("Geçersiz bölüm kodu girilmiştir.");
        }
        this.bolumKodu = bolumKodu;
    }

    public Ogrenci(String ad, String bolum, int girisYili, int girisSirasi, double gano, int bolumKodu) {
        this.setAd(ad);
        this.setBolum(bolum);
        this.setGirisYili(girisYili);
        this.setGano(gano);
        this.setBolumKodu( bolumKodu);
        this.ogrNo = this.ogrNoOlustur(girisSirasi);
    }

    public Ogrenci(String ad, String bolum, int ogrNo){
        this.setAd(ad);
        this.setBolum(bolum);
        this.setOgrNo(ogrNo);
    }



    public Ogrenci(String ad, String bolum, int girisYili, int bolumKodu, int girisSirasi) {
        this.setAd(ad);
        this.setBolum(bolum);
        this.setGirisYili(girisYili);
        this.setBolumKodu(bolumKodu);
        this.setBolumKodu( bolumKodu);
        this.ogrNo = this.ogrNoOlustur(girisSirasi);
    }

    public Integer ogrNoOlustur(int girisSirasi){
       // +2015+     005 +   "2015005001"   2022 123 030
        if(girisSirasi<0 ||girisSirasi>999){ //öğrencinin giriş sırası negatif ve dört basamaklı olamaz
            throw new IllegalArgumentException("Bu Öğrenci sıralaması üç haneden fazla olamaz");
        }
        //giriş yılı + bolum kodu + giris sirasi String veri tipinden Integer veri tipine dönüştürüldü ve 3 basamaklı olması sağlandı
     return Integer.parseInt(""+girisYili+String.format("%03d", Integer.valueOf(bolumKodu))+String.format("%03d", Integer.valueOf(girisSirasi)));
    }

    public double harcHesapla(int dersSayisi){
        Integer thisYear = LocalDate.now().getYear(); // bu yıl alındı
        if(this.girisYili==null){
           return 0.0;
        }
        if(thisYear>this.girisYili+4){
            return dersSayisi*55.0;
        }
        return 0;
    }

    public double harcHesapla(int dersSayisi,double dersBasiUcreti){
        Integer thisYear = LocalDate.now().getYear();
        if(this.girisYili==null){
            return 0.0;
        }
        if(thisYear>this.girisYili+4){ //4 yıllık bölüm okuyup okulu uzatanların harc ücreti hesaplama
            return dersSayisi*dersBasiUcreti;
        }
        return 0;
    }


    public double harcHesapla(int dersSayisi,int bolumSuresi, double dersBasiUcreti){
        Integer thisYear = LocalDate.now().getYear();
        if(this.girisYili==null){
            return 0.0;
        }
        if(thisYear>this.girisYili+bolumSuresi){
            return dersSayisi*dersBasiUcreti;
        }
        return 0;
    }

    @Override
    public String toString() {
        return  " " + ad +
                " " + bolum +
                " " + ogrNo +
                " " + gano;
    }
}
