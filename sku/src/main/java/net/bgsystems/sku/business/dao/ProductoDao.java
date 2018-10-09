package net.bgsystems.sku.business.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import net.bgsystems.sku.business.entity.Producto;
import net.bgsystems.util.dao.AbstractGenericDao;

@Repository
public class ProductoDao extends AbstractGenericDao<Producto> implements IProductoDao {
	public ProductoDao() {
		setEntityClass(Producto.class);
	}

	@Override
	public List<Producto> search(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Producto> cq = cb.createQuery(Producto.class);
		Root<Producto> rootEntry = cq.from(Producto.class);
		CriteriaQuery<Producto> all = cq.select(rootEntry).where(cb.like(rootEntry.get("nombre"), name.concat("%")));
		TypedQuery<Producto> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}
}
