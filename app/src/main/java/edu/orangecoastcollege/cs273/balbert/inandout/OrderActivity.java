package edu.orangecoastcollege.cs273.balbert.inandout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

/**
 * OrderActivity is the class that represents the "main" Controller of the In and Out app.
 *
 * All of the TextViews and EditTexts are initialized and connections established between
 * the activity_order.xml View and this OrderActivity Controller.
 *
 * A connection to the Model, Order.java, is established.
 *
 * The onCreate() method is called which sets the content view, connects the widgets,
 * and initializes the TextViews that have dynamic data associated with them.  I.e. if the
 * price of an item changes, the Model will update this Controller and then the appropriate
 * TextView will be altered.
 *
 * When the user is ready to place an order, they tap the Place Order Button.
 * This calls the placeOrder() method.
 * Inside placeOrder(), the updateModel() method is called, this sends the user's order details
 * to the Model for calculation.
 *
 * Once the Model has been updated, we package an Intent consisting of the user's Order object.
 * This Intent is sent via startActivity() to the next helper Activity called SummaryActivity,
 * where the user's order details will be displayed.
 */
public class OrderActivity extends AppCompatActivity {

    private TextView mDoubleDoubleTextView;
    private TextView mCheeseburgerTextView;
    private TextView mFrenchFriesTextView;
    private TextView mShakesTextView;
    private TextView mSmallDrinkTextView;
    private TextView mMediumDrinkTextView;
    private TextView mLargeDrinkTextView;

    private EditText mDoubleDoubleEditText;
    private EditText mCheeseburgerEditText;
    private EditText mFrenchFriesEditText;
    private EditText mShakesEditText;
    private EditText mSmallDrinkEditText;
    private EditText mMediumDrinkEditText;
    private EditText mLargeDrinkEditText;

    // Create connection to Model
    Order order = new Order();

    /**
     * onCreate() performs several functions.
     * 1) any previous state is recovered and displayed.
     * 2) the View is populated with the appropriate TextViews, EditTexts and Button.
     * 3) the widgets are wired up to the Controller.
     * 4) the dynamic data associated with the TextView widgets, such as the prices
     *    of the items, is retrieved from the Model and populated.
     *
     * @param savedInstanceState contains the details of the state of the app when the user
     *                           sent it to the background, when the app is resumed.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        connectWidgets();
        initializeView();
    }

    private void initializeView() {
        mDoubleDoubleTextView.setText(String.format(Locale.getDefault(), "%s $%.2f", getString(R.string.double_double), order.getPriceDoubleDouble()));
        mCheeseburgerTextView.setText(String.format(Locale.getDefault(), "%s $%.2f", getString(R.string.cheeseburger),  order.getPriceCheeseburger()));;
        mFrenchFriesTextView .setText(String.format(Locale.getDefault(), "%s $%.2f", getString(R.string.french_fries),  order.getPriceFrenchFries()));;
        mShakesTextView      .setText(String.format(Locale.getDefault(), "%s $%.2f", getString(R.string.shakes),        order.getPriceShake()));;
        mSmallDrinkTextView  .setText(String.format(Locale.getDefault(), "%s $%.2f", getString(R.string.small_drink),   order.getPriceSmallDrink()));;
        mMediumDrinkTextView .setText(String.format(Locale.getDefault(), "%s $%.2f", getString(R.string.medium_drink),  order.getPriceMediumDrink()));;
        mLargeDrinkTextView  .setText(String.format(Locale.getDefault(), "%s $%.2f", getString(R.string.large_drink),   order.getPriceLargeDrink()));;
    }

    // Create connection to View's various widgets
    private void connectWidgets() {

        mDoubleDoubleTextView = (TextView) findViewById(R.id.doubleDoubleTextView);
        mCheeseburgerTextView = (TextView) findViewById(R.id.cheeseBurgerTextView);
        mFrenchFriesTextView  = (TextView) findViewById(R.id.frenchFriesTextView);
        mShakesTextView       = (TextView) findViewById(R.id.shakesTextView);
        mSmallDrinkTextView   = (TextView) findViewById(R.id.smallDrinkTextView);
        mMediumDrinkTextView  = (TextView) findViewById(R.id.mediumDrinkTextView);
        mLargeDrinkTextView   = (TextView) findViewById(R.id.largeDrinkTextView);

        mDoubleDoubleEditText = (EditText) findViewById(R.id.doubleDoubleEditText);
        mCheeseburgerEditText = (EditText) findViewById(R.id.cheeseBurgerEditText);
        mFrenchFriesEditText  = (EditText) findViewById(R.id.frenchFriesEditText);
        mShakesEditText       = (EditText) findViewById(R.id.shakesEditText);
        mSmallDrinkEditText   = (EditText) findViewById(R.id.smallDrinkEditText);
        mMediumDrinkEditText  = (EditText) findViewById(R.id.mediumDrinkEditText);
        mLargeDrinkEditText   = (EditText) findViewById(R.id.largeDrinkEditText);
    }

    private void updateModel() {

        try { order.setCheeseBurgers(Integer.parseInt(mCheeseburgerEditText.getText().toString())); } catch (NumberFormatException nfe) { order.setCheeseBurgers(0); }
        try { order.setDoubleDoubles(Integer.parseInt(mDoubleDoubleEditText.getText().toString())); } catch (NumberFormatException nfe) { order.setDoubleDoubles(0); }
        try { order.setFrenchFries(  Integer.parseInt(mFrenchFriesEditText .getText().toString())); } catch (NumberFormatException nfe) { order.setFrenchFries(0); }
        try { order.setLargeDrinks(  Integer.parseInt(mLargeDrinkEditText  .getText().toString())); } catch (NumberFormatException nfe) { order.setLargeDrinks(0); }
        try { order.setMediumDrinks( Integer.parseInt(mMediumDrinkEditText .getText().toString())); } catch (NumberFormatException nfe) { order.setMediumDrinks(0); }
        try { order.setShakes(       Integer.parseInt(mShakesEditText      .getText().toString())); } catch (NumberFormatException nfe) { order.setShakes(0); }
        try { order.setSmallDrinks(  Integer.parseInt(mSmallDrinkEditText  .getText().toString())); } catch (NumberFormatException nfe) { order.setSmallDrinks(0); }
    }

    /**
     * placeOrder() is called when the user taps the Place Order button.
     *
     * Once called, this function updates the Model with the user's order details.
     *
     * Next, an Intent is created that will allow the user's order details to be sent to
     * the helper Activity, SummaryActivity.
     *
     * In the Intent we place the user's Order object.
     * We had to be sure to extend serializable in the Model, Order.
     * This was so we could send an object via the Intent.
     *
     * startActivity() is called and passed the Intent.
     *
     * @param view is the Place Order Button the user taps when they are ready to place
     *             an order and see their order details.
     */
    protected void placeOrder(View view) {

        updateModel();

        Intent orderIntent = new Intent(this, SummaryActivity.class);
        orderIntent.putExtra("order", order);
        startActivity(orderIntent);
    }
}
