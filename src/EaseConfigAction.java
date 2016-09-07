import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import config.ProjectContext;

import javax.swing.*;

/**
 * Created by oclous on 16-9-5.
 */
public class EaseConfigAction extends AnAction {
    private JFrame jFrame;
    @Override
    public void actionPerformed(AnActionEvent e) {
        //获取当前项目的根目录用于用户定位自己的具体项目文件
        Project project=e.getData(PlatformDataKeys.PROJECT);
        ProjectContext.setProject(project);
        //新建窗口
        jFrame = new NetEaseConfigGUIFrame("EaseConfigGUIFORM");
    }
}
