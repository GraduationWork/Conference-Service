package com.conference.services.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.util.StreamUtils;

public class ResourceUtils {

	public static File loadFileFromClasspath(String path) throws IOException {
		InputStream is = ResourceUtils.class.getResourceAsStream(path);
		File file = new File("temp");
		OutputStream os = new FileOutputStream(file);
		StreamUtils.copy(is, os);
		return file;
	}

}
