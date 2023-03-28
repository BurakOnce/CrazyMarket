
/**
 * Asıl kuyruk burasıdır 
 * Her şey düzgün bir şekilde işler
 * sırası gelen hizmet alır
 * hizmetini alan sıradan çıkar
 * 
 * maintains a customer queue in a circular array TODO: methodlari implement
 * ediniz, fazla method-field ekleyebilirsiniz.
 */
import java.util.*;

public class QServer {

    LinkedList<Customer> queue = new LinkedList<>();
    int front = 0, back = 0; // head&tail of queue

    /** kuyruğa ekleme işlemi */
    boolean enqueue(Customer customer) {
        if (back == 10) { //kuyruk sınırı 10
            return false;
        } else {
            queue.add(customer);
            back = back + 1;
            return true;
        }
    }

    /** kuyruktan çıkarma işlemi */
    Customer dequeue() {
        if (back == 0) {
            return null;
        } else {
            back = back - 1;
            return queue.poll();

        }

    }

    /**
     * peek a customer in queue
     * 
     */
    Customer peek() {
        return queue.element();
    }

    /** kuruktaki toplam eleman sayisi */
    int size() {
        return back;
    }

    /** kuyruğun boş olup olmamasını return eder */
    boolean isEmpty() {
        if (back == 0) {
            return true;
        } else
            return false;
    }
}
