package com.sallyf.sallyf_freemarker;


import com.sallyf.sallyf.Container.Container;
import com.sallyf.sallyf.Container.ContainerAware;
import com.sallyf.sallyf.Router.Router;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import java.io.File;
import java.util.Locale;

public class FreeMarker extends ContainerAware
{
    private Configuration configuration;

    public FreeMarker(Container container)
    {
        super(container);
    }

    @Override
    public void initialize() throws Exception
    {
        configuration = new Configuration();

        configuration.setDirectoryForTemplateLoading(new File("/home/raphael/Documents/Code/Yuconz/resources/views"));

        configuration.setIncompatibleImprovements(new Version(2, 3, 20));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setLocale(Locale.US);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        getContainer().get(Router.class).addResponseTransformer(new FreeMarkerTransformer(getContainer()));
    }

    public Configuration getConfiguration()
    {
        return configuration;
    }
}
