package main;

/**
 * TODO: FILL IN CLASS DESCRIPTIOn
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

    public MenuItemGroup(String itemName, String[] details, int quantity, float totalPrice)
    {
        this.itemName = itemName;
        this.details = details;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getItemName()
    {
        return itemName;
    }

    public String[] getDetails()
    {
        return details;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public float getTotalPrice()
    {
        return totalPrice;
    }

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
