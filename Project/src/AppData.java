import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;

public class AppData {

    private static AppData instance = null;

    private AppData() { }

    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }

    public String loadData(String dataFile) {
        try {
            // Espera un segon
            Thread.sleep(1000);

            // Llegir l'arxiu que està dins del .jar
            try (InputStream is = getClass().getResourceAsStream(dataFile);
                Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {

                StringBuilder content = new StringBuilder();
                char[] buffer = new char[1024];
                int bytesRead;

                while ((bytesRead = reader.read(buffer)) != -1) {
                    content.append(buffer, 0, bytesRead);
                }

                return content.toString();

            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("Error al llegir l'arxiu: " + dataFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al carregar les dades.");
        }
    }
}
