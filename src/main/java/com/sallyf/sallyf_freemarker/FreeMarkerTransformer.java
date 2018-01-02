package com.sallyf.sallyf_freemarker;

import com.sallyf.sallyf.Container.Container;
import com.sallyf.sallyf.Router.ResponseTransformerInterface;
import com.sallyf.sallyf.Server.RuntimeBag;
import freemarker.template.Template;

import java.io.StringWriter;

public class FreeMarkerTransformer implements ResponseTransformerInterface<FreeMarkerResponse, String>
{
    private Container container;

    public FreeMarkerTransformer(Container container)
    {
        this.container = container;
    }

    @Override
    public boolean supports(RuntimeBag runtimeBag, Object response)
    {
        return response instanceof FreeMarkerResponse;
    }

    @Override
    public String transform(RuntimeBag runtimeBag, FreeMarkerResponse response) throws Exception
    {
        FreeMarker freeMarker = container.get(FreeMarker.class);

        Template template = freeMarker.getConfiguration().getTemplate(response.getTemplate());

        StringWriter stringWriter = new StringWriter();
        template.process(response.getData(), stringWriter);

        return stringWriter.toString();
    }
}
