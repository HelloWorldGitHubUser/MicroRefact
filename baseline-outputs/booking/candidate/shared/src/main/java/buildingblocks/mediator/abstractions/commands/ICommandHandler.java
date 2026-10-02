package buildingblocks.mediator.abstractions.commands;
 import buildingblocks.mediator.abstractions.requests.IRequestHandler;
public interface ICommandHandler extends IRequestHandler<TCommand, TResponse>{


public TResponse handle(TCommand command)
;

}