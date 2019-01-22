package safaya.ali.masbahati;

public class Item {

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
