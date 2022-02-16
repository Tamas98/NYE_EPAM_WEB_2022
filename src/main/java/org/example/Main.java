package org.example;

import org.example.view.PrintCoins;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);//init the context
        PrintCoins printCoins = applicationContext.getBean(PrintCoins.class);
        //printCoins.printCoinsWithinPriceRange(15f, 20f);
        //printCoins.printGainers();
        //printCoins.printSearchResult("DOGE");
        printCoins.printTopGainers();
    }
}
