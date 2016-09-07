import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.vfs.VirtualFile;
import config.ConfigInfoObject;
import config.DefaultConfigInfoObject;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.components.JBPanel;
import config.ObjectFileExchange;
import config.ProjectContext;
import guipanel.AddGroupInfo;
import guipanel.SetFieldValueInfo;
import guipanel.ShowGroupInfo;
import guipanel.UpdateGroupInfo;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by oclous on 16-9-5.
 */
public class NetEaseConfigGUIFrame extends JFrame implements ApplicationComponent,ActionListener{

    //菜单栏
    private JMenuBar jMenuBar=new JMenuBar();
    private JMenu jMenuGetGroup=new JMenu("查看分组信息");
    private JMenu jMenuSetGroup=new JMenu("更新分组信息");

    private JMenuItem jMenuAddGorup=new JMenuItem("自定义分组");
    private JMenuItem jMenuSetAttribute=new JMenuItem("批量添加属性");
    private JMenuItem jMenuSetResouceDir=new JMenuItem("设置资源目录");
    private JMenuItem jMenuHelp=new JMenuItem("Help");
    private ArrayList<JMenuItem> showGroupInfo=new ArrayList<>();
    private ArrayList<JMenuItem> setGroupInfo=new ArrayList<>();

    //默认构造函数
    public NetEaseConfigGUIFrame() {

    }

    @Override
    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "NetEaseConfigGUIFrame";
    }


    //自定义构造函数
    public NetEaseConfigGUIFrame(String title){
        super(title);
        //初始化菜单栏
        this.initMenu();
        //设置通用大小杂项
        init();
    }

    public void initMenu(){

        jMenuBar.add(jMenuGetGroup);
        jMenuBar.add(jMenuSetGroup);
        jMenuBar.add(jMenuAddGorup);
        jMenuBar.add(jMenuSetAttribute);
        jMenuBar.add(jMenuSetResouceDir);
        jMenuBar.add(jMenuHelp);

        jMenuAddGorup.addActionListener(this);
        jMenuSetResouceDir.addActionListener(this);
        jMenuSetAttribute.addActionListener(this);
        jMenuHelp.addActionListener(this);

        DefaultConfigInfoObject defaultConfigInfoObject=new DefaultConfigInfoObject();
        for(int i=0;i<defaultConfigInfoObject.getConfigInfoObject().getArrayList().size();i++){
            showGroupInfo.add(i,new JMenuItem(defaultConfigInfoObject.getConfigInfoObject().getArrayList().get(i)));
            setGroupInfo.add(i,new JMenuItem(defaultConfigInfoObject.getConfigInfoObject().getArrayList().get(i)));
        }

        for(int i=0;i<showGroupInfo.size();i++){
            jMenuGetGroup.add(showGroupInfo.get(i));
            jMenuSetGroup.add(setGroupInfo.get(i));

            showGroupInfo.get(i).addActionListener(this);
            setGroupInfo.get(i).addActionListener(this);
        }

        this.setJMenuBar(jMenuBar);
    }

    public void init(){
        setContentPane(new JBPanel<>());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(1000,800);
        setVisible(true);

        ObjectFileExchange objectFileExchange=new ObjectFileExchange();
        ConfigInfoObject configInfoObject=objectFileExchange.FileToObject();

        if(configInfoObject==null){
           configInfoObject=new DefaultConfigInfoObject().getConfigInfoObject();
            objectFileExchange.objectTOFile(configInfoObject);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jMenuSetResouceDir) {
            FileChooserDescriptor fileChooserDescriptor = new FileChooserDescriptor(false, true, false, false, false, false);
            fileChooserDescriptor.setHideIgnored(false);
            fileChooserDescriptor.setTitle("当PATH错误为空时,请手动指定resouces路径");
            fileChooserDescriptor.setDescription("当前PATH:" + ProjectContext.getResourcesDir());
            fileChooserDescriptor.setShowFileSystemRoots(true);
            System.out.println(ProjectContext.getProject().getBaseDir());
            VirtualFile virtualFile = FileChooser.chooseFile(fileChooserDescriptor, ProjectContext.getProject(), ProjectContext.getProject().getBaseDir());
            if (virtualFile != null && !virtualFile.getPath().equals(ProjectContext.getProjectFilePath())) {
                String tempResourcesDir = virtualFile.getPath();
                ProjectContext.setResourcesDir(tempResourcesDir);
            }
        }

        for(int i=0;i<showGroupInfo.size();i++){
            if(e.getSource()==showGroupInfo.get(i)){
                this.setContentPane(new ShowGroupInfo(e.getActionCommand()));
                this.setVisible(true);
                break;
            }
        }

        for(int i=0;i<setGroupInfo.size();i++){
            if(e.getSource()==setGroupInfo.get(i)){
                this.setContentPane(new UpdateGroupInfo(e.getActionCommand()));
                this.setVisible(true);
                break;
            }
        }

        if(e.getSource()==jMenuAddGorup){
            this.setContentPane(new AddGroupInfo("添加分组名称"));
            this.setVisible(true);
        }

        if(e.getSource()==jMenuSetAttribute){
            this.setContentPane(new SetFieldValueInfo());
            this.setVisible(true);
        }
    }

}
