package com.goodskill.config;
 import io.minio.MinioClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConditionalOnProperty(prefix = "minio", name = "endpoint")
@ConditionalOnClass(MinioClient.class)
public class MinioConfig {


@Bean
public MinioClient minioClient(MinioProperties minioProperties){
    return MinioClient.builder().endpoint(minioProperties.getEndpoint()).credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey()).build();
}


}