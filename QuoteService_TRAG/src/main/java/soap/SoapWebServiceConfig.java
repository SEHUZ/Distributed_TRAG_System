package soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 *
 * @author sonic
 * 
 */
@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {


    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {

        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "cotizaciones")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema cotizacionSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("CotizacionPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://mycompany.com/quoteservice");
        wsdl.setSchema(cotizacionSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema cotizacionSchema() {
        return new SimpleXsdSchema(new ClassPathResource("cotizacion_schema.xsd"));
    }
}
