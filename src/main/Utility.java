package main;

import java.text.DecimalFormat;

/**
 * Used to change floats into a String with Dollars format.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */


public class Utility
{
    /**
     * Function to change a float into dollars format
     *
     * @param amount Price that will be formatted into dollars.
     * @return A String that is in dollars format.
     */
    public static String ToDollars(float amount)
    {
        float flooredAmount = ( float ) (Math.floor(Math.round(amount * 100)) / 100);

        DecimalFormat formatter = new DecimalFormat("'$'###,###,###,###,##0.00");
        formatter.setGroupingSize(3);


        return formatter.format(flooredAmount);
    }
}
