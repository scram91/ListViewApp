package edu.psu.sweng888.listviewapp;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class InformationViewActivity extends MainActivity{

    private TextView mTextViewId;
    private TextView mTextViewCredits;
    private TextView mTextViewDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_view_activity);

        ItemInformation item = (ItemInformation) getIntent().getSerializableExtra("selectedItem");

        mTextViewId = findViewById(R.id.textview_item_id);
        mTextViewCredits = findViewById(R.id.textview_item_credits);
        mTextViewDesc = findViewById(R.id.textview_item_description);

       // mTextViewId.setText(String.valueOf(item.getID()));
     //   mTextViewCredits.setText(String.valueOf(item.getCredits()));
      //  mTextViewDesc.setText(String.valueOf(item.getDescription()));
    }
}
