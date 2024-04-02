package Model;


public class Item {
    private int id;
    private String name;
    private int quantity;

    public Item(int id, String name, int quantity)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Item(){}

    @Override
    public String toString()
    {
        return String.valueOf(id) + ";" + name + ";" + String.valueOf(quantity) + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
    
    
}
