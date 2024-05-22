import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantOrderTest {
    Restaurant restaurant;

    @BeforeEach
    public void setUp() {
        LocalTime openingTime = LocalTime.parse("10:00:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant = new Restaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
        restaurant.addToMenu("Sweet corn soup", 119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }

    @Test
    public void calculating_order_value_should_return_sum_of_selected_items() {
        List<String> selectedItems = Arrays.asList("Sweet corn soup", "Vegetable lasagne");
        int totalValue = restaurant.calculateOrderValue(selectedItems);
        assertEquals(388, totalValue);
    }

    @Test
    public void calculating_order_value_with_no_items_should_return_zero() {
        List<String> selectedItems = Arrays.asList();
        int totalValue = restaurant.calculateOrderValue(selectedItems);
        assertEquals(0, totalValue);
    }

    @Test
    public void calculating_order_value_with_some_items_should_return_correct_sum() {
        List<String> selectedItems = Arrays.asList("Sweet corn soup");
        int totalValue = restaurant.calculateOrderValue(selectedItems);
        assertEquals(119, totalValue);
    }
}
