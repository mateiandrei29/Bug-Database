package main;

import model.Bug;
import model.Product;
import repository.ProductRepository;
import validator.ProductValidator;
import service.Service;
import ui.Ui;

public class Main {

    public static void main(String[] args) {

//		Bug b=new Bug();
//		b.readBug(1);
//		System.out.println("///////////////////////////////////////");
        //Bug.addBug(new Bug("Bug added from the app","noss.png","UX",2,"low",2,3,1)); working

        ProductValidator validator=new ProductValidator();
        Service service= new Service(validator);
        Ui ui =new Ui(service);
        ui.run();

    }

}
