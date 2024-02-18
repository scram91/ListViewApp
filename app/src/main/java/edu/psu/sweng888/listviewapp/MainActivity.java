package edu.psu.sweng888.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //initialize mListView
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initiailize an Array List of the item data models
        ArrayList<ItemInformation> itemList = new ArrayList<ItemInformation>();
        itemList = loadItemData();
        //create the custom adapter
        InformationListAdapter adapter = new InformationListAdapter(MainActivity.this, itemList);
        //set the listview to the ListView defined in layouts
        mListView = findViewById(R.id.listview_items);
        mListView.setAdapter(adapter);

        //Item click listener. When an item is click create an intent to start the second activity and pass the selected list item to the intent
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemInformation selectedItem = (ItemInformation) mListView.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, InformationViewActivity.class);
                intent.putExtra("selected_item", selectedItem);
                startActivity(intent);
            }
        });
    }

    /**
     *Create the data models for the list view
     * Currently only three items but can be expanded
     * @return item
     */
    private ArrayList<ItemInformation> loadItemData() {
        ArrayList<ItemInformation> item = new ArrayList<>();

        item.add(new ItemInformation("SWENG888",
                "Everton Guimares",
                    "Mobile App Development",
                "Learning to create mobile applications on the Android operating system"));
        item.add(new ItemInformation("SWENG586",
                "Phillip Laplante",
                    "Requirements Engineering",
                "Learn to extract requirements from stakeholders and create requirements documentation"));
        item.add(new ItemInformation("SWENG581",
                "Joanna DeFranco",
                    "Software Project Management",
                "Concepts regarding the management of software projects."));

        return item;
    }
    //On return to MainActivity unpack the intent
    //If returnFromInformation is true show the snackbar
    @Override
    protected void onResume() {
        super.onResume();

        boolean returnFromInformation = getIntent().getBooleanExtra("RETURN", false);
        String val = getIntent().getStringExtra("Item");

        if (returnFromInformation) {
            showSnackbar("Returned from " + val);
        }
    }

    //mthod to show snackbar
    private void showSnackbar(String snackbarMessage) {
        Snackbar.make(mListView, snackbarMessage, Snackbar.LENGTH_SHORT).show();
    }
}