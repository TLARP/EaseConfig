import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.components.JBPanel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Created by oclous on 16-9-5.
 */
public class NetEaseConfigGUIFrame extends JFrame implements ApplicationComponent,ActionListener{

    private JMenuBar jMenuBar=new JMenuBar();
    private JMenu jMenuGetGroup=new JMenu("GetGroupInfo");
    private JMenu jMenuSetGroup=new JMenu("SetGroupInfo");
    private JMenu jMenuSetAttribute=new JMenu("SetAttribute");
    private JMenu jMenuSetResouceDir=new JMenu("SetReourcesDir");
    private JMenu jMenuHelp=new JMenu("Help");

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

    public NetEaseConfigGUIFrame(String title){
        super(title);
        //初始化菜单栏
        this.initMenu();
        //设置通用大小杂项
        init();
    }

    public void init(){
        setContentPane(new JBPanel<>());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(800,600);
        setVisible(true);

        ObjectFileExchange objectFileExchange=new ObjectFileExchange();
        ConfigInfoObject configInfoObject=objectFileExchange.FileToObject();

        if(configInfoObject==null){
           // Messages.showMessageDialog("please set Test envirment resouces dir","sample",Messages.getInformationIcon());
        }
    }

    public void initMenu(){

        jMenuBar.add(jMenuGetGroup);
        jMenuBar.add(jMenuSetGroup);
        jMenuBar.add(jMenuSetAttribute);
        jMenuBar.add(jMenuSetResouceDir);
        jMenuBar.add(jMenuHelp);

        this.setJMenuBar(jMenuBar);

        jMenuGetGroup.addActionListener(this);
        jMenuSetGroup.addActionListener(this);
        jMenuSetAttribute.addActionListener(this);
        jMenuSetResouceDir.addActionListener(this);
        jMenuHelp.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("hello world");
        Messages.showMessageDialog("success","sample",Messages.getInformationIcon());
    }
}
