package dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Nikolay on 03.01.2017.
 */
public class Product {
    private Integer id;
    private String name;
    private ProductCategory category;
    private Integer price;
    private String description;
    private MultipartFile photo;
    private String pathPhoto;
    private ProductSort sort;
    public static String SAVE_LOCATION="E:\\image\\made";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public String getPathPhoto() {
        return pathPhoto;
    }

    public void setPathPhoto(String pathPhoto) {
        this.pathPhoto = pathPhoto;
    }

    public ProductSort getSort() {
        return sort;
    }

    public void setSort(ProductSort sort) {
        this.sort = sort;
    }

    public static String getSaveLocation() {
        return SAVE_LOCATION;
    }

    public static void setSaveLocation(String saveLocation) {
        SAVE_LOCATION = saveLocation;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", photo=" + photo +
                ", pathPhoto='" + pathPhoto + '\'' +
                ", sort=" + sort +
                '}';
    }
}
