package com.divyashree.af.service;

import javax.servlet.http.HttpServletRequest;

public interface RequestIP {
    public String getClientIPaddress(HttpServletRequest request);
}
