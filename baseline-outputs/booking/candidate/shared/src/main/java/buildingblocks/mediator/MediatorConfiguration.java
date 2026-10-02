package buildingblocks.mediator;
 import buildingblocks.core.event.EventDispatcher;
import buildingblocks.mediator.abstractions.IMediator;
import buildingblocks.mediator.abstractions.requests.IRequest;
import buildingblocks.mediator.behaviors.LogPipelineBehavior;
import buildingblocks.mediator.behaviors.TransactionPipelineBehavior;
import buildingblocks.mediator.behaviors.ValidationPipelineBehavior;
import org.slf4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.validation.Validator;
import java.util.List;
@EnableConfigurationProperties(MediatorProperties.class)
@ConditionalOnMissingBean({ IMediator.class })
@ConditionalOnClass({ IMediator.class })
@ConditionalOnProperty(prefix = "mediator", name = "enabled", havingValue = "true", matchIfMissing = true)
@Configuration
public class MediatorConfiguration {

MediatorConfiguration() {
}
@Bean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public LogPipelineBehavior<TRequest,TResponse> logPipelineBehavior(){
    return new LogPipelineBehavior<>();
}


@Bean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public ValidationPipelineBehavior<TRequest,TResponse> validationPipelineBehavior(List<Validator> validators){
    return new ValidationPipelineBehavior<>(validators);
}


@Bean
@ConditionalOnMissingBean
public IMediator mediator(ApplicationContext applicationContext){
    return new Mediator(applicationContext);
}


@Bean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public TransactionPipelineBehavior<TRequest,TResponse> transactionPipelineBehavior(PlatformTransactionManager transactionManager,Logger logger,EventDispatcher eventDispatcher){
    return new TransactionPipelineBehavior<>(transactionManager, logger, eventDispatcher);
}


}