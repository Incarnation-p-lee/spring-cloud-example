package example.zuul.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RefreshScope
@Component
public class AccessFilter extends ZuulFilter {

    private static final String FILTER_BEFORE = "pre";

    private static final Integer FIRST_FILTER = 0;

    @Value("${required.parameter}")
    private String requiredParameter;

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

        final Object parameter = request.getParameter(this.requiredParameter);

        if (parameter == null) {
            log.warn("detected null parameter");

            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);

            return null;
        } else {
            log.info("obtain parameter {} with value {}", this.requiredParameter, parameter);
            log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        }

        return null;
    }
}
