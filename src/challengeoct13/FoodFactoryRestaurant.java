package challengeoct13;

import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;
abstract class Cuisine {
    public abstract Cuisine serveFood(String dish);
}

class UnservableCuisineRequestException extends Exception {
    public UnservableCuisineRequestException(String message) {
        super(message);
    }
}


/*
 * Create the FoodFactory class and other required classes here.
 */

class FoodFactory {
    
    Map<String, Cuisine> cusineMap = new HashMap<String, Cuisine>();
    static FoodFactory factory = new FoodFactory();
     public static FoodFactory getFactory() {
        return factory;
    }
    
    public void registerCuisine(String cuisineKey, Cuisine  cuisine) {
        cusineMap.put(cuisineKey, cuisine);
    }
    public Cuisine serveCuisine(String cuisineKey, String dish) throws UnservableCuisineRequestException{
        if (cusineMap.containsKey(cuisineKey)) {
            return cusineMap.get(cuisineKey).serveFood(dish);
        } else {
            throw new UnservableCuisineRequestException("Unservable Cuisine " + cuisineKey + " for dish " + dish);
        }
    }
}

class Chinese extends Cuisine {
    private String dish;
    
    public void setDish(String dish) {
       this.dish = dish;
    }
    public String getDish() {
        return dish;
    }
    public Cuisine serveFood(String dish){
        setDish(dish);
        return this;
    }
} 

class Italian extends Cuisine {
    
     private String dish;
    
    public void setDish(String dish) {
       this.dish = dish;
    }
    public String getDish() {
        return dish;
    }
    
    public Cuisine serveFood(String dish){
        setDish(dish);
        return this;
    }
}

class Japanese extends Cuisine {
    
     private String dish;
    
    public void setDish(String dish) {
       this.dish = dish;
    }
    public String getDish() {
        return dish;
    }
    
    public Cuisine serveFood(String dish){
        setDish(dish);
        return this;
    }
}

class Mexican extends Cuisine {
    
     private String dish;
    
    public void setDish(String dish) {
       this.dish = dish;
    }
    public String getDish() {
        return dish;
    }
    
    public Cuisine serveFood(String dish){
        setDish(dish);
        return this;
    }
}

public class FoodFactoryRestaurant {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final FoodFactory FOOD_FACTORY = FoodFactory.getFactory();
    
    static {
        FoodFactory.getFactory().registerCuisine("Chinese", new Chinese());
        FoodFactory.getFactory().registerCuisine("Italian", new Italian());
        FoodFactory.getFactory().registerCuisine("Japanese", new Japanese());
        FoodFactory.getFactory().registerCuisine("Mexican", new Mexican());
    }
    
    public static void main(String[] args) {
        int totalNumberOfOrders = Integer.parseInt(INPUT_READER.nextLine());
        while (totalNumberOfOrders-- > 0) {
            String[] food = INPUT_READER.nextLine().split(" ");
            String cuisine = food[0];
            String dish = food[1];

            try {
                if (FOOD_FACTORY.equals(FoodFactory.getFactory())) {
                    Cuisine servedFood = FOOD_FACTORY.serveCuisine(cuisine, dish);

                    switch (cuisine) {
                        case "Chinese":
                            Chinese chineseDish = (Chinese) servedFood;
                            System.out.println("Serving " + chineseDish.getDish() + "(Chinese)");
                            break;
                        case "Italian":
                            Italian italianDish = (Italian) servedFood;
                            System.out.println("Serving " + italianDish.getDish() + "(Italian)");
                            break;
                        case "Japanese":
                            Japanese japaneseDish = (Japanese) servedFood;
                            System.out.println("Serving " + japaneseDish.getDish() + "(Japanese)");
                            break;
                        case "Mexican":
                            Mexican mexicanDish = (Mexican) servedFood;
                            System.out.println("Serving " + mexicanDish.getDish() + "(Mexican)");
                            break;
                        default:
                            break;
                    }
                }
            } catch (UnservableCuisineRequestException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
