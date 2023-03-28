import java.util.Random;

/**
 * Marketin çılgın kısmı burasıdır
 * Kuyruktan çıkacak kişi rastgele belirlenir
 * 
 * TODO: indeksle cikarma islemenin ve ekleme isleminin verimli oldugu bir
 * implementasyon yapmaniz istenmektedir.
 */

public class QLottery {
    Customer[] queue = new Customer[5]; // Asıl kuyruk , sınır 5
    Customer[] queue2 = new Customer[5]; // Silinen elemanın döndürülebilmesi için method kullanmak yerine farklı bir
                                         // kuyruk kullanmayı tercih ettim

    int front = 0, back = 0; // head&tail of queue

    /** kuyruğa ekleme işlemi */
    boolean enqueue(Customer customer) {
        if (back == 6) {

        } else {
            queue[back] = customer;
            back = back + 1; // kuyruğun uzaması

        }
        return true;
    }

    /** kuyruktan çıkarma işlemi */
    Customer dequeue() {

        Random r = new Random();
        int a = r.nextInt(5); // üretilen rastgele sayı kuyruktan kimin çıkacağına karar verir

        if (back == 0) {

        } else {
            queue2[0] = queue[a - 1];

            for (int x = a - 1; x < back - 1; x++)
                queue[x] = queue[x + 1];

            back = back - 1;

        }
        return queue2[0];
    }

    /** kuyruğun boş olup olmamasını return eder */
    boolean isEmpty() {
        if (back == 0) {
            return true;
        } else
            return false;
    }

    /** sıradaki eleman */
    Customer peek() {
        return queue[front];
    }

    /** kuruktaki toplam eleman sayisi */
    int size() {
        return back;
    }

    /** sıraya en son giren müşteri */
    Customer LastCustomer() {

        return queue[back];
    }

}
