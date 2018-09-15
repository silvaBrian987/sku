package net.bgsystems.sku.util.jackson;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import net.bgsystems.sku.business.entity.Type;

public class ObjectMapperProvider {
	public static ObjectMapper createDefaultMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, false);
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"));

		SimpleModule myModule = new SimpleModule("myModule");
		myModule.addDeserializer(Type.class, new TypeDeserializer());
		myModule.addSerializer(Type.class, new TypeSerializer());
		mapper.registerModule(myModule);

		return mapper;
	}
}
