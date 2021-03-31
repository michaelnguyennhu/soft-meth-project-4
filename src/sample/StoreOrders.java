package sample;

public class StoreOrders implements Customizable{

    private Order[] ordersList;
    private int numOrders;

    public StoreOrders(){
        this.ordersList = new Order[0];
        this.numOrders = 0;
    }



    @Override
    public boolean add(Object obj){
        return false;
    }

    @Override
    public boolean remove(Object obj){
        return false;
    }
}
