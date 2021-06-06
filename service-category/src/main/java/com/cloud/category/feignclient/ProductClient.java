package com.cloud.category.feignclient;

import com.cloud.category.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author sunchangqing
 */
@FeignClient(value = "SERVICE-PRODUCT")
public interface ProductClient {
    @GetMapping("/product")
    String product();

    @GetMapping(value = "/list ")
    String list();

    @GetMapping("/test")
    String test(@RequestParam(value = "name") String name,
                @RequestParam(value = "age") Integer age);

    @GetMapping("/{id}/{name}")
    String testPath(@PathVariable("id") Integer id,
                    @PathVariable("name") String name);

    @PostMapping("/testobj")
    String testObj(@RequestBody Product product);

    @PostMapping(value = "/testform", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String testForm(Product product);

    @GetMapping("/testArray")
    String testArray(@RequestParam("ids") Integer[] ids);

    @GetMapping("/testList")
    String testList(@RequestParam(value = "ids") List<Integer> ids);

    @GetMapping("/product/{id}")
    Product product(@PathVariable("id") Integer id);

    @GetMapping("/products/{categoryId}")
    List<Product> findByCategoryId(@PathVariable("categoryId") Integer categoryId);

    @GetMapping("/products/page")
    Map<String, Object> findByCategoryIdInPage(@RequestParam(value = "pageNumber") Integer pageNumber,
                                               @RequestParam(value = "pageSize") Integer pageSize,
                                               @RequestParam(value = "categoryId") Integer categoryId);

}
