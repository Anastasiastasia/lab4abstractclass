import java.io.*;
import java.util.*;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import java.util.zip.*;
class Drinks extends Menu {
    
    public Drinks() {
        this.name = null;
        this.weight = 0;
        this.price = 0;
    }

    public Drinks(String name, int weight, int price ) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }
    public Map<Integer, Drinks> meals = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    public Map<Integer, Drinks> readMealsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length != 3) {
                    meals.put(count, new Drinks("", 0, 0));
                    System.out.println("Uncorrect elements");
                    count++;
                    continue;
                }
                try {
                    String first = parts[0];
                    int cost = Integer.parseInt(parts[1]);
                    int amount = Integer.parseInt(parts[2]);
                    Drinks meal = new Drinks(first, cost, amount);
                    meals.put(count, meal);
                    count++;
                } 
                catch (NumberFormatException e) {
                    meals.put(count, new Drinks("", 0, 0));
                    System.out.println("Uncorrect elements");
                    count++;
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return meals;
    }
    public String toString() {
        return "Drink {" +  "name= " + getName() + ' ' + ", weight= " + getWeight() +' ' + ", price= " + getPrice() + '}';
    }
    
    public void displayMealItems(Map<Integer, Drinks> meal) {
        //for (Map.Entry<Integer, Drinks> entry : meal.entrySet()) {
         //   System.out.println(entry.getValue().toString());
        // }
        Iterator<Map.Entry<Integer, Drinks>> iterator = meal.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Drinks> entry = iterator.next();
            System.out.println(entry.getValue().toString());
        }
    }
    public void addElement() {
        System.out.println("Введите название");
        String name1 = scanner.nextLine();
        System.out.println("Введите массу");
        int weight1 = scanner.nextInt();
        System.out.println("Введите цену");
        int price1 = scanner.nextInt();
        Drinks meal = new Drinks(name1, weight1, price1);
        meals.put(meals.size(), meal);
    }

    public void removeElement() {
        System.out.println("Введите номер объекта");
        int i = scanner.nextInt();
        meals.remove(i-1);
        scanner.close();
    }
    public void replaceElement() {
        System.out.println("Введите номер объекта");
        int i = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите название");
        String name1 = scanner.nextLine();
        System.out.println("Введите массу");
        int weight1 = scanner.nextInt();
        System.out.println("Введите цену");
        int price1 = scanner.nextInt();
        Drinks updatedMeal = new Drinks(name1, weight1, price1);
        meals.put(i - 1, updatedMeal);
    }

    public void maximum() {
        Drinks maxCostMeal = null;
        Drinks maxWeight = null;
        for (Map.Entry<Integer, Drinks> entry : meals.entrySet()) {
            Drinks meal = entry.getValue();
            if (maxCostMeal == null || meal.getPrice() > maxCostMeal.getPrice()) {
                maxCostMeal = meal;
            }
            if (maxWeight == null || meal.getWeight() > maxWeight.getWeight()) {
                maxWeight = meal;
            }
        }
        System.out.println("Напитки:\n Максимальная цена " + maxCostMeal + "\n Максимальный вес " + maxWeight + "\n");
    }
    
    public void saveToFile1(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Iterator<Map.Entry<Integer, Drinks>> iterator = meals.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Drinks> entry = iterator.next();
                //System.out.println(entry.getValue().toString());
                // }
                // for (Map.Entry<Integer, Drinks> entry : meals.entrySet()) {
                writer.write(entry.getValue().getName() + " " + entry.getValue().getWeight() + " " + entry.getValue().getPrice());
                writer.newLine();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sortprice() {
        List<Drinks> drinkList = new ArrayList<>(meals.values());
        Collections.sort(drinkList, new Comparator<Drinks>() {
            @Override
            public int compare(Drinks o1, Drinks o2) {
                return Integer.compare(o1.getPrice(), o2.getPrice());
            }
        }
        );
        System.out.println("Отсортированные по цене напитки:");
        drinkList.forEach(n->System.out.println(n.toString()));
    }


    public void sortWeight() {
        List<Drinks> drinkList = new ArrayList<>(meals.values());
        Collections.sort(drinkList, new Comparator<Drinks>() {
            @Override
            public int compare(Drinks o1, Drinks o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        }
        );
        System.out.println("Отсортированные по весу напитки:");
        drinkList.forEach(n->System.out.println(n.toString()));
    }

    //********** Метод sortprice сортировки напитков по названию **********
    public void sortName() {
        //List<Drinks> drinkList = new ArrayList<>(meals.values());
        List<Drinks> drinkList = new ArrayList<>(meals.values());
        // Collections.sort(drinkList, new Comparator<Drinks>() {
          //  @Override
          //  public int compare(Drinks o1, Drinks o2) {
          //      return o1.getName().compareTo( o2.getName());
          //  }
        // });
        Collections.sort(drinkList, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println("Отсортированные по алфавиту напитки:");
        drinkList.forEach(n->System.out.println(n.toString()));
    }

    public void toZipDrinks(String filename) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("MenuDrinks.zip"));
            FileInputStream fis = new FileInputStream(filename);) {
            ZipEntry entry1 = new ZipEntry(filename);
            zout.putNextEntry(entry1);
          
            byte[] buffer = new byte[fis.available()];
        
            zout.write(buffer);
  
            zout.closeEntry();
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

   
    public void inZipDrinks() {
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream("MenuDrinks.zip")))
        {
            ZipEntry entry;
            String name;
            while((entry=zin.getNextEntry())!=null){
                  
                name = entry.getName(); // получим название файла
                System.out.printf("Файл в ZIP-архиве: %s \n", name);
                 
             
                FileOutputStream fout = new FileOutputStream("new" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
                System.out.printf("Данные из ZIP-архива извлекаем в новый файл: %s \n", "new" + name); // данные извлекаем из архива
            }
        }
        catch(Exception ex) {   
            System.out.println(ex.getMessage());
        } 
    } 
}
    
    
    
