public class Link {
    public Link next;
    public Link previous;
    public Sehir sehir;

    public Link(Sehir sehir) {
        this.sehir = sehir;
    }

    public void displayLink(){
        System.out.println(sehir.toString()+ " ");
    }
}



