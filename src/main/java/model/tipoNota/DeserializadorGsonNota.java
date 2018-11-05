package model.tipoNota;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

public class DeserializadorGsonNota implements JsonDeserializer<Nota> {

	 @Override
	    public Nota deserialize(final JsonElement json,
	                            final Type typeOfT,
	                            final JsonDeserializationContext context) throws JsonParseException {

	        
	        JsonPrimitive valuePrimitive = json.getAsJsonPrimitive();

	        if (valuePrimitive.isNumber()) {
	            return new Numerica(valuePrimitive.getAsDouble());
	        }
	        else if (valuePrimitive.isString()) {
	            return new Conceptual(EnumConceptual.valueOf(valuePrimitive.getAsString()));
	        }
	        else {
	            throw new JsonParseException("DeserializadorNota: valor no reconocido");
	        }
	    }
	
	
}
