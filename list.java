import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.zip.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

class Meals extends Menu {
    
    public Meals( String name, int weight, int price) {
        this.name = name;this.weight = weight;this.price= price;
    }

    public Meals() {
        this.name = null; this.weight = 0;this.price=0 ;
    }
    
    //********** Секретный ключ для шифрования **********
    private static final String key = "ThisIsASecretKey"; // Секретный ключ для шифрования

    //********** Метод для шифрования строки **********
    public static String encrypt(String value) {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedValue = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encryptedValue);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //********** Метод для дешифрования строки **********
    public static String decrypt(String encryptedValue) {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedValue = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
            return new String(decryptedValue);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //********** Метод считывания из файла **********
    public  List<Meals> meals = new ArrayList<>();
    Scanner scanner= new Scanner(System.in);
    
    public  List<Meals> readMealsFromFile(String filename) {
           
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;                              
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length != 3) {
                    meals.add(new Meals(" ", 0, 0)); // Добавляем пустую строку вместо некорректного элемента
                    System.out.println("Uncorrect elements");
                    continue;
                }
                try {
                    String first = parts[0];
                                             
                    int cost = Integer.parseInt(parts[1]);
                    int amount = Integer.parseInt(parts[2]);
                    @SuppressWarnings("unused")
                    Meals meal1 = new Meals(encrypt(first), (cost), amount); // шифрование
                    //System.out.println(meal1);                             // вывод шифрованного на консоль
                    Meals meal = new Meals(first, cost, amount);
                    meals.add(meal);
                }
                catch (NumberFormatException e) {
                    meals.add(new Meals("", 0, 0)); // Добавляем пустую строку вместо некорректного элемента
                    System.out.println("Uncorrect elements");
                }
            }           
        } 
        catch (IOException e) {
            e.printStackTrace();
        }        
        return meals;
    }
    
    //********** Метод toString() преобразования числа в строку **********
    public String toString() {
    return "Meal {" +  "name=" + getName() + ' ' + ", weight=" + 
    getWeight()+' ' + ", price=" + getPrice()+'}';
    }
    
    //********** Метод вывода элементов листа на консоль **********
    public void displayMealItems( List<Meals> meal) { 
        Iterator<Meals> iterator = meal.iterator();
        while (iterator.hasNext()) {
            Meals item = iterator.next();
                //String encryptedName = encrypt(item.getName());
                //String decryptedName = decrypt(encryptedName);
        
                //System.out.println("Зашифрованное название: " + encryptedName); // Encrypted name
                //System.out.println("Расшифрованное название: " + decryptedName);         // Decrypted name
        
            System.out.println(item.toString());
        }                    
        // for(Menu item : meal) {
        // System.out.println(item.toString());
    }

    //********** Метод вывода элементов листа на консоль шифрованное **********
    public void displayMealEncrypt( List<Meals> meal) { 
        Iterator<Meals> iterator = meal.iterator();
        while (iterator.hasNext()) {
            Meals item = iterator.next();
            String encryptedName = encrypt(item.getName());
            //String decryptedName = decrypt(encryptedName);
        
            System.out.println("Зашифрованное название: " + encryptedName); // Encrypted name
            //System.out.println("Расшифрованное название: " + decryptedName);         // Decrypted name
        
            //System.out.println(item.toString());
        }                    
        // for(Menu item : meal) {
        // System.out.println(item.toString());
    }

    //********** Метод вывода элементов листа на консоль дешифрованное **********
    public void displayMealDecrypt( List<Meals> meal) { 
        Iterator<Meals> iterator = meal.iterator();
        while (iterator.hasNext()) {
            Meals item = iterator.next();
            String encryptedName = encrypt(item.getName());
            String decryptedName = decrypt(encryptedName);
        
            //System.out.println("Зашифрованное название: " + encryptedName);        // Encrypted name
            System.out.println("Расшифрованное название: " + decryptedName);         // Decrypted name
        
            //System.out.println(item.toString());
        }                    
        // for(Menu item : meal) {
        // System.out.println(item.toString());
    }
           
    //********** Метод добавление блюда **********
    public void addElement() {  
        System.out.println("Введите название");
        String name1=scanner.nextLine();
        System.out.println("Введите массу");
        int weight1=scanner.nextInt();
        System.out.println("Введите цену");
        int price1=scanner.nextInt();
        Meals meal = new Meals(name1, weight1, price1);
        meals.add(meal);
    }
        
    //********* Метод удаления блюда **********
    public void removeElement() {
        System.out.println("Введите номер объекта");
        int i= scanner.nextInt();
        meals.remove(i-1);
        scanner.nextLine(); 
    }
        
    //********* Метод изменения блюда **********
    public void replaceElement() {
        System.out.println("Введите номер объекта");
        int i= scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Введите название");
        String name1=scanner.nextLine();
        System.out.println("Введите массу");
        int weight1=scanner.nextInt();
        System.out.println("Введите цену");
        int price1=scanner.nextInt();
        meals.get(i-1).setWeight(weight1);
        meals.get(i-1).setName(name1);
        meals.get(i-1).setPrice(price1);  
    }
        
    //********** Метод сортировки-поиска максимальной цены и веса *********
    public void maximum() {
        Meals maxCostMeal = meals.get(0); 
        Meals maxWeight=meals.get(0);
        for (Meals meal : meals) {
            if (meal.getPrice() > maxCostMeal.getPrice()) {
                maxCostMeal = meal;
            }
            if(meal.getWeight()>maxWeight.getWeight()) {
                maxWeight=meal;
            }
        }
        System.out.println("Блюда:\n Максимальная цена " + maxCostMeal + "\n Максимальный вес " + maxWeight + "\n");
    }   
    
    //********** Метод сортировки по весу *********
    public void sortWeight() {
        Collections.sort(meals, new Comparator<Meals>() {
            @Override
            public int compare(Meals o1, Meals o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });

        System.out.println("Отсортированные по весу блюда:");
        meals.forEach(n->System.out.println(n.toString()));
    }
    
    //********** Метод сортировки по цене *********
    public void sortprice() {
        //Collections.sort(meals, new Comparator<Meals>() {
        // @Override
        //public int compare(Meals o1, Meals o2) {
        //   return Integer.compare(o1.getPrice(), o2.getPrice());
        // }
        Collections.sort(meals, (o1, o2) ->Integer.compare(o1.getPrice(), o2.getPrice()) );
        //});
        System.out.println("Отсортированные по цене блюды:");
        meals.forEach(n->System.out.println(n.toString()));
    } 
  
    //********** Метод сортировки по алфавиту *********
    public void sortName(){
        Collections.sort(meals, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println("Отсортированные по алфавиту блюда:");
        // for (Meals m : meals) {
        //    System.out.println(m.toString());
        // }
        meals.forEach(n->System.out.println(n.toString()));
    } 

    //********** Метод записи в файл.txt *********
    void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Iterator<Meals> iterator = meals.iterator();
            while (iterator.hasNext()) {
                Meals item = (Meals) iterator.next();
                // System.out.println(item.toString());
                // }
                // for (Meals meal : meals) {
                writer.write(item.getName() + " " + item.getWeight() + " " + item.getPrice());
                writer.newLine();
            }
            // writer.write(".........");
            // writer.newLine();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //********** Метод записи в файл.xml *********
    public void saveToFileHtml(String filename)  {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element rootElement = doc.createElement("meals");
            doc.appendChild(rootElement);
    
            for (Meals meal : meals) {
                Element mealElement = doc.createElement("meal");
                rootElement.appendChild(mealElement);
    
                Element nameElement = doc.createElement("name");
                nameElement.appendChild(doc.createTextNode(meal.getName()));
                mealElement.appendChild(nameElement);
    
                Element weightElement = doc.createElement("weight");
                weightElement.appendChild(doc.createTextNode(String.valueOf(meal.getWeight())));
                mealElement.appendChild(weightElement);
    
                Element priceElement = doc.createElement("price");
                priceElement.appendChild(doc.createTextNode(String.valueOf(meal.getPrice())));
                mealElement.appendChild(priceElement);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(source, result);
        } 
        catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    } 

    //********** Метод считывания из файла.xml *********
    public void readFromFileHtml(String filename) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filename));
            NodeList mealList = doc.getElementsByTagName("meal");
        
            for (int i = 0; i < mealList.getLength(); i++) {
                Element mealElement = (Element) mealList.item(i);
        
                String name = mealElement.getElementsByTagName("name").item(0).getTextContent();
                int weight = Integer.parseInt(mealElement.getElementsByTagName("weight").item(0).getTextContent());
                int price = Integer.parseInt(mealElement.getElementsByTagName("price").item(0).getTextContent());
                Meals meal = new Meals(name, weight, price);
                meals.add(meal);
            }
        } 
        catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    //********** Метод считывания из файла.json *********
    public void readMealsFromjFile() {
        //Path path = Paths.get("cafe-menu.json");
        Path path = Paths.get("cafe-menu10.json");
        try {
            String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
     
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(content);
            //System.out.println("\n" + jsonObject + "\n");
            JSONArray mealsArray = (JSONArray) jsonObject.get("menu");
            for (Object obj : mealsArray) {
                JSONObject meal = (JSONObject) obj;
                String name = (String) meal.get("name");
                int weight = Integer.parseInt(String.valueOf(meal.get("weight")));
                int price = Integer.parseInt(String.valueOf(meal.get("price")));
                Meals newMeal = new Meals(name, weight, price);
                meals.add(newMeal);
            }  
        } 
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    //********** Метод записи в файл.json *********
    @SuppressWarnings("unchecked")
    public void writeMealsToJsonFile() {
        Path path = Paths.get("cafe-menu10.json");
        JSONObject jsonObject = new JSONObject();
        JSONArray mealsArray = new JSONArray();
        for (Meals meal : meals) {
            JSONObject mealObject = new JSONObject();
            mealObject.put("name", meal.getName());
            mealObject.put("weight", meal.getWeight());
            mealObject.put("price", meal.getPrice());
            mealsArray.add(mealObject);
        }
        
        jsonObject.put("menu", mealsArray);
    
        try (FileWriter file = new FileWriter(path.toString())) {
            file.write(jsonObject.toJSONString());
            file.flush();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //********** Метод записи в файл.zip *********
    public void toZipMeals(String filename) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("MenuMeals.zip"));
            FileInputStream fis = new FileInputStream(filename);) {
            ZipEntry entry1 = new ZipEntry(filename);
            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //********** Метод распаковки файла.zip *********
    public void inZipMeals() {
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream("MenuMeals.zip")))
        {
            ZipEntry entry;
            String name;
            while((entry=zin.getNextEntry())!=null){
                  
                name = entry.getName(); // получим название файла
                System.out.printf("Файл в ZIP-архиве: %s \n", name); // данные извлекаем из архива
                 
                // распаковка
                FileOutputStream fout = new FileOutputStream("new" + name); // сохраняем в новый файл
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
        
        
    
    
    
    
    