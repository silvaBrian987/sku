package net.bgsystems.sku.web.config.converter;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

import net.bgsystems.sku.business.entity.Type;
import net.bgsystems.sku.util.EnumLocaleConversor;

public class StringToTypeConverter implements Converter<String, Type> {
	private static final Logger LOGGER = Logger.getLogger(StringToTypeConverter.class);
	
	public Type convert(String source) {
		try {
			return (Type) EnumLocaleConversor.getInstance().stringToEnum(Type.class, source);
		} catch (Exception e) {
			LOGGER.error("No se pudo convertir el valor", e);
			return null;
		}
	}
	
}
