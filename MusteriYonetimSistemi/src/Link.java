public class Link {

    private Musteri musteri;

    Link next;

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }


    public Link(Musteri musteri) {
        this.musteri = musteri;
    }
}
