package com.main.urban_vibe.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        // Tạo instance của ModelMapper
        ModelMapper modelMapper = new ModelMapper();

        // Cấu hình ModelMapper (nếu cần)
        // Ví dụ: modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;
    }
}