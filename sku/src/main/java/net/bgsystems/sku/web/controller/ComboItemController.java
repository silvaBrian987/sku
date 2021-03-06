package net.bgsystems.sku.web.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.bgsystems.sku.business.entity.ComboItem;
import net.bgsystems.sku.business.service.IComboItemService;

@RestController
@RequestMapping("comboItem")
public class ComboItemController {
	private static final Logger LOGGER = LogManager.getLogger(ComboItemController.class);

	@Autowired
	private IComboItemService comboItemService;

	@RequestMapping(path = "findAll", method = RequestMethod.GET)
	public ResponseEntity<List<ComboItem>> findAll() throws Exception {
		return ResponseEntity.ok(comboItemService.findAll());
	}

	@RequestMapping("save")
	public ResponseEntity<ComboItem> save(@RequestBody ComboItem comboItem) throws Exception {
		LOGGER.debug(comboItem);
		comboItemService.save(comboItem);
		return ResponseEntity.ok(comboItem);
	}
}
