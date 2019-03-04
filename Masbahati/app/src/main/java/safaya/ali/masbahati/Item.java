package safaya.ali.masbahati;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable {

    public static class ItemsToSave {
        public static ArrayList<Item> items = null;
        public static Item currentItem = null;
    }

    public static ArrayList<Item> getItemsToSave(Context context) {
        if (ItemsToSave.items == null) {
            try {

                FileInputStream itemsDir = context.openFileInput("items");
                ObjectInputStream objIn = new ObjectInputStream(itemsDir);
                ItemsToSave.items = (ArrayList<Item>) objIn.readObject();
                objIn.close();
                itemsDir.close();
            } catch(IOException | ClassNotFoundException e) {
                ItemsToSave.items = new ArrayList<>();
                Item.getItemsToSave(context).add(new Item("صلوات", "اللهم صلي على سيدنا محمد النبي الأمي العلي القدر العظيم الجاه و على آله وصحبه وسلم"));
                Item.getItemsToSave(context).add(new Item("لا إله إلا الله", ""));
            }

            try {

                FileInputStream currentItemDir = context.openFileInput("currentItem");
                ObjectInputStream objIn = new ObjectInputStream(currentItemDir);
                ItemsToSave.currentItem = (Item) objIn.readObject();
                objIn.close();
                currentItemDir.close();
            } catch(IOException | ClassNotFoundException e) {
                ItemsToSave.currentItem = null;
            }

        }
        return ItemsToSave.items;
    }

    public static Item getCurrentItem(Context context){
        getItemsToSave(context);
        return ItemsToSave.currentItem;
    }

    public static void saveItems(Context context){
        try {
            FileOutputStream outputStream = context.openFileOutput("items", Context.MODE_PRIVATE);
            ObjectOutputStream objOut = new ObjectOutputStream(outputStream);
            objOut.writeObject(ItemsToSave.items);
            objOut.close();
            outputStream.close();
        } catch(IOException e) {
            ItemsToSave.items = new ArrayList<>();
        }

        try {
            FileOutputStream outputStream = context.openFileOutput("currentItem", Context.MODE_PRIVATE);
            ObjectOutputStream objOut = new ObjectOutputStream(outputStream);
            objOut.writeObject(ItemsToSave.currentItem);
            objOut.close();
            outputStream.close();
        } catch(IOException e) {
            ItemsToSave.currentItem = null;
        }
    }


    public String itemName;
    public String itemDescription;
    public int itemValue;

    public Item(String name, String description) {
        this.itemName = name;
        this.itemDescription = description;
        this.itemValue = 0;
    }


    public String getItemName() {
        return this.itemName;
    }

    public String getItemDescription() {
        return this.itemDescription;
    }

    public String getItemValue(){
        return String.valueOf(this.itemValue);
    }

    public void increase(){
        this.itemValue++;
    }

    public void reset() {
        this.itemValue =0;
    }
}
