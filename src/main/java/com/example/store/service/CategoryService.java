package com.example.store.service;
import com.example.store.dto.request.LoginDto;
import com.example.store.dto.request.CategoryDto;
import com.example.store.entity.ActivityHistory;
import com.example.store.entity.Category;
import com.example.store.repository.AcitvityHistoryRepository;
import com.example.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AcitvityHistoryRepository acitvityHistoryRepository;

    public void createCategory(CategoryDto category){

        categoryRepository.save(category);
    }
    public List<Category> findCategory(LoginDto loginDto)
    {
        acitvityHistoryRepository.save(new ActivityHistory(loginDto.getEmail(),"User had viewed category List"));
        return categoryRepository.findAll();
    }



}
