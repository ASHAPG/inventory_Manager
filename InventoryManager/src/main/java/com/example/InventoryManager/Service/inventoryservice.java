package com.example.InventoryManager.Service;


import com.example.InventoryManager.models.inventorymodel;
import com.example.InventoryManager.repository.Inventoryrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inventoryservice implements inventoryServiceImpl {

    @Autowired
    private Inventoryrepo inventoryrepo;


    public inventoryservice(){

    }
    @Override
    public List<inventorymodel> get() {
        return inventoryrepo.findAll();
    }

    @Override
    public inventorymodel getbyId(Integer id) {
        return inventoryrepo.getReferenceById(id);
    }


    @Override
    public inventorymodel create(inventorymodel inventorymodel) {
        return inventoryrepo.save(inventorymodel);
    }

    @Override
    public void delete(Integer id) {
        inventoryrepo.deleteById(id);
    }


    @Override
    public inventorymodel update(Integer id, inventorymodel inventorymodel) {
        if (inventoryrepo.existsById(id)) {
            inventoryrepo.save(inventorymodel);
        }
        return inventorymodel;
    }

}