package com.Hall.Lawn.Booking.System.Api.Service;

import com.Hall.Lawn.Booking.System.Api.Entity.Hall_Images;
import com.Hall.Lawn.Booking.System.Api.Entity.Halls;
import com.Hall.Lawn.Booking.System.Api.Entity.User;
import com.Hall.Lawn.Booking.System.Api.Repository.HallImagesRepository;
import com.Hall.Lawn.Booking.System.Api.Repository.HallRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class HallService {
    private final HallRepository hallRepository;
    private final HallImagesRepository hallImagesRepository;
    public HallService(HallRepository hallRepository , HallImagesRepository hallImagesRepository) {
        this.hallRepository = hallRepository;
        this.hallImagesRepository = hallImagesRepository;
    }

    public Halls getHallById(long id) {
        return hallRepository.findById(id).orElse(null);
    }

    public List<Halls> getAllHalls() {
        return hallRepository.findAll();
    }

    public Halls addHall(Halls hall, List<MultipartFile> images, User user) throws IOException {
        hall.setUser(user);
        Halls savedHall = hallRepository.save(hall);

        if (images != null) {
            for (MultipartFile image : images) {
                Hall_Images hall_images = new Hall_Images();

                hall_images.setImage_data(image.getBytes());
                hall_images.setHalls(savedHall);
                Hall_Images savedImages=  hallImagesRepository.save(hall_images);

            }
        }
        return savedHall;
    }



}
