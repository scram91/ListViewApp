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

    public InformationListAdapter(Context context, ArrayList<ItemInformation> itemInformation) {
        super(context, 0, itemInformation);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ItemInformation itemInformation = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_info, parent, false);
        }


        TextView textViewID = convertView.findViewById(R.id.textview_item_id);
        TextView textViewCredits = convertView.findViewById(R.id.textview_item_credits);
        TextView textViewDescription = convertView.findViewById(R.id.textview_item_description);

        if (textViewID != null) {
            textViewID.setText(String.valueOf(itemInformation.getID()));
        }
        if (textViewCredits != null) {
            textViewCredits.setText(String.valueOf(itemInformation.getCredits()));
        }
        if (textViewDescription != null) {
            textViewDescription.setText(itemInformation.getDescription());
        }

        return convertView;
    }
}
