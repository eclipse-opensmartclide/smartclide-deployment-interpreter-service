package com.smartclide.pipeline_converter.output;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.ser.std.NonTypedScalarSerializerBase;

public class UnquotedSerializer extends NonTypedScalarSerializerBase<String>
{
   public UnquotedSerializer() { 
	   super(String.class); 
   }

   /**
    * For Strings, both null and Empty String qualify for emptiness.
    */
   @Override
   public boolean isEmpty(String value) {
      return (value == null) || (value.length() == 0);
   }

   @Override
   public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
      jgen.writeRawValue(value);
   }

   public JsonNode getSchema(SerializerProvider provider, Type typeHint) {
      return createSchemaNode("string", true);
   }

   @Override
   public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException {
      if (visitor != null) visitor.expectStringFormat(typeHint);
   }
}