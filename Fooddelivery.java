import java.util.*;

public class Fooddelivery {

    static class DeliveryBoy {
        int id;
        String name;
        int availableFrom;
        DeliveryBoy(int id) {
            this.id = id;
            this.name = "D" + id;
            this.availableFrom = 0;
        }
    }
    static class CustomerOrder {
        int id;
        String name;
        int orderTime;
        int travelTime;

        CustomerOrder(int id, int orderTime, int travelTime) {
            this.id = id;
            this.name = "C" + id;
            this.orderTime = orderTime;
            this.travelTime = travelTime;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstLine = sc.nextLine();
        String[] nm = firstLine.split(",");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        List<CustomerOrder> orders = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String orderLine = sc.nextLine();
            String[] ot = orderLine.split(",");
            int orderTime = Integer.parseInt(ot[0]);
            int travelTime = Integer.parseInt(ot[1]);
            orders.add(new CustomerOrder(i, orderTime, travelTime));
        }

        List<DeliveryBoy> drivers = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            drivers.add(new DeliveryBoy(i));
        }

        for (CustomerOrder order : orders) {
            boolean assigned = false;

            for (DeliveryBoy driver : drivers) {
                if (driver.availableFrom <= order.orderTime) {
                    System.out.println(order.name + " - " + driver.name);
                    driver.availableFrom = order.orderTime + order.travelTime;
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                System.out.println(order.name + " - No Food :-(");
            }
        }

        sc.close();
    }
}

