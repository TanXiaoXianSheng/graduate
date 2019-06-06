package cn.bcf.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootstrapApplication {

    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "D:\\WorkSoft\\hadoop2.6_Win_x64");
        SpringApplication.run(BootstrapApplication.class, args);
    }

}
