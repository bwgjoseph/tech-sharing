package com.bwgjoseph.techsharing.config;

import org.springframework.beans.factory.config.BeanPostProcessor;

import lombok.extern.slf4j.Slf4j;

/**
 * Apply Bean Processing to all Beans
 */
@Slf4j
public class CustomBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        log.info("{} from postProcessBeforeInitialization", beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        log.info("{} from postProcessAfterInitialization", beanName);
        return bean;
    }
}
