import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DoubleLinkList {
    public Link head;
    public Link tail;

    private Link headTemp; // for sorting
    private Link tailTemp; // for sorting

    public int plakaCount = 1;
    public DoubleLinkList(){
        head=null;
        tail=null;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void insert(Sehir sehir){

        Link newlink = new Link(sehir);
        if(!isEmpty() && find(sehir.sehirAd)!=null){
            System.out.println("Sistemde zaten kayıtlı sehir adı bulunmaktadır.");
            return;
        }

        Integer plakaNo=getPlakaNo(sehir);
        sehir.plakaNo = plakaNo;
        Link temp=head;
        if (!isEmpty()) {
            do {
                if (temp != null && temp.sehir.plakaNo >= plakaNo) {
                    temp.sehir.plakaNo++;
                }
                temp = temp.next;
            } while (temp != head);
        }
        if (isEmpty()){
            head = newlink;
        }
        else{
            head.previous=newlink;
        }
        if(tail!=null) {
            newlink.previous = tail;
            tail.next = newlink;
        }

        tail= newlink;
        tail.next=head;

        plakaCount++;

    }

    private int getPlakaNo(Sehir sehir) {
        if(!isEmpty()){
            Link temp = head;
            long minFark = Long.MIN_VALUE;
            int plakaNo = plakaCount;
            do{
                if(temp!=null){
                    long tempFark = compareToStrings(sehir.sehirAd,temp.sehir.sehirAd);
                    System.out.println(sehir.sehirAd + " -> Compare to " +temp.sehir.sehirAd+ "  == "+ tempFark);
                    if(tempFark<0 && minFark<tempFark) {
                        minFark =tempFark;
                        plakaNo = temp.sehir.plakaNo;
                    }
                }
                temp = temp.next;
            }while(temp!=head);
            return plakaNo;

        }
        return 1;
    }

    private long compareToStrings(String sehirAd, String sehirAd1) {
        char[] arr1 = sehirAd.toLowerCase().toCharArray();
        char[] arr2 = sehirAd1.toLowerCase().toCharArray();

        int lenghtOfSehirAd = sehirAd.length();
        int i =0;
        long sum = 0;
        while(lenghtOfSehirAd>0 && i<sehirAd1.length()){
            sum = sum +  ((int) arr1[i]-arr2[i])*(long) Math.pow(30,lenghtOfSehirAd);
            i++;
            lenghtOfSehirAd--;
        }
        return sum;

    }


    public Link delete(String sehirAd) {
        Link temp = head;
        Integer plakaNo = null;
        boolean silindi = false;
        do {
            if (temp != null && temp.sehir.sehirAd.equals(sehirAd)) {
                plakaNo = temp.sehir.plakaNo;
                if (temp == head && temp == tail) {
                    head = null;
                    tail = null;
                } else if (temp == head) {
                    head = temp.next;
                    head.previous = tail;
                } else if (temp == tail) {
                    tail = temp.previous;
                    tail.next = head;
                } else {
                    temp.previous.next = temp.next;
                }
                silindi = true;
                break;
            }
            temp = temp.next;
        } while (temp != head && temp!=null);
        Link temp2 = head;
        if (silindi) {
            do {
                if (temp2 != null && temp2.sehir.plakaNo > plakaNo) {
                    temp2.sehir.plakaNo--;
                }
                temp2 = temp2.next;
            } while (temp2 != head);

            plakaCount--;
            return temp;
        }
        return null;
    }
    public Link delete(int plakaNo) {
        Link temp=head;
        boolean silindi =false;

        do{
            if(temp!=null && temp.sehir.plakaNo==(plakaNo)){
                if(temp==head && temp==tail){
                    head = null;
                    tail = null;
                }
                else if(temp==head){
                    head = temp.next;
                    head.previous =tail;
                }
                else if(temp==tail){
                    tail=temp.previous;
                    tail.next = head;
                }
                else{
                    temp.previous.next = temp.next;
                    temp.next.previous=temp.previous;
                }
                silindi =true;
                break;
            }
            temp=temp.next;
        } while(temp!=head && temp!=null);
        Link temp2=head;
        if(silindi) {
            if(!isEmpty())
                do {
                    if (temp2 != null && temp2.sehir.plakaNo > plakaNo) {
                        temp2.sehir.plakaNo--;
                    }
                    temp2 = temp2.next;
                } while (temp2 != head);

            plakaCount--;
            return temp;
        }
        return null;
    }
    public void delete(){
        head=null;
        tail=null;
        plakaCount = 1;
    }
    public Link find(int plakaNo){
        Link temp=head;
        boolean bulundu =false;
        do{
            if(temp!=null && temp.sehir.plakaNo==(plakaNo)){
                bulundu =true;
                break;
            }
            temp=temp.next;
        } while(temp!=head);
        return bulundu ? temp:null;

    }
    public Link find(String SehirAd){
        Link temp=head;
        boolean bulundu =false;
        do{
            if(temp!=null && temp.sehir.sehirAd.equals(SehirAd)){
                bulundu =true;
                break;
            }
            temp=temp.next;
        } while(temp!=head);
        return bulundu ? temp:null;
    }

    public void sortList() {
        if (isEmpty()) {
            return;
        }
        headTemp = head;
        tailTemp =tail;
        head=null;
        tail=null;
        List<Sehir> listSehir = new ArrayList<>();
        Link current = headTemp;
        do {
            listSehir.add(current.sehir);
            current=current.next;
        }while(current!=headTemp);
        plakaCount=1;
        listSehir.sort(new Comparator<Sehir>() {
            @Override
            public int compare(Sehir o1, Sehir o2) {
                return (int) (o1.nufus-o2.nufus);
            }
        });
        listSehir.forEach(this::insert);
        headTemp=null;
        tailTemp =null;
    }

    private void sonaEkleme(Link link){
        Link temp = new Link(new Sehir(link.sehir.nufus,link.sehir.sehirAd));
        temp.sehir.plakaNo = link.sehir.plakaNo;
        if(temp==null)
            return;
        if (headTemp==null){
            headTemp = temp;
            headTemp.previous=temp;
            headTemp.next=temp;

            tailTemp= temp;

        }
        else{
            headTemp.previous=temp;
        }
        if(tailTemp!=null){
            tailTemp.next = temp;
            temp.previous = tailTemp;
            temp.next = headTemp;
            tailTemp= temp;
        }
        plakaCount++;
    }



    public void displayFormard(){
        System.out.print("Liste: (head----> tail):");
        if(isEmpty()){
            System.out.println("Liste Boş");
            return;
        }
        Link current=head;
        do{
            current.displayLink();
            current=current.next;
        }while (current!=head);
        System.out.println();
    }
    public void displayBackward() {
        System.out.print("Liste: (tail----> head):");
        if(isEmpty()){
            System.out.println("Liste Boş");
            return;
        }
        Link current = tail;
        do {
            current.displayLink();
            current = current.previous;
        } while (current != tail);
        System.out.println();
    }
}