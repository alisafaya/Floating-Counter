package safaya.ali.masbahati;

import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.RadioButton;
import java.util.ArrayList;


public class CountersAdapter extends BaseAdapter {

    private Context context; //context
    private ArrayList<Item> items; //data source of the list adapter
    private int selectedPosition = -1;


    //public constructor
    public CountersAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;

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
    public View getView(int position, View convertView, ViewGroup parent) {
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
        RadioButton radioButton = (RadioButton) convertView.findViewById(R.id.radio_button);

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

        // returns the view for the current row
        return convertView;
    }
}
