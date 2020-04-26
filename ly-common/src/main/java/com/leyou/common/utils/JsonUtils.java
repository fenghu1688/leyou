package com.leyou.common.utils;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static String objectToJson(Object object) {
		if (object != null) {
			try {
				String jsonData = MAPPER.writeValueAsString(object);
				return jsonData;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static <T> T jsonToObject(String jsonData, Class<T> clazz) {
		if (StringUtils.isNotBlank(jsonData)) {
			try {
				T t = MAPPER.readValue(jsonData, clazz);
				return t;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	public static <T> List<T> jsonToList(String jsonData, Class<T> clazz) {
		if (StringUtils.isNotBlank(jsonData)) {
			try {
				List<T> list = MAPPER.readValue(jsonData,
						MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
				return list;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	static class User{
		String name;
		Integer age;
	}

	public static void main(String[] args) {
        User user = new User( "jack",21);
        String json = objectToJson(user);
        System.out.println(json);

        User user1 = jsonToObject(json, User.class);
        System.out.println(user1);

        json="[20,10,30]";
        List<Integer> list = jsonToList(json, Integer.class);
        System.out.println(list);

        //language=JSON
        String jsons="{\"name\": \"jack\",\"age\": 21}";



    }
}
