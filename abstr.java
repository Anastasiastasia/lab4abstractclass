import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

abstract class Menu
{
    protected String name;
    protected int weight;
    protected int price;
  
    public  String getName()
    {
    return name;
    }
public int  getWeight()
{
return weight;
}
public int getPrice()
{
return price;
}

public void setName(String name) {
this.name = name;
}
public void setWeight(int weight) {
this.weight = weight;
}
public void setPrice(int price) {
this.price = price;
}
  
    public void toZip(String filename) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("output.zip"));
             FileInputStream fis = new FileInputStream(filename);) {
            ZipEntry entry1 = new ZipEntry(filename);
            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
