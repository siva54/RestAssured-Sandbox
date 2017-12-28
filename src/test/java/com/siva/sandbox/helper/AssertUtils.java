package com.siva.sandbox.helper;

import java.io.IOException;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import com.siva.sandbox.common.Error;
import com.siva.sandbox.exception.ApplicationAssertionException;

public class AssertUtils {
	private static final String JSON_DATA_VALIDATE_PATH = "src/test/resources/data/validate/json/";

	public static void compareJSON(String path, String jsonData) throws ApplicationAssertionException {
		try {
			JSONAssert.assertEquals(DataUtils.getJSONFromPath(JSON_DATA_VALIDATE_PATH + path), jsonData,
					JSONCompareMode.LENIENT);
		} catch (JSONException e) {
			throw new ApplicationAssertionException(Error.E10001, e);
		} catch (IOException e) {
			throw new ApplicationAssertionException(Error.E10000, e);
		}
	}
}