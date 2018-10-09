package net.bgsystems.sku.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.bgsystems.sku.business.dao.IProductoDao;
import net.bgsystems.sku.business.entity.Producto;
import net.bgsystems.util.dao.IGenericDao;
import net.bgsystems.util.service.AbstractGenericService;

@Service
public class ProductoService extends AbstractGenericService<Producto> implements IProductoService {

	@Autowired
	@Override
	public void setDao(@Qualifier("productoDao") IGenericDao<Producto> dao) {
		this.dao = dao;
	}

	@Override
	public List<Producto> search(String name) {
		return ((IProductoDao) dao).search(name);
	}

}
