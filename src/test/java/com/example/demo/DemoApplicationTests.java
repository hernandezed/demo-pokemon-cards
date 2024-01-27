package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class DemoApplicationTests {

    @BeforeEach
    void setup() throws FileNotFoundException {
        ResourceUtils.getFile("001.html").delete();
        ResourceUtils.getFile("003.html").delete();
    }

    @AfterEach
    void teardown() throws FileNotFoundException {
        ResourceUtils.getFile("001.html").delete();
        ResourceUtils.getFile("003.html").delete();
    }

    @Test
    void contextLoads() throws Exception {
        DemoApplication.main(new String[]{});
        String expectedFile001 = new String(new FileInputStream(ResourceUtils.getFile("classpath:001.html")).readAllBytes());
        String expectedFile003 = new String(new FileInputStream(ResourceUtils.getFile("classpath:003.html")).readAllBytes());


        String resultFile001 = new String(new FileInputStream(ResourceUtils.getFile("001.html")).readAllBytes());
        String resultFile003 = new String(new FileInputStream(ResourceUtils.getFile("003.html")).readAllBytes());

        assertThat(resultFile003).isEqualTo(expectedFile003);
        assertThat(resultFile001).isEqualTo(expectedFile001);
    }

}
