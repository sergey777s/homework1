package HomeWork3;

/**
 * Created by Sergey777s on 06.11.16.
 */
interface InventoryMust {
    void add(Product product);

    double getCostByCategory(String category);

    double printAll();
}