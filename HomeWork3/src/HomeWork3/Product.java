package HomeWork3;

/**
 * Created by Sergey777s on 04.11.16.
 */
public class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;

    Product (String name, double price, int quantity,String category){

        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.category=category;
    }
    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getCategory(){
        return  category;
    }


}
