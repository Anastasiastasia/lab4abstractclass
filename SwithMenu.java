
public class SwithMenu {
    
    Meals meal = new Meals();                                   
    Drinks drink = new Drinks("", 0, 0);      
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
        meal.readFromFileHtml("menu10.xml");
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
}
