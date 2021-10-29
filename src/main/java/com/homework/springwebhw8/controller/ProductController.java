package com.homework.springwebhw8.controller;

import com.homework.springwebhw8.entity.Manufacturer;
import com.homework.springwebhw8.entity.Product;
import com.homework.springwebhw8.service.BaseService;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "product")
public class ProductController extends ControllerImpl<Product, Long> {

    private final BaseService<Product, Long> baseService;

    public ProductController(BaseService<Product, Long> baseService) {
        super(baseService);
        this.baseService = baseService;
    }

    @PutMapping("name")//http://localhost:8080/product/name?id=1&name=MacBook
    public Product changeName(@RequestParam(name = "id", defaultValue = "1") Long id,
                              @ApiParam(required = true, name = "name", defaultValue = "SmartPhone")
                              @RequestParam(name = "name") String name) {
        return baseService.findById(id)
                .map(product -> {
                    product.setName(name);
                    return baseService.save(product);
                })
                .orElse(null);
    }

    @PutMapping("price")//http://localhost:8080/product/price?id=1&price=1500
    public Product changePrice(
            @RequestParam(name = "id", defaultValue = "1") Long id,
            @ApiParam(required = true, name = "price", defaultValue = "100")
            @RequestParam(name = "price") Double price) {
        return baseService.findById(id)
                .map(product -> {
                    product.setPrice(price);
                    return baseService.save(product);
                })
                .orElse(null);
    }

    @PutMapping("manufacturer")//http://localhost:8080/product/manufacturer?id=1&manufacturer=1
    public Product changeManufacturer(
            @RequestParam(name = "id", defaultValue = "1") Long id,
            @ApiParam(required = true, name = "manufacturer", defaultValue = "100")
            @RequestParam(name = "manufacturer") Manufacturer manufacturer) {
        return baseService.findById(id)
                .map(product -> {
                    product.setManufacturer(manufacturer);
                    return baseService.save(product);
                })
                .orElse(null);
    }
}