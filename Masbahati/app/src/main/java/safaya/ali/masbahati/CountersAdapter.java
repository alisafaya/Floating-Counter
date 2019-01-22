package safaya.ali.masbahati;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.support.v7.widget.RecyclerView;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;


public class CountersAdapter extends BaseAdapter {

    public Context context; //context
    public ArrayList<Item> items; //data source of the list adapter
    public int selectedPosition = -1;
    public ArrayList<View> selectedViews;
    public ArrayList<Item> selectedItems;


    //public constructor
    public CountersAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
        this.selectedViews = new ArrayList<>();
        this.selectedItems = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.item, parent, false);
        }

        // get current item to be displayed
        Item currentItem = (Item) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.text_view_item_name);
        TextView textViewItemDescription = (TextView)
                convertView.findViewById(R.id.text_view_item_description);
        TextView textViewCounterValue = (TextView)
                convertView.findViewById(R.id.text_view_counter_value);
        final RadioButton radioButton = (RadioButton) convertView.findViewById(R.id.radio_button);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(currentItem.getItemName());
        textViewItemDescription.setText(currentItem.getItemDescription());
        textViewCounterValue.setText(currentItem.getItemValue());

        convertView.setTag(position);
        radioButton.setChecked(position == selectedPosition);
        radioButton.setTag(position);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPosition = (Integer)view.getTag();
                notifyDataSetChanged();
            }
        });

        final String Name = currentItem.itemName;

        convertView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, " تم اختيار " + Name , Toast.LENGTH_SHORT).show();
                        radioButton.callOnClick();
                    }
                }
        );

        convertView.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        if (selectedViews.contains(v)) {
                            v.setBackgroundColor(Color.WHITE);
                            selectedViews.remove(v);
                            selectedItems.remove( (Integer) v.getTag());

                        } else {
                            selectedViews.add(v);
                            selectedItems.add(items.get((Integer) v.getTag()));
                            v.setBackgroundColor(0xffd6d7d7);
                        }
                        return true;
                    }
                }
        );

        // returns the view for the current row
        return convertView;
    }

}
