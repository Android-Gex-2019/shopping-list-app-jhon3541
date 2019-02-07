/**
 * @file
 * @author Jhon Romero
 * @version 1.0
 *
 *
 * @section DESCRIPTION
 * Shopping List Assignment
 *
 *
 * @section LICENSE
 *
 *
 * Copyright 2019
 * Permission to use, copy, modify, and/or distribute this software for
 * any purpose with or without fee is hereby granted, provided that the
 * above copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 *
 * @section Academic Integrity
 * I certify that this work is solely my own and complies with
 * NBCC Academic Integrity Policy (policy 1111)
 */

package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    public static final int TEXT_REQUEST = 1;


    ShoppingList shoppingList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shoppingList=new ShoppingList();

        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            if (savedInstanceState != null) {

                //delete text views
                shoppingList=(ShoppingList)savedInstanceState.getSerializable(SecondActivity.EXTRA_ITEM);
                //refill Shopping list
                fillShoppingList();
            }
        }

    }

    /**
     * Launch second activity
     * @param view
     */
    public void launchSecondActivity(View view) {

        Intent intent = new Intent(this, SecondActivity.class);

        startActivityForResult(intent, TEXT_REQUEST);

    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {

                String item = data.getStringExtra(SecondActivity.EXTRA_ITEM);

                shoppingList.addItem(item);

                fillShoppingList();


            }
        }
    }

    /**
     * Method that clears the linear layout containing the shopping list information and
     * add text view elements for each item in the shopping list
     */
    public void fillShoppingList()
    {

        LinearLayout shoppingLayout= (LinearLayout) findViewById(R.id.shopping_list_layout);
        shoppingLayout.removeAllViews();
        Map<String, Integer> shoppingMapCopy = shoppingList.getShoppingMap();
        for (String key : shoppingMapCopy.keySet()) {
            TextView text = new TextView(this);
            text.setText(shoppingList.getItemCount(key));
            text.setTextSize(40);
            text.setGravity(Gravity.CENTER);
            text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            shoppingLayout.addView(text);
        }


    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save shopping list map
        if(shoppingList!=null) {
            outState.putSerializable(SecondActivity.EXTRA_ITEM, shoppingList);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}
