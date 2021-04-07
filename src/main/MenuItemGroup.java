package main;

/**
 * Menu item group. Stores all data for a group of items.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */


public class MenuItemGroup
{

    private final String itemName;
    private final String[] details;
    private final int quantity;
    private final float totalPrice;
    private MenuItem itemReference;

    /**
     * Constructor. Initializes the menu item details.
     * @param itemName - Name of item
     * @param details - Addins or details of item
     * @param quantity - How many of current item
     * @param totalPrice - Total price of item
     * @param item - Menu item to reference
     */
    public MenuItemGroup(String itemName, String[] details, int quantity, float totalPrice, MenuItem item)
    {
        this.itemName = itemName;
        this.details = details;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.itemReference = item;
    }

    /**
     * Get the name of the item group.
     * @return Item name
     */
    public String getItemName()
    {
        return itemName;
    }

    /**
     * Get the details of the item group.
     * @return Item details array
     */
    public String[] getDetails()
    {
        return details;
    }

    /**
     * Get the quantity of items.
     * @return Amount of items
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Get the current price of items
     * @return Price of items.
     */
    public float getTotalPrice()
    {
        return totalPrice;
    }

    /**
     * Get the menu item this is based off on.
     * @return MenuItem object
     */
    public MenuItem getItem(){
        return itemReference;
    }


    /**
     * Converts all details and variables of menu item group to a string.
     * @return Item name, Quantity, Details, Price of menu item group in string form.
     */
    @Override
    public String toString()
    {

        if ( details != null && details.length > 0 )
        {
            String detailString = "";

            for ( int i = 0; i < details.length; i++ )
            {
                detailString += details[i] + ", ";
            }

            detailString = detailString.substring(0, detailString.length() - 2);

            return itemName + " x" + quantity + " | Details - " + detailString + " | Price - " + Utility.ToDollars(totalPrice);
        }

        return itemName + " x" + quantity + " | Price - " + Utility.ToDollars(totalPrice);
    }


}
