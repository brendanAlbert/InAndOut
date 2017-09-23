package edu.orangecoastcollege.cs273.balbert.inandout;

/**
 * Created by brendantyleralbert on 9/23/17.
 */

public class Order {
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

    public Order() {
        mCheeseBurgers = 0;
        mDoubleDoubles = 0;
        mFrenchFries   = 0;
        mLargeDrinks   = 0;
        mMediumDrinks  = 0;
        mShakes        = 0;
        mSmallDrinks   = 0;
    }

    public double calculateSubtotal() {
        return    PRICE_CHEESEBURGER  * mCheeseBurgers
                + PRICE_DOUBLE_DOUBLE * mDoubleDoubles
                + PRICE_FRENCH_FRIES  * mFrenchFries
                + PRICE_LARGE_DRINK   * mLargeDrinks
                + PRICE_MEDIUM_DRINK  * mMediumDrinks
                + PRICE_SHAKE         * mShakes
                + PRICE_SMALL_DRINK   * mSmallDrinks;
    }

    public double calculateTax() { return calculateSubtotal() * TAX_RATE; }

    public double calculateTotal() { return calculateSubtotal() + calculateTax(); }

    public int getNumberItemsOrdered() {
        return  mCheeseBurgers +
                mDoubleDoubles +
                mFrenchFries +
                mLargeDrinks +
                mMediumDrinks +
                mShakes +
                mSmallDrinks;
    }

    public int getCheeseBurgers() { return mCheeseBurgers; }

    public int getDoubleDoubles() { return mDoubleDoubles; }

    public int getFrenchFries() { return mFrenchFries; }

    public int getLargeDrinks() { return mLargeDrinks; }

    public int getShakes() { return mShakes; }

    public int getMediumDrinks() { return mMediumDrinks; }

    public int getSmallDrinks() { return mSmallDrinks; }

    public void setCheeseBurgers(int cheeseBurgers) { mCheeseBurgers = cheeseBurgers; }

    public void setDoubleDoubles(int doubleDoubles) { mDoubleDoubles = doubleDoubles; }

    public void setFrenchFries(int frenchFries) { mFrenchFries = frenchFries; }

    public void setLargeDrinks(int largeDrinks) { mLargeDrinks = largeDrinks; }

    public void setMediumDrinks(int mediumDrinks) { mMediumDrinks = mediumDrinks; }

    public void setShakes(int shakes) { mShakes = shakes; }

    public void setSmallDrinks(int smallDrinks) { mSmallDrinks = smallDrinks; }
}
