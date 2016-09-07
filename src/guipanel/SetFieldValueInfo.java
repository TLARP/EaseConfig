package guipanel;

import com.intellij.openapi.ui.Messages;
import com.sun.tools.javac.tree.JCTree;
import config.ConfigInfoObject;
import config.DefaultConfigInfoObject;
import config.FieldWriteToFiles;
import config.ProjectContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by hzwangqiqing on 2016/9/6.
 */
public class SetFieldValueInfo extends JPanel implements ActionListener {
    private ConfigInfoObject configInfoObject;

    private GridBagConstraints gridBagConstraints = new GridBagConstraints();

    private JTextField jTextField = new JTextField("分组列表");

    private JTextField fileJTextField = new JTextField("配置文件列表");

    private JTextField configParamTips = new JTextField("配置参数名称:");

    private JTextField configParamName = new JTextField(20);

    private JTextField configParamValueTips = new JTextField("配置参数的值:");

    private JTextField configParamValue = new JTextField(20);

    private JCheckBox defaultStrategy = new JCheckBox("默认策略,使用环境的目录名称作为参数值");

    private JButton jButton = new JButton("点击生效");

    //分组列表
    private ArrayList<String> groupArrayList;

    private ArrayList<JCheckBox> groupJcheckBoxList = new ArrayList<JCheckBox>();
    //配置文件列表
    private ArrayList<String> fileArrayList;

    private ArrayList<JCheckBox> fileJcheckBoxList = new ArrayList<>();

