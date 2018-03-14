package com.pactera.datasource;

import org.aspectj.lang.JoinPoint;

import java.util.Map;

/**
 * @author wjwei
 * 动态切换数据源切面
 */
public class DataSourceAspect {
    private String defaultDataSource;
    private Map<String, Object> targetDataSources;

    public void doBefore(JoinPoint joinPoint) {
           boolean isSetDataSource = false;
        String targetName = joinPoint.getTarget().getClass().getName();
        for(Map.Entry<String, Object> entry : targetDataSources.entrySet()) {
            if(targetName.contains(entry.getKey())){
                String value = entry.getValue().toString();
                CustomerContextHolder.setCustomerType(value);
                isSetDataSource = true;
                break;
            }
        }
        if(!isSetDataSource) {
            CustomerContextHolder.setCustomerType(defaultDataSource);
        }

    }

    public void doAfterReturning(JoinPoint joinPoint) {
        CustomerContextHolder.clearCustomerType();
    }

    public String getDefaultDataSource() {
        return defaultDataSource;
    }

    public void setDefaultDataSource(String defaultDataSource) {
        this.defaultDataSource = defaultDataSource;
    }

    public Map<String, Object> getTargetDataSources() {
        return targetDataSources;
    }

    public void setTargetDataSources(Map<String, Object> targetDataSources) {
        this.targetDataSources = targetDataSources;
    }
}
