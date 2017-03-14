package dao;

import dto.Product;
import dto.ProductCategory;
import dto.ProductSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nikolay on 27.12.2016.
 */
public class ProductDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL = "SELECT * FROM products INNER JOIN product_categories ON products.category_id=product_categories.id INNER JOIN product_sorts ON products.sort_id=product_sorts.id";
    private static final String SELECT_PRODUCT_BY_SORT = "SELECT * FROM products INNER JOIN product_categories ON products.category_id=product_categories.id INNER JOIN product_sorts ON products.sort_id=product_sorts.id WHERE products.sort_id=?";
    private static final String ADD_PRODUCT = "INSERT INTO products (name, category_id, price, path_photo, description, sort_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_PRODUCT_CATEGORIES = "SELECT * FROM product_categories";
    private static final String SELECT_PATH_PRODUCT_PHOTO_BY_ID = "SELECT path_photo FROM products WHERE id=?";
    private static final String ADD_PRODUCT_CATEGORY = "INSERT INTO product_categories (categories, path_photo) VALUES(?, ?)";
    private static final String UPDATE_PRODUCT = "UPDATE products SET name = ?, description = ?, category_id = ?, price = ?, path_photo=?, sort_id=? WHERE id = ?";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM products INNER JOIN product_categories ON products.category_id = product_categories.id INNER JOIN product_sorts ON products.sort_id=product_sorts.id WHERE products.id=?";
    private static final String SELECT_PATH_CATEGORY_PHOTO_BY_ID = "SELECT path_photo FROM product_categories WHERE id=?";
    private static final String SELECT_PRODUCT_SORT = "SELECT * FROM product_sorts";
    private static final String SELECT_PATH_SORT_PHOTO_BY_ID = "SELECT path_photo FROM product_sorts WHERE id=?";

    public List<Product> getProducts() {
        List<Product> products = jdbcTemplate.query(SELECT_ALL, new ProductRowMapper());
        return products;
    }

    public List<ProductCategory> getProductCategories() {
        List<ProductCategory> categories = jdbcTemplate.query(SELECT_PRODUCT_CATEGORIES, new CategoryRowMapper());
        return categories;
    }

    public void addProduct(Product product) {
        jdbcTemplate.update(ADD_PRODUCT, product.getName(), product.getCategory().getId(), product.getPrice(), product.getPathPhoto(), product.getDescription(), product.getSort().getId());
    }

    public String getPathProductPhoto(Integer id) {
        String pathPhoto = jdbcTemplate.queryForObject(SELECT_PATH_PRODUCT_PHOTO_BY_ID, String.class, id);
        return pathPhoto;
    }

    public void addProductCategory(ProductCategory productCategory) {
        jdbcTemplate.update(ADD_PRODUCT_CATEGORY, productCategory.getCategory(), productCategory.getPathPhoto());
    }

    public String getPathCategoryPhoto(Integer id) {
        String pathPhoto = jdbcTemplate.queryForObject(SELECT_PATH_CATEGORY_PHOTO_BY_ID, String.class, id);
        return pathPhoto;
    }

    public void updateProduct(Product product) {
        jdbcTemplate.update(UPDATE_PRODUCT, product.getName(), product.getDescription(), product.getCategory().getId(), product.getPrice(), product.getPathPhoto(), product.getSort().getId(), product.getId());
    }

    public Product getProductById(Integer id) {
        Product product = jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_ID, new ProductRowMapper(), id);
        return product;
    }

    public List<ProductSort> getProductSort() {
        List<ProductSort> sorts = jdbcTemplate.query(SELECT_PRODUCT_SORT, new SortRowMapper());
        return sorts;
    }

    public List<Product> getProductsBySort(Integer sort) {
        List<Product> products = jdbcTemplate.query(SELECT_PRODUCT_BY_SORT, new ProductRowMapper(), sort);
        return products;
    }

    public String getPathSortPhoto(Integer id) {
        String pathPhoto = jdbcTemplate.queryForObject(SELECT_PATH_SORT_PHOTO_BY_ID, String.class, id);
        return pathPhoto;
    }

    public static class ProductRowMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
            Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getInt("price"));
            ProductCategory category = new ProductCategory();
            category.setId(resultSet.getInt("id"));
            category.setCategory(resultSet.getString("categories"));
            product.setCategory(category);
            ProductSort sort = new ProductSort();
            sort.setId(resultSet.getInt("id"));
            sort.setSort(resultSet.getString("sort"));
            sort.setPathPhoto(resultSet.getString("path_photo"));
            product.setSort(sort);
            product.setPathPhoto(resultSet.getString("path_photo"));
            product.setDescription(resultSet.getString("description"));
            return product;
        }
    }

    public static class CategoryRowMapper implements RowMapper<ProductCategory> {

        @Override
        public ProductCategory mapRow(ResultSet resultSet, int i) throws SQLException {
            ProductCategory productCategory = new ProductCategory();
            productCategory.setId(resultSet.getInt("id"));
            productCategory.setCategory(resultSet.getString("categories"));
            productCategory.setPathPhoto(resultSet.getString("path_photo"));
            return productCategory;
        }
    }

    public static class SortRowMapper implements RowMapper<ProductSort> {
        @Override
        public ProductSort mapRow(ResultSet resultSet, int i) throws SQLException {
            ProductSort productSort = new ProductSort();
            productSort.setId(resultSet.getInt("id"));
            productSort.setSort(resultSet.getString("sort"));
            productSort.setPathPhoto(resultSet.getString("path_photo"));
            return productSort;
        }
    }

}
