package com.example.InventoryManager.repository;
import com.example.InventoryManager.models.inventorymodel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Inventoryrepo extends JpaRepository<inventorymodel, Integer> {

}




