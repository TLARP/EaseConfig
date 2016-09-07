package config;

import java.util.ArrayList;

/**
 * Created by hzwangqiqing on 2016/9/6.
 */
public class DefaultConfigInfoObject {

    private ConfigInfoObject configInfoObject;

    private ObjectFileExchange objectFileExchange;

    public ConfigInfoObject getConfigInfoObject() {
        return configInfoObject;
    }

    public void setConfigInfoObject(ConfigInfoObject configInfoObject) {
        this.configInfoObject = configInfoObject;
    }

    public DefaultConfigInfoObject() {
        this.objectFileExchange = new ObjectFileExchange();

        if (objectFileExchange.FileToObject() != null) {
            this.configInfoObject = objectFileExchange.FileToObject();
        } else {
            configInfoObject = new ConfigInfoObject();
            configInfoObject.getArrayList().add(0, "默认环境");
            configInfoObject.getArrayList().add(1, "预发环境");
            configInfoObject.getArrayList().add(2, "测试环境");

            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(0, "app_auto1");
            arrayList.add(1, "base-service1");
            arrayList.add(2, "base-service2");
            arrayList.add(3, "beta");
            arrayList.add(4, "hotfix");
            arrayList.add(5, "hst_auto1");
            arrayList.add(6, "hst_hotfix1");
            arrayList.add(7, "hst_hotfix2");
            arrayList.add(8, "hst_hotfix3");
            arrayList.add(9, "hst_hotfix4");
            arrayList.add(10, "hst_test1");
            arrayList.add(11, "hst_test2");
            arrayList.add(12, "hst_test3");
            arrayList.add(13, "hst_test4");
            arrayList.add(14, "hst_test5");
            arrayList.add(15, "hst_test6");
            arrayList.add(16, "hst_test7");
            arrayList.add(17, "hst_test8");
            arrayList.add(18, "hst_test9");
            arrayList.add(19, "hst_test10");
            arrayList.add(20, "integration_test");
            arrayList.add(21, "local");
            arrayList.add(22, "online");
            arrayList.add(23, "performance");
            arrayList.add(24, "pre");
            arrayList.add(25, "pre2");
            arrayList.add(26, "pre3");
            arrayList.add(27, "pre4");
            arrayList.add(28, "pre5");
            arrayList.add(29, "pre6");
            arrayList.add(30, "stable");
            arrayList.add(31, "stable_dev");
            arrayList.add(32, "stable_master");
            arrayList.add(33, "test1");
            arrayList.add(34, "test2");
            arrayList.add(35, "test3");
            arrayList.add(36, "test4");
            arrayList.add(37, "test5");
            arrayList.add(38, "test6");
            arrayList.add(39, "test7");
            arrayList.add(40, "test8");
            arrayList.add(41, "test9");
            arrayList.add(42, "test10");
            arrayList.add(43, "test11");
            arrayList.add(44, "test12");
            arrayList.add(45, "test13");
            arrayList.add(46, "test14");
            arrayList.add(47, "test15");
            arrayList.add(48, "test16");
            arrayList.add(49, "test17");
            arrayList.add(50, "test18");
            arrayList.add(51, "test19");
            arrayList.add(52, "test20");
            arrayList.add(53, "test21");


            configInfoObject.getMap().put("默认环境", arrayList);

            ArrayList<String> testArrayList = new ArrayList<>();

            testArrayList.add(0, "test1");
            testArrayList.add(1, "test2");
            testArrayList.add(2, "test3");
            testArrayList.add(3, "test4");
            testArrayList.add(4, "test5");
            testArrayList.add(5, "test6");
            testArrayList.add(6, "test7");
            testArrayList.add(7, "test8");
            testArrayList.add(8, "test9");
            testArrayList.add(9, "test10");
            testArrayList.add(10, "test11");
            testArrayList.add(11, "test12");
            testArrayList.add(12, "test13");
            testArrayList.add(13, "test14");
            testArrayList.add(14, "test15");
            testArrayList.add(15, "test16");
            testArrayList.add(16, "test17");
            testArrayList.add(17, "test18");
            testArrayList.add(18, "test19");
            testArrayList.add(19, "test20");
            testArrayList.add(20, "test21");

            configInfoObject.getMap().put("测试环境", testArrayList);

            ArrayList<String> preArrayList = new ArrayList<>();
            preArrayList.add(0, "pre");
            preArrayList.add(1, "pre2");
            preArrayList.add(2, "pre3");
            preArrayList.add(3, "pre4");
            preArrayList.add(4, "pre5");
            preArrayList.add(5, "pre6");

            configInfoObject.getMap().put("预发环境", preArrayList);

            objectFileExchange.objectTOFile(configInfoObject);
        }
    }

}
