import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {

    @Test
    public void testEncryptDecrypt() {
        String value = "TestValue";
        String encryptedValue = Meals.encrypt(value);
        String decryptedValue = Meals.decrypt(encryptedValue);
        assertEquals(value, decryptedValue);
    }

    @Test
    public void testReadMealsFromFile() {
        Meals meals = new Meals();
        @SuppressWarnings("unused")
        List<Meals> mealList = meals.readMealsFromFile("testfile.txt");
    }

    @Test
    public void testSortWeight() {
        Meals meals = new Meals();
        @SuppressWarnings("unused")
        List<Meals> mealList = meals.readMealsFromFile("testfile.txt");
        meals.sortWeight();
    }

    @Test
    public void testSortPrice() {
        Meals meals = new Meals();
        @SuppressWarnings("unused")
        List<Meals> mealList = meals.readMealsFromFile("testfile.txt");
        meals.sortprice();
    }

    @Test
    public void testSortName() {
        Meals meals = new Meals();
        @SuppressWarnings("unused")
        List<Meals> mealList = meals.readMealsFromFile("testfile.txt");
        meals.sortName();
        
    }

}