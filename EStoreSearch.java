package eStoreSearch;
import java.util.Scanner;
/*import jdk.internal.jshell.tool.resources.version;*/
import java.util.*;

public class EStoreSearch{
    // similarities between books and electronics
    private String description;
    private String productid;
    private String [] temp;
    private String years;
    private String year1;
    private String year2;
    private int yr1;
    private int yr2;
    private String delimiter = "-";
/**
 * the search asks foe input and does error checking by booleans at he bottom of this class
 */
    EStoreSearch( ArrayList <Book> BookList , ArrayList <Electronics> electronicsList){ 
        int check2 =0,check3 =0, check4 =0;
        boolean gradeCheck = true;
        Scanner object2 = new Scanner(System.in);
        Scanner object3 = new Scanner(System.in);
        Scanner object4 = new Scanner(System.in);
        // taking in all the inputs here
        do {
            System.out.println("Please type in the description :");
            // taking in input and comparing against conditions
            description = object4.nextLine();
            if(setdescription(description)== true){
                check4 = 1;
            }
        }while (check4!= 1);

        do {
           // taking in input and comparing against conditions
            System.out.println("Please  type in product id :");
            productid = object3.nextLine();
            if(setproductid(productid)== true){
                check3 = 1;
            }

        }while (check3 != 1);


        do {
            System.out.println("Please type in the  year :");
            // taking in input and comparing against conditions
            years = object2.nextLine();
            if(setyears(years)== true){
                check2 = 1;
            }
            if (years.isEmpty()==true){
            check2 =1;
            break;
            }
            temp = years.split(delimiter);
            if(temp.length == 2 && years.length() > 6){
                // in the format year1-year2
                year1 = temp[0];
                year2 = temp[1];
                yr1 = Integer.parseInt(year1);
                yr2 = Integer.parseInt(year2);
                break;
            }else if(temp.length ==1 && years.length()== 4){
                year1 = temp[0];
                year2 = temp[0];
                yr1 = Integer.parseInt(year1);
                yr2 = Integer.parseInt(year2);
                break;
                // 2010 format
            }else if(years.charAt(0)=='-' && years.length()== 5){
                //-2010 format
                year1 = "1000";
                year2 = temp[1];
                yr1 = Integer.parseInt(year1);
                yr2 = Integer.parseInt(year2);
                break;
            }else if (temp.length ==1 && years.charAt(4)=='-'){
                //2010- format
                year1 = temp[0];
                year2 = "9999";
                yr1 = Integer.parseInt(year1);
                yr2 = Integer.parseInt(year2);
                break;
            }
        } while (check2 != 1);

        // do match checking here for books and display
        int i =0;
        int call = 0;
        int count =0 ;
        int gate1 =0,gate2 =0, gate3=0;
        String [] s1  = description.split("[ ]+");
        
        for ( i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getproductid().equalsIgnoreCase(productid)) { 
                gate1 =1;
                
            }
            String [] s2  = BookList.get(i).getdescription().split("[ ]+");
            for( String s : s1){
                for(String ss : s2){
                    if(ss.equalsIgnoreCase(s) /*&& call ==1*/){
                        //looking at counts for keywords and match later
                        count++;
                        
                    }
                }
               if(s1.length == count){
                gate2 =1;
                }
            }
            int bookYear = Integer.parseInt(BookList.get(i).getyears());
            if(bookYear <= yr2 && bookYear >= yr1){
                gate3 =1;
               
            }
            if(years.isEmpty()== true){
                gate3 =0;
            }
            // checking for the cases here to print according to conditions
            if (gate1 == 1 && gate2 ==1 && gate3 == 1){
                System.out.println(BookList.get(i).toString());
            }else if (gate1 ==1 && gate2 ==1 && gate3 == 0){
                System.out.println(BookList.get(i).toString());
            }else if (gate1 ==1 && gate2 ==0 && gate3 == 0){
                System.out.println(BookList.get(i).toString());
            }else if (gate1 ==1 && gate2 ==0 && gate3 == 1){
                System.out.println(BookList.get(i).toString());
            }else if (gate1 ==0 && gate2 ==1 && gate3 == 0){
                System.out.println(BookList.get(i).toString());
            }else if (gate1 ==0 && gate2 ==1 && gate3 == 1){
                System.out.println(BookList.get(i).toString());
            }else if (gate1 ==0 && gate2 ==0 && gate3 == 1){
                System.out.println(BookList.get(i).toString());
            } 
            if ( years.isEmpty()==true && productid.isEmpty()==true && description.isEmpty()==true){
                System.out.println(BookList.get(i).toString());
            }
        }

