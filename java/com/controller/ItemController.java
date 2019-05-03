package com.controller;

import com.model.Item;
import com.service.ItemService;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class ItemController {
    //private ItemSer
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.POST, value = "/add", produces = "text/plain")
    public String add(@RequestBody String item) {
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        objectMapper.setDateFormat(df);

        try {
            Item newItem = objectMapper.readValue(item, Item.class);
            newItem.setId((long)0); //Поскольку Id генерируется автоматически
            itemService.add(newItem);
        } catch (JsonParseException e) {
            System.out.println("Exception Occured whiile converting the Json into java" + e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println("Exception Occured whiile converting the Json into java" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exception Occured whiile converting the Json into java" + e.getMessage());
        }
        return item;
    }

    //Пробный запрос
    @RequestMapping(value = "/something", method = RequestMethod.POST)
    public void handle(@RequestBody String body, Writer writer) throws IOException {
        writer.write(body);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}", produces = "text/plain")
    public @ResponseBody
    void delete(@PathVariable String id) {
        itemService.delete(Long.parseLong(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update", produces = "text/plain")
    public String update(@RequestBody String item) {
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        objectMapper.setDateFormat(df);
        try {
            Item updatingItem = objectMapper.readValue(item, Item.class);
            itemService.update(updatingItem);

        } catch (JsonParseException e) {
            System.out.println("Exception Occured whiile converting the Json into java" + e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println("Exception Occured whiile converting the Json into java" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exception Occured whiile converting the Json into java" + e.getMessage());
        }
        return item;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findById/{id}", produces = "text/plain")
    public @ResponseBody
    Item findById(@PathVariable String id) {
        System.out.println(id);
        Item item = itemService.findById(Long.parseLong(id));
        System.out.println(item);
        return item;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list", produces = "text/plain")
    public @ResponseBody
    List<Item> itemsList() {
        List<Item> resList = itemService.itemsList();
        System.out.println(resList);
        return resList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findByName", produces = "text/plain")
    public @ResponseBody
    Item findByName(String name) {
        return itemService.findByName(name);
    }

}
