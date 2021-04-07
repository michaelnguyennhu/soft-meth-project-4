package main;

/**
 * Menu item. Stores all details required for menu item.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */


public class MenuItem
{
    protected float price;

    /**
     * Constructor. Sets price to 0.
     */
    public MenuItem()
    {
        this.price = 0;
    }

    /**
     * Calculates the current price of the item.
     */
    public void itemPrice()
    {
        if ( this instanceof Donut )
        {
            Donut donut = ( Donut ) this;
            donut.itemPrice();
        } else if ( this instanceof Coffee )
        {
            Coffee coffee = ( Coffee ) this;
            coffee.itemPrice();

        }
    }

    /**
     * Get the current price of the item.
     * @return Float value dollars of the current item price.
     */
    public float getItemPrice()
    {
        this.itemPrice();
        return this.price;
    }

    /**
     * Get an array of strings that contains extra details about item.
     * @return Array of item details.
     */
    public String[] getDetails()
    {
        return new String[0];
    }

    /**
     * Check if this menu item is equal to another, based on instances.
     * @param obj MenuItem Object
     * @return If the objects are equal.
     */
    @Override
    public boolean equals(Object obj)
    {
        if ( (this instanceof Coffee) && (obj instanceof Coffee) )
        {
            Coffee thisCoffee = ( Coffee ) this;
            Coffee otherCoffee = ( Coffee ) obj;
            return thisCoffee.equals(otherCoffee);
        } else if ( (this instanceof Donut) && (obj instanceof Donut) )
        {
            Donut thisDonut = ( Donut ) this;
            Donut otherDonut = ( Donut ) obj;
            return thisDonut.equals(otherDonut);
        } else
        {
            return false;
        }

    }

    /**
     * Gets the string of the menu item if it is either a donut or coffee.
     * @return ToString() of extended classes.
     */
    @Override
    public String toString()
    {
        String menuItemString = "";
        if ( this instanceof Donut )
        {
            Donut donut = ( Donut ) this;
            menuItemString = donut.toString();
        } else if ( this instanceof Coffee )
        {
            Coffee coffee = ( Coffee ) this;
            menuItemString = coffee.toString();
        }

        return menuItemString;
    }
}
