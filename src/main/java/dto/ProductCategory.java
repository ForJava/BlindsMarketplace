package dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Nikolay on 31.01.2017.
 */
public class ProductCategory {
    private Integer id;
    private String category;
    private MultipartFile photo;
    private String pathPhoto;
    public static String SAVE_LOCATION="E:\\image\\static";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", photo=" + photo +
                ", pathPhoto='" + pathPhoto + '\'' +
                '}';
    }
}
