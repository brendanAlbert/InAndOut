package edu.orangecoastcollege.cs273.balbert.inandout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class OrderActivity extends AppCompatActivity {

    EditText mDoubleDoubleEditText;
    EditText mCheeseburgerEditText;
    EditText mFrenchFriesEditText;
    EditText mShakesEditText;
    EditText mSmallDrinkEditText;
    EditText mMediumDrinkEditText;
    EditText mLargeDrinkEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        connectWidgets();
    }

    private void connectWidgets() {
        mDoubleDoubleEditText = (EditText) findViewById(R.id.doubleDoubleEditText);
        mCheeseburgerEditText = (EditText) findViewById(R.id.cheeseBurgerEditText);
        mFrenchFriesEditText  = (EditText) findViewById(R.id.frenchFriesEditText);
        mShakesEditText  = (EditText) findViewById(R.id.shakesEditText);
        mSmallDrinkEditText  = (EditText) findViewById(R.id.smallDrinkEditText);
        mMediumDrinkEditText  = (EditText) findViewById(R.id.mediumDrinkEditText);
        mLargeDrinkEditText  = (EditText) findViewById(R.id.largeDrinkEditText);
    }

    private void placeOrder(View view) {

    }
}
