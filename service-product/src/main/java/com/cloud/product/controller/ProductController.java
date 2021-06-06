package com.cloud.product.controller;

import com.cloud.product.bean.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author scq
 */
@RestController
@RequestMapping(value = "/p")
public class ProductController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/product")
    public String product() {
        System.out.println("进入商品服务");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "product ok, 当前提供服务端口：" + port;
    }

    @GetMapping("/list ")
    public String list() {
        System.out.println("商品列表服务");
        return "list ok, 当前提供服务端口：" + port;
    }

    @GetMapping("/listHeader ")
    public String listHeader(HttpServletRequest request, String color) {
        String header = request.getHeader("User-Name");
        System.out.println("获取请求头信息：" + header);
        System.out.println("获取参数color：" + color);
        System.out.println("商品列表服务");
        return "list ok, 当前提供服务端口：" + port;
    }

    @GetMapping("/test")
    public String test(@RequestParam(value = "name") String name,
                       @RequestParam(value = "age") Integer age) {
        System.out.println("name=" + name + " age=" + age);
        return "test ok, 当前提供服务端口：" + port;
    }

    @GetMapping("/{id}/{name}")
    public String testPath(@PathVariable("id") Integer id,
                           @PathVariable("name") String name) {
        System.out.println("id=" + id + " name=" + name);
        return "testPath ok, 当前提供服务端口：" + port;
    }

    @PostMapping("/testobj")
    public String testObj(@RequestBody Product product) {
        System.out.println(product);
        return "testobj ok, 当前提供服务端口：" + port;
    }

    // FIXME
    @PostMapping(value = "/testform")
    public String testForm(Product product) {
        System.out.println(product);
        return "testForm ok, 当前提供服务端口：" + port;
    }

    @GetMapping("/testArray")
    public String testArray(@RequestParam(value = "ids") Integer[] ids) {
        for (Integer id : ids) {
            System.out.println(id);
        }
        return "testArray ok, 当前提供服务端口：" + port;
    }

    @GetMapping("/testList")
    public String testList(@RequestParam(value = "ids") List<Integer> ids) {
        ids.forEach(System.out::println);
        return "testList ok, 当前提供服务端口：" + port;
    }

    @GetMapping("/product/{id}")
    public Product product(@PathVariable("id") Integer id) {
        System.out.println(id);
        return new Product(id + port, "产品", 234.12, new Date());
    }

    @GetMapping("/products/{categoryId}")
    public List<Product> findByCategoryId(@PathVariable("categoryId") Integer categoryId) {
        System.out.println(categoryId);
        return Arrays.asList(
                new Product(new Random().nextInt(100), "产品" + categoryId, new Random().nextDouble(), new Date()),
                new Product(new Random().nextInt(100), "产品" + categoryId, new Random().nextDouble(), new Date()),
                new Product(new Random().nextInt(100), "产品" + categoryId, new Random().nextDouble(), new Date()),
                new Product(new Random().nextInt(100), "产品" + categoryId, new Random().nextDouble(), new Date())
        );
    }

    @GetMapping("/products/page")
    public Map<String, Object> findByCategoryIdInPage(@RequestParam(value = "pageNumber") Integer pageNumber,
                                                      @RequestParam(value = "pageSize") Integer pageSize,
                                                      @RequestParam(value = "categoryId") Integer categoryId) {
        System.out.println(pageNumber + " " + pageSize + " " + categoryId);
        HashMap<String, Object> map = new HashMap<>();
        List<Product> products = Arrays.asList(
                new Product(new Random().nextInt(100), "产品" + categoryId, new Random().nextDouble(), new Date()),
                new Product(new Random().nextInt(100), "产品" + categoryId, new Random().nextDouble(), new Date()),
                new Product(new Random().nextInt(100), "产品" + categoryId, new Random().nextDouble(), new Date()),
                new Product(new Random().nextInt(100), "产品" + categoryId, new Random().nextDouble(), new Date())
        );
        map.put("data", products);
        map.put("pageNumber", pageNumber);
        map.put("pageSize", pageSize);
        map.put("total", 1000);
        return map;
    }
}
