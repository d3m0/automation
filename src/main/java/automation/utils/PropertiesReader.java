package automation.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrii Mogyla
 * @since 19.04.2021
 */
@Slf4j
public class PropertiesReader {
    public static Map<String, String> getProperties() {
        InputStream fileFromResourceAsStream = getFileFromResourceAsStream();

        Map<String, String> result = new HashMap<>();
        try (InputStreamReader streamReader = new InputStreamReader(fileFromResourceAsStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("=");
                result.put(split[0].trim(), split[1].trim());
            }

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return result;
    }

    private static InputStream getFileFromResourceAsStream() {
        String fileName = "automation.properties";
        // The class loader that loaded the class
        ClassLoader classLoader = PropertiesReader.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}