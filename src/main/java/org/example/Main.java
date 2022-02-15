package org.example;

import org.example.configuration.BasicConfiguration;
import org.example.view.PrintCoins;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BasicConfiguration.class);
        applicationContext.refresh();
        PrintCoins printCoins = applicationContext.getBean(PrintCoins.class);
        //printCoins.printCoinsWithinPriceRange(15f, 20f);
        //printCoins.printGainers();
        //printCoins.printSearchResult("DOGE");
        printCoins.printTopGainers();
    }
}
