package org.inventory.service.controller;

import java.util.List;

import org.inventory.service.response.InventoryResponse;
import org.inventory.service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
//@RequiredArgsConstructor
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	//	@GetMapping("/{sku-code}")
	//	@ResponseStatus(HttpStatus.OK)
	//	public boolean isInStock(@PathVariable("sku-code") String skuCode) {
	//		return inventoryService.isInStock(skuCode);
	//	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
		return inventoryService.isInStock(skuCode);
	}
}
