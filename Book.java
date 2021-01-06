package eStoreSearch;
import java.util.Scanner;
/*import jdk.internal.jshell.tool.resources.version;*/
import java.util.ArrayList;

public class Book{
    private String author;
    private String years;
    private String productid;
    private String description;
    private String price;
    private String publisher;
    /**
     * Book makes the book from the booklist needed by to add to the list
     */
    Book (){
        int check2 =0,check3 =0,check4=0;
        Scanner object = new Scanner(System.in);
        Scanner object2 = new Scanner(System.in);
        Scanner object3 = new Scanner(System.in);
        Scanner object4 = new Scanner(System.in);
        Scanner object5 = new Scanner(System.in);
        Scanner object6 = new Scanner(System.in);
        /**
         * function declaraions and checks are declared here for input and checks
         */
        
        System.out.println("Please  type in the author name :");
        author = object.nextLine();

        do {
            System.out.println("Please type in the  year :");
            // taking in input and comparing against conditions
            years = object2.nextLine();
            // add condition for number only 
            String eq = "[0-9]+";
            if (years.matches(eq) && years.length() ==4){
                int year1 = Integer.parseInt(years);
                    if( 1000 > year1 && year1>9999){
                        check2 =0;
                    }else{
                        check2 =1;
                    }
            }else if(setyears(years)== true){
                check2 = 1;
            }
        }while (check2 != 1);

        do {
            System.out.println("Please  type in product id :");
            productid = object3.nextLine();
            // taking in input and comparing against conditions
            if(setproductid(productid)== true){
                check3 = 1;
            }

        }while (check3 != 1);

        do {
            System.out.println("Please type in the description :");
            description = object4.nextLine();
            if(setdescription(description)== true){
                check4 = 1;
            }
        }while (check4!= 1);
        int check5 =0;
        do {
        System.out.println("Please type in the Book price :");
        // taking in input and comparing against conditions
        price = object5.nextLine();
        if (setprice(price)==true){
            check5=1;
        }
        }while(check5 != 1);

        System.out.println("Please type in the publisher name :");
        publisher = object6.nextLine();
     
    }
    Book(String test)
    {

    }
    /**
     * 
     * @param author takes the author, sets and returns it
     */
    public void setauthor (String author){
        this.author = author ;
    }

    public String getauthor (){
        return author;
    }
    /**
     * 
     * @param years checks the function has the correct conditions
     * @return it based on value of true or false
     */
    public boolean setyears(String years ){
        String eq = "[0-9]+";
        if(years.length()== 4 && years.matches(eq)){
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
     * @param productid checks the function has the correct conditions of numerical values in this case
     * @return it based on value of true or false
     */
    public boolean setproductid(String productid ){
        String eq = "[0-9]+";
        if(productid.length()==6 && productid.matches(eq)){
            this.productid = productid;
        }else{
            return false;
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
            return false;
        }else{
            this.description = description;
        }
        return true;
    }

    public String getdescription(){
        return description;
    }
    /**
     * 
     * @param price checks price to see if it is correct integer
     * @return it based on value of true or false
     */
    public boolean setprice(String price ){
        String eq = "[0-9,.]+";
        if( price.matches(eq)){
            this.price = price;
        }else{
            return false;
        }
        return true;
    }

    public String getprice(){
        return price;
    }
    public String getpublisher(){
        return publisher;
    }
    /* to see if evrything is being stored and is printing */
    public String toString(){
        return " ----------Book------------- \n"+"| Product id : " + productid + " \n" +  "| Description : " + description + " \n" + "| Price Entered : $" + price + " \n" + "| Year : " + years + " \n" +"| Author : " + author + " \n" + "| Publisher : " + publisher + " \n " + "--------------------------- \n";
    }
}