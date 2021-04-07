package main;

import java.text.DecimalFormat;

/**
 * TODO: FILL IN CLASS DESCRIPTIOn
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */


public class Utility
{
    public static String ToDollars(float amount)
    {
        float flooredAmount = ( float ) (Math.floor(Math.round(amount * 100)) / 100);

        DecimalFormat formatter = new DecimalFormat("'$'###,###,###,###,##0.00");
        formatter.setGroupingSize(3);


        return formatter.format(flooredAmount);
    }
}
