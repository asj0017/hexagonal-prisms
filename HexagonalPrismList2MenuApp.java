import java.util.Scanner;
import java.io.IOException;

/**
 * Allows the user to decide what happens to an array of prisms.
 * Project 8.
 *
 * @author Amber Jackson
 * @version 03-21-2016
 */
public class HexagonalPrismList2MenuApp
{
/**
 * 
 * @param args - is not used.
 * @throws IOException from scanning input file.
 */
   public static void main(String[] args) throws IOException
   {
      String hListName = "no list name";
      HexagonalPrism[] myList = new HexagonalPrism[100];
      HexagonalPrismList2 myHList = new 
         HexagonalPrismList2(hListName, myList, 0);
      String fileName = "";
      
      String label;
      double side, height;   
      
      String code = "";
   
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Hexagonal Prism List System Menu\n"
                       + "R - Read File and Create Hexagonal Prism List\n"
                       + "P - Print Hexagonal Prism List\n" 
                       + "S - Print Summary\n"
                       + "A - Add Hexagonal Prism\n"   
                       + "D - Delete Hexagonal Prism\n"   
                       + "F - Find Hexagonal Prism\n"
                       + "E - Edit Hexagonal Prism\n"
                       + "Q - Quit");
   
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = scan.nextLine();
         if (code.length() == 0) {
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch(codeChar) {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = scan.nextLine();
            
               myHList = myHList.readFile(fileName);
            
               System.out.println("\tFile read in and "
                              + "Hexagonal Prism List created\n");
               break; 
                    
            case 'P':
               System.out.println(myHList.toString());
               break;
               
            case 'S':
               System.out.println(myHList.summaryInfo());
               break;
               
            case 'A':
               System.out.println("\n\tLabel: ");
               label = scan.nextLine();
               System.out.println("\n\tSide: ");
               side = Integer.parseInt(scan.nextLine());
               System.out.println("\n\tHeight: ");
               height = Integer.parseInt(scan.nextLine());
               myHList.addHexagonalPrism(label, side, height);
               System.out.println("\n\t*** Hexagonal Prism added ***");
               break;
         
            case 'D':
               System.out.println("\n\tLabel: ");
               label = scan.nextLine();
               if (myHList.deleteHexagonalPrism(label) != null) {
                  System.out.println("\n\t\"" + label + "\" deleted");
               }
               else {
                  System.out.println("\n\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'F':
               System.out.println("\n\tLabel: ");
               label = scan.nextLine();
               if (myHList.findHexagonalPrism(label) != null) {
                  System.out.println(myHList);
               }
               else {
                  System.out.println("\n\t\"" + label + "\" not found\n");
               }
               break;   
               
            case 'E':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tSide: ");
               side = Integer.parseInt(scan.nextLine());
               System.out.print("\tHeight: ");
               height = Integer.parseInt(scan.nextLine());
            
               if (myHList.findHexagonalPrism(label) != null) {
                  System.out.println("\n\t\"" + label 
                     + "\" successfully edited");
               }
               else {
                  System.out.println("\n\t\"" + label + "\" not found\n");
               }
            
            
               break;   
                  
            case 'Q': case 'q':
               break;
               
            default:
             // loop again
         }
      
      } while (!code.equalsIgnoreCase("Q"));   
      
      
   }
}