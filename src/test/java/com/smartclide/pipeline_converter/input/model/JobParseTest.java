//package com.smartclide.pipeline_converter.input.model;
//
//import org.junit.jupiter.api.Test;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class JobParseTest {
//	@Test
//	public void testDeSerializingWithJsonSetter() throws IOException {
//	  String jsonString = "{\"personId\": 231, \"personName\": \"Mary Parker\", \"emailId\": \"mary@gmail.com\", \"gender\": \"female\"}";
//	  ObjectMapper mapper = new ObjectMapper();
//	  Job bean = objectMapper.readValue(jsonString, Job.class);
//	  System.out.println(bean);
//	  assertThat(bean.personName, is(equalTo("Mary Parker")));
//	  assertThat(bean.personId, is(equalTo(231L)));
//	  assertEquals("female", bean.getProperties().get("gender"));
//	}
//}
