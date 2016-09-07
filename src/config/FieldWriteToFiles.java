package config;

import com.intellij.openapi.ui.Messages;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by hzwangqiqing on 2016/9/7.
 */
public class FieldWriteToFiles {

    public static DefaultConfigInfoObject defaultConfigInfoObject;

    public static String resourcesPath;

    public static void writeToFiles(ArrayList<String> files, String env, String name, String value, boolean strategy) {
        defaultConfigInfoObject = new DefaultConfigInfoObject();

        resourcesPath = ProjectContext.getResourcesDir();

        ArrayList<String> envGroup = defaultConfigInfoObject.getConfigInfoObject().getMap().get(env);

        for (String fileName : files) {
            for (int i = 0; i < envGroup.size(); i++) {
                String filePath = resourcesPath + File.separator + envGroup.get(i);

                filePath = lookFilePath(filePath,fileName);

                SetProperty setProperty=new SetProperty(filePath);

                if(strategy==true){
                    setProperty.writeProperties(name,envGroup.get(i));
                }
                else{
                    setProperty.writeProperties(name,value);
                }
            }
        }
    }

    public static String lookFilePath(String directory, String fileName) {
        File file = new File(directory);
        if (!file.exists()) {
            return null;
        }
        File[] files = file.listFiles();

        for (File file1 : files) {
            if (file1.isFile() && file1.getName().matches(fileName)) {
                return file1.getPath();
            }
            if (file1.isDirectory()) {
                for (File file2 : file1.listFiles()) {
                    if (file2.isFile() && file2.getName().matches(fileName)) {
                        return file2.getPath();
                    }
                }
            }
        }
        return null;
    }

}
