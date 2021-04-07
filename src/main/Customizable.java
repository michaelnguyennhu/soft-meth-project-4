package main;

/**
 * Customizable object interface. Supplied add and remove function.
 *
 * @author Alexander Xie
 * @author Michael Nguyen
 */


public interface Customizable
{
    /**
     * Add an object
     * @param obj - Object to add
     * @return If succeeded or not.
     */
    boolean add(Object obj);

    /**
     * Removes an object
     * @param obj - Object to remove
     * @return If succeeded or not.
     */
    boolean remove(Object obj);
}
