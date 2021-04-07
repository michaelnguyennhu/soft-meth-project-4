package main;

/**
 * Stores and manages all data for a single donut.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */


public class Donut extends MenuItem
{
    //Donut types
    private static final int YEAST = 0;
    private static final int CAKE = 1;
    private static final int HOLE = 2;

    //Donut type prices
    private static final float YEAST_PRICE = 1.39f;
    private static final float CAKE_PRICE = 1.59f;
    private static final float HOLE_PRICE = 0.33f;

    //Donut flavors
    private static final int GLAZED = 0;
    private static final int CHOCOLATE = 1;
    private static final int VANILLA = 2;

    private int donutType;
    private int donutFlavor;

    /**
     * Constructor. Creates a donut with a choosen type and flavor.
     * @param chooseType - Type of the donut (0-2)
     * @param chooseFlavor - Flavor of the donut (0-2)
     */
    public Donut(int chooseType, int chooseFlavor)
    {
        super();
        this.donutType = chooseType;
        this.donutFlavor = chooseFlavor;
    }

    /**
     * Get the current type of donut
     * @return Type int of the donut (0-2)
     */
    public int getType()
    {
        return this.donutType;
    }

    /**
     * Get the current flavour of donut
     * @return Flavor int of the donut (0-2)
     */
    public int getFlavor()
    {
        return this.donutFlavor;
    }


    /**
     * Calculates the price of the current donut.
     */
    @Override
    public void itemPrice()
    {
        if ( this.donutType == YEAST )
        {
            this.price = YEAST_PRICE;

        } else if ( this.donutType == CAKE )
        {
            this.price = CAKE_PRICE;
        } else if ( this.donutType == HOLE )
        {
            this.price = HOLE_PRICE;
        } else
        {
            throw new RuntimeException("Invalid donut type specified.");
        }
    }

    /**
     * Checks if another donut has the same flavor and type.
     * @param obj Donut object
     * @return If both donuts are the same.
     */
    @Override
    public boolean equals(Object obj)
    {
        if ( !(obj instanceof Donut) )
        {
            return false;
        }

        Donut otherDonut = ( Donut ) obj;
        return (this.donutType == otherDonut.getType()) && (this.donutFlavor == otherDonut.getFlavor());
    }

    /**
     * Generates string that contains the details of the donut
     * @return Flavour and Type of donut in a string
     */
    @Override
    public String toString()
    {
        String flavorName = "";

        switch ( this.donutFlavor )
        {
            case VANILLA:
                flavorName = "Vanilla ";
                break;
            case GLAZED:
                flavorName = "Glazed ";
                break;
            case CHOCOLATE:
                flavorName = "Chocolate ";
                break;
        }

        switch ( this.donutType )
        {
            case YEAST:
                return flavorName + "Yeast Donut";
            case CAKE:
                return flavorName + "Cake Donut";
            case HOLE:
                return flavorName + "Donut Hole";
            default:
                return "Unknown Donut";
        }


    }
}
