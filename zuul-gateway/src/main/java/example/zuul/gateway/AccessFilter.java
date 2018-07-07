package example.zuul.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class AccessFilter extends ZuulFilter {

    private static final String FILTER_BEFORE = "pre";

    private static final Integer FIRST_FILTER = 0;

    @Override
    public String filterType() {
        return FILTER_BEFORE;
    }

    @Override
    public int filterOrder() {
        return FIRST_FILTER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        final RequestContext context = RequestContext.getCurrentContext();
        final HttpServletRequest request = context.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        final Object token = request.getParameter("token");

        if (token == null) {
            log.warn("detected null token");

            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);

            return null;
        } else {
            log.info("obtain token");
        }

        return null;
    }
}
