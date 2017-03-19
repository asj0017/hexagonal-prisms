import java.text.DecimalFormat;

public class HexagonalPrism {
  // Fields - instance variables  
   private String tag = " ";
   private double base;
   private double tall;
    /**  */
    
   /**  
    *  @param label to display shape's name.
    *  @param side to determine shape's side.
    *  @param height to determine shape's height.
    */
   public HexagonalPrism(String label, double side, double height) {
      tag = label.trim();
      base = side;
      tall = height;
   }
   
   /**  
    * @return label.
    */
   public String getLabel() {
      return tag;
   }
   
   /**  
    *  @param newLabel to replace old label.
    *  @return false.
    */
   public boolean setLabel(String newLabel) {
      if (newLabel != null) {
         tag = newLabel.trim();
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
    *  @return side.
    */
   public double getSide() {
      return base;
   }
    
   /**  
    *  @param side to determine shape's side.
    */
   public void setSide(double side) {
      base = side;
   }
    
   /**
    *  @return height.
    */
   public double getHeight() {
      return tall;
   }
      
   /**  
    *  @param height to determine shape's height.
    */
   public void setHeight(double height) {
      tall = height;
   }
   
   /**  
    * @return basePerimeter.
    */
   public double basePerimeter() {
      return (6 * base);
   }
   
   /**  
    * @return baseArea.
    */
   public double baseArea() {
      return (3 * Math.sqrt(3) * (Math.pow(base, 2) / 2));
   }
   
   /**  
    * @return surfaceArea.
    */  
   public double surfaceArea() {
      return ((3 * Math.sqrt(3) * Math.pow(base, 2)) 
         + (6 * base * tall));
   }
   
   /**  
    * @return volume.
    */
   public double volume() {
      return ((3 * Math.sqrt(3) / 2) * Math.pow(base, 2) * tall);
   }

   /**  
    * @return toString.
    */
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      return "\"" + tag + "\" is a hexagonal "
         + "prism with side = " + df.format(base) + " units and height = "
         + df.format(tall) + " units," + "\nwhich has base perimeter = "
         + df.format(basePerimeter()) + " units, base area = " 
         + df.format(baseArea()) + " square units,\nsurface area = " 
         + df.format(surfaceArea()) + " square units, and volume = "
         + df.format(volume()) + " cubic units.";
   }

}
