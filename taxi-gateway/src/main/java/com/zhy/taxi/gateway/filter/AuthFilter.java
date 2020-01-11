package com.zhy.taxi.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @ClassName AuthFilter
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        // TODO Auto-generated method stub
        return null;
    }
}
