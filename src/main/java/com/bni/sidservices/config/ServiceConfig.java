package com.bni.sidservices.config;

import com.bni.sidservices.endpoint.InvestorEndpoint;
import com.bni.sidservices.utils.MyWsdl11Definition;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class ServiceConfig {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext appContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(appContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    // localhost:8080/ws/investor.wsdl
    @Bean(name = "investor")
    public MyWsdl11Definition defaultWsdl11Definition(XsdSchema schema){
        MyWsdl11Definition wsdl11Definition = new MyWsdl11Definition();
        wsdl11Definition.setPortTypeName("InvestorPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setRequestSuffix("");
        wsdl11Definition.setResponseSuffix("Response");
        wsdl11Definition.setTargetNamespace(InvestorEndpoint.NAMESPACE_URI);
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema investorInfoSchema(){
        return new SimpleXsdSchema(new ClassPathResource("/investor.xsd"));
    }
}
