package com.springmvc.mongoweb.controller;

import com.springmvc.mongoweb.dao.ProductRepository;
import com.springmvc.mongoweb.dto.ProductDto;
import com.springmvc.mongoweb.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto create(@RequestBody ProductDto productDto) {
        Product product = productRepository.save(convertToEntity(productDto));
        return convertToDto(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ProductDto show(@PathVariable String id) {
        return convertToDto(productRepository.findOne(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ProductDto> showAll() {
        Iterable<Product> productsIterable = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        productsIterable.forEach(products::add);

        return convertToDtoList(products);
    }

    /*
    @RequestMapping("/delete")
    public String delete(@RequestParam String id) {
        Product product = productRepository.findOne(id);
        productRepository.delete(product);

        return "redirect:/product";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("product", productRepository.findOne(id));
        return "edit";
    }

    @RequestMapping("/update")
    public String update(@RequestParam String id, @RequestParam String prodName, @RequestParam String prodDesc,
                         @RequestParam Double prodPrice, @RequestParam String prodImage) {
        Product product = productRepository.findOne(id);
        product.setProdName(prodName);
        product.setProdDesc(prodDesc);
        product.setProdPrice(prodPrice);
        product.setProdImage(prodImage);
        productRepository.save(product);

        return "redirect:/show/" + product.getId();
    }
*/
    private Product convertToEntity(ProductDto productDto) {
        return mapper.map(productDto, Product.class);
    }

    private ProductDto convertToDto(Product post) {
        return mapper.map(post, ProductDto.class);
    }

    private List<ProductDto> convertToDtoList(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product : products) {
            productDtos.add(convertToDto(product));
        }

        return productDtos;
    }

}
