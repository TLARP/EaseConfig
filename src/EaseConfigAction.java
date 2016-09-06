import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.ui.components.JBPanel;

import javax.swing.*;

/**
 * Created by oclous on 16-9-5.
 */
public class EaseConfigAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        JFrame frame = new NetEaseConfigGUIFrame("EaseConfigGUIFORM");
    }
}
