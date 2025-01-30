package com.flight.management.system.model;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FLIGHT_NO", nullable = false, unique = true)
    private BigInteger flightNo;

    @Column(name = "CARRIER_NAME", nullable = false)
    private String carrierName;

    @Column(name = "FLIGHT_MODEL", nullable = false)
    private String flightModel;

    @Column(name = "SEAT_CAPACITY", nullable = false)
    private int seatCapacity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(BigInteger flightNo) {
        this.flightNo = flightNo;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getFlightModel() {
        return flightModel;
    }

    public void setFlightModel(String flightModel) {
        this.flightModel = flightModel;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }
}
