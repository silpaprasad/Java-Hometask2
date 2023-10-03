import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import java.util.Scanner;
import java.time.Year;
public class Car{
        int carId;
        String make;
        String model;
        int manufactureYear;
        String color;
        double price;
        String regNumber;
    public Car(int id, String make, String model, int manufactureYear, String color, double price, String regNumber){
        this.carId = id;
        this.make = make;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.color = color;
        this.price = price;
        this.regNumber = regNumber;
    }
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public int getYear(){
        return manufactureYear;
    }
    public double getPrice(){
        return price;
    }
    public String getCarDetails(){
        return carId+","+make+","+model+","+manufactureYear+","+color+","+price+","+regNumber;
        
    }
    public static void main(String[] args){
        Car[] cars = new Car[5];
        cars[0] = new Car(1, "tata", "Altroz", 2022, "blue", 500000.0, "KL1234");
        cars[1] = new Car(2, "Maruti", "Alto", 2000, "red", 200000.0, "KL2351");
        cars[2] = new Car(3, "Maruti", "wagonr", 2010, "white", 400000.0, "KL0012");
        cars[3] = new Car(4, "tata", "nexon", 2022, "blue", 900000.0, "KL4512");
        cars[4] = new Car(5, "Maruti", "Alto", 2000, "black", 200000.0, "KL2353");
        try{
            File file1 = new File("CarFile1.txt");
            file1.createNewFile();
            File file2 = new File("CarFile2.txt");
            file2.createNewFile();
            File file3 = new File("CarFile3.txt");
            file3.createNewFile();
                //System.out.println("File created: " + file1.getName());
            
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        saveCars(cars, "tata");
        saveCars(cars, "Alto", 10);
        saveCars(cars, 2010, 300000.0);
    }

    public static void saveCars(Car[] cars, String make){
        for (Car car : cars) {
            if (car.getMake().equals(make)){
                try{
                FileWriter fWriter = new FileWriter("CarFile1.txt");
                fWriter.write(car.getCarDetails());
                fWriter.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void saveCars(Car[] cars, String model, int years){
        for (Car car : cars) {
            int currentYear = Year.now().getValue();
            if (car.getModel().equals(model) && currentYear-car.getYear()>years){
                try{
                FileWriter fWriter = new FileWriter("CarFile2.txt");
                fWriter.write(car.getCarDetails());
                fWriter.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
     public static void saveCars(Car[] cars, int year, double price){
        for (Car car : cars) {
             if (car.getYear()==year && car.getPrice()>price){
                try{
                FileWriter fWriter = new FileWriter("CarFile3.txt");
                fWriter.write(car.getCarDetails());
                fWriter.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
