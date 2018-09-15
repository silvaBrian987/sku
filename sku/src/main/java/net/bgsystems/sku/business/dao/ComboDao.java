package net.bgsystems.sku.business.dao;

import org.springframework.stereotype.Repository;

import net.bgsystems.sku.business.entity.Combo;
import net.bgsystems.util.dao.AbstractGenericDao;

@Repository
public class ComboDao extends AbstractGenericDao<Combo> implements IComboDao {
	
	public ComboDao() {
		setEntityClass(Combo.class);
	}

}
