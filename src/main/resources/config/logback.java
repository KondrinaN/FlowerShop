import org.w3c.dom.DOMConfiguration;

class Main
{
    private static final Logger LOG = 	LoggerFactory.getLogger(Main.class);

    public  static void main(String[] args)
    {
        DOMConfiguration.configure("config/logback.xml");

        System.out.println("logger...");
        LOG.debug("log");
    }
}