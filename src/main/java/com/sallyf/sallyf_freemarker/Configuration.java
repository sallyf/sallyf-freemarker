package com.sallyf.sallyf_freemarker;

import com.sallyf.sallyf.Container.ConfigurationInterface;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import java.util.Locale;

public class Configuration extends freemarker.template.Configuration implements ConfigurationInterface
{
    public Configuration()
    {
        this.setIncompatibleImprovements(new Version(2, 3, 20));
        this.setDefaultEncoding("UTF-8");
        this.setLocale(Locale.US);
        this.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }
}
