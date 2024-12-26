package Model;

public class Item {
    private String id;
    private String itemName;
    private int qty;
    private Double price;
    private String description;

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item(String id, String itemName, int qty, Double price, String description) {
        this.id = id;
        this.itemName = itemName;
        this.qty = qty;
        this.price = price;
        this.description = description;
    }

}
