package scripts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Managment implements SetFiles{
    private String path;
    private String msg;
    private String key;
    private String objName;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    @Override
    public void writeFile(ArrayList<String> keys, ArrayList<String> vaules) {
        FileWriter fileWriter;
        JSONObject o = new JSONObject();
        JSONObject id = new JSONObject();

        try {
            for(int i = 0; i<keys.toArray().length; i++){
                o.put(keys.get(i), vaules.get(i));
            }
            id.put(this.objName, o);
            fileWriter = new FileWriter(this.path, true);
            fileWriter.write(id.toString());
            fileWriter.flush();
        }
        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
