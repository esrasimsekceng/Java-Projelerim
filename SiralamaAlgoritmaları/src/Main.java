import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static ArrayList<Long> timeList = new ArrayList<>();
    static ArrayList<String> nameList = new ArrayList<>();

    public class SıralamaAlgoritmaları {
        public static void selectionSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }

        // Hızlı Sıralama (Quick Sort) Algoritması
        public static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);

                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            return i + 1;
        }

        // Birleştirme Sıralaması (Merge Sort) Algoritması
        public static void mergeSort(int[] arr, int l, int r) {
            if (l < r) {
                int m = (l + r) / 2;

                mergeSort(arr, l, m);
                mergeSort(arr, m + 1, r);

                merge(arr, l, m, r);
            }
        }

        private static void merge(int[] arr, int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;

            int[] L = new int[n1];
            int[] R = new int[n2];

            System.arraycopy(arr, l, L, 0, n1);
            System.arraycopy(arr, m + 1, R, 0, n2);

            int i = 0, j = 0, k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }


        // Sokma Sıralaması (Insertion Sort) Algoritması
        public static void insertionSort(int[] arr) {
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                int key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
        }

        // Sallama Sıralaması (Shaker Sort) Algoritması
        public static void shakerSort(int[] arr) {
            boolean swapped;
            do {
                swapped = false;
                for (int i = 0; i <= arr.length - 2; i++) {
                    if (arr[i] > arr[i + 1]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        swapped = true;
                    }
                }
                if (!swapped)
                    break;

                swapped = false;
                for (int i = arr.length - 2; i >= 0; i--) {
                    if (arr[i] > arr[i + 1]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        swapped = true;
                    }
                }
            } while (swapped);
        }

        // Kabuk Sıralaması (Shell Sort) Algoritması
        public static void shellSort(int[] arr) {
            int n = arr.length;

            for (int gap = n / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < n; i += 1) {
                    int temp = arr[i];
                    int j;
                    for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                        arr[j] = arr[j - gap];
                    arr[j] = temp;
                }
            }
        }

        // Rastgele Sıralama (Bogo Sort) Algoritması
        public static void bogoSort(int[] arr) {
            while (!isSorted(arr)) {
                shuffle(arr);
            }
        }

        private static void shuffle(int[] arr) {
            Random random = new Random();
            for (int i = 0; i < arr.length; i++) {
                int randomIndex = random.nextInt(arr.length);
                int temp = arr[i];
                arr[i] = arr[randomIndex];
                arr[randomIndex] = temp;
            }
        }

        private static boolean isSorted(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }

        // Bozo Sıralaması (Bozo Sort) Algoritması
        public static void bozoSort(int[] arr) {
            while (!isSorted(arr)) {
                int i = new Random().nextInt(arr.length);
                int j = new Random().nextInt(arr.length);

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Goro Sıralaması (Goro Sort) Algoritması
        public static void goroSort(int[] arr) {
            int n = arr.length;
            boolean swapped;

            do {
                swapped = false;

                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] > arr[i + 1]) {
                        // Swap arr[i] and arr[i+1]
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        swapped = true;
                    }
                }
            } while (swapped);
        }

        // Şanslı Sıralama (Lucky Sort) Algoritması
        public static void luckySort(int[] arr) {
            Random random = new Random();
            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < arr.length - 1; i++) {
                    if (arr[i] > arr[i + 1]) {
                        // Swap elements if they are in the wrong order
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;

                        sorted = false;
                    }
                }

                // "Lucky" part: Shuffle the array randomly
                for (int i = 0; i < arr.length; i++) {
                    int randomIndex = random.nextInt(arr.length);
                    int temp = arr[i];
                    arr[i] = arr[randomIndex];
                    arr[randomIndex] = temp;
                }
            }
        }

        // Serseri Sıralama (Stooge Sort) Algoritması
        public static void stoogeSort(int[] arr, int l, int h) {

            if (l >= h) {
                return;
            }

            if (arr[l] > arr[h]) {
                int temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp;
            }

            if (h - l + 1 > 2) {
                int t = (h - l + 1) / 3;

                stoogeSort(arr, l, h - t);
                stoogeSort(arr, l + t, h);
                stoogeSort(arr, l, h - t);
            }
        }

        // Şimşek Sıralaması (Partial Flash Sort) Algoritması
        public static void partialFlashSort(int[] arr) {

        }

        // Permütasyon Sıralaması (Perm Sort) Algoritması
        public static void permSort(int[] arr) {

        }

        // Several Unique Sort Algoritması
        public static void severalUniqueSort(int[] arr) {

        }

        // Tarak Sıralaması (Comb Sort) Algoritması
        public static void combSort(int[] arr) {
            int n = arr.length;
            int gap = n;
            boolean swapped = true;

            while (gap != 1 || swapped) {
                gap = getNextGap(gap);
                swapped = false;

                for (int i = 0; i < n - gap; i++) {
                    if (arr[i] > arr[i + gap]) {
                        int temp = arr[i];
                        arr[i] = arr[i + gap];
                        arr[i + gap] = temp;
                        swapped = true;
                    }
                }
            }
        }

        private static int getNextGap(int gap) {
            gap = (gap * 10) / 13;
            return (gap < 1) ? 1 : gap;
        }
    }




    public static void main(String[] args) {

        int diziBoyutu = 1000;
        int[] dizi = new int[diziBoyutu];
        Random random = new Random();

        for (int i = 0; i < diziBoyutu; i++) {
            dizi[i] = random.nextInt(1000); // Dizinin elemanları 0 ile 999 arasında random olacak
        }

        long startTime, endTime, duration;


        // Seçerek Sıralama
        int[] selectionSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Seçerek Sıralama fonksiyonunu çağır
        selectionSort(selectionSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Selection Sort");
        System.out.println("Seçerek Sıralama Süresi: " + duration + " nanosaniye");

        // Hızlı Sıralama
        int[] quickSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Hızlı Sıralama fonksiyonunu çağır
        quickSort(quickSortDizi, 0, quickSortDizi.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Quick Sort");
        System.out.println("Hızlı Sıralama Süresi: " + duration + " nanosaniye");

        // Birleştirme Sıralaması
        int[] mergeSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Birleştirme Sıralaması fonksiyonunu çağır
        mergeSort(mergeSortDizi, 0, mergeSortDizi.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Merge Sort");
        System.out.println("Birleştirme Sıralaması Süresi: " + duration + " nanosaniye");

        // Yığınlama Sıralaması
        int[] heapSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Yığınlama Sıralaması fonksiyonunu çağır
        heapSort(heapSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Heap Sort");
        System.out.println("Yığınlama Sıralaması Süresi: " + duration + " nanosaniye");

        // Sayarak Sıralama
        int[] countingSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Sayarak Sıralama fonksiyonunu çağır
        countingSort(countingSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Counting Sort");
        System.out.println("Sayarak Sıralama Süresi: " + duration + " nanosaniye");

        // Kabarcık Sıralaması
        int[] bubbleSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Kabarcık Sıralaması fonksiyonunu çağır
        bubbleSort(bubbleSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Bubble Sort");
        System.out.println("Kabarcık Sıralaması Süresi: " + duration + " nanosaniye");

        // Kokteyl Sıralaması
        int[] cocktailSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Kokteyl Sıralaması fonksiyonunu çağır
        cocktailSort(cocktailSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Cocktail Sort");
        System.out.println("Kokteyl Sıralaması Süresi: " + duration + " nanosaniye");

        // Taban Sıralaması (Radix Sort)
        int[] radixSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Taban Sıralaması (Radix Sort) fonksiyonunu çağır
        radixSort(radixSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Radix Sort");
        System.out.println("Taban Sıralaması (Radix Sort) Süresi: " + duration + " nanosaniye");

        // Sokma Sıralaması
        int[] insertionSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Sokma Sıralaması fonksiyonunu çağır
        insertionSort(insertionSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Insertion Sort");
        System.out.println("Sokma Sıralaması Süresi: " + duration + " nanosaniye");

        // Sallama Sıralaması
        int[] shakerSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Sallama Sıralaması fonksiyonunu çağır
        shakerSort(shakerSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Shaker Sort");
        System.out.println("Sallama Sıralaması Süresi: " + duration + " nanosaniye");

        // Kabuk Sıralaması
        int[] shellSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Kabuk Sıralaması fonksiyonunu çağır
        shellSort(shellSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Shell Sort");
        System.out.println("Kabuk Sıralaması Süresi: " + duration + " nanosaniye");

        // Rastgele Sıralama (Bogo Sort)
        int[] bogoSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Rastgele Sıralama (Bogo Sort) fonksiyonunu çağır
        bogoSort(bogoSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Bogo Sort");
        System.out.println("Rastgele Sıralama (Bogo Sort) Süresi: " + duration + " nanosaniye");

        // Bozo Sıralaması
        int[] bozoSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Bozo Sıralaması fonksiyonunu çağır
        bozoSort(bozoSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Bozo Sort");
        System.out.println("Bozo Sıralaması Süresi: " + duration + " nanosaniye");

        // Goro Sıralaması
        int[] goroSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Goro Sıralaması fonksiyonunu çağır
        goroSort(goroSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Goro Sort");
        System.out.println("Goro Sıralaması Süresi: " + duration + " nanosaniye");

        // Şanslı Sıralama
        int[] luckySortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Şanslı Sıralama fonksiyonunu çağır
        luckySort(luckySortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Lucky Sort");
        System.out.println("Şanslı Sıralama Süresi: " + duration + " nanosaniye");

        // Serseri Sıralama
        int[] stoogeSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Serseri Sıralama fonksiyonunu çağır
        stoogeSort(stoogeSortDizi, 0, stoogeSortDizi.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Stooge Sort");
        System.out.println("Serseri Sıralama Süresi: " + duration + " nanosaniye");

        // Şimşek Sıralaması
        int[] flashSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Şimşek Sıralaması fonksiyonunu çağır
        flashSort(flashSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Flash Sort");
        System.out.println("Şimşek Sıralaması Süresi: " + duration + " nanosaniye");

        // Permütasyon Sıralaması
        int[] permSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Permütasyon Sıralaması fonksiyonunu çağır
        permSort(permSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Perm Sort");
        System.out.println("Permütasyon Sıralaması Süresi: " + duration + " nanosaniye");

        // Bazı Yegane Sıralaması
        int[] severalSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Bazı Yegane Sıralaması fonksiyonunu çağır
        severalSort(severalSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Several Sort");
        System.out.println("Bazı Yegane Sıralaması Süresi: " + duration + " nanosaniye");

        // Tarak Sıralaması
        int[] combSortDizi = Arrays.copyOf(dizi, dizi.length);
        startTime = System.nanoTime();
        // Tarak Sıralaması fonksiyonunu çağır
        combSort(combSortDizi);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        timeList.add(duration);
        nameList.add("Comb Sort");
        System.out.println("Tarak Sıralaması Süresi: " + duration + " nanosaniye");

            int n = timeList.size();
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (timeList.get(j) < timeList.get(minIndex)) {
                        minIndex = j;
                    }
                }
                Long temp = timeList.get(minIndex);
                timeList.set(minIndex, timeList.get(i));
                timeList.set(i, temp);

                String temp1 = nameList.get(minIndex);
                nameList.set(minIndex, nameList.get(i));
                nameList.set(i, temp1);
            }
        System.out.println();
        System.out.println("En küçükten en büyüğe doğru algoritmanın sıralanmış hali:");
        for (int i = 0; i < nameList.size() - 1; i++) {
            System.out.print(nameList.get(i)+": ");
            System.out.println(timeList.get(i));
        }
    }



    private static void quickSort(int[] quickSortDizi, int i, int i1) {
    }

    private static void heapSort(int[] heapSortDizi) {
    }

    private static void flashSort(int[] flashSortDizi) {
    }

    private static void combSort(int[] combSortDizi) {
    }

    private static void severalSort(int[] severalSortDizi) {
    }

    private static void permSort(int[] permSortDizi) {
    }

    private static void stoogeSort(int[] stoogeSortDizi, int i, int i1) {
    }

    private static void luckySort(int[] luckySortDizi) {
    }

    private static void bubbleSort(int[] bubbleSortDizi) {
    }

    private static void goroSort(int[] goroSortDizi) {
    }

    private static void bozoSort(int[] bozoSortDizi) {
    }

    private static void radixSort(int[] radixSortDizi) {
    }

    private static void bogoSort(int[] bogoSortDizi) {
    }

    private static void shellSort(int[] shellSortDizi) {
    }

    private static void shakerSort(int[] shakerSortDizi) {
    }

    private static void insertionSort(int[] insertionSortDizi) {
    }

    private static void cocktailSort(int[] cocktailSortDizi) {
    }

    private static void countingSort(int[] countingSortDizi) {
    }

    private static void selectionSort(int[] selectionSortDizi) {
    }

    private static void mergeSort(int[] mergeSortDizi, int i, int i1) {
    }


}