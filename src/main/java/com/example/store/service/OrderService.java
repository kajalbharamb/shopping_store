package com.example.store.service;
import com.example.store.dto.request.OrderDto;
import com.example.store.entity.ActivityHistory;
import com.example.store.entity.Product;
import com.example.store.entity.Sales;
import com.example.store.repository.AcitvityHistoryRepository;
import com.example.store.repository.OrderRepository;
import com.example.store.repository.ProductRepository;
import com.example.store.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private AcitvityHistoryRepository acitvityHistoryRepository;

    public Product postorder(OrderDto orderDto) {
        Optional<Product> Product=productRepository.findById(orderDto.getProductId());
        Product product=Product.get();
        int currentStock = product.getNoInStock() - orderDto.getQuantity();
        if(currentStock>0){
            updateStock(product,currentStock);
            sales(orderDto,product);
        acitvityHistoryRepository.save(new ActivityHistory(orderDto.getUserId(),"user has order the product"+product.getName()));
        }
        return product;
    }

    public void updateStock(Product product,int currentStock){
        product.setName(product.getName());
        product.setNoInStock(currentStock);
        product.setOriginalPrice(product.getOriginalPrice());
        product.setDiscount(product.getDiscount());
        product.setSellingPrice(product.getSellingPrice());
        productRepository.save(product);
    }

    public void sales(OrderDto orderDto,Product product){
        Sales sales=new Sales();
        sales.setProductId(orderDto.getProductId());
        sales.setUserId(orderDto.getUserId());
        sales.setSoldStock(orderDto.getQuantity());
        sales.setProductName(product.getName());
        sales.setProductSellingPrice((int) product.getSellingPrice());
        salesRepository.save(sales);

    }
}

