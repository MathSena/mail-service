package org.mathsena.mailservice.infra.ses;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSesConfig {

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("yourAccessKey", "yourSecretKey");

        return AmazonSimpleEmailServiceClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(Regions.US_EAST_1)
                .build();
    }
}
