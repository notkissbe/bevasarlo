package hu.notkissbe.bevasarlo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ListAdapter extends BaseAdapter {
    private final Context context;
    ArrayList<String> items;
    ArrayList<String> amounts;
    LayoutInflater inflater;


    public ListAdapter(Context context, ArrayList<String> items, ArrayList<String> amounts) {
        this.context = context;
        this.items = items;
        this.amounts = amounts;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return amounts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.items_list_item, parent, false);
        }
        TextView itemNev = convertView.findViewById(R.id.itemNev);
        TextView itemSzam = convertView.findViewById(R.id.itemSzam);
        itemNev.setText(items.get(position));
        itemSzam.setText(amounts.get(position));
        return convertView;
    }
    public void removeItem(int position) {
        items.remove(position);
        amounts.remove(position);
        notifyDataSetChanged();
    }
}
