package org.example;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

@Log4j2
public class MyTests {

    //테스트 public void 이름 ( )
    @Test
    public void test1() {

        log.debug("test 한글 debug.........");

        log.info("test 한글 info.........");

        log.error("test 한글 error.........");

    }

    @Test
    public void test2() {

    }
}