package HomeWork3;
/**
 * Created by Sergey777s on 04.11.16.
 */

import HomeWork3.Product;

import java.util.Map;
import java.util.TreeMap;
interface InventoryInterface{
    void add(Product product);
    void printAllinCategory(String category);
    void printAll();
}


public class Inventory implements InventoryInterface{
    private Map<String,Double> productPrices=new TreeMap<>();
    private Map<String,Integer> productQuantitys=new TreeMap<>();
    private Map<String,String> productCategorys=new TreeMap<>();

    public Map<String,Double> getMapPrices(){
        return productPrices;
    }
    public Map<String,Integer> getMapQuanitis(){
        return productQuantitys;
    }
    public Map<String,String> getMapCategorys(){
        return productCategorys;
    }
    public void add (Product product){
        if(productPrices.containsKey(product.getName())){
            productPrices.put(product.getName(),product.getPrice());
            productQuantitys.put(product.getName(),product.getQuantity()+productQuantitys.get(product.getName()));
            productCategorys.put(product.getName(), product.getCategory());
        }else {
            productPrices.put(product.getName(), product.getPrice());
            productQuantitys.put(product.getName(), product.getQuantity());
            productCategorys.put(product.getName(), product.getCategory());
        }
    }
    public void printAllinCategory(String category){
        String name;
        double price;
        int quantity;
        double totalCost=0;

        System.out.println("All products in category "+category+":");
        for(Map.Entry<String,String> e : productCategorys.entrySet()){
            name=e.getKey();
            price=productPrices.get(name);
            quantity=productQuantitys.get(name);
            if(e.getValue().equals(category)) {
                System.out.println("Name = " + name + " price: " + price + " quantity on hand:" + quantity);
                totalCost = totalCost + price*quantity;
            }
        }
        System.out.println("Total cost: "+totalCost);
    }

    public void printAll(){
        String name;
        String category;
        double price;
        int quantity;
        double totalCost=0;
        System.out.println("All products in database: ");
        for(Map.Entry<String,String> e : productCategorys.entrySet()){
            name=e.getKey();
            price=productPrices.get(name);
            quantity=productQuantitys.get(name);
            category=productCategorys.get(name);
            System.out.println("Name = " + name + " price: " + price + " quantity on hand:" + quantity+ " category: "+category);
            totalCost = totalCost + price*quantity;
        }
        System.out.println("Total cost: "+totalCost);
    }
}
