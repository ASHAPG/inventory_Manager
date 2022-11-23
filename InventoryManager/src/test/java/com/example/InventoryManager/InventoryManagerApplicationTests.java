package com.example.InventoryManager;

import com.example.InventoryManager.Service.inventoryservice;
import com.example.InventoryManager.models.inventorymodel;
import com.example.InventoryManager.repository.Inventoryrepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class InventoryManagerApplicationTest {

	@Autowired
	private inventoryservice inventoryservice;
	@MockBean
	private Inventoryrepo inventoryrepo;


	@Test
	public void get() {
		when(inventoryrepo.findAll()).thenReturn(Stream
				.of(new inventorymodel(1, "item1", "mobile",2014, LocalDate.parse("2021-11-09")), new inventorymodel(2, "item2", "desktop", 2022,LocalDate.parse("2006-09-12"))).collect(Collectors.toList()));
		assertEquals(2, inventoryservice.get().size());
	}


	@Test
	public void getById () {
		inventoryservice.getbyId(3);
		verify(inventoryrepo,times(1)).getReferenceById(3);
	}

	@Test
	public void create() throws ParseException {
		inventorymodel i = new inventorymodel(4,"item","mobiles",2011,LocalDate.parse("2013-12-05"));
		when(inventoryrepo.save(i)).thenReturn(i);
		assertEquals(i,inventoryservice.create(i));
	}

	@Test
	public void update() {
		Integer id = 3;
		inventorymodel inventory = new inventorymodel(3, "item3", "Metal",2020 ,LocalDate.parse("2007-10-03"));
		when(inventoryrepo.save(inventory)).thenReturn(inventory);
		assertEquals(inventory, inventoryservice.update(id,inventory));
	}


	@Test
	public void delete () {
		Integer id = 4;
		inventoryservice.delete(id);
		verify(inventoryrepo,times(1)).deleteById(id);
	}


}