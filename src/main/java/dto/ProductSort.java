package dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Nikolay on 20.02.2017.
 */
public class ProductSort {
    private Integer id;
    private String sort;
    private MultipartFile photo;
    private String pathPhoto;
    private static String SAVE_LOCATION="E:\\image\\static";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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

    public static String getSaveLocation() {
        return SAVE_LOCATION;
    }

    public static void setSaveLocation(String saveLocation) {
        SAVE_LOCATION = saveLocation;
    }

    @Override
    public String toString() {
        return "ProductSort{" +
                "id=" + id +
                ", sort='" + sort + '\'' +
                ", photo=" + photo +
                ", pathPhoto='" + pathPhoto + '\'' +
                '}';
    }
}
