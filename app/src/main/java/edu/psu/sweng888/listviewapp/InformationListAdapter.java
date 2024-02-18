package edu.psu.sweng888.listviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class InformationListAdapter extends ArrayAdapter<ItemInformation> {
    //constructor
    public InformationListAdapter(Context context, ArrayList<ItemInformation> itemInformation) {
        super(context, 0, itemInformation);
    }

    //inflating view for the ListView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ItemInformation itemInformation = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_info, parent, false);
        }


        TextView textViewID = convertView.findViewById(R.id.item_id);
        TextView textViewCredits = convertView.findViewById(R.id.textview_item_professor);
        TextView textViewDescription = convertView.findViewById(R.id.textview_item_description);
        TextView textViewTitle = convertView.findViewById(R.id.item_title);

        if (textViewID != null) {
            textViewID.setText(String.valueOf(itemInformation.getID()));
        }
        if (textViewCredits != null) {
            textViewCredits.setText(String.valueOf(itemInformation.getProfessor()));
        }
        if (textViewDescription != null) {
            textViewDescription.setText(itemInformation.getDescription());
        }
        if (textViewTitle != null) {
            textViewTitle.setText(itemInformation.getTitle());
        }
        //return our inflated view
        return convertView;
    }
}
