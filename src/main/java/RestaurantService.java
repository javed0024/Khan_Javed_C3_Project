import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    //Implemented findRestaurantByName Method
    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        Restaurant searchedRestaurant = null;
        if (!restaurants.isEmpty()) {
            for (Restaurant restaurant : restaurants) {
                if (restaurant.getName().equals(restaurantName)) {
                    searchedRestaurant = restaurant;
                    break;
                }
            }
        }
        if (searchedRestaurant == null)
            throw new restaurantNotFoundException(restaurantName);

        return searchedRestaurant;
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
