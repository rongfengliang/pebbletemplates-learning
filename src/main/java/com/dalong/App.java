package com.dalong;

import io.minio.MinioClient;
import io.pebbletemplates.pebble.PebbleEngine;
import io.pebbletemplates.pebble.loader.DelegatingLoader;
import io.pebbletemplates.pebble.template.PebbleTemplate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("minio", "minio123")
                        .build();
        DelegatingLoader delegatingLoader = new DelegatingLoader(Arrays.asList(new S3Loader(minioClient,"demoapp")));
        PebbleEngine engine = new PebbleEngine.Builder().loader(delegatingLoader).build();
        PebbleTemplate compiledTemplate = engine.getTemplate("home.html");
        Map<String, Object> context = new HashMap<>();
        context.put("name", "Mitchell");
        Writer writer = new StringWriter();
        compiledTemplate.evaluate(writer, context);
        String output = writer.toString();
        System.out.println(output);
    }
}
