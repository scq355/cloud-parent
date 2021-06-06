package com.cloud.category.controller;

import com.cloud.category.feignclient.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author sunchangqing
 */
@RestController
public class CategoryController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/category")
    public String category() {
//        String product = productClient.product();
//        String list = productClient.list();
//        String test = productClient.test("中国", 23);
//        String testPath = productClient.testPath(12, "中国人");
//        System.out.println(product);
//        System.out.println(list);
//        System.out.println(test);
//        System.out.println(testPath);

//        return "category ok: " + product + list + test + testPath;
//        String testObj = productClient.testObj(new Product(1, "产品", 123.234, new Date()));
//        return "category ok: " + testObj;

//        String testForm = productClient.testForm(new Product(1, "产品", 123.234, new Date()));
//        return "category ok: " + testForm;

//        String testArray = productClient.testArray(new Integer[]{1, 2, 3});
//        return "category ok: " + testArray;

//        String testList = productClient.testList(Arrays.asList(1, 2, 3));
//        return "category ok: " + testList;

//        Product product = productClient.product(new Random().nextInt(100));
//        return "category ok: " + product.toString();

//        List<Product> products = productClient.findByCategoryId(new Random().nextInt(100));
//        return "products ok: " + products.toString();

//        Map<String, Object> page = productClient.findByCategoryIdInPage(1, 10, new Random().nextInt(100));
//        return "page ok: " + page.toString();

        // openfeign默认超时时间为1s
        String product = productClient.product();
        return "product ok: " + product;
    }
}
