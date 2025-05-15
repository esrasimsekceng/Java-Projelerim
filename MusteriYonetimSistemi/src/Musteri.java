public class Musteri {
    private int musteriNo;
    private String ad;
    private String soyad;
    private String eposta;
    private String telefon;
    public Musteri(String ad, String soyad, String eposta, String telefon) {
        this.ad = ad;
        this.soyad = soyad;
        this.eposta = eposta;
        this.telefon = telefon;
    }



    public int getMusteriNo() {
        return musteriNo;
    }
    public void setMusteriNo(int musteriNo) {
        this.musteriNo = musteriNo;
    }
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public Boolean eslemeKontrol(String anahtarKelime){
        boolean musteriOk=false;
        Musteri tempMusteri=this;
        if (tempMusteri.getAd().startsWith(anahtarKelime)){
            musteriOk=true;
        }
        if (tempMusteri.getSoyad().startsWith(anahtarKelime)){
            musteriOk=true;
        }
        if (tempMusteri.getEposta().startsWith(anahtarKelime)){
            musteriOk=true;
        }
        if (tempMusteri.getTelefon().startsWith(anahtarKelime)){
            musteriOk=true;
        }if (String.valueOf(tempMusteri.getMusteriNo()).startsWith(anahtarKelime)){
            musteriOk=true;
        }
        return musteriOk;

    }

    @Override
    public String toString() {
        return "Musteri{" +
                "musteriNo=" + musteriNo +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", eposta='" + eposta + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}


