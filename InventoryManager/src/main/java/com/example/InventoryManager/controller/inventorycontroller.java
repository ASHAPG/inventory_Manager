package com.example.InventoryManager.controller;
 import com.example.InventoryManager.models.inventorymodel;
 import com.example.InventoryManager.repository.Inventoryrepo;
 import org.springframework.beans.BeanUtils;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;
 import java.util.List;

@RestController
@RequestMapping("/v1/inventory_manager")
public class inventorycontroller {
    @Autowired
    private Inventoryrepo inventoryrepo;

    @GetMapping
    public List<inventorymodel> list() {
        return inventoryrepo.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public inventorymodel get(@PathVariable Integer id) {
        return inventoryrepo.getOne(id);
    }

    @PostMapping
    public inventorymodel create(@RequestBody final inventorymodel session
    ){
        return inventoryrepo.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        inventoryrepo.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public inventorymodel update(@PathVariable Integer id, @RequestBody inventorymodel inventorymodel) {
        inventorymodel existingSession = inventoryrepo.getOne(id);
        BeanUtils.copyProperties(inventorymodel, existingSession, "session_id");
        return inventoryrepo.saveAndFlush(existingSession);
    }

}

