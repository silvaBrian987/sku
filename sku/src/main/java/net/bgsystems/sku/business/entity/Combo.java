package net.bgsystems.sku.business.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Combo implements Serializable {
	@Id
    @GenericGenerator(name = "sku", strategy = "net.bgsystems.sku.business.entity.generator.SkuGenerator")
    @GeneratedValue(generator = "sku")  
    @Column(name="sku")
	private String sku;
	@Column
	private String nombre;
	@OneToOne
	private ComboItem itemBase;
	@ManyToMany
	private Set<ComboItem> items;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ComboItem getItemBase() {
		return itemBase;
	}

	public void setItemBase(ComboItem itemBase) {
		this.itemBase = itemBase;
	}

	public Set<ComboItem> getItems() {
		return items;
	}

	public void setItems(Set<ComboItem> items) {
		this.items = items;
	}
}
