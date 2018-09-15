package net.bgsystems.sku.business.dao;

import org.springframework.stereotype.Repository;

import net.bgsystems.sku.business.entity.Producto;
import net.bgsystems.util.dao.AbstractGenericDao;

@Repository
public class ProductoDao extends AbstractGenericDao<Producto> implements IProductoDao {
	public ProductoDao() {
		setEntityClass(Producto.class);
	}
}