        // do match checking here for electronics and display
        int j = 0;
        int call2 = 0;
        int gate4 =0,gate5 =0, gate6=0;
        for ( j = 0; j <electronicsList.size(); j++) {
            if (electronicsList.get(j).getproductid().equalsIgnoreCase(productid)) { 
                gate4 =1;
            }
            String  [] s2  = electronicsList.get(j).getdescription().split("[ ]+");
            for(String s : s1){
                for(String ss : s2){
                    if(ss.equalsIgnoreCase(s) /*&&call ==1*/){
                       //looking at counts for keywords and match later
                        count++;
                    }
                }
                if(s1.length == count ){
                    gate5 =1;
                }
            }
            int elecYear = Integer.parseInt(electronicsList.get(j).getyears());
            if(elecYear <= yr2 && elecYear >= yr1){
                gate6 =1;
            }
            if(years.isEmpty()== true){
                gate6 =0;
            }
            // checking for the cases here to print according to conditions
            if (gate4 ==1 && gate5 ==1 && gate6 == 1){
                System.out.println(electronicsList.get(j).toString());
            }else if (gate4 ==1 && gate5 ==1 && gate6 == 0){
                System.out.println(electronicsList.get(j).toString());
            }else if (gate4 ==1 && gate5 ==0 && gate6 == 0){
                System.out.println(electronicsList.get(j).toString());
            }else if (gate4 ==1 && gate5 ==0 && gate6 == 1){
                System.out.println(electronicsList.get(j).toString());
            }else if (gate4 ==0 && gate5 ==1 && gate6 == 0){
                System.out.println(electronicsList.get(j).toString());
            }else if (gate4 ==0 && gate5 ==1 && gate6 == 1){
                System.out.println(electronicsList.get(j).toString());
            }else if (gate4 ==0 && gate5 ==0 && gate6 == 1){
                System.out.println(electronicsList.get(j).toString());
            }
            if ( years.isEmpty()==true && productid.isEmpty()==true && description.isEmpty()==true){
                System.out.println(electronicsList.get(j).toString());
            }

        }

        //match checking ends and prints
        System.out.println( "\n" + " The search is complete." + "\n" );
        // done
        
    }
    EStoreSearch( String search){

    }
    /**
     * 
     * @param years checks the function has the correct conditions
     * @return it based on value of true or false
     */
    public boolean setyears(String years ){
        String eq = "[0-9,-]+";
        if((years.length()== 4 && years.matches(eq)) || years.isEmpty()==true){
            this.years = years;
        }else{
            return false;
        }
        return true;
    }
    public String getyears(){
        return years;
    }
    /**
     * 
     * @param productid checks the function has the correct conditions
     * @return it based on value of true or false
     */
    public boolean setproductid(String productid ){
        if(productid.length()== 6){
            this.productid = productid;
        }else{
            return true;
        }
        return true;
    }
    public String getproductid(){
        return productid;
    }
    /**
     * 
     * @param description checks the function has the correct conditions
     * @return it based on value of true or false
     */
    public boolean setdescription(String description ){
        if(description.isEmpty()== true){
            return true;
        }else{
            this.description = description;
        }
        return true;
    }

    public String getdescription(){
        return description;
    }

}