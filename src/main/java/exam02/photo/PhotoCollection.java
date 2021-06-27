package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos = new ArrayList<>();


    public void addPhoto(String... names) {
        for (String name : names) {
            photos.add(new Photo(name));
        }
    }


    public void starPhoto(String name, Quality quality) {
        boolean found = false;
        for (Photo photo : photos) {
            if (photo.getName().equals(name)) {
                photo.setQuality(quality);
                found = true;
            }
            if (!found) {
                throw new PhotoNotFoundException("No such photo found!");
            }
        }
    }

    public int numberOfStars() {
        int count = 0;
        for (Photo photo : photos) {

            if (photo.getQuality() == Quality.ONE_STAR) {
                count++;
            }
            if (photo.getQuality() == Quality.TWO_STAR) {
                count = count + 2;
            }
        }
        return count;
    }

    public List<Photo> getPhotos() {
        return photos;
    }


//    public int numberOfStars() {
//        int count = 0;
//        for (Photo photo : photos) {
//            switch (photo.getQuality()) {
//                case TWO_STAR :
//                    count += 2;
//                case ONE_STAR :
//                    count++;
//                }
//            }
//        return count;
//    }


}
