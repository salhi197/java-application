package com.gym.gym.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inscriptions")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Each inscription belongs to one member
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne // Each inscription has one price
    @JoinColumn(name = "price_id", nullable = false)
    private Price price;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private double versement;

    @Column(nullable = false)
    private double reste;

    @Column(name = "nbr_seances", nullable = false)
    private int nbrSeances;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean state;

    @Column(nullable = false)
    private int user; // User ID associated with the inscription

    @Column(nullable = false)
    private int tripode; // Tripode ID associated with the inscription

    // Constructors
    public Inscription() {
        this.createdAt = LocalDateTime.now(); // Set current date by default
        this.updatedAt = LocalDateTime.now();
        this.state = true; // Default state can be true or false based on your logic
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getVersement() {
        return versement;
    }

    public void setVersement(double versement) {
        this.versement = versement;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }

    public int getNbrSeances() {
        return nbrSeances;
    }

    public void setNbrSeances(int nbrSeances) {
        this.nbrSeances = nbrSeances;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getTripode() {
        return tripode;
    }

    public void setTripode(int tripode) {
        this.tripode = tripode;
    }
}
