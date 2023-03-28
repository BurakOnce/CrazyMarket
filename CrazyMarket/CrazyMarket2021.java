import java.util.Random;

/**
 * Burak Önce
 * @burakonce9
 * 20120205052
 *             çılgın market simulatoru
 *             hizmet alınan bir kasa ve iki kuyruk bulunmakta
 *             çılgınlık kuyruklardan birinin çekiliş tarzı çalışmasından kaynaklanmakta
 */

public class CrazyMarket2021 {
    /** parameters for simulations */
    double lambda;
    /** arrival rate */
    double mu;
    /** service rate */
    int Wthreshold = 1;
    /**
     * number of customers to be served. (simulation is done after Nth customer
     * served)
     */
    double N;

    public CrazyMarket2021(double lambda, double mu, int n) {
        // TODO: assign lambda mu, etc
        this.lambda = lambda;
        this.mu = mu;

    }

    QServer qServer = new QServer();

    QLottery qLottery = new QLottery();

    Customer[] customerX;

    /* variables for statistics */
    double meanWaitingTime = 0; // mean waiting time of SERVED customers
    double totalWaitingTime = 0; // total waiting time of SERVED customers
    double meanServiceTime = 0; // mean service time of SERVED customers
    double totalServiceTime = 0; // total service time of SERVED customers
    double interArrivalTime = 0; // customers arrival times difference

    /**
     * 
     */
    public void simulateMarket() {

        while (true) {

            if (meanWaitingTime >= meanServiceTime) {// arrival event
                if (meanWaitingTime >= Wthreshold) {
                    Random random = new Random();
                    int a1 = random.nextInt();
                    int a2 = random.nextInt();

                    qServer.enqueue(customerX[0]);
                    customerX[0].serviceTime = -Math.log(a1) / (mu);
                    meanServiceTime = -Math.log(a1) / (mu);
                    customerX[0].arrivalTime = -Math.log(a2) / ((lambda));

                } else {
                    qLottery.enqueue(customerX[0]);
                }

                System.out.println("departure event");
            } else {
                // departure event
                qServer.dequeue();
                totalServiceTime += meanServiceTime;
                System.out.println("departure event");
            }

        }

    }

    public void printStatistics() {
        System.out.println("totalWaitingTime:" + totalWaitingTime);
        System.out.println("meanWaitingTime:" + meanWaitingTime);
        System.out.println("totalServiceTime:" + totalServiceTime);
        System.out.println("meanServiceTime:" + meanServiceTime);
    }

    public static void main(String[] args) {
        /*
         * double lambda = Double.parseDouble(args[0]);
         * double mu = Double.parseDouble(args[1]);
         * int N = 10;
         * CrazyMarket2021 cm = new CrazyMarket2021(lambda, mu, N);
         * cm.simulateMarket();
         * cm.printStatistics();
         */
        /*
         * QLottery q1 = new QLottery();
         * for(int i=0 ; i<5 ;i++){
         * Customer c = new Customer();
         * q1.enqueue(c);
         * }
         * q1.dequeue();
         * q1.dequeue();
         * 
         * QLottery q2 = new QLottery();
         * for(int i=0 ; i<5 ;i++){
         * Customer c = new Customer();
         * q2.enqueue(c);
         * }
         * 
         * q2.dequeue();
         * 
         * System.out.println(q1.size());
         * System.out.println(q2.size());
         */
    }

}
