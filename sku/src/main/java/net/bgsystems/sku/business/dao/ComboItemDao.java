package net.bgsystems.sku.business.dao;

import org.springframework.stereotype.Repository;

import net.bgsystems.sku.business.entity.ComboItem;
import net.bgsystems.util.dao.AbstractGenericDao;

@Repository
public class ComboItemDao extends AbstractGenericDao<ComboItem> implements IComboItemDao {
	public ComboItemDao() {
		setEntityClass(ComboItem.class);
	}
}
