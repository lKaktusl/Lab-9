package com.company;

public class Main {

    public static void main(String[] args) {
        Product product1 = new Product("Shopcountry", "Одесса,Пушкинская,1", "dweed23", "Хлопья", 30,
                1);

        Product product2 = new Product("bestmarket", "Одесса,Пушкинская,2", "dweed23", "Хлопья", 50,
                1);

        Product product3 = new Product("Shopcountry", "Одесса,Пушкинская,3", "dweed23", "Бублики", 30,
                5);

        Product product4 = new Product("Shopcountry", "Одесса,Пушкинская,4", "dweed23", "Хлопья", 30,
                1);

        Product product5 = new Product("Shopcountry", "Одесса,Пушкинская,5", "dweed23", "Хлопья", 30,
                1);

        FileControl files = new FileControl();
        files.createFiles();

        ProductsArrayList products = new ProductsArrayList();
        /*products.addNewProductItem(product1);
        products.addNewProductItem(product2);
        products.addNewProductItem(product3);
        products.addNewProductItem(product4);
        products.addNewProductItem(product5);

        products.Save(files.getNameMainFile());

        products.deleteAll();
        products.showProductArrayList();*/
        products.Load(files.getNameMainFile());
        products.showProductArrayList();
        products.deleteProductWithIndicatedPrice(1);
    }
}

