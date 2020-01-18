package com.zhy.taxi.gateway.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.protocol.RequestContent;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AuthFilter
 * @Description 鉴权 Filter
 * @Date 2020/1/11 16:16
 * @Version 1.0
 */
@Component
public class AuthFilter extends ZuulFilter {

    /*过滤类型:*/
    @Override
    public String filterType() {
        // 标志前置过滤
        return FilterConstants.PRE_TYPE;
    }
    /**/
    @Override
    public int filterOrder() {
        return 4;
    }

    @Override
    public boolean shouldFilter() {
        // 获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String uri = request.getRequestURI();
        System.out.println("来源uri:"+uri);
        //只有此接口/api-passenger/api-passenger-gateway-test/hello才被拦截
        if("/api-passenger/api-passenger-gateway-test/hello".equalsIgnoreCase(uri)) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("拦截");
        //获取上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String token = request.getHeader("Authorization");
        if(StringUtils.isNotBlank(token) && "1234".equals(token)) {
            System.out.println("校验通过");
        } else {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
