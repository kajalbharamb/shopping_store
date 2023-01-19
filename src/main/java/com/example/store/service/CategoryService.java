package com.example.store.service;
import com.example.store.dto.Login;
import com.example.store.entity.ActivityHistory;
import com.example.store.entity.Category;
import com.example.store.repository.AcitvityHistoryRepository;
import com.example.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Locale;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AcitvityHistoryRepository acitvityHistoryRepository;

    public void createCategory(Category category){

        categoryRepository.save(category);
    }
    public List<Category> findCategory(Login login)
    {
        acitvityHistoryRepository.save(new ActivityHistory(login.getEmail(),"User had viewed category List"));
        return categoryRepository.findAll();
    }


}
