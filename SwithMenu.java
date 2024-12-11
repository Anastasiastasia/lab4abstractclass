
public class SwithMenu {
    
    Meals meal = new Meals();                                   // создаем объект meal класса Meals
    Drinks drink = new Drinks("", 0, 0);      // создаем объект drink класса Drinks

    // .......... Метод чтения меню из файла ..........
    public void readMealsDrinkFile() {
        meal.readMealsFromFile("inputMeals.txt");
        drink.readMealsFromFile("inputDrinks.txt");
        meal.displayMealItems(meal.meals);                      // вывод на консоль меню блюда
        drink.displayMealItems(drink.meals);                    // вывод на консоль меню напитки
    }

    // .......... Метод добавления нового блюда в меню ..........
    public void addMeal() {
        meal.addElement();
        meal.displayMealItems(meal.meals);
    }

    // .......... Метод удаления блюда из меню ..........
    public void removeMeal() {
        meal.removeElement();
        meal.displayMealItems(meal.meals);
    }

    // .......... Метод просмотра текущего состояния меню(блюда) ..........
    public void displayMeal() {
        meal.displayMealItems(meal.meals);
    }

    // .......... Метод добавления нового напитка в меню ..........
    public void addDrink() {
        drink.addElement();
        drink.displayMealItems(drink.meals);
    }

    // .......... Метод удаления напитка из меню ..........
    public void removeDrink() {
        drink.removeElement();
        drink.displayMealItems(drink.meals);
    }

    // .......... Метод просмотра текущего состояния меню(напитки) ..........
    public void displayDrink() {
        drink.displayMealItems(drink.meals);
    }

    // .......... Метод поиска блюда и напитка с максимальной ценой и максимальной массы ..........
    public void maxMealDrink() {
        meal.maximum();
        drink.maximum();
    }

    // .......... Метод сортировки блюд и напитков по цене ..........
    public void sortpriceMealDrink() {
        meal.sortprice();
        drink.sortprice();
    }

    // .......... Метод сортировки блюд и напитков по массе ..........
    public void sortWeightMealDrink() {
        meal.sortWeight();
        drink.sortWeight();
    }

    // .......... Метод сортировки блюд и напитков по названию ..........
    public void sortNameMealDrink() {
        meal.sortName();
        drink.sortName();
    }
    
    // .......... Метод записи меню в файл.txt ..........
    public void saveToFileMealDrink() {
        meal.saveToFile("MenuMeals.txt");
        drink.saveToFile1("MenuDrinks.txt");
    }

    // .......... Метод замены блюда в меню ..........
    public void replaceMeal() {
        meal.replaceElement();
        meal.displayMealItems(meal.meals);
    }

    // .......... Метод замены напитка в меню ..........
    public void replaceDrink() {
        drink.replaceElement();
        drink.displayMealItems(drink.meals);
    }

    // .......... Метод считывания меню из файла.XML ..........
    public void readMenuXml1()  {
        // readMenu.readXmlMenu();
        meal.readFromFileHtml("menu10.xml");
        //meal.readMenuXml();
        meal.displayMealItems(meal.meals);
    }
    
    // .......... Метод записи меню в файл.xml ..........
    public void savetoHMLfile()
    {
        meal.saveToFileHtml("menu10.xml");
    }
    
    // .......... Метод считывания меню из файла.json ..........
    public void readFromJsonFile()
    {
        meal.readMealsFromjFile();
        meal.displayMealItems(meal.meals);
    }
    
    // .......... Метод записи меню в файл.json ..........
    public void writetoJsonFile()
    {
        meal.writeMealsToJsonFile();
    }
    
    // .......... Метод записи меню в файл.zip ..........
    public void Zip()
    {
        meal.toZipMeals("MenuMeals.txt");  
        drink.toZipDrinks("MenuDrinks.txt");  
    }

    // .......... Метод распаковки  ..........
    public void inoutZip()
    {
        // блюда
        meal.inZipMeals();          // распаковываем файла.zip в файл newMenuMeals.txt
        
        meal.readMealsFromFile("newMenuMeals.txt");    // считываем новый файл
        meal.displayMealItems(meal.meals);                      // выводим на консоль меню блюда

        //напитки
        drink.inZipDrinks();        // распаковываем файла.zip в файл newMenuDrinks.txt

        drink.readMealsFromFile("newMenuDrinks.txt");  // считываем новый файл
        drink.displayMealItems(drink.meals);                    // выводим на консоль меню блюда
    } 

    // .......... Метод вывода шифрования ..........
    public void displayMEncrypt()
    {
        meal.displayMealEncrypt(meal.meals);  
    }

    // .......... Метод вывода дешифрования ..........
    public void displayMDecrypt()
    {
        meal.displayMealDecrypt(meal.meals);  
    }
}