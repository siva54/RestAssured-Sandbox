package com.siva.sandbox.helper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class DataUtils {
	public static String getJSONFromPath(String path) throws IOException {
		String json = null;
		json = FileUtils.readFileToString(new File(path), Charset.defaultCharset());
		return json;
	}
}
