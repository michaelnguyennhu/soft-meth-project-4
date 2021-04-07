package main;

public class MenuItemGroup
{

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

    private String itemName;
    private String[] details;
    private int quantity;
    private float totalPrice;

    public MenuItemGroup(String itemName, String[] details, int quantity, float totalPrice){
        this.itemName = itemName;
        this.details = details;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString(){

        if(details != null && details.length > 0){
            String detailString = "";

            for(int i = 0; i < details.length; i++){
                detailString += details[i] + ", ";
            }

            detailString.substring(0, detailString.length() - 2);

            return itemName + " x" + quantity + " Details - " + detailString +  " Price - " + Utility.ToDollars(totalPrice);
        }

        return itemName + " x" + quantity + " Price - " + Utility.ToDollars(totalPrice);
    }


}
