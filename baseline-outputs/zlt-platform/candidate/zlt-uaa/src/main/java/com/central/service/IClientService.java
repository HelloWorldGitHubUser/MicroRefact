package com.central.service;
 import com.central.model.PageResult;
import com.central.entity.Client;
import java.util.Map;
public interface IClientService extends ISuperService<Client>{


public Client loadClientByClientId(String clientId)
;

public PageResult<Client> listClient(Map<String,Object> params,boolean isPage)
;

public void saveClient(Client client) throws Exception
;

public void delClient(long id)
;

}