package guipanel;

import com.intellij.openapi.ui.Messages;
import config.ConfigInfoObject;
import config.DefaultConfigInfoObject;
import config.ObjectFileExchange;
import config.ProjectContext;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by hzwangqiqing on 2016/9/6.
 */
public class AddGroupInfo extends JPanel implements ActionListener {

    private JTextField jTextField=new JTextField(15);


    private JButton jButton=new JButton("确定");

    private ArrayList<JCheckBox> jCheckBoxes=new ArrayList<>();

    public AddGroupInfo(String title){
        this.setSize(800,800);
        this.configInfoObject= new DefaultConfigInfoObject().getConfigInfoObject();
        this.setLayout(new GridLayout(8,10,5,5));
        ArrayList<String> arrayList= ProjectContext.getArrayList();
        for(int i=0;i<arrayList.size();i++){
            JCheckBox jCheckBox=new JCheckBox();
            jCheckBox.setText(arrayList.get(i));
            jCheckBox.setEnabled(true);
            jCheckBox.setSelected(false);
            this.add(jCheckBox);
            jCheckBoxes.add(jCheckBoxes.size(),jCheckBox);
        }


        jTextField.setSize(20,20);
        jTextField.setColumns(15);
        jTextField.setText("在此处添加你的分组名称");
        this.add(jTextField);

        this.add(jButton);
        this.setVisible(true);

        jButton.addActionListener(this);
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
        if(e.getSource()==jButton){
            if(jTextField.getText()==null){
                Messages.showMessageDialog("分组名称不能为空","sample",Messages.getInformationIcon());
                return;
            }else if(configInfoObject.getArrayList().contains(jTextField.getText())){
                Messages.showMessageDialog("分组已经存在","sample", Messages.getInformationIcon());
                return;
            }else{
                configInfoObject.getArrayList().add(configInfoObject.getArrayList().size(),jTextField.getText());
                ArrayList<String> arrayList=new ArrayList<>();
                for(int i=0;i<jCheckBoxes.size();i++){
                    if(jCheckBoxes.get(i).isSelected()){
                        arrayList.add(arrayList.size(),jCheckBoxes.get(i).getText());
                    }
                }
                if(arrayList.size()==0){
                    Messages.showMessageDialog("至少添加一个测试环境","sample", Messages.getInformationIcon());
                    return;
                }
                configInfoObject.getMap().put(jTextField.getText(),arrayList);

                ObjectFileExchange objectFileExchange=new ObjectFileExchange();

                objectFileExchange.objectTOFile(configInfoObject);

                Messages.showMessageDialog("分组添加成功，重启后生效","sample", Messages.getInformationIcon());
            }
        }
    }
}
