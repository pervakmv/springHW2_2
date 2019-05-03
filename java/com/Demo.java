package com;

import com.controller.ItemController;
import com.repository.ItemDAO;

public class Demo {
    public static void main(String[] args) {
        ItemController itemController = new ItemController();
        ItemDAO itemDAO = new ItemDAO();

        System.out.println("Start");
        System.out.println(itemDAO.itemsList());


    }
}
