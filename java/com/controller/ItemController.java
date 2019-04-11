package com.controller;

import com.model.Item;
import com.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemController {
    //private ItemSer
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET, value = "/add", produces = "text/plain")
    public @ResponseBody
    Item add(Item item) {
        //return itemService.add(item);
        System.out.println("add");
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete", produces = "text/plain")
    public @ResponseBody
    Item delete(long id) {

        //return itemService.delete(id);
        System.out.println("delete");
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/update", produces = "text/plain")
    public @ResponseBody
    Item update(Item item) {

        //return itemService.update(item);
        System.out.println("update");
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findById", produces = "text/plain")
    public @ResponseBody
    Item findById(long id) {

        //return itemService.findById(id);
        System.out.println("findById");
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list", produces = "text/plain")
    public @ResponseBody
    List<Item> itemsList() {


        return itemService.itemsList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findByName", produces = "text/plain")
    public @ResponseBody
    Item findByName(String name) {
        return itemService.findByName(name);
    }

}
