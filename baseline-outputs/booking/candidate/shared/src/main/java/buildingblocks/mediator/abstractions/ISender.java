package buildingblocks.mediator.abstractions;
 import buildingblocks.mediator.abstractions.commands.ICommand;
import buildingblocks.mediator.abstractions.queries.IQuery;
import buildingblocks.mediator.abstractions.requests.IRequest;
public interface ISender {


public TResponse send(IQuery<TResponse> query)
;

}