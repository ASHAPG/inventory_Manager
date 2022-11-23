package com.example.InventoryManager.controller;


import com.example.InventoryManager.Service.inventoryServiceImpl;
import com.example.InventoryManager.models.inventorymodel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/inventory_manager")
public class inventorycontroller {

    @Autowired
    private inventoryServiceImpl inventoryServiceimpl;

    @GetMapping
    public List<inventorymodel> list() {
        return inventoryServiceimpl.get();
    }

    @GetMapping
    @RequestMapping("{id}")
    public inventorymodel getbyId(@PathVariable Integer id) {
        return inventoryServiceimpl.getbyId(id);
    }

    @PostMapping
    public inventorymodel create(@RequestBody final inventorymodel inventorymodel){
        return inventoryServiceimpl.create(inventorymodel);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        inventoryServiceimpl.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public inventorymodel update(@PathVariable Integer id, @RequestBody inventorymodel inventorymodel) {
        inventorymodel m = inventoryServiceimpl.getbyId(id);
        BeanUtils.copyProperties(inventorymodel,m,"inventoryid");

        return inventoryServiceimpl.update(id,m);
    }

}