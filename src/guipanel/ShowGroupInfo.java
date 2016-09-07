package guipanel;

import config.ConfigInfoObject;
import config.DefaultConfigInfoObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by hzwangqiqing on 2016/9/6.
 */
public class ShowGroupInfo extends JPanel{
    public ShowGroupInfo(String title){
        this.setSize(800,800);
        this.configInfoObject= new DefaultConfigInfoObject().getConfigInfoObject();
        this.setLayout(new GridLayout(8,10,5,5));
         ArrayList<String> arrayList;
        arrayList=configInfoObject.getMap().get(title);
        for(int i=0;i<arrayList.size();i++){
            JCheckBox jCheckBox=new JCheckBox();
            jCheckBox.setText(arrayList.get(i));
            jCheckBox.setEnabled(false);
            jCheckBox.setSelected(true);
            this.add(jCheckBox);
        }
        this.setVisible(true);
    }

    public ConfigInfoObject getConfigInfoObject() {
        return configInfoObject;
    }

    public void setConfigInfoObject(ConfigInfoObject configInfoObject) {
        this.configInfoObject = configInfoObject;
    }

    private ConfigInfoObject configInfoObject;
}
