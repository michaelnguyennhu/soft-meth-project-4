package sample;

public class Order implements Customizable{

    private int orderNumber;
    private MenuItem[] itemsList;
    private int numItems;

    public Order(int newOrderNumber){
        this.orderNumber = newOrderNumber;
        this.itemsList = new MenuItem[0];
        this.numItems = 0;
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
