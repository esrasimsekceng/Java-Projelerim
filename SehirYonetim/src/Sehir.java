public class Sehir {
     public int plakaNo;
     public long nufus;
     public String sehirAd;

     public Sehir(long nufus, String sehirAd) {
          this.nufus = nufus;
          this.sehirAd = sehirAd;
     }

     @Override
     public String toString() {
          return "Sehir{" +
                  "plakaNo=" + plakaNo +
                  ", nufus=" + nufus +
                  ", sehirAd='" + sehirAd + '\'' +
                  '}';
     }
}
