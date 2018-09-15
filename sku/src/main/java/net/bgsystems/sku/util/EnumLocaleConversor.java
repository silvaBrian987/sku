package net.bgsystems.sku.util;

import java.util.Properties;

import org.apache.log4j.Logger;

import net.bgsystems.util.conversor.AbstractEnumLocaleConversor;

public class EnumLocaleConversor extends AbstractEnumLocaleConversor {
	private static final Logger LOGGER = Logger.getLogger(EnumLocaleConversor.class);
	private static EnumLocaleConversor INSTANCE;
	private static final String PROPERTY_LOCATION = "net/bgsystems/sku/config/enumLocale.properties";

	private EnumLocaleConversor() throws Exception {
		try {
			props = new Properties();
			props.load(getClass().getClassLoader().getResourceAsStream(PROPERTY_LOCATION));
		} catch (Exception e) {
			LOGGER.error("No se pudo obtener las propiedades por el siguiente error: " + e.getMessage());
			throw e;
		}
	}

	public static EnumLocaleConversor getInstance() throws Exception {
		if (INSTANCE == null) {
			INSTANCE = new EnumLocaleConversor();
		}
		return INSTANCE;
	}
}
