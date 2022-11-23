package com.example.InventoryManager.Service;

import com.example.InventoryManager.models.inventorymodel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface inventoryServiceImpl {

    List<inventorymodel> get();

    inventorymodel getbyId(Integer id);

    inventorymodel create(inventorymodel inventorymodel);

    void delete(Integer id);

    inventorymodel update(Integer id, inventorymodel inventorymodel);
}
