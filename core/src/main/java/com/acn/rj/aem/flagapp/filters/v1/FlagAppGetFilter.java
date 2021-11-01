package com.acn.rj.aem.flagapp.filters.v1;

import com.acn.rj.aem.flagapp.dtos.FlagAppGetResponse;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.servlets.annotations.SlingServletFilter;
import org.apache.sling.servlets.annotations.SlingServletFilterScope;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.osgi.service.component.propertytypes.ServiceVendor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

import static com.acn.rj.aem.flagapp.utils.CommonHelper.writeValueAsString;


@Component
@SlingServletFilter(
        scope = SlingServletFilterScope.REQUEST,
        pattern = FlagAppGetFilter.GET_API_FILTER_PATTERN,
        methods = HttpConstants.METHOD_GET)
@ServiceDescription("FlagApp Get Api")
@ServiceVendor("RJS")
public class FlagAppGetFilter implements Filter {

    public static final String GET_API_FILTER_PATTERN = "/api/flagapp/v1/projects(?:/(?<pname>[a-zA-Z0-9-_%\\s]+))?(?:/(?<fname>[a-zA-Z0-9-_%]+))?";

    private static final Logger LOGGER = LoggerFactory.getLogger(FlagAppGetFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // No Operation
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*final SlingHttpServletRequest slingRequest = (SlingHttpServletRequest) request;
        response.setContentType(HttpType.MEDIA_TYPE_JSON.value());
        Pattern pattern = Pattern.compile(FlagAppUtils.FLAP_APP_GET_API_PATTERN);
        Matcher matcher = pattern.matcher(slingRequest.getRequestURI());
        Map<String, Object> result = new HashMap<>();
        if (matcher.matches()) {
            try {
                result = processOperation(matcher);
            } catch (RJSRuntimeException e) {
                setFailure(result, e.getMessage());
            }
        } else {
            result.put(FlagAppUtils.RS_STATUS, FlagAppUtils.PATTERN_ERROR);
        }
        response.getWriter().write(CommonHelper.writeValueAsString(result));*/
        final SlingHttpServletRequest slingRequest = (SlingHttpServletRequest) request;

        response.getWriter().write(writeValueAsString(new FlagAppGetResponse()));
    }

    @Override
    public void destroy() {
        // No Operation
    }
}
