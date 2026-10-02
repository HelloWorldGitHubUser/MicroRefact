package buildingblocks.mediator.abstractions.requests;
 public interface IPipelineBehavior {


public TResponse handle(TRequest request,RequestHandlerDelegate<TResponse> next)
;

}