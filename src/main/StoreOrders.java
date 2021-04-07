package main;

/**
 * Keeps track of the orders that have been placed.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */


public class StoreOrders implements Customizable
{

    private final int GROWTH_AMOUNT = 4;
    private Order[] ordersList;
    private int numOrders;

    private int numOrdersInHistory; //use this as the orderNumber of an order

    /**
     * Constructor for an instance of StoreOrders.
     *
     * Creates an empty ordersList as well as setting numOrders and numOrdersInHistory to 0.
     */
    public StoreOrders()
    {
        this.ordersList = new Order[0];
        this.numOrders = 0;
        this.numOrdersInHistory = 0;
    }

    /**
     * Gets the number of orders that have ever been added to the ordersList.
     * @return The int that is stored in numOrdersInHistory.
     */
    public int getNumOrdersInHistory()
    {
        return this.numOrdersInHistory;
    }

    /**
     * Gets the ordersList from an instance of StoreOrders.
     * @return The list of orders stored in ordersList.
     */
    public Order[] getOrdersList()
    {
        return this.ordersList;
    }

    /**
     * Gets the number of orders in ordersList.
     * @return The int that is stored in numOrders.
     */
    public int getNumOrders()
    {
        return this.numOrders;
    }

    /**
     * Finds a specific order from the ordersList.
     * @param order The order that needs to be found.
     * @return The index of the order found in ordersList.
     *          This will return -1 if it is not found.
     */
    private int findStore(Order order)
    {

        for ( int i = 0; i < numOrders; i++ )
        {
            if ( ordersList[i].getOrderNumber() == order.getOrderNumber() )
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Increases the size of ordersList so that extra orders can be added to the list.
     */
    private void growStore()
    {
        Order[] increasedArr = new Order[ordersList.length + GROWTH_AMOUNT];

        for ( int i = 0; i < ordersList.length; i++ )
        {
            increasedArr[i] = ordersList[i];
        }

        this.ordersList = increasedArr;
    }

    /**
     * Adds an order to the ordersList.
     * @param obj The order that will be added to the ordersList.
     * @return True if the order was added to ordersList.
     *         False if the order was not added to ordersList.
     */
    @Override
    public boolean add(Object obj)
    {
        if ( !(obj instanceof Order) )
        {
            return false;
        }
        Order newOrder = ( Order ) obj;

        while ( this.numOrders >= this.ordersList.length )
        {
            growStore();
        }


        this.numOrders++;
        this.ordersList[numOrders - 1] = newOrder;
        this.numOrdersInHistory++;

        return true;

    }

    /**
     * Removes an order from ordersList.
     * @param obj The order that must be removed from ordersList.
     * @return True if the order was added to ordersList.
     *         False if the order was not added to ordersList.
     */
    @Override
    public boolean remove(Object obj)
    {
        if ( !(obj instanceof Order) )
        {
            return false;
        }
        Order removeOrder = ( Order ) obj;

        int index = findStore(removeOrder);

        if ( index == -1 )
        {
            return false;
        }

        for ( int i = index + 1; i < numOrders; i++ )
        {
            ordersList[i - 1] = ordersList[i];
        }
        numOrders--;
        return true;
    }
}
