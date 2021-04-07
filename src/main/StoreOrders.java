package main;

public class StoreOrders implements Customizable{

    private final int GROWTH_AMOUNT = 4;
    private Order[] ordersList;
    private int numOrders;

    private int numOrdersInHistory; //use this as the orderNumber


    public StoreOrders(){
        this.ordersList = new Order[0];
        this.numOrders = 0;
        this.numOrdersInHistory = 0;
    }

    public int getNumOrdersInHistory(){
        return this.numOrdersInHistory;
    }

    public Order[] getOrdersList(){
        return this.ordersList;
    }

    private int findStore(Order order){

        for (int i = 0; i < numOrders; i++){
            if (ordersList[i].getOrderNumber() == order.getOrderNumber()){
                return i;
            }
        }
        return -1;
    }

    private void growStore(){
        Order[] increasedArr = new Order[ordersList.length + GROWTH_AMOUNT];

        for (int i = 0; i < ordersList.length; i++){
            increasedArr[i] = ordersList[i];
        }

        this.ordersList = increasedArr;
    }

    @Override
    public boolean add(Object obj){
        if ( !(obj instanceof Order) ){
            return false;
        }
        Order newOrder = (Order) obj;

        while ( this.numOrders >= this.ordersList.length )
        {
            growStore();
        }


        this.numOrders++;
        this.ordersList[numOrders - 1] = newOrder;
        this.numOrdersInHistory++;

        return true;

    }

    @Override
    public boolean remove(Object obj){
        if ( !(obj instanceof Order) ){
            return false;
        }
        Order removeOrder = (Order) obj;

        int index = findStore(removeOrder);

        if (index == -1){
            return false;
        }

        for (int i = index + 1; i < numOrders; i++){
            ordersList[i - 1] = ordersList[i];
        }
        numOrders--;
        return true;
    }
}
