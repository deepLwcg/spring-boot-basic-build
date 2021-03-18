package cn.yajienet.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

//初始化springboot后，最后加载," String... args " 与 main 方法 值一样

@Slf4j
@Component
public class DemoCommandLineRunner implements CommandLineRunner {
    @Value("${server.port}")
    private Integer port;
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public void run(String... args) throws Exception {
        initUserTable();
        log.info(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
        String localhost = "http://localhost:"+port.toString();
        log.info("服务地址：{}",localhost);
        log.info("API文档：{}",localhost+"/swagger-ui.html");

    }

    private void initUserTable(){
        try {
            List<Map<String, Object>> tables = jdbcTemplate.queryForList("show tables");
            boolean user = false;
            for (Map<String, Object> table:tables){
                for (Map.Entry<String,Object> entry:table.entrySet()){
                    if ("user".equals(entry.getValue().toString())){
                        user = true;
                    }
                }
            }
            if (!user){
                jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS `user` (" +
                        "  `id` int(11) NOT NULL AUTO_INCREMENT," +
                        "  `user_name` varchar(100) NOT NULL," +
                        "  `email` varchar(100) DEFAULT NULL," +
                        "  `phone` varchar(100) DEFAULT NULL," +
                        "  `password` varchar(200) DEFAULT NULL," +
                        "  `is_enable` bit(1) NOT NULL DEFAULT b'1'," +
                        "  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP," +
                        "  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP," +
                        "  PRIMARY KEY (`id`)," +
                        "  UNIQUE KEY `user_name` (`user_name`)," +
                        "  UNIQUE KEY `email` (`email`)," +
                        "  UNIQUE KEY `phone` (`phone`)," +
                        "  KEY `is_enable` (`is_enable`)" +
                        ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;");
                jdbcTemplate.execute("INSERT INTO `user` (`id`, `user_name`, `email`, `phone`, `password`, `is_enable`, `updated_at`, `created_at`) VALUES " +
                        "(1, 'wcg', '975696229@qq.com', '13014532809', 'e10adc3949ba59abbe56e057f20f883e', b'1', '2021-03-14 09:44:45', '2021-03-14 09:44:45');");
                log.info("User表不存在，已经自动添加成功");

            }
        }catch (Exception e){
            log.info("表初始化失败");
        }
    }
}
