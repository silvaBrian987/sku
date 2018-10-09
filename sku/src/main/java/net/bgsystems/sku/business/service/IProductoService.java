package net.bgsystems.sku.business.service;

import java.util.List;

import net.bgsystems.sku.business.entity.Producto;
import net.bgsystems.util.service.IGenericService;

public interface IProductoService extends IGenericService<Producto> {
	List<Producto> search(String name);
}
