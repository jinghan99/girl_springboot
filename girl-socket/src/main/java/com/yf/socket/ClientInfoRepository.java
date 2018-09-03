package com.yf.socket;

import org.springframework.data.repository.CrudRepository;

/**
 * @Package com.yf.socket
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/3 16:21
 */
public interface ClientInfoRepository  extends CrudRepository<ClientInfo, String> {

    ClientInfo findClientByclientid(String clientId);
}
