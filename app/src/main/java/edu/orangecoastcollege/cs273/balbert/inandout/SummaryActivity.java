package edu.orangecoastcollege.cs273.balbert.inandout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

/**
 * SummaryActivity.java is the second Controller of our In and Out app.
 *
 * This Controller manages connections to the activity_summary.xml View where the user can
 * review the details of their order.
 *
 * In this Controller we initialize and connect our TextView widgets to the View.
 * One of the functions of this class is receiveIntent, it does what it says.
 * We receive the Order object which has been sent as an Intent from OrderActivity.
 * This object is used to populate the various Total, Subtotal, Items Ordered and Tax TextViews.
 *
 * When the user is done, or wants to place another order they may tap the Start New Order button.
 * This calls the startNewOrder method which calls finish().
 * Finish() cleans up memory and sends the user back to the activity_order.xml View.
 */
public class SummaryActivity extends AppCompatActivity {

    private TextView orderTotalTextView;
    private TextView itemsOrderedTextView;
    private TextView subtotalTextView;
    private TextView taxTextView;

    /**
     * onCreate() is where the TextViews of activity_summary get initialized.
     * Then, receiveIntent is called to receive the Intent from the first controller,
     * OrderActivity.  This Intent is an Order object representing the details of the user's order.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        orderTotalTextView   = (TextView) findViewById(R.id.orderTotalTextView);
        itemsOrderedTextView = (TextView) findViewById(R.id.itemsOrderedTextView);
        subtotalTextView     = (TextView) findViewById(R.id.subtotalTextView);
        taxTextView          = (TextView) findViewById(R.id.taxTextView);

        receiveIntent();
    }

    /**
     * receiveIntent is called to receive the user's Order object.  This object is then passed
     * to populateTextViews() so that the TextViews can be set up with the details of the user's
     * order.
     */
    protected void receiveIntent() {
        Intent intent = getIntent();
        Order orderObject = (Order) intent.getSerializableExtra("order");

        populateTextViews(orderObject);
    }

    private void populateTextViews(Order order) {
        orderTotalTextView  .setText(String.format(Locale.getDefault(),"%s $%.2f",           getString(R.string.order_total),                     order.calculateTotal()));
        itemsOrderedTextView.setText(String.format(Locale.getDefault(),"%s: %s",             getString(R.string.items_ordered),                   order.getNumberItemsOrdered()));
        subtotalTextView    .setText(String.format(Locale.getDefault(),"%s: $%.2f",          getString(R.string.subtotal),                        order.calculateSubtotal()));
        taxTextView         .setText(String.format(Locale.getDefault(),"%s (%.0f%%): $%.2f", getString(R.string.tax),(order.getTaxRate() * 100),  order.calculateTax()));
    }

    /**
     * startNewOrder() calls the finish() method when the user taps the Start New Order Button.
     * This will clean up any memory associated with this Activity and sends them back to
     * the previous Activity, OrderActivity.
     *
     * @param view represents the Button that the user taps, Start New Order.
     *             Doing so the user can return to the previous Activity to enter
     *             new data and create another order.
     *
     */
    protected void startNewOrder(View view) { finish(); }
}
