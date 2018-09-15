package net.bgsystems.sku.util.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.bgsystems.sku.business.entity.Type;
import net.bgsystems.sku.util.EnumLocaleConversor;

public class TypeDeserializer extends StdDeserializer<Type> {

	public TypeDeserializer() {
		super(TypeDeserializer.class);
	}

	@Override
	public Type deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		try {
			String value = null;
			JsonNode root = p.readValueAsTree();
			
			if(root.isValueNode()) {
				value = root.asText();
			}else {
				JsonNode typeNode = root.get("type");
				
				if(typeNode == null)
					throw new Exception("No se encontro campo con nombre \"type\"");
				
				value = typeNode.asText();
			}
			
			return (Type) EnumLocaleConversor.getInstance().stringToEnum(Type.class, value);
		} catch (Exception e) {
			throw new IOException("No se pudo convertir el valor", e);
		}
	}
}