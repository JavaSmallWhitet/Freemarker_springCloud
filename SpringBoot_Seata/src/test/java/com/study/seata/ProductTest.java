package com.study.seata;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.study.seata.mappers.ProductMapper;
import com.study.seata.mode.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName ProductTest
 * @author JIAYUTAO
 * @create 2021-01-22 15:34
 * @desc
 **/
@RunWith(SpringRunner.class)
@SpringBootTest()
public class ProductTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    @DS(value = "product-ds")
    public void test() {
        Product product = productMapper.selectByPrimaryKey(1);
        System.out.println(product);
    }
}