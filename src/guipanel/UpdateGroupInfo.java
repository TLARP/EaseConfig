package guipanel;

import com.intellij.openapi.ui.Messages;
import com.intellij.util.ui.JBUI;
import config.ConfigInfoObject;
import config.DefaultConfigInfoObject;
import config.ObjectFileExchange;
import config.ProjectContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by hzwangqiqing on 2016/9/6.
 */
public class UpdateGroupInfo extends JPanel implements ActionListener {

    private JButton jbutton=new JButton("确定");

    private ArrayList<JCheckBox> checkArrayList=new ArrayList<>();

    private String title;

    public UpdateGroupInfo(String title){
        jbutton.setSize(10,10);
        this.title=title;
        this.setSize(800,800);
        this.configInfoObject= new DefaultConfigInfoObject().getConfigInfoObject();
        this.setLayout(new GridLayout(8,10,5,5));
        ArrayList<String> arrayList;
        ArrayList<String> defaultArrayList= ProjectContext.getArrayList();
        arrayList=configInfoObject.getMap().get(title);
        for(int i=0;i<defaultArrayList.size();i++){
            JCheckBox jCheckBox=new JCheckBox();
            jCheckBox.setText(defaultArrayList.get(i));
            jCheckBox.setEnabled(true);
            if(arrayList.contains(defaultArrayList.get(i))){
                jCheckBox.setSelected(true);
            }
            this.add(jCheckBox);
            checkArrayList.add(checkArrayList.size(),jCheckBox);
        }
        this.setVisible(true);

        this.add(jbutton);

        jbutton.addActionListener(this);
    }

    public ConfigInfoObject getConfigInfoObject() {
        return configInfoObject;
    }

    public void setConfigInfoObject(ConfigInfoObject configInfoObject) {
        this.configInfoObject = configInfoObject;
    }

    private ConfigInfoObject configInfoObject;

    @Override
    public void actionPerformed(ActionEvent e) {
        configInfoObject.getMap().get(title).clear();
        ObjectFileExchange objectFileExchange=new ObjectFileExchange();
        if(e.getSource()==jbutton){
            for(int i=0;i<checkArrayList.size();i++){
                if(checkArrayList.get(i).isSelected()==true){
                    configInfoObject.getMap().get(title).add(configInfoObject.getMap().get(title).size(),checkArrayList.get(i).getText());
                }
            }

            objectFileExchange.objectTOFile(configInfoObject);
            Messages.showMessageDialog("更新分组成功","sample",Messages.getInformationIcon());
        }
    }
}
