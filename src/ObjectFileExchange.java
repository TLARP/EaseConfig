import java.io.*;

/**
 * Created by oclous on 16-9-5.
 */
public class ObjectFileExchange {

    ObjectFileExchange(){
        userDir=System.getProperty("user.dir");
        FileName="ConfigInfoObject";
    }

    private String userDir;

    public  String FileName;

    public void objectTOFile(ConfigInfoObject configInfoObject){
        String filePath=userDir+ File.separator+FileName;

        File file=new File(filePath);
        if(!file.exists()){
            return;
        }

        try {
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(configInfoObject);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ConfigInfoObject FileToObject(){
        String filePath=userDir+ File.separator+FileName;
        File file=new File(filePath);

        if(!file.exists()){
            return null;
        }

        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            Object object=objectInputStream.readObject();
            if(object instanceof ConfigInfoObject){
                return (ConfigInfoObject)object;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return  null;
    }
}
