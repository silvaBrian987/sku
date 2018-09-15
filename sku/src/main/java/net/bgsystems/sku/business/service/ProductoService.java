package net.bgsystems.sku.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

}
