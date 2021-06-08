package com.sophossolutions.utilities;

import com.google.gson.Gson;

import java.util.Map;

public class ConvertToJSon {

	public static String convetToJson(Map<String, String> dataTableBody) {
		Gson gson = new Gson();
		return gson.toJson(dataTableBody);
	}
}
