package edu.orangecoastcollege.cs273.balbert.inandout;

import java.io.Serializable;

/**
 * Order represents the Model of the In and Out app.
 * A single Order object is used to encapsulate a user's order details.
 *
 * This class extends Serializable so that the Order object can be sent using an Intent.
 *
 * In this class we have member variables representing the items available to be ordered.
 * There are also constants for the various prices and tax.
 *
 * A default constructor initializes the member variables.
 *
 * There are methods to calculate subtotal, total, tax, and the number of items ordered.
 *
 * There are getters and setters.
 * The getters for the member variables are unused but have been included because the UML spec
 * requested them.
 *
 * Getters are also provided for the constant fields which was NOT specified in the UML spec.
 * However the thinking behind this addition was, if prices or tax change in the future,
 * they need only be updated here and the changes will be reflected across the app, rather
 * than having to manually update the views themselves.
 * This should also facilitate translations of various locales' currency.
 *
 * The setters are associated with their respective EditTexts in activity_order.xml.
 *
 * Created by brendantyleralbert on 9/23/17.
 */

public class Order implements Serializable {
    private int mCheeseBurgers;
    private int mDoubleDoubles;
    private int mFrenchFries;
    private int mLargeDrinks;
    private int mMediumDrinks;
    private int mShakes;
    private int mSmallDrinks;
    private final double PRICE_CHEESEBURGER = 2.15;
    private final double PRICE_DOUBLE_DOUBLE = 3.60;
    private final double PRICE_FRENCH_FRIES = 1.65;
    private final double PRICE_LARGE_DRINK = 1.75;
    private final double PRICE_MEDIUM_DRINK = 1.55;
    private final double PRICE_SHAKE = 2.20;
    private final double PRICE_SMALL_DRINK = 1.45;
    private final double TAX_RATE = 0.08;

    /**
     * The default constructor Order() initializes the various member variables.
     */
    public Order() {
        mCheeseBurgers = 0;
        mDoubleDoubles = 0;
        mFrenchFries   = 0;
        mLargeDrinks   = 0;
        mMediumDrinks  = 0;
        mShakes        = 0;
        mSmallDrinks   = 0;
    }

    /**
     *
     * @return the cost of the items the user ordered WITHOUT any tax added.
     * This is displayed in summary_activity.xml.
     */
    public double calculateSubtotal() {
        return    PRICE_CHEESEBURGER  * mCheeseBurgers
                + PRICE_DOUBLE_DOUBLE * mDoubleDoubles
                + PRICE_FRENCH_FRIES  * mFrenchFries
                + PRICE_LARGE_DRINK   * mLargeDrinks
                + PRICE_MEDIUM_DRINK  * mMediumDrinks
                + PRICE_SHAKE         * mShakes
                + PRICE_SMALL_DRINK   * mSmallDrinks;
    }

    /**
     *
     * @return the product of the tax and the cost of the user's ordered items.
     * This is display in summary_activity.xml.
     */
    public double calculateTax() { return calculateSubtotal() * TAX_RATE; }

    /**
     *
     * @return the sum of the user's subtotal and tax. This is displayed in summary_activity.xml.
     */
    public double calculateTotal() { return calculateSubtotal() + calculateTax(); }

    /**
     *
     * @return how many items the user ordered. This is displayed in summary_activity.xml
     */
    public int getNumberItemsOrdered() {
        return  mCheeseBurgers +
                mDoubleDoubles +
                mFrenchFries +
                mLargeDrinks +
                mMediumDrinks +
                mShakes +
                mSmallDrinks;
    }

    /**
     *
     * @return how many cheeseburgers were ordered. Included because UML spec asked for it.
     */
    public int getCheeseBurgers() { return mCheeseBurgers; }

    /**
     *
     * @return how many double doubles were ordered. Included because UML spec asked for it.
     */
    public int getDoubleDoubles() { return mDoubleDoubles; }

    /**
     *
     * @return how many fries were ordered. Included because UML spec asked for it.
     */
    public int getFrenchFries() { return mFrenchFries; }

    /**
     *
     * @return how many large drinks were ordered. Included because UML spec asked for it.
     */
    public int getLargeDrinks() { return mLargeDrinks; }

    /**
     *
     * @return how many shakes were ordered. Included because UML spec asked for it.
     */
    public int getShakes() { return mShakes; }

    /**
     *
     * @return how many medium drinks were ordered. Included because UML spec asked for it.
     */
    public int getMediumDrinks() { return mMediumDrinks; }

