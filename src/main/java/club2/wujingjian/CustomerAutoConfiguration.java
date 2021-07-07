package club2.wujingjian;

import club2.wujingjian.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//声明是配置类
@Configuration
//将被 @ConfigurationProperties修饰的类CustomerProperties加载到spring容器中
@EnableConfigurationProperties(CustomerProperties.class)
//只有在项目路径下加载到CustomerService类，才会进行自动配置
@ConditionalOnClass(CustomerService.class)
//检查配置文件中，必须有customerstarter.enabled=true才会自动配置
@ConditionalOnProperty(prefix = "customerstarter", name = "enabled", havingValue = "true")
public class CustomerAutoConfiguration {

    @Autowired
    private CustomerProperties customerProperties;

    @Bean
    @ConditionalOnMissingBean(CustomerService.class)
    public CustomerService customerService(){
        CustomerService customerService = new CustomerService();
        customerService.setName(customerProperties.getName());
        return customerService;
    }
}
