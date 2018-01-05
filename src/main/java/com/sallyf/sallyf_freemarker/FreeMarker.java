package com.sallyf.sallyf_freemarker;


import com.sallyf.sallyf.Container.ContainerAwareInterface;
import com.sallyf.sallyf.Router.Router;

public class FreeMarker implements ContainerAwareInterface
{
    private final Router router;

    private Configuration configuration;

    public FreeMarker(Router router, Configuration configuration)
    {
        this.router = router;
        this.configuration = configuration;
    }

    @Override
    public void initialize() throws Exception
    {
        router.addResponseTransformer(new FreeMarkerTransformer(this));
    }

    public Configuration getConfiguration()
    {
        return configuration;
    }
}
