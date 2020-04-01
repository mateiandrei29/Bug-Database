package ui;

import java.util.Scanner;

import service.Service;

public class Ui {
    private Service service;

    public Ui(Service service) {
        this.service = service;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            System.out.println("1. Add product \n2. Delete product \n3. Update product\n4. Get all products\n\n0. Exit");
            try {
                int option = Integer.parseInt(sc.nextLine());
                switch (option) {
                    case 0:
                        System.exit(1);
                    case 1:
                        System.out.println("Name: ");
                        String name = sc.nextLine();
                        System.out.println("Description: ");
                        String description = sc.nextLine();
                        System.out.println("Finished?: ");
                        int finished = Integer.parseInt(sc.nextLine());
                        service.addProduct(name, description, finished);
                        break;
                    case 2:
                        System.out.println("Product name for deleting: ");
                        String nameDelete = sc.nextLine();
                        service.deleteProduct(nameDelete);
                        break;

                    case 3:
                        System.out.println("Choose the product you want to update by name: \n");
                        String toUpdate = sc.nextLine();
                        System.out.println("Name: ");
                        String nameUp = sc.nextLine();
                        System.out.println("Description: ");
                        String descriptionUp = sc.nextLine();
                        System.out.println("Finished?: ");
                        int finishedUp = Integer.parseInt(sc.nextLine());
                        service.updateProduct(toUpdate, nameUp, descriptionUp, finishedUp);
                        break;
                    case 4:
                        System.out.println(service.getAllProducts());
                        break;
                }
            } catch (Exception e) {
                System.out.println("Wrong input.");
                System.out.println(e.getMessage());
            }

        }

    }

}
