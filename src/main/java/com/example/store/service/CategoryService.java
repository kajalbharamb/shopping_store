package com.example.store.service;

import com.example.store.dto.request.LoginDto;
import com.example.store.entity.ActivityHistory;
import com.example.store.entity.Category;
import com.example.store.repository.AcitvityHistoryRepository;
import com.example.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AcitvityHistoryRepository acitvityHistoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findCategory(LoginDto loginDto) {
        acitvityHistoryRepository.save(new ActivityHistory(loginDto.getEmail(), "User had viewed category List"));
        return categoryRepository.findAll();
    }

    public Optional<Category> findByCategoryId(int categoryId) {
        return categoryRepository.findById(categoryId);
    }


}
