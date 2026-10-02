package buildingblocks.mediator;
 import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties(prefix = "mediator")
@ConditionalOnBean({ MediatorConfiguration.class })
public class MediatorProperties {

 private  boolean enabled;

 private  boolean enabledLogPipeline;


public void setEnabled(boolean enabled){
    this.enabled = enabled;
}


public void setEnabledLogPipeline(boolean enabledLogPipeline){
    this.enabledLogPipeline = enabledLogPipeline;
}


public boolean isEnabled(){
    return enabled;
}


public boolean isEnabledLogPipeline(){
    return enabledLogPipeline;
}


}