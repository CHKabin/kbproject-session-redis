package com.kabin.kbproject.common.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 系统启动服务，用于检查系统状态及打印系统信息
 */
@Component
class SystemInistService {
    private SystemInistService systemInistService;
    @Autowired
    private Environment environment;

    @PostConstruct
    private void inist() {
        systemInistService = this;

        try {
            SystemInfoPrinter.printInfo("kbproject初始化信息", getSystemInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> getSystemInfo() {

        Map<String, String> infos = new LinkedHashMap<>();

        infos.put(SystemInfoPrinter.CREATE_PART_COPPER + 0, "系统信息");
        // 测试获取application-db.yml配置信息
        infos.put("服务器端口", environment.getProperty("server.port"));
        infos.put("数据库USER", environment.getProperty("spring.datasource.username"));
        infos.put("数据库地址", environment.getProperty("spring.datasource.url"));

        return infos;
    }
}
