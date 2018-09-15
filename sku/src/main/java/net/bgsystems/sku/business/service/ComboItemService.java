package net.bgsystems.sku.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.bgsystems.sku.business.entity.ComboItem;
import net.bgsystems.util.dao.IGenericDao;
import net.bgsystems.util.service.AbstractGenericService;

@Service
public class ComboItemService extends AbstractGenericService<ComboItem> implements IComboItemService {
	
	@Autowired
	@Override
	public void setDao(@Qualifier("comboItemDao") IGenericDao<ComboItem> dao) {
		this.dao = dao;
	}

}
