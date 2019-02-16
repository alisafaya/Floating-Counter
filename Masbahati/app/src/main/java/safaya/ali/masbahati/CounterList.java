package safaya.ali.masbahati;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class CounterList extends AppCompatActivity {

    private static final int CODE_DRAW_OVER_OTHER_APP_PERMISSION = 2084;
    CountersAdapter adapter;
    ListView itemsListView;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_list);

        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompts, null);

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                final TextView label = (TextView) promptsView.findViewById(R.id.promptTextView);
                label.setText("ادخل اسم العداد");


                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("حفظ",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text

                                        if (userInput.getText().toString().isEmpty()){
                                            Toast.makeText(context,"لا يمكن إضافة فارغ", Toast.LENGTH_SHORT).show();
                                            return;
                                        }

                                        final Item item = new Item( userInput.getText().toString(), "");
                                        LayoutInflater li = LayoutInflater.from(context);
                                        View promptsView2 = li.inflate(R.layout.prompts, null);

                                        final AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(
                                                context);

                                        // set prompts.xml to alertdialog builder
                                        alertDialogBuilder2.setView(promptsView2);

                                        final EditText userInput2 = (EditText) promptsView2
                                                .findViewById(R.id.editTextDialogUserInput);

                                        final TextView label = (TextView) promptsView2.findViewById(R.id.promptTextView);
                                        label.setText("ادخل صيغة التسبيح (اختياري)");
                                        userInput.setText("");
                                        // set dialog message


                                        alertDialogBuilder2
                                                .setCancelable(false)
                                                .setPositiveButton("حفظ",
                                                        new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog,int id) {
                                                                // get user input and set it to result
                                                                // edit text
                                                                item.itemDescription = userInput2.getText().toString();
                                                                adapter.items.add(item);
                                                                adapter.notifyDataSetChanged();
                                                            }
                                                        })
                                                .setNegativeButton("إلغاء",
                                                        new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog,int id) {
                                                                dialog.cancel();
                                                            }
                                                        });

                                        // create alert dialog
                                        AlertDialog alertDialog = alertDialogBuilder2.create();

                                        // show it
                                        alertDialog.show();
                                    }
                                })
                        .setNegativeButton("إلغاء",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });

        FloatingActionButton delete = (FloatingActionButton) findViewById(R.id.delete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adapter.selectedItems.isEmpty()) {
                    Snackbar.make(view, "اضغط مطولا لاختيار ما سيتم حذفه", Snackbar.LENGTH_LONG)
                            .setAction("إزالة", null).show();
                    return;
                }
                //Delete selected rows
                for (Item item : adapter.selectedItems){
                    adapter.items.remove(item);
                }

                for (View v : adapter.selectedViews){
                    v.setBackgroundColor(Color.WHITE);
                }
                adapter.notifyDataSetChanged();
                adapter.selectedViews.clear();
                adapter.selectedItems.clear();
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
        this.adapter = new CountersAdapter(this, itemsArrayList);

        // get the ListView and attach the adapter
        this.itemsListView  = (ListView) findViewById(R.id.countersList);
        itemsListView.setAdapter(this.adapter);

        /*

        Check if the application has draw over other apps permission or not?
        This permission is by default available for API<23. But for API > 23
        you have to ask for the permission in runtime.

        */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {


            //If the draw over permission is not available open the settings screen
            //to grant the permission.
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, CODE_DRAW_OVER_OTHER_APP_PERMISSION);
        } else {
            initializeView();
        }

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

    /**
     * Set and initialize the view elements.
     */
    private void initializeView() {
        findViewById(R.id.start_floating_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(CounterList.this, FloatingViewService.class));
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODE_DRAW_OVER_OTHER_APP_PERMISSION) {
            //Check if the permission is granted or not.
            if (resultCode == RESULT_OK) {
                initializeView();
            } else { //Permission is not available
                Toast.makeText(this,
                        "Draw over other app permission not available. Closing the application",
                        Toast.LENGTH_SHORT).show();

                finish();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
