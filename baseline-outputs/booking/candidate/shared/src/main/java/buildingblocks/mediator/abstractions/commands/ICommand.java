package buildingblocks.mediator.abstractions.commands;
 import buildingblocks.mediator.abstractions.requests.IRequest;
public interface ICommand extends IRequest<TResponse>, IBaseCommand{


}