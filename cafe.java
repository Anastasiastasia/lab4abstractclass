import java.io.IOException;
import java.util.*;

public class cafe {

    public static void main(String[] args) throws IOException {
        
        SwithMenu mealdrink = new SwithMenu();                     
        
        Scanner scanner = new Scanner(System.in);                   
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
            System.out.println("24. Шифровать файл");
            System.out.println("25. Дешифровать файл");


            System.out.println("==========================");
            System.out.print(" Введите номер: ");
            
            int choice = scanner.nextInt();
            switch(choice) {
                case 1 -> { mealdrink.readMealsDrinkFile(); }       
                    
                case 2 -> { mealdrink.addMeal(); }                 
                    
                case 3 -> { mealdrink.removeMeal(); }             
                    
                case 4 -> { mealdrink.displayMeal(); }              
                    
                case 5 -> { mealdrink.addDrink(); }             
                    
                case 6 -> { mealdrink.removeDrink(); }              
                    
                case 7 -> { mealdrink.displayDrink(); }             
                    
                case 8 -> { mealdrink.maxMealDrink(); }             
                    
                case 9 -> { mealdrink.sortpriceMealDrink(); }       
                    
                case 10 -> { mealdrink.sortWeightMealDrink(); }    
                    
                case 11 -> { mealdrink.sortNameMealDrink(); }      
                    
                case 12 -> { mealdrink.saveToFileMealDrink(); }    
                    
                case 13 -> { mealdrink.replaceMeal(); }             
                    
                case 14 -> { mealdrink.replaceDrink(); }         
                    
                case 15 -> { running = false; }

                case 16 -> { mealdrink.readMenuXml1(); }           
                     
                case 17 -> {mealdrink.savetoHMLfile();}            
                     
                case 18 -> {mealdrink.readFromJsonFile();}         
                     
                case 19 -> {mealdrink.writetoJsonFile();}          
                     
                case 20 -> {mealdrink.Zip();}                       

                case 21 -> {mealdrink.inoutZip();}                  

                case 22 -> {mealdrink.displayMEncrypt();}          

                case 23 -> {mealdrink.displayMDecrypt();}         

                case 24 -> {mealdrink.mainCript();}                

                case 25 -> {mealdrink.mainDecCript();}           
                
                default -> { System.out.println("Ошибка ввода! Пожалуйста повторите выбор."); }
            }
        }
        scanner.close();
    }
}
    
