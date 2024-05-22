import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public void removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        if (restaurantToBeRemoved == null) {
            throw new restaurantNotFoundException(restaurantName);
        }
        restaurants.remove(restaurantToBeRemoved);
    }

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(restaurantName)) {
                return restaurant;
            }
        }
        throw new restaurantNotFoundException(restaurantName);
    }

    public List<Restaurant> getRestaurants() {
        return new ArrayList<>(restaurants);
    }

    public int calculateOrderValue(String restaurantName, List<String> itemNames) throws restaurantNotFoundException {
        Restaurant restaurant = findRestaurantByName(restaurantName);
        return restaurant.calculateOrderValue(itemNames);
    }
}
