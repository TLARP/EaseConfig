package config;

import com.intellij.openapi.ui.Messages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class SetProperty {
    public Properties props = new Properties();

    public String filePath;

    SetProperty(String filePath) {
        this.filePath = filePath;
        try {
            props.load(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPropertyValue(String key) {
        return props.getProperty(key);
    }

    public void writeProperties(String keyname, String keyvalue) {
        try {
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
            OutputStream fos = new FileOutputStream(filePath);
            props.setProperty(keyname, keyvalue);
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            props.store(fos, "Update '" + keyname + "' value");
        } catch (IOException e) {
            Messages.showMessageDialog("属性文件更新错误:" + filePath, "sample", Messages.getInformationIcon());
        }
    }

}