package net.bgsystems.sku.util.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.bgsystems.sku.business.entity.Type;
import net.bgsystems.sku.util.EnumLocaleConversor;

public class TypeSerializer extends StdSerializer<Type> {

	public TypeSerializer() {
		super(Type.class);
	}

	@Override
	public void serialize(Type value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		try {
			String strValue = EnumLocaleConversor.getInstance().enumToString(Type.class, value);
			gen.writeString(strValue != null ? strValue : value.name());
		} catch (Exception e) {
			throw new IOException("No se pudo convertir el valor", e);
		}
	}
}