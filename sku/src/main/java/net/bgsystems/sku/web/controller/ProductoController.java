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

import net.bgsystems.sku.business.entity.Producto;
import net.bgsystems.sku.business.service.IProductoService;

@RestController
@RequestMapping("producto")
public class ProductoController {
	private static final Logger LOGGER = LogManager.getLogger(ProductoController.class);

	@Autowired
	private IProductoService productoService;

	@RequestMapping(path = "findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> findAll() throws Exception {
		return ResponseEntity.ok(productoService.findAll());
	}

	@RequestMapping("save")
	public ResponseEntity<Producto> save(@RequestBody Producto producto) throws Exception {
		LOGGER.debug(producto);
		productoService.save(producto);
		return ResponseEntity.ok(producto);
	}
}
