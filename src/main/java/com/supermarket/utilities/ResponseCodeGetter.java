package com.supermarket.utilities;

import java.net.HttpURLConnection;
import java.net.URL;

public class ResponseCodeGetter {

	public int getResponseCode(String url) {
		int responseCode = 0;
		HttpURLConnection huc = null;
		try {
			huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			responseCode = huc.getResponseCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseCode;
	}
}
