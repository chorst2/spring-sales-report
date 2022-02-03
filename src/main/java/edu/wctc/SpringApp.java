package edu.wctc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="edu.wctc")
public class SpringApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //register our main class - .class is way of referring to this entire class
        context.register(SpringApp.class);
        //because we made a change we need to refresh the context
        context.refresh();

        ((SalesReportHelper)context.getBean("salesReportHelper")).generateReport();
    }

    @Bean
    public SalesInput salesInput() {
        return new FileInput();
//        return new CommandLineInput();
    }

    @Bean
    public SalesReport salesReport() {
        return new SummaryReport();
//        return new DetailedReport();
    }


    @Bean
    public ShippingPolicy shippingPolicy(){
        return new FlatRateShippingPolicy();
//        return new FreeShippingPolicy();
    }
}
