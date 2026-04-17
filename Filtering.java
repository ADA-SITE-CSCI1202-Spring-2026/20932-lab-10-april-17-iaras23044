import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filtering{
    static class Product{
        String name;
        double price;
        boolean inStock;

        public Product(String name, double price, boolean inStock){
            this.name = name;
            this.price = price;
            this.inStock = inStock;
        }

        @Override
        public String toString(){
            return name + ", " + price + "$" + ", " + (inStock ? "In Stock" : "Out of Stock");
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Bread", 30, true));
        products.add(new Product("Milk", 25, true));
        products.add(new Product("Butter", 45, false));
        products.add(new Product("Honey", 40, true));
        products.add(new Product("Cheese", 120, true));

         Predicate<Product> isAffordable = p -> p.price < 50 && p.inStock;

         products.removeIf(p -> !isAffordable.test(p));

         System.out.println("The remaining items: ");
         for(Product p : products){
            System.out.println(p);
         }

    }
}