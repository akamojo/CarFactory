import com.sun.org.apache.xpath.internal.operations.Or;
import xml.Item;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int cars = 0;
    public static int mot = 0;
    public static int tru = 0;

    private static boolean beginning = false;

    private static ArrayList<Order> orders;


    static int processLine(String line) {

        if(line.compareTo("<order>") == 0) beginning = true;
        else{
            if(beginning) {
                if (line.compareTo("</order>") == 0) {
                    orders.add(new Order(cars, mot, tru));
                    beginning = false;
                    return 1;
                } else {
                    if (line.contains("car")) cars++;
                    else if (line.contains("motorcycle")) mot++;
                    else if (line.contains("truck")) tru++;
                    return 0;
                }
            }
        }
        return 0;

    }

    static String getContent(String file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    static void inputFromStdin(Company com) {

        System.out.println("----------------- TYPE YOUR ORDER IN XML FORMAT -----------------\n");
        com.setStdin(true);

        Scanner scan = new Scanner(System.in);

        while (true) {
            String input = scan.nextLine();
            int stat = processLine(input);
            if(stat == 1) {
                com.addOrder(orders.get(orders.size() - 1));
            }
        }
    }

    static void inputFromXmlFile(String file, Company com) {
        try {

            System.out.println("----------------- PROCESSING XML FILE -----------------\n");

            String xml = getContent(file);
            System.out.println(xml);

            StringReader reader = new StringReader(xml);
            JAXBContext context = JAXBContext.newInstance(xml.Order.class);
            Unmarshaller un = context.createUnmarshaller();

            xml.Order orderData = (xml.Order) un.unmarshal(reader);
            List<Item> items = orderData.getItems();

            for (Item e : items) {
                if (e.type.compareTo("car") == 0) cars++;
                else if (e.type.compareTo("motorcycle") == 0) mot++;
                else if (e.type.compareTo("truck") == 0) tru++;
            }

            orders.add(new Order(cars, mot, tru));
            com.addOrder(orders.get(orders.size() - 1));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // write your code here

        System.out.println("----------------- WELCOME IN CAR FACTORY -----------------\n");

        Company com = new Company();
        com.start();
        orders = new ArrayList<>();

        //inputFromStdin(com);
        inputFromXmlFile("dataIn.xml", com);

    }
}
