package com.goodskill.service;
 import com.goodskill.enums.Events;
import com.goodskill.enums.States;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineEventResult;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Slf4j
@Component
public class StateMachineService {

 public  String STATEMACHINE_REDIS_KEY_PREFIX;

 private  Map<String,StateMachine<States,Events>> stateMachineMap;

@Resource
 private  StateMachineFactory<States,Events> stateMachineFactory;

@Resource
 private  StateMachinePersister<States,Events,String> stateMachinePersister;


@SneakyThrows
public boolean feedMachine(Events e,long seckillId){
    StateMachine<States, Events> stateMachine = stateMachineMap.get(String.valueOf(seckillId));
    if (stateMachine == null) {
        log.warn("feedMachine skipped because state machine is missing, seckillId: {}, event: {}", seckillId, e);
        return false;
    }
    stateMachinePersister.restore(stateMachine, STATEMACHINE_REDIS_KEY_PREFIX + seckillId);
    StateMachineEventResult<States, Events> eventResult = stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(e).build())).blockLast();
    log.info("eventResult:{}", eventResult);
    stateMachinePersister.persist(stateMachine, STATEMACHINE_REDIS_KEY_PREFIX + seckillId);
    return eventResult != null && StateMachineEventResult.ResultType.ACCEPTED.equals(eventResult.getResultType());
}


@SneakyThrows
public StateMachine<States,Events> initStateMachine(long seckillId){
    StateMachine<States, Events> existingStateMachine = stateMachineMap.get(String.valueOf(seckillId));
    if (existingStateMachine != null) {
        return existingStateMachine;
    }
    StateMachine<States, Events> stateMachine = stateMachineFactory.getStateMachine();
    stateMachinePersister.persist(stateMachine, STATEMACHINE_REDIS_KEY_PREFIX + seckillId);
    StateMachine<States, Events> previousStateMachine = stateMachineMap.putIfAbsent(String.valueOf(seckillId), stateMachine);
    return previousStateMachine == null ? stateMachine : previousStateMachine;
}


@SneakyThrows
public boolean checkState(long seckillId,States state){
    StateMachine<States, Events> stateMachine = stateMachineMap.get(String.valueOf(seckillId));
    if (stateMachine == null) {
        log.warn("checkState failed because state machine is missing, seckillId: {}, expectedState: {}", seckillId, state);
        return false;
    }
    stateMachinePersister.restore(stateMachine, STATEMACHINE_REDIS_KEY_PREFIX + seckillId);
    return stateMachine.getState().getId().equals(state);
}


}