package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.bean.Bill;
import com.comp2024b.tocountornot.bean.Category;
import com.comp2024b.tocountornot.dao.BillMapper;
import com.comp2024b.tocountornot.dao.CategoryMapper;
import com.comp2024b.tocountornot.exception.ForbiddenException;
import com.comp2024b.tocountornot.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryMapper categoryMapper;
    private final BillMapper billMapper;

    public CategoryService(CategoryMapper categoryMapper, BillMapper billMapper) {
        this.categoryMapper = categoryMapper;
        this.billMapper = billMapper;
    }

    public void insertCategory(Category category) {
        categoryMapper.insertCategory(category);
    }

    public void deleteCategory(int id, int uid) {
        if (ExistCategory(id,uid)) {
            if (!ExistBill(id)) {
                categoryMapper.deleteCategory(id);
            } else {
                throw new ForbiddenException("cannot delete category cause there is at least a bill under it");
            }
        } else {
            throw new NotFoundException("category not found");
        }
    }

    public void updateCategory(Category category, int uid) {
        if (ExistCategory(category.getId(),uid)) {
            Category c = getCategoryById(category.getId(), uid);
            if (c.getDivision() == category.getDivision()) {
                categoryMapper.updateCategory(category);
            } else {
                throw new ForbiddenException("cannot modify division");
            }
        } else {
            throw new NotFoundException("category not found");
        }
    }

    public Category getCategoryById(int id, int uid) {
        Category category = categoryMapper.getCategoryById(id, uid);
        if (category != null) {
            return category;
        } else {
            throw new NotFoundException("category not found");
        }
    }

    public List<Category> getCategoryByDivision(int did, int uid) {
        return categoryMapper.getCategoriesByDivision(did, uid);
    }

    public boolean ExistCategory(int id, int uid) {
        Category category = getCategoryById(id, uid);
        return category != null;
    }

    public boolean ExistBill(int id) {
        Bill bill = billMapper.getBillByCategory(id);
        return bill != null;
    }
}
