package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.bean.Category;
import com.comp2024b.tocountornot.service.CategoryService;
import com.comp2024b.tocountornot.service.DivisionService;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;
    private final DivisionService divisionService;

    public CategoryController(CategoryService categoryService, DivisionService divisionService) {
        this.categoryService = categoryService;
        this.divisionService = divisionService;
    }

    @TokenRequired
    @PostMapping("category")
    public Result insertCategory(@Valid @RequestBody Category category, @RequestAttribute("uid") int uid) {
        if (divisionService.ExistDivision(category.getDivision(), uid)) {
            categoryService.insertCategory(category);
        }
        return ResultFactory.getCreatedResult(category.getId());
    }

    @TokenRequired
    @DeleteMapping("category/{id}")
    public Result deleteCategory(@PathVariable("id") int id, @RequestAttribute("uid") int uid) {
        categoryService.deleteCategory(id, uid);
        return ResultFactory.getSuccessResult(id);
    }

    @TokenRequired
    @PutMapping("category/{id}")
    public Result updateCategory(@PathVariable("id") int id, @Valid @RequestBody Category category, @RequestAttribute("uid") int uid) {
        if (divisionService.ExistDivision(category.getDivision(), uid)) {
            category.setId(id);
        }
        categoryService.updateCategory(category, uid);
        return ResultFactory.getSuccessResult(category.getId());
    }

    @TokenRequired
    @GetMapping("category/{id}")
    public Result getCategoryById(@PathVariable("id") int id, @RequestAttribute("uid") int uid) {
        Category category = categoryService.getCategoryById(id, uid);
        return ResultFactory.getSuccessResult(category);
    }

    @TokenRequired
    @GetMapping("categories/{division}")
    public Result getCategoryByDivision(@PathVariable("division") int division, @RequestAttribute("uid") int uid) {
        List<Category> categories = null;
        if (divisionService.ExistDivision(division, uid)) {
             categories = categoryService.getCategoryByDivision(division, uid);
        }
        return ResultFactory.getSuccessResult(categories);
    }
}
