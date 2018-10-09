package net.bgsystems.sku.business.dao;

import java.util.List;

import net.bgsystems.sku.business.entity.Producto;
import net.bgsystems.util.dao.IGenericDao;

public interface IProductoDao extends IGenericDao<Producto> {
	List<Producto> search(String name);
}
