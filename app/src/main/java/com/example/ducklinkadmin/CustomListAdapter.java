package com.example.ducklinkadmin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private ArrayList<String> mUserList;

    public CustomListAdapter(Context context, ArrayList<String> userList) {
        super(context, 0, userList);
        mContext = context;
        mUserList = userList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        }

        String currentUser = mUserList.get(position);

        TextView personName = listItem.findViewById(R.id.personName);
        personName.setText(currentUser);

        // If you have additional TextViews in your list item layout, you can bind them here

        return listItem;
    }
}
