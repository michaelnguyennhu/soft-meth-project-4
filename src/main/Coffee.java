package main;

/**
 * Stores and manages all data for a single coffee.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */

public class Coffee extends MenuItem implements Customizable
{
    //Coffee size constants
    private static final int SHORT = 0;
    private static final int TALL = 1;
    private static final int GRANDE = 2;
    private static final int VENTI = 3;

    //Base coffee price
    private static final float SHORT_BLACK = 1.99f;
    //Increments per coffee
    private static final float NEXT_SIZE_PRICE = 0.50f;
    //Price for every add in
    private static final float ADDIN_PRICE = 0.20f;

    private int size;
    private int numAddIns;
    private final AddIns addIns;

    /**
     * Constructor. Requires the initial size.
     * @param newSize Size of the coffee (0-3)
     */
    public Coffee(int newSize)
    {
        super();
        this.size = newSize;
        this.numAddIns = 0;
        this.addIns = new AddIns();
    }

    /**
     * Calculates the item price for this coffee.
     */
    @Override
    public void itemPrice()
    {
        this.price = SHORT_BLACK;
        for ( int i = 0; i < this.size; i++ )
        {
            this.price += NEXT_SIZE_PRICE;
        }

        for ( int i = 0; i < this.numAddIns; i++ )
        {
            this.price += ADDIN_PRICE;
        }
    }

    /**
     * Changes the size of the coffee.
     * @param newSize Size to change to (0-3)
     */
    public void changeSize(int newSize)
    {
        this.size = newSize;
    }

    /**
     * Get the size of the coffee
     * @return Coffee size (0-3)
     */
    public int getSize()
    {
        return this.size;
    }

    /**
     * Get the number of add ins
     * @return Add in amount
     */
    public int getNumAddIns()
    {
        return this.numAddIns;
    }

    /**
     * Get the addins for this coffee.
     * @return AddIns object
     */
    public AddIns getAddIns()
    {
        return this.addIns;
    }

    /**
     * Add an addin to this coffee.
     * @param obj Addin Object
     * @return Returns true if successfully added.
     */
    @Override
    public boolean add(Object obj)
    {
        if ( !(obj instanceof AddIns) )
        {
            return false;
        }

        AddIns moreAddIns = ( AddIns ) obj;


        if ( moreAddIns.getCream() )
        {
            this.addIns.setCream(true);
        }

        if ( moreAddIns.getSyrup() )
        {
            this.addIns.setSyrup(true);
        }

        if ( moreAddIns.getMilk() )
        {
            this.addIns.setMilk(true);
        }

        if ( moreAddIns.getCaramel() )
        {
            this.addIns.setCaramel(true);
        }

        if ( moreAddIns.getWhippedCream() )
        {
            this.addIns.setWhippedCream(true);
        }

        this.numAddIns = this.addIns.getTotalAddIns();
        return true;
    }


    /**
     * Remove the supplied addins from this coffee.
     * @param obj AddIns Object
     * @return True if successfully removed
     */
    @Override
    public boolean remove(Object obj)
    {

        if ( !(obj instanceof AddIns) )
        {
            return false;
        }

        AddIns moreAddIns = ( AddIns ) obj;

        if ( moreAddIns.getCream() )
        {
            this.addIns.setCream(false);
        }

        if ( moreAddIns.getSyrup() )
        {
            this.addIns.setSyrup(false);
        }

        if ( moreAddIns.getMilk() )
        {
            this.addIns.setMilk(false);
        }

        if ( moreAddIns.getCaramel() )
        {
            this.addIns.setCaramel(false);
        }

        if ( moreAddIns.getWhippedCream() )
        {
            this.addIns.setWhippedCream(false);
        }

        this.numAddIns = this.addIns.getTotalAddIns();
        return true;
    }

    /**
     * Check if this coffee equals another one. Compares size and addins.
     * @param obj Coffee Object
     * @return True if the other object is equal.
     */
    @Override
    public boolean equals(Object obj)
    {
        if ( !(obj instanceof Coffee) )
        {
            return false;
        }

        Coffee otherCoffee = ( Coffee ) obj;

        if ( (this.size == otherCoffee.getSize()) && (this.numAddIns == otherCoffee.getNumAddIns()) )
        {
            return this.addIns.equals(otherCoffee.getAddIns());
        } else
        {
            return false;
        }

    }

    /**
     * Get a list of the addins from this coffee.
     * @return List of addins strings.
     */
    @Override
    public String[] getDetails()
    {
        String[] addinsDetail = new String[addIns.getTotalAddIns()];
        int cur = 0;
        if ( addIns.getCream() )
        {
            addinsDetail[cur] = "Cream";
            cur++;
        }

        if ( addIns.getSyrup() )
        {
            addinsDetail[cur] = "Syrup";
            cur++;
        }

        if ( addIns.getMilk() )
        {
            addinsDetail[cur] = "Milk";
            cur++;
        }

        if ( addIns.getCaramel() )
        {
            addinsDetail[cur] = "Caramel";
            cur++;
        }

        if ( addIns.getWhippedCream() )
        {
            addinsDetail[cur] = "Whipped Cream";
            cur++;
        }

        return addinsDetail;
    }

    /**
     * Creates string based on size of the coffee.
     * @return Size + "Coffee".
     */
    @Override
    public String toString()
    {
        String sizeName = "";

        switch ( this.size )
        {
            case SHORT:
                sizeName = "Short ";
                break;
            case TALL:
                sizeName = "Tall ";
                break;
            case GRANDE:
                sizeName = "Grande ";
                break;
            case VENTI:
                sizeName = "Venti ";
                break;
        }

        return sizeName + "Coffee";
    }
}
