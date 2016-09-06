import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

/**
 * Created by oclous on 16-9-5.
 */
public class EaseConfigCompment implements ApplicationComponent {
    public EaseConfigCompment() {
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
        return "EaseConfigCompment";
    }
}
