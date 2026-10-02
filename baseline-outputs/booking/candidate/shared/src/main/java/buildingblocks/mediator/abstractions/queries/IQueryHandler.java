package buildingblocks.mediator.abstractions.queries;
 import buildingblocks.mediator.abstractions.requests.IRequestHandler;
public interface IQueryHandler extends IRequestHandler<TQuery, TResponse>{


public TResponse handle(TQuery query)
;

}