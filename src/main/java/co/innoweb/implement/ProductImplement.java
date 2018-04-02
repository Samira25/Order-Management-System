package co.innoweb.implement;

import co.innoweb.Service.ProductService;
import co.innoweb.model.Product;
import co.innoweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service("ProductService")
public class ProductImplement implements ProductService {

    @Autowired private ProductService productService;
    @Autowired private ProductRepository productRepository;
    @Autowired private JdbcTemplate jdbcTemplate;
    private EntityManager entityManager;

    public ProductImplement(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product update(Product product) {
        Product p = productRepository.findOne(product.getId());
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setDescription(product.getDescription());
        return productRepository.save(p);
    }

    @Override
    public void delete(long id) {
        Product product = productRepository.findOne(id);
        productRepository.delete(product);
    }

    @Override
    public List<Product> productlist() {
        String sql = "select * from product";
        List<Product> productList = jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setDescription(resultSet.getString("description"));
                return product;
            }
        });
        return productList;
    }
}
