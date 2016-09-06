import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by oclous on 16-9-5.
 */
public class ConfigInfoObject implements Serializable {

    private static final long serialVersionUID = -6430130697538767981L;

    private ArrayList<String> arrayList;

    private Map< String,ArrayList<String> > map;

    //项目的根路径
    private String PROJECTRESOUCEPATH;

    public ConfigInfoObject(){
        ArrayList<String> arrayList=new ArrayList<>();
        Map< String,ArrayList<String> > map=new HashMap<String ,ArrayList<String> >();
        PROJECTRESOUCEPATH=null;
    }
}
