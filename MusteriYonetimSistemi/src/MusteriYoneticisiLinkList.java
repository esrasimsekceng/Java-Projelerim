import java.util.Scanner;

public class MusteriYoneticisiLinkList {
    Link head = null;
    Link tail = null;

    private Integer maksimumBoyut;

    private int  musteriSayisi=0;

    private int musteriNoCounter;

    public MusteriYoneticisiLinkList(Integer maksimumBoyut) {
        this.maksimumBoyut = maksimumBoyut;
    }

    public void MusteriEkle(Musteri musteri) {
        musteriNoCounter++;
        if(musteriSayisi>=maksimumBoyut) {
            System.out.println("liste doldu bu yüzden daha fazla musteri ekleyemezsiniz.");
            return;
        }
        musteri.setMusteriNo(musteriNoCounter);
        Link eleman = new Link(musteri);

        if (head == null) {
            head = eleman;

            System.out.println("liste oluşturuldu ilk müşteri kayıt edildi");
        } else {
            if(tail==null){
                tail =eleman;
                head.next=eleman;
            }else{
                tail.setNext(eleman);
            }

            System.out.println(musteri.getMusteriNo() + " numaralı müşteri kayıt edildi");
        }
        musteriSayisi++;
    }

    public void musteriSil(Integer musteriNo) {
        boolean sonuc = false;
        if (head == null) {
            System.out.println("liste boş!!");
        } else {

            if (head.getMusteri().getMusteriNo() == musteriNo) {
                head = head.getNext();
                sonuc = true;
            }
            else {
                Link next = head.next;
                Link previous=head;
                while(next!=null && sonuc==false )
                    if(next.getMusteri().getMusteriNo() == musteriNo) {
                        sonuc = true;
                        previous.next = next.next;
                        if(next==tail) {
                            tail =null;
                        }
                    }

            }
            if (!sonuc)
                System.out.println(musteriNo + " numaralı müşteri listede bulunamadı");
            else {
                musteriSayisi--;
                System.out.println(musteriNo + " numaralı müşteri silindi.");
            }

        }

    }
    public void musteriAra(String anahtarKelime) {
        if (head == null) {
            System.out.println("liste boş!!");
        } else {
            Link temp = head;
            while (temp != null) {
                if (temp.getMusteri().eslemeKontrol(anahtarKelime)) {
                    System.out.println(temp.getMusteri());
                }
                temp = temp.next;
            }
        }

    }
    public void musterileriListele() {
        Link temp=head;
        while (temp!=null){
            System.out.println(temp.getMusteri());
            temp=temp.next;
        }
    }


    public void musterileriSiralamaListele() {
        if (head == null) {
            System.out.println("Liste boş!!");
        } else {
            // Müşterileri diziye kopyala
            Musteri[] musterilerDizi = new Musteri[musteriSayisi];
            Link temp = head;
            int index = 0;
            while (temp != null) {
                musterilerDizi[index] = temp.getMusteri();
                temp = temp.next;
                index++;
            }

            // Selection Sort ile sırala
            for (int i = 0; i < musteriSayisi - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < musteriSayisi; j++) {
                    if (musterilerDizi[j].getMusteriNo() < musterilerDizi[minIndex].getMusteriNo()) {
                        minIndex = j;
                    }
                }
                Musteri tempMusteri = musterilerDizi[i];
                musterilerDizi[i] = musterilerDizi[minIndex];
                musterilerDizi[minIndex] = tempMusteri;
            }

            // Sıralanmış müşterileri listele
            for (Musteri musteri : musterilerDizi) {
                System.out.println(musteri);
            }
        }

    }
}



