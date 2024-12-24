import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class SwithMenu {
    
    Meals meal = new Meals();                                 
    Drinks drink = new Drinks("", 0, 0);    

    CriptMain meal1 = new CriptMain();

   
    public void readMealsDrinkFile() {
        meal.readMealsFromFile("inputMeals.txt");
        drink.readMealsFromFile("inputDrinks.txt");
        meal.displayMealItems(meal.meals);                     
        drink.displayMealItems(drink.meals);                    
    }

    public void addMeal() {
        meal.addElement();
        meal.displayMealItems(meal.meals);
    }

  
    public void removeMeal() {
        meal.removeElement();
        meal.displayMealItems(meal.meals);
    }

    public void displayMeal() {
        meal.displayMealItems(meal.meals);
    }

    
    public void addDrink() {
        drink.addElement();
        drink.displayMealItems(drink.meals);
    }

 
    public void removeDrink() {
        drink.removeElement();
        drink.displayMealItems(drink.meals);
    }

  
    public void displayDrink() {
        drink.displayMealItems(drink.meals);
    }

    
    public void maxMealDrink() {
        meal.maximum();
        drink.maximum();
    }

  
    public void sortpriceMealDrink() {
        meal.sortprice();
        drink.sortprice();
    }


    public void sortWeightMealDrink() {
        meal.sortWeight();
        drink.sortWeight();
    }

  
    public void sortNameMealDrink() {
        meal.sortName();
        drink.sortName();
    }
    
 
    public void saveToFileMealDrink() {
        meal.saveToFile("MenuMeals.txt");
        drink.saveToFile1("MenuDrinks.txt");
    }


    public void replaceMeal() {
        meal.replaceElement();
        meal.displayMealItems(meal.meals);
    }

    public void replaceDrink() {
        drink.replaceElement();
        drink.displayMealItems(drink.meals);
    }

    public void readMenuXml1()  {
        // readMenu.readXmlMenu();
        meal.readFromFileHtml("menu7.xml");
        //meal.readMenuXml();
        meal.displayMealItems(meal.meals);
    }
    
    public void savetoHMLfile()
    {
        meal.saveToFileHtml("menu10.xml");
    }
    public void readFromJsonFile()
    {
        meal.readMealsFromjFile();
        meal.displayMealItems(meal.meals);
    }
    public void writetoJsonFile()
    {
        meal.writeMealsToJsonFile();
    }
    public void Zip()
    {
        meal.toZipMeals("MenuMeals.txt");  
        drink.toZipDrinks("MenuDrinks.txt");  
    }
    public void inoutZip()
    {
        meal.inZipMeals();         
        
        meal.readMealsFromjFile();
        meal.readMealsFromFile("newMenuMeals.txt");  
        meal.displayMealItems(meal.meals);                     

        drink.inZipDrinks();     

        drink.readMealsFromFile("newMenuDrinks.txt");  
        drink.displayMealItems(drink.meals);                  
    } 
    public void displayMEncrypt()
    {
        meal.displayMealEncrypt(meal.meals);  
    }
    public void displayMDecrypt()
    {
        meal.displayMealDecrypt(meal.meals);  
    }
    @SuppressWarnings("static-access")
    public void mainCript() {
        try {
            meal1.mainCript();
        } 
        catch (InvalidKeyException e) {
            e.printStackTrace();
        } 
        catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (BadPaddingException e) {
            e.printStackTrace();
        } 
        catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }  
    }
    @SuppressWarnings("static-access")
    public void mainDecCript() {
        try {
            meal1.mainCriptDec();
        } 
        catch (InvalidKeyException e) {
            e.printStackTrace();
        } 
        catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (BadPaddingException e) {
            e.printStackTrace();
        } 
        catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }  
        
        meal.readMealsFromjFile();
        // meal.readMealsFromFile("newinputMeals.txt");   
        // newmenu10.xml, newinputMeals.txt
        meal.displayMealItems(meal.meals);                      
    }
}

