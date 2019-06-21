package Helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Created by Petert on 5/23/19.
 */
public class Helpers {

    private static Helpers myself = new Helpers();

    private Helpers() {
    }

    public static Helpers getInstance() {
        if (myself == null) {
            myself = new Helpers();
        }

        return myself;
    }

    public String   getINN() {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(getFileFromResources("inn.json")));

            JSONArray jsonArray = (JSONArray) obj;
            JSONObject jsonObject;
            JSONObject writeJsonObject = new JSONObject();

            for (int i=0; i<jsonArray.size(); i++) {
                jsonObject = (JSONObject) jsonArray.get(i);
                String used = jsonObject.get("used").toString();

                if (used.equals("no")) {
                    String inn = jsonObject.get("inn").toString();
                    jsonArray.remove(i);
                    writeJsonObject.put("inn", inn);
                    writeJsonObject.put("used", "yes");

                    jsonArray.add(writeJsonObject);
                    writeJSONtoFile(jsonArray);
                    return inn;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public JSONArray getAllInns() {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(getFileFromResources("inn.json")));

            JSONArray jsonArray = (JSONArray) obj;

                    return jsonArray;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public void writeJSONtoFile(JSONArray jsonArray) {
        try {
            FileWriter fileWriter = new FileWriter(getFileFromResources("inn.json"));
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFileFromResources(String fileName) throws URISyntaxException {
        String fileUrl = "";
        URL res = getClass().getClassLoader().getResource(fileName);
        File file = Paths.get(res.toURI()).toFile();
        fileUrl = file.getAbsolutePath();
        return fileUrl;
    }

}
