package main;

/**
 * Used to keep track of the status of add ins.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */

public class AddIns
{
    // Enabled add ins for coffee
    private boolean cream;
    private boolean syrup;
    private boolean milk;
    private boolean caramel;
    private boolean whippedCream;


    /**
     * Construct. Defaults all add ins to false, or none.
     */
    public AddIns()
    {
        this.cream = false;
        this.syrup = false;
        this.milk = false;
        this.caramel = false;
        this.whippedCream = false;
    }

    /**
     * Get the total amount of add ins enabled.
     *
     * @return The amount of add ins enabled
     */
    public int getTotalAddIns()
    {
        int totalAddIns = 0;
        if ( this.cream )
        {
            totalAddIns++;
        }
        if ( this.syrup )
        {
            totalAddIns++;
        }
        if ( this.milk )
        {
            totalAddIns++;
        }
        if ( this.caramel )
        {
            totalAddIns++;
        }
        if ( this.whippedCream )
        {
            totalAddIns++;
        }

        return totalAddIns;
    }


    /**
     * Get the status of cream. Added is true.
     * @return
     */
    public boolean getCream()
    {
        return this.cream;
    }

    /**
     * Set the status of cream. Added is true.
     * @param added - True is added, false is not added.
     */
    public void setCream(boolean added)
    {
        this.cream = added;
    }

    /**
     * Get the status of cream. Added is true.
     * @return Status of syrup.
     */
    public boolean getSyrup()
    {
        return this.syrup;
    }

    /**
     * Set the status of syrup. Added is true.
     * @param added - True is added, false is not added.
     */
    public void setSyrup(boolean added)
    {
        this.syrup = added;
    }

    /**
     * Get the status of milk. Added is true.
     * @return Status of milk.
     */
    public boolean getMilk()
    {
        return this.milk;
    }

    /**
     * Set the status of milk. Added is true.
     * @param added - True is added, false is not added.
     */
    public void setMilk(boolean added)
    {
        this.milk = added;
    }

    /**
     * Get the status of caramel. Added is true.
     * @return Status of caramel
     */
    public boolean getCaramel()
    {
        return this.caramel;
    }

    /**
     * Set the status of caramel. Added is true.
     * @param added - True is added, false is not added.
     */
    public void setCaramel(boolean added)
    {
        this.caramel = added;
    }

    /**
     * Get the status of whipped cream. Added is true.
     * @return Status of whipped cream.
     */
    public boolean getWhippedCream()
    {
        return this.whippedCream;
    }

    /**
     * Set the status of syrup. Added is true.
     * @param added - True is added, false is not added.
     */
    public void setWhippedCream(boolean added)
    {
        this.whippedCream = added;
    }


    @Override
    public boolean equals(Object obj)
    {
        if ( !(obj instanceof AddIns) )
        {
            return false;
        }
        AddIns otherAddIns = ( AddIns ) obj;

        return (this.cream == otherAddIns.getCream()) && (this.syrup == otherAddIns.getSyrup()) && (this.milk == otherAddIns.getMilk()) && (this.caramel == otherAddIns.getCaramel()) && (this.whippedCream == otherAddIns.getWhippedCream());

    }

    @Override
    public String toString()
    {
        String addInString = "";
        if ( this.cream )
        {
            addInString = addInString + "Cream:";
        }
        if ( this.syrup )
        {
            addInString = addInString + "Syrup:";
        }
        if ( this.milk )
        {
            addInString = addInString + "Milk:";
        }
        if ( this.caramel )
        {
            addInString = addInString + "Caramel:";
        }
        if ( this.cream )
        {
            addInString = addInString + "Cream:";
        }

        return addInString;
    }
}
