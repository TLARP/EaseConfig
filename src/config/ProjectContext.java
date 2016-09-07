package config;

import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by hzwangqiqing on 2016/9/6.
 */
public class ProjectContext {

    private static Project project;

    //resouces 所在的目录
    private static String resourcesDir;

    //目录列表
    private static ArrayList<String> arrayList=new ArrayList<String>();

    public static ArrayList<String> getFileArrayList() {
        return fileArrayList;
    }

    public static void setFileArrayList(ArrayList<String> fileArrayList) {
        ProjectContext.fileArrayList = fileArrayList;
    }

    //配置文件列表
    public static ArrayList<String>  fileArrayList=new ArrayList<>();

    public static Project getProject() {
        return project;
    }


    public static void setProject(Project project) {
        //项目环境
        ProjectContext.project = project;
        //通过project设置项目的基准目录
        ProjectContext.setResourcesDir(lookforResourceDir(getBasePath()));
        //获取到resource的目录之后，获取当前目录下的目录列表

        setEnvList(arrayList);

        setFileList(fileArrayList);

        return ;
    }

    public static ArrayList<String> getArrayList() {
        return arrayList;
    }

    public static void setArrayList(ArrayList<String> arrayList) {
        ProjectContext.arrayList = arrayList;
    }

    public static  String getResourcesDir(){
        return resourcesDir;
    }

    public static void setResourcesDir(String resourcesDir){
        ProjectContext.resourcesDir=resourcesDir;
    }

    public static String getProjectFilePath() {
        return project.getProjectFilePath();
    }

    public static String getBasePath() {
        return project.getBasePath();
    }

    public static String getName() {
        return project.getName();
    }

    public static Boolean getIsOpen() {
        return project.isOpen();
    }

    public static VirtualFile getBaseDir() {
        return project.getBaseDir();
    }

    //自动检测代码
    public static String lookforResourceDir(String projectDir){
        String resourcesDir=getFiles(projectDir);
        if(resourcesDir==null){
            Messages.showMessageDialog("Don't get resouces directory Auto,please set in setResourcesDir menu","sample",Messages.getInformationIcon());
        }
        return resourcesDir;
    }

    public static void setFileList(ArrayList<String> fileArrayList){
        File file=new File(ProjectContext.resourcesDir+File.separator+arrayList.get(0));

        if(file.isDirectory()){
            for(File file1:file.listFiles()){
                if(file1.isFile()){
                    fileArrayList.add(fileArrayList.size(),file1.getName());
                    continue;
                }
                for(File file2:file1.listFiles()){
                    fileArrayList.add(fileArrayList.size(),file2.getName());
                }
            }
        }
    }

    private static String getFiles(String filePath){
        File root = new File(filePath);
        File[] files = root.listFiles();
        //如果列表为空，返回null
        if(files==null)
            return null;

        for(File file:files){
            if(file.isFile()){
                continue;
            }
            if(file.isDirectory()){
                if(file.getName().matches("resources")){
                    return file.getPath();
                };
                if(getFiles(file.getPath())!=null){
                   return getFiles(file.getPath());
                };
            }
        }
        return null;
    }

    public static void setEnvList(ArrayList<String> arrayList){
        File file=new File(resourcesDir);
        File [] files=file.listFiles();
        for(File tempfile:files){
            if(isTestEnv(tempfile)){
                arrayList.add(arrayList.size(),tempfile.getName());
            }
        }
    }

    public static  boolean isTestEnv(File file){
        File [] files=file.listFiles();

        for(File tempFile:files){
            if(tempFile.getName().matches("dubbo.properties")||tempFile.getName().matches("account-config.properties")){
                return true;
            }
        }
        return false;
    }
}

