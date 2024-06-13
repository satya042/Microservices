package org.inventory.service.service;

import java.util.List;

import org.inventory.service.repository.InventoryRepository;
import org.inventory.service.response.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skuCode) {

		// return inventoryRepository.findBySkuCode(skuCode).isPresent();

		return inventoryRepository.findBySkuCodeIn(skuCode).stream().map(inventory -> InventoryResponse.builder()
				.skuCode(inventory.getSkuCode()).isInStock(inventory.getQuntity() > 0).build()).toList();
	}

}
