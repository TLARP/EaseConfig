package config;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by oclous on 16-9-5.
 * Object 保存了配置的配置的文件信息
 */
public class ConfigInfoObject implements Serializable {

    private static final long serialVersionUID = -6430130697538767981L;

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public Map<String, ArrayList<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, ArrayList<String>> map) {
        this.map = map;
    }

    private ArrayList<String> arrayList;

    private Map< String,ArrayList<String> > map;


    public ConfigInfoObject(){
        arrayList=new ArrayList<>();
        map=new HashMap<String ,ArrayList<String> >();
    }
}
