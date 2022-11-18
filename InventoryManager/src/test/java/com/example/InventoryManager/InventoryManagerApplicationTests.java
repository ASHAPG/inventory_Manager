package com.example.InventoryManager;

import com.example.InventoryManager.models.inventorymodel;
import com.example.InventoryManager.repository.Inventoryrepo;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InventoryManagerApplicationTest {
	@Autowired
	Inventoryrepo inventoryrepo;

	@Test
	public void create() throws ParseException {
		inventorymodel p = new inventorymodel();
		String pattern = "yyyy-mm-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date d = simpleDateFormat.parse("2022-08-31");
		p.setInventoryid(24);
		p.setInventoryname("item24");
		p.setInventorytype("mobiles");
		p.setMfcyear(2014);
		p.setDbupdate(d);
		inventoryrepo.save(p);
		assertNotNull(inventoryrepo.findById(24).get());
	}

	@Test
	public void get() {
		List<inventorymodel> list = inventoryrepo.findAll();
		AssertionsForInterfaceTypes.assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void getById () {
		inventorymodel p = inventoryrepo.findById(5).get();
		assertEquals("engines", p.getInventorytype());
	}

	@Test
	public void update () {
		inventorymodel p = inventoryrepo.findById(12).get();
		p.setInventorytype("laptop");
		inventoryrepo.save(p);
		assertNotEquals("laptops", inventoryrepo.findById(12).get().getInventorytype());
	}

	@Test
	public void delete () {
		inventoryrepo.deleteById(22);
		AssertionsForInterfaceTypes.assertThat(inventoryrepo.existsById(19)).isFalse();
	}

}