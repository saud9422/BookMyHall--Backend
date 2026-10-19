package com.Hall.Lawn.Booking.System.Api.DTO;

import com.Hall.Lawn.Booking.System.Api.Entity.Booking;
import com.Hall.Lawn.Booking.System.Api.Entity.Halls;
import com.Hall.Lawn.Booking.System.Api.Entity.User;

import java.util.List;

public class DashboardDto {
    private  User user;
    private List<Halls> halls;
    private List<Booking> bookings;

    public List<Halls> getHalls() {
        return halls;
    }

    public void setHalls(List<Halls> halls) {
        this.halls = halls;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setBookings(List<Booking> bookings) {this.bookings = bookings;}

    public List<Booking> getBookings() {return bookings;}
}


