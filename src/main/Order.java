package main;

import java.util.ArrayList;

/**
 * Store and manages MenuItems for a specific order.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */


public class Order implements Customizable
{

    private final int GROWTH_AMOUNT = 4;
    private final int orderNumber;
    private MenuItem[] itemsList;
    private int numItems;

    /**
     * Constructor. Initiates Array to store menu items.
     * @param newOrderNumber Order number ID
     */
    public Order(int newOrderNumber)
    {
        this.orderNumber = newOrderNumber;
        this.itemsList = new MenuItem[0];
        this.numItems = 0;
    }

    /**
     * Get the order number
     * @return Order number ID
     */
    public int getOrderNumber()
    {
        return this.orderNumber;
    }


    /**
     * Find an menu item in array.
     * @param menuItem Item to find
     * @return Index of item
     */
    private int findOrder(MenuItem menuItem)
    {

        for ( int i = 0; i < numItems; i++ )
        {
            if ( itemsList[i].equals(menuItem) )
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Grows the array size by GROWTH_AMOUNT
     */
    private void growOrder()
    {
        MenuItem[] increasedArr = new MenuItem[itemsList.length + GROWTH_AMOUNT];

        for ( int i = 0; i < itemsList.length; i++ )
        {
            increasedArr[i] = itemsList[i];
        }

        this.itemsList = increasedArr;
    }

    /**
     * Adds a menu item to the list
     * @param obj - MenuItem to add
     * @return If successfully added
     */
    @Override
    public boolean add(Object obj)
    {
        if ( !(obj instanceof MenuItem) )
        {
            return false;
        }


        while ( this.numItems >= this.itemsList.length )
        {
            growOrder();
        }

        MenuItem newMenuItem = ( MenuItem ) obj;

        this.numItems++;
        this.itemsList[numItems - 1] = newMenuItem;

        return true;


    }

    /**
     * Removes a menu item from the order
     * @param obj - MenuItem to remove
     * @return If successfully remove.
     */
    @Override
    public boolean remove(Object obj)
    {
        if ( !(obj instanceof MenuItem) )
        {
            return false;
        }
        MenuItem removeMenuItem = ( MenuItem ) obj;

        int index = findOrder(removeMenuItem);

        if ( index == -1 )
        {
            return false;
        }

        for ( int i = index + 1; i < numItems; i++ )
        {
            itemsList[i - 1] = itemsList[i];
        }


        numItems--;
        return true;
    }

    /**
     * Gets the total price of all menu items.
     * @return Sum of all menu item's prices
     */
    public float getPriceTotal()
    {
        float total = 0;

        for ( int i = 0; i < numItems; i++ )
        {
            total += itemsList[i].getItemPrice();
        }

        return total;
    }

    /**
     * Returns all menu items in array list form.
     * @return ArrayList of menu items.
     */
    public ArrayList< MenuItem > toArrayList()
    {
        ArrayList< MenuItem > arrayList = new ArrayList<>();

        for ( int i = 0; i < numItems; i++ )
        {
            arrayList.add(itemsList[i]);
        }

        return arrayList;
    }

}
