import java.text.DecimalFormat;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HexagonalPrismList2 {

   private String name;
   private HexagonalPrism[] hexPrismList;
   private int size;
   
   /**  */
    
   /**  
    *  @param hexPrismListIn to display list of shapes.
    *  @param nameIn to display name of list.
    *  @param sizeIn to display size of list.
    */
   public HexagonalPrismList2(String nameIn, 
      HexagonalPrism[] hexPrismListIn, int sizeIn) {
      hexPrismList = hexPrismListIn;
      name = nameIn;
      size = sizeIn;
   }
   
   /**  
    *  @return name.
    */
   public String getName() {
      return name;
   }
   
   /**  
    *  @return hexPrismList.size().
    */
   public int numberOfHexagonalPrisms() {
      return size;
   }
   
   /**
    *  @return totalSurfaceArea.
    */
   public double totalSurfaceArea() {
      if (size == 0) {
         return 0.0;
      }
      int i = 0;
      double totalSurfaceArea = 0;
      while (i < numberOfHexagonalPrisms()) {
         totalSurfaceArea += hexPrismList[i].surfaceArea();
         i++;
      }
      
      return totalSurfaceArea;
   }
   
   /**  
    *  @return totalVolume.
    */
   public double totalVolume() {
      if (size == 0) {
         return 0.0;
      }
      
      int i = 0;
      double totalVolume = 0;
      while (i < numberOfHexagonalPrisms()) {
         totalVolume += hexPrismList[i].volume();
         i++;
      }
      
      return totalVolume;
   }
   
   /**  
    *  @return totalBasePerimeter.
    */
   public double totalBasePerimeter() {
      if (size == 0) {
         return 0.0;
      }
      
      int i = 0;
      double totalBasePerimeter = 0;
      while (i < size) {
         totalBasePerimeter += hexPrismList[i].basePerimeter();
         i++;
      }
      
      return totalBasePerimeter;
   }

   /**  
    *  @return totalBaseArea
    */
   public double totalBaseArea() {
      if (size == 0) {
         return 0.0;
      }
      
      int i = 0;
      double totalBaseArea = 0;
      while (i < numberOfHexagonalPrisms()) {
         totalBaseArea += hexPrismList[i].baseArea();
         i++;
      }
      
      return totalBaseArea;
   }

   /**  
    *  @return averageSurfaceArea.
    */
   public double averageSurfaceArea() {
      double totalSA = totalSurfaceArea();
      int length = numberOfHexagonalPrisms();
      if (length != 0) {
         return totalSA / (double) length;
      }
      else {
         return 0.0;
      }
   }

   /**  
    *  @return averageVolume.
    */
   public double averageVolume() {
      double totalVol = totalVolume();
      int length = numberOfHexagonalPrisms();
      if (length != 0) {
         return totalVol / (double) length;
      }
      else {
         return 0.0;
      }
   }

   /**  
    *  @return toString.
    */
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      int i = 0;
      String output = "";
      output = "\n" + getName() + "\n\n";
      while (i < numberOfHexagonalPrisms()) {
         output += hexPrismList[i].toString() + "\n\n";
         i++;
      
      }
    
      return output;
   }
   
   /**  
    *  @return summaryInfo.
    */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String summaryOutput = "----- " + getName() + " Summary -----"
         + "\nNumber of Hexagonal Prisms: " + numberOfHexagonalPrisms()
         + "\nTotal Surface Area: " + df.format(totalSurfaceArea())
         + "\nTotal Volume: " + df.format(totalVolume())     
         + "\nTotal Base Perimeter: " + df.format(totalBasePerimeter())
         + "\nTotal Base Area: " + df.format(totalBaseArea())
         + "\nAverage Surface Area: " + df.format(averageSurfaceArea())
         + "\nAverage Volume: " + df.format(averageVolume());
   
      return summaryOutput;
   }
   
   /**  
    *  @return getList.
    */
   public HexagonalPrism[] getList() {
      return hexPrismList;
   }
   
   /**  
    *  @param fileName to get file's name.
    *  @return readFile.
    *  @throws IOException to main.
    */
   public HexagonalPrismList2 readFile(String fileName)throws IOException {
   
      Scanner fileScanner = new Scanner(new File(fileName));
      HexagonalPrism[] hp = new HexagonalPrism[100];
      name = fileScanner.nextLine();
      
      HexagonalPrismList2 hpL = null;
      int i = 0;
      while (fileScanner.hasNext()) {
         String label = fileScanner.nextLine();
         double side = Double.parseDouble(fileScanner.nextLine());
         double height = Double.parseDouble(fileScanner.nextLine());
         
         HexagonalPrism hpList = new HexagonalPrism(label, side, height);
         hp[i] = hpList;
         i++;
          
      }
   
      hpL = new HexagonalPrismList2(name, hp, i);
      return hpL;
   }
    
    /**  
    *  @param labelIn to display shape's name.
    *  @param sideIn to determine shape's side.
    *  @param heightIn to determine shape's height.
    */
   public void addHexagonalPrism(String labelIn, 
      double sideIn, double heightIn) {
      HexagonalPrism hp1 = new HexagonalPrism(labelIn, sideIn, heightIn);
      hexPrismList[size] = hp1;
      size++;
   }
   
   /**  
    *  @param labelIn to display shape's name.
    *  @return deleteHexagonalPrism.
    */
   public HexagonalPrism deleteHexagonalPrism(String labelIn) {
      HexagonalPrism hp2 = null;
      
      for (int i = 0; i < numberOfHexagonalPrisms(); i++) {
         if (hexPrismList[i].getLabel().equalsIgnoreCase(labelIn)) {
            hp2 = hexPrismList[i];
            
            for (int index = i; index < numberOfHexagonalPrisms() 
               - 1; index++) {
               hexPrismList[index] = hexPrismList[index + 1];
            }
            hexPrismList[numberOfHexagonalPrisms() - 1] = null;
            size--;
            break;
         }
      }
      return hp2;   
   }
   
   /**  
    *  @param labelIn to display shape's name.
    *  @return findHexagonalPrism.
    */
   public HexagonalPrism findHexagonalPrism(String labelIn) {
      int index = 0;
      while (index < size
         && !labelIn.equalsIgnoreCase(hexPrismList[index].getLabel()))
      {
         index++;
      }
      if (index < size) {
         return hexPrismList[index];
      }
      else {
         return null;
      }
   }
   
   /**  
    *  @param labelIn to display shape's name.
    *  @param sideIn to determine shape's side.
    *  @param heightIn to determine shape's height.
    *  @return false.
    */
   public boolean editHexagonalPrism(String labelIn, 
      double sideIn, double heightIn) {
      int index = 0;
      while (index < size
         && !labelIn.equalsIgnoreCase(hexPrismList[index].getLabel()))
      {
         index++;
      }
      if (index < size) {
         hexPrismList[index].setSide(sideIn);
         hexPrismList[index].setHeight(heightIn);
         return true;
      }
      else {
         return false;
      }
   }
}
