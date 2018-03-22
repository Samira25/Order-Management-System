package co.innoweb.Service;

import co.innoweb.model.Product;

import java.util.List;

public interface ProductService {
    public void save(Product product);
    public Product getById(long id);
    public Product update(Product product);
    public void delete(long id);
    public List<Product> productlist();
}
