package application;

import entities.Product;
import services.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        String path = "teste.txt";

        List<Product> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {
                String[] fields= line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }


            System.out.println("Products on file teste.txt " + list);

            Product x = CalculationService.max(list);

            System.out.println("Most expanse is: " + x);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }


    }


}
