package com.divyashree.af.service.impl;

import com.divyashree.af.service.RequestIP;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

@Service
public class RequestIPimpl implements RequestIP {
//    private Logger logger= (Logger) LoggerFactory.getLogger(RequestIPimpl.class);
    private  final String LOCALHOST_INP4="127.0.0.1";
    private  final String LOCALHOST_IPV6="0:0:0:0:0:0:0:1";
    private  final String UNKNOWN="unknown";
    @Override
    public String getClientIPaddress(HttpServletRequest request) {
        String clientIPAddress= request.getHeader("X-Forwarded-For");

        if(!StringUtils.hasLength(clientIPAddress)|| UNKNOWN.equals(clientIPAddress) )
        {
            clientIPAddress= request.getHeader("Proxy-Client-IP");
        }
        if(!StringUtils.hasLength(clientIPAddress)|| UNKNOWN.equals(clientIPAddress) )
        {
            clientIPAddress= request.getHeader("WL-Proxy-Client-IP") ;
        }
        if(!StringUtils.hasLength(clientIPAddress)|| UNKNOWN.equals(clientIPAddress) )
        {
            clientIPAddress= request.getRemoteAddr();
            if(LOCALHOST_INP4.equals(clientIPAddress) || LOCALHOST_IPV6.equals(clientIPAddress))
            {
                try
                {
                    InetAddress inetAddress= InetAddress.getLocalHost();
                    clientIPAddress=inetAddress.getHostAddress();
                }
                catch (UnknownHostException e)
                {
                    e.printStackTrace();
                }
            }
        }
        if(StringUtils.hasLength(clientIPAddress)
                && clientIPAddress.length()>15
                && clientIPAddress.indexOf(",")>0)
        {
            clientIPAddress=clientIPAddress.substring(0, clientIPAddress.indexOf(","));
        }

        return clientIPAddress;
    }
}
