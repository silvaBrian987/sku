package net.bgsystems.sku.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.bgsystems.sku.business.entity.Combo;
import net.bgsystems.util.dao.IGenericDao;
import net.bgsystems.util.service.AbstractGenericService;

@Service
public class ComboService extends AbstractGenericService<Combo> implements IComboService {

	@Autowired
	@Override
	public void setDao(@Qualifier("comboDao") IGenericDao<Combo> dao) {
		this.dao = dao;
	}

}
