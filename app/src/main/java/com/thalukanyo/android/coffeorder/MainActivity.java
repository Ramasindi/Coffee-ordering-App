/**
 * IMPORTANT: Make sure you are using the correct package name.
 * <p>
 * This example uses the package name:
 * <p>
 * package com.example.android.justjava
 * <p>
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * <p>
 * in the project's AndroidManifest.xml file.
 **/
package com.thalukanyo.android.coffeorder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 1;

    public void submitOrder(View view) throws UnsupportedEncodingException {
        EditText userInput = findViewById(R.id.editname_text_view);
        String userName = userInput.getText().toString();
        EditText userNumber = findViewById(R.id.editnumber_text_view);
        String userInputNo = "+27 ";
        userInputNo += userNumber.getText().toString();
        CheckBox whippedCheckBox = findViewById(R.id.whipped_cream_checkBox);
        boolean hasWhippedCream = whippedCheckBox.isChecked();
        CheckBox chocolate = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolate.isChecked();
        int price = calculatePrice(hasWhippedCream, hasChocolate);

        String summary = createOrderSummary(price, hasWhippedCream, hasChocolate, userName);


        //Intent intent = new Intent(Intent.ACTION_SENDTO);
        //intent.setData(Uri.parse("mailto:"));
        //intent.putExtra(Intent.EXTRA_SUBJECT,"Coffee order for " + userName);

        String url = "https://api.whatsapp.com/send?phone=%d" + userInputNo + "&text=" + URLEncoder.encode(summary, "UTF-8");
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));


        startActivity(i);
        //intent.putExtra(Intent.EXTRA_TEXT,summary);
        //if (intent.resolveActivity(getPackageManager()) != null);{
        // startActivity(intent);
        //}


    }

    //createOrderSummary method
    public String createOrderSummary(int price, boolean whippedCream, boolean chocolate, String name) {
        return "Name: " + name + "\nAdd whipped cream? " + whippedCream +
                "\nAdd chocolate? " + chocolate + "\nQuantity: " + quantity + "\nTotal:R" + price + "\n" + getString(R.string.thank_you);
    }

    /**
     * This method is for incrementing
     * <p>
     * Intent intent = new Intent(Intent.ACTION_SENDTO);
     * intent.setData(Uri.parse("mailto:"));
     * intent.putExtra(Intent.EXTRA_SUBJECT,"Coffee order for " + userName);
     * <p>
     * intent.putExtra(Intent.EXTRA_TEXT,summary);
     * if (intent.resolveActivity(getPackageManager()) != null);{
     * startActivity(intent);
     * }
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "We can not serve more than hundred coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity += 1;
        displayQuantity(quantity);
    }

    /**
     * This method is for decrementing
     */

    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "You can not have less than one coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity -= 1;
        displayQuantity(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Calculates the price of the order.
     */

    private int calculatePrice(boolean whippedCream, boolean chocolate) {
        int price = quantity * 5;
        if (whippedCream) {
            price = price + 1 * quantity;
        }
        if (chocolate) {
            price = price + 2 * quantity;
        }
        return price;
    }
    /**
     * This method displays the given text on the screen.

     */


}
