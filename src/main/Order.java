package main;

public class Order implements Customizable{

    private int orderNumber;
    private MenuItem[] itemsList;
    private int numItems;

    private final int GROWTH_AMOUNT = 4;

    public Order(int newOrderNumber){
        this.orderNumber = newOrderNumber;
        this.itemsList = new MenuItem[0];
        this.numItems = 0;
    }

    public int getOrderNumber(){
        return this.orderNumber;
    }


    private int findOrder(MenuItem menuItem){

        for (int i = 0; i < numItems; i++){
            if (itemsList[i].equals(menuItem)){
                return i;
            }
        }
        return -1;
    }


    private void growOrder(){
        MenuItem[] increasedArr = new MenuItem[itemsList.length + GROWTH_AMOUNT];

        for (int i = 0; i < itemsList.length; i++){
            increasedArr[i] = itemsList[i];
        }

        this.itemsList = increasedArr;
    }

    @Override
    public boolean add(Object obj){
        if ( !(obj instanceof MenuItem) ){
            return false;
        }

        while ( this.numItems >= this.itemsList.length )
        {
            growOrder();
        }

        MenuItem newMenuItem = (MenuItem) obj;

        this.numItems++;
        this.itemsList[numItems - 1] = newMenuItem;

        return true;


    }

    @Override
    public boolean remove(Object obj){
        if ( !(obj instanceof MenuItem) ){
            return false;
        }
        MenuItem removeMenuItem = (MenuItem) obj;

        int index = findOrder(removeMenuItem);

        if (index == -1){
            return false;
        }

        for (int i = index + 1; i < numItems; i++){
            itemsList[i - 1] = itemsList[i];
        }
        numItems--;
        return true;
    }

    public float getPriceTotal(){
        float total = 0;

        for(int i = 0 ; i < numItems; i++){
            total += itemsList[i].getItemPrice();
        }

        return total;
    }

}
