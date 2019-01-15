package safaya.ali.masbahati;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;

public class CounterList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_list);

        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton delete = (FloatingActionButton) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Setup the data source
        ArrayList<Item> itemsArrayList = new ArrayList<>(); // calls function to get items list

        itemsArrayList.add(new Item("الصلاو زسسيثق زشسيشس", "شسيشس منشتسينمشست شستنميىشسنميتمنس كمسيمكس سمنية"));
        itemsArrayList.add(new Item("الصلاو زسسيثق زشسيشس", "شسيشس منشتسينمشست شستنميىشسنميتمنس كمسيمكس سمنية"));
        itemsArrayList.add(new Item("شسينم ثتنمضص نمش", "نمشسم شتنمسةى شنمسشسنم منشسةي"));
        itemsArrayList.add(new Item("شسيث", "ضصثضص "));
        itemsArrayList.add(new Item("شسينم ثتنمضص نمش", "نمشسم شتنمسةى شنمسشسنم منشسةي"));
        itemsArrayList.add(new Item("شسيث", "ضصثضص "));
        itemsArrayList.add(new Item("الصلاو زسسيثق زشسيشس", "شسيشس منشتسينمشست شستنميىشسنميتمنس كمسيمكس سمنية"));
        itemsArrayList.add(new Item("الصلاو زسسيثق زشسيشس", "شسيشس منشتسينمشست شستنميىشسنميتمنس كمسيمكس سمنية"));
        itemsArrayList.add(new Item("شسينم ثتنمضص نمش", "نمشسم شتنمسةى شنمسشسنم منشسةي"));
        itemsArrayList.add(new Item("شسيث", "ضصثضص "));
        itemsArrayList.add(new Item("شسينم ثتنمضص نمش", "نمشسم شتنمسةى شنمسشسنم منشسةي"));
        itemsArrayList.add(new Item("شسيث", "ضصثضص "));

        // instantiate the custom list adapter
        CountersAdapter adapter = new CountersAdapter(this, itemsArrayList);

        // get the ListView and attach the adapter
        ListView itemsListView  = (ListView) findViewById(R.id.countersList);
        itemsListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_counter_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
