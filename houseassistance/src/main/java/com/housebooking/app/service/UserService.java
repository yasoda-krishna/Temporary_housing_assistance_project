package com.housebooking.app.service;

import com.housebooking.app.dao.*;
import com.housebooking.app.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private HouseRepo houseRepo;

    @Autowired
    private AppointmentModel appointmentModel;

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private ReserveModel reserveModel;

    @Autowired
    private Coupon coupon;

    @Autowired
    private CouponRepo couponRepo;

    @Autowired
    private ReserveRepo reserveRepo;

    public void saveMsg(MessageModel msg) {
        messageRepo.save(msg);

    }

    public List<HouseModel> getAllHouses(){
        return houseRepo.findAll();
    }

    public void saveAppointment(AppointmentModel appointment) {

        appointmentRepo.save(appointment);


    }

    public int saveReserveHouse(ReserveModel reserve) {
        // TODO Auto-generated method stub

        List<Coupon> coupons = couponRepo.findAll();

        List<Coupon> coupon = coupons.stream().filter(co -> co.getCouponCode().equals(reserve.getCoupon())).collect(Collectors.toList());

        if(coupon.size() != 0) {
            reserveRepo.save(reserve);

            couponRepo.deleteById(coupon.get(0).getId());
            return 1;
        }
        else {

            return 0;
        }


    }

}
