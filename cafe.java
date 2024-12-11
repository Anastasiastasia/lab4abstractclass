import java.io.IOException;
import java.util.*;
public class cafe {
    public static void main(String[] args) throws IOException {
        
        SwithMenu mealdrink = new SwithMenu();                      // создаем объект mealdrink класса SwithMenu
        
        Scanner scanner = new Scanner(System.in);                   // создаем сканер
        System.out.println("\n========== Кафе ==========");
        
        boolean running = true;
        
        while (running) {
            System.out.println("\n====== Меню выбора =======");
            System.out.println("1. Прочитать меню из файла");
            System.out.println("2. Добавить новое блюдо");
            System.out.println("3. Удалить блюдо");
            System.out.println("4. Посмотреть текущее состояние меню(блюда)");
            System.out.println("5. Добавить новый напиток");
            System.out.println("6. Удалить напиток ");
            System.out.println("7. Посмотреть текущее состояние меню(напитки)");
            System.out.println("8. Найти максимальное ");
            System.out.println("9. Сортировка блюд и напитков по цене");
            System.out.println("10. Сортировка блюд и напитков по весу");
            System.out.println("11. Сортировка блюд и напитков по алфавиту");
            System.out.println("12. Записать меню в файл.txt");
            System.out.println("13. Замена блюда");
            System.out.println("14. Замена напитка");
            System.out.println("15. Закрыть меню");
            System.out.println("16. Прочитать меню из файла XML");
            System.out.println("17. Записать меню в файл XML");
            System.out.println("18. Прочитать меню из файла Json");
            System.out.println("19. Записать меню в файл Json");
            System.out.println("20. Записать меню в файл ZIP");
            System.out.println("21. Распаковать меню из файл ZIP");
            System.out.println("22. Шифровать данные");
            System.out.println("23. Дешифровать данные");

            System.out.println("==========================");
            System.out.print(" Введите номер: ");
            
            int choice = scanner.nextInt();
            
            // используем лямбда-стрелку для сопоставления case с кодом
            switch(choice) {
                case 1 -> { mealdrink.readMealsDrinkFile(); }       // Прочитать меню из файла.txt
                    
                case 2 -> { mealdrink.addMeal(); }                  // Добавить новое блюдо
                    
                case 3 -> { mealdrink.removeMeal(); }               // Удалить блюдо
                    
                case 4 -> { mealdrink.displayMeal(); }              // Посмотреть текущее состояние меню(блюда)
                    
                case 5 -> { mealdrink.addDrink(); }                 // Добавить новый напиток
                    
                case 6 -> { mealdrink.removeDrink(); }              // Удалить напиток
                    
                case 7 -> { mealdrink.displayDrink(); }             // Посмотреть текущее состояние меню(напитки)
                    
                case 8 -> { mealdrink.maxMealDrink(); }             // Найти блюдо и напиток с максимальной ценой и максимальной массы
                    
                case 9 -> { mealdrink.sortpriceMealDrink(); }       // Сортировка блюд и напитков по цене
                    
                case 10 -> { mealdrink.sortWeightMealDrink(); }     // Сортировка блюд и напитков по весу
                    
                case 11 -> { mealdrink.sortNameMealDrink(); }       // Сортировка блюд и напитков по алфавиту
                    
                case 12 -> { mealdrink.saveToFileMealDrink(); }     // Записать меню в файл.txt
                    
                case 13 -> { mealdrink.replaceMeal(); }             // Замена блюда
                    
                case 14 -> { mealdrink.replaceDrink(); }            // Замена напитка
                    
                case 15 -> { running = false; }                     // Закрыть меню

                case 16 -> { mealdrink.readMenuXml1(); }            // Прочитать меню из файла.XML
                     
                case 17 -> {mealdrink.savetoHMLfile();}             // Записать меню в файл.XML
                     
                case 18 -> {mealdrink.readFromJsonFile();}          // Прочитать меню из файла.JSON
                     
                case 19 -> {mealdrink.writetoJsonFile();}           // Записать меню в файл.JSON
                     
                case 20 -> {mealdrink.Zip();}                       // Записать меню в файл.ZIP

                case 21 -> {mealdrink.inoutZip();}                  // Распаковать меню из файл.ZIP

                case 22 -> {mealdrink.displayMEncrypt();}           // Шифровать данные

                case 23 -> {mealdrink.displayMDecrypt();}           // Дешифровать данные
                
                default -> { System.out.println("Ошибка ввода! Пожалуйста повторите выбор."); }
            }
        }
        scanner.close();
    }
}
    