    public SetFieldValueInfo() {

        configInfoObject = new DefaultConfigInfoObject().getConfigInfoObject();

        this.setSize(800, 800);
        this.configInfoObject = new DefaultConfigInfoObject().getConfigInfoObject();
        this.setLayout(new GridBagLayout());
        groupArrayList = configInfoObject.getArrayList();
        fileArrayList = ProjectContext.getFileArrayList();

        //分组列表提示符
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 20;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        jTextField.setEnabled(false);
        this.add(jTextField, gridBagConstraints);

        //分组列表checkBox
        for (int i = 0; i < groupArrayList.size(); i++) {
            JCheckBox jCheckBox = new JCheckBox();
            jCheckBox.setText(groupArrayList.get(i));
            jCheckBox.setEnabled(true);
            jCheckBox.setSelected(false);


            gridBagConstraints.gridx = i % 4 * 100;
            gridBagConstraints.gridy = (1 + i / 4) * 80;
            gridBagConstraints.gridheight = 20;
            gridBagConstraints.gridwidth = 20;
            gridBagConstraints.fill = GridBagConstraints.NONE;
            gridBagConstraints.anchor = gridBagConstraints.WEST;
            groupJcheckBoxList.add(groupJcheckBoxList.size(), jCheckBox);
            jCheckBox.addActionListener(this);
            this.add(jCheckBox, gridBagConstraints);
        }

        //文件列表提示符
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = (2 + groupArrayList.size() / 4) * 80;
        gridBagConstraints.gridheight = 20;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        fileJTextField.setEnabled(false);
        this.add(fileJTextField, gridBagConstraints);

        //文件列表checkbox
        for (int i = 0; i < fileArrayList.size(); i++) {
            JCheckBox jCheckBox = new JCheckBox();
            jCheckBox.setText(fileArrayList.get(i));
            jCheckBox.setEnabled(true);
            jCheckBox.setSelected(false);
            gridBagConstraints.gridx = i % 4 * 100;
            gridBagConstraints.gridy = (3 + i / 4 + groupArrayList.size() / 4) * 80;
            gridBagConstraints.gridheight = 20;
            gridBagConstraints.gridwidth = 20;
            gridBagConstraints.fill = GridBagConstraints.NONE;
            gridBagConstraints.anchor = gridBagConstraints.WEST;
            fileJcheckBoxList.add(fileJcheckBoxList.size(), jCheckBox);
            jCheckBox.addActionListener(this);
            this.add(jCheckBox, gridBagConstraints);
        }

        //开始输入参数
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = (4 + fileArrayList.size() / 4 + groupArrayList.size() / 4) * 80;
        gridBagConstraints.gridheight = 20;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        configParamTips.setEnabled(false);
        this.add(configParamTips, gridBagConstraints);

        gridBagConstraints.gridx = 100;
        gridBagConstraints.gridy = (4 + fileArrayList.size() / 4 + groupArrayList.size() / 4) * 80;
        gridBagConstraints.gridheight = 20;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        configParamName.setEnabled(true);
        this.add(configParamName, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = (5 + fileArrayList.size() / 4 + groupArrayList.size() / 4) * 80;
        gridBagConstraints.gridheight = 20;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        configParamValueTips.setEnabled(false);
        this.add(configParamValueTips, gridBagConstraints);

        gridBagConstraints.gridx = 100;
        gridBagConstraints.gridy = (5 + fileArrayList.size() / 4 + groupArrayList.size() / 4) * 80;
        gridBagConstraints.gridheight = 20;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        configParamValue.setEnabled(true);
        this.add(configParamValue, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = (6 + fileArrayList.size() / 4 + groupArrayList.size() / 4) * 80;
        gridBagConstraints.gridheight = 20;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        defaultStrategy.setEnabled(true);
        defaultStrategy.setText("默认策略,使用环境的目录名称作为参数值");
        this.add(defaultStrategy, gridBagConstraints);

        defaultStrategy.addActionListener(this);

        gridBagConstraints.gridx = 500;
        gridBagConstraints.gridy = (8 + fileArrayList.size() / 4 + groupArrayList.size() / 4) * 80;
        gridBagConstraints.gridheight = 20;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        jButton.setEnabled(true);
        jButton.setText("点击生效");

        jButton.addActionListener(this);

        this.add(jButton, gridBagConstraints);


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == defaultStrategy) {
            if (defaultStrategy.isSelected()) {
                configParamValue.setEnabled(false);
                return;
            } else {
                configParamValue.setEnabled(true);
            }
            return;
        } else if (e.getSource() == jButton) {
            if (configParamName.getText()==null||configParamName.getText().equals("") || configParamName.getText().contains(" ")) {
                Messages.showMessageDialog("参数名称为空或者含有空格", "sample", Messages.getInformationIcon());
                return;
            }
            if (defaultStrategy.isSelected() == false && (configParamName.getText()==null||(configParamValue.getText().equals("") || configParamValue.getText().contains(" ")))) {
                Messages.showMessageDialog("参数值为空或者含有空格", "sample", Messages.getInformationIcon());
                return;
            }

            Boolean falg = false;

            for (int i = 0; i < groupJcheckBoxList.size(); i++) {
                if (groupJcheckBoxList.get(i).isSelected() == true) {
                    falg = true;
                    break;
                }
            }

            if (falg == false) {
                Messages.showMessageDialog("至少选中一个分组", "sample", Messages.getInformationIcon());
                return;
            }

            falg = false;

            for (int i = 0; i < fileJcheckBoxList.size(); i++) {
                if (fileJcheckBoxList.get(i).isSelected() == true) {
                    falg = true;
                    break;
                }
            }

            if (falg == false) {
                Messages.showMessageDialog("至少选中一个配置文件", "sample", Messages.getInformationIcon());
                return;
            }

            ArrayList<String> selectFilesGroup=new ArrayList<>();
            for(int i=0;i<fileJcheckBoxList.size();i++){
                if(fileJcheckBoxList.get(i).isSelected()){
                    selectFilesGroup.add(selectFilesGroup.size(),fileJcheckBoxList.get(i).getText());
                }
            }

            String group=null;
            for(int i=0;i<groupJcheckBoxList.size();i++){
                if(groupJcheckBoxList.get(i).isSelected()==true){
                    group=groupJcheckBoxList.get(i).getText();
                    break;
                }
            }

            FieldWriteToFiles.writeToFiles(selectFilesGroup,group,configParamName.getText(),configParamValue.getText(),defaultStrategy.isSelected());

            Messages.showMessageDialog("批量设置成功", "sample", Messages.getInformationIcon());

            return;

        }

        for (int i = 0; i < groupJcheckBoxList.size(); i++) {
            if (e.getSource() == groupJcheckBoxList.get(i)) {
                if (groupJcheckBoxList.get(i).isSelected()) {
                    for (int j = 0; j < groupJcheckBoxList.size(); j++) {
                        if(j==i)
                            continue;
                        if (groupJcheckBoxList.get(j).isSelected()) {
                            groupJcheckBoxList.get(j).setSelected(false);
                        }
                    }
                }
                break;
            }
        }


    }

   /* @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawLine(0,50,800,50);
    }*/
}