    /**
     *
     * @return how many small drinks were ordered. Included because UML spec asked for it.
     */
    public int getSmallDrinks() { return mSmallDrinks; }

    /**
     *
     * @return the price of a cheeseburger
     * Although not asked for in the UML spec, this was included because it simplifies
     * the displaying of prices in the Views.  If this was not included the price would need
     * to be hardcoded into the Strings.xml and that would be no bueno.
     */
    public double getPriceCheeseburger() { return PRICE_CHEESEBURGER; }

    /**
     *
     * @return the price of a double double.
     * Although not asked for in the UML spec, this was included because it simplifies
     * the displaying of prices in the Views.  If this was not included the price would need
     * to be hardcoded into the Strings.xml and that would be no bueno.
     */
    public double getPriceDoubleDouble() { return PRICE_DOUBLE_DOUBLE; }

    /**
     *
     * @return the price of french fries.
     * Although not asked for in the UML spec, this was included because it simplifies
     * the displaying of prices in the Views.  If this was not included the price would need
     * to be hardcoded into the Strings.xml and that would be no bueno.
     */
    public double getPriceFrenchFries() { return PRICE_FRENCH_FRIES; }

    /**
     *
     * @return the price of a large drink.
     * Although not asked for in the UML spec, this was included because it simplifies
     * the displaying of prices in the Views.  If this was not included the price would need
     * to be hardcoded into the Strings.xml and that would be no bueno.
     */
    public double getPriceLargeDrink() { return PRICE_LARGE_DRINK; }

    /**
     *
     * @return the price of a medium drink.
     * Although not asked for in the UML spec, this was included because it simplifies
     * the displaying of prices in the Views.  If this was not included the price would need
     * to be hardcoded into the Strings.xml and that would be no bueno.
     */
    public double getPriceMediumDrink() { return PRICE_MEDIUM_DRINK; }

    /**
     *
     * @return the price of a shake.
     * Although not asked for in the UML spec, this was included because it simplifies
     * the displaying of prices in the Views.  If this was not included the price would need
     * to be hardcoded into the Strings.xml and that would be no bueno.
     */
    public double getPriceShake() { return PRICE_SHAKE; }

    /**
     *
     * @return the price of a small drink.
     * Although not asked for in the UML spec, this was included because it simplifies
     * the displaying of prices in the Views.  If this was not included the price would need
     * to be hardcoded into the Strings.xml and that would be no bueno.
     */
    public double getPriceSmallDrink() { return PRICE_SMALL_DRINK; }

    /**
     *
     * @return the current sales tax in California.
     * Although not asked for in the UML spec, this was included because it simplifies
     * the displaying of prices in the Views.  If this was not included the tax would need
     * to be hardcoded into the Strings.xml and that would be no bueno.
     */
    public double getTaxRate() { return TAX_RATE; }

    /**
     *
     * @param cheeseBurgers is either the number of cheeseburgers the user enters or, if they did
     *                    not order any, the try-catch in the updateModel method of
     *                    OrderActivity, will set this to zero.
     */
    public void setCheeseBurgers(int cheeseBurgers) { mCheeseBurgers = cheeseBurgers; }

    /**
     *
     * @param doubleDoubles is either the number of double doubles the user enters or zero.
     *                      Zero would be added by the try-catch in the updateModel method
     *                      in the OrderActivity Controller.
     */
    public void setDoubleDoubles(int doubleDoubles) { mDoubleDoubles = doubleDoubles; }

    /**
     *
     * @param frenchFries is either the number of fries entered by the user, or zero if the
     *                    user did not enter any.
     */
    public void setFrenchFries(int frenchFries) { mFrenchFries = frenchFries; }

    /**
     *
     * @param largeDrinks is set to the number of large drinks ordered or zero
     *                    if none were provided.
     */
    public void setLargeDrinks(int largeDrinks) { mLargeDrinks = largeDrinks; }

    /**
     *
     * @param mediumDrinks is set to the number of medium drinks ordered or zero if none
     *                     were provided.
     */
    public void setMediumDrinks(int mediumDrinks) { mMediumDrinks = mediumDrinks; }

    /**
     *
     * @param shakes is set to the number of shakes ordered or zero if none were provided.
     */
    public void setShakes(int shakes) { mShakes = shakes; }

    /**
     *
     * @param smallDrinks is set to the number of small drinks ordered.  If none were provided,
     *                    then the try-catch in the updateModel method of the Controller
     *                    OrderActivity.java would set this to zero.
     */
    public void setSmallDrinks(int smallDrinks) { mSmallDrinks = smallDrinks; }
}
