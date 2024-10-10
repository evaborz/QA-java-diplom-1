package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;
    private static IngredientType type;
    private final String name;
    private final float price;
    private final static double DELTA = 0.0f;

    @Before
    public void beforeBenTest() {
        ingredient = new Ingredient(type, name, price);
    }

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getTypeNameAndPrice() {
        return new Object[][] {
                {type.SAUCE, "Sausage", (float) 60.00},
                {type.FILLING, "Ketchup", (float) 20.00}
        };
    }

    @Test
    public void getPriceTest() {
        assertEquals("Price of ingredient is not correct", price, ingredient.getPrice(), DELTA);
    }

    @Test
    public void getNameTest() {
        assertEquals("Name of ingredient is not correct", name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Type of ingredient is not correct", type, ingredient.getType());
    }
}
