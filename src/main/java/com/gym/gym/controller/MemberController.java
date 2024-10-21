package com.gym.gym.controller;

import com.gym.gym.model.Member;
import com.gym.gym.model.Inscription; // Import the Inscription model
import com.gym.gym.model.Price;
import com.gym.gym.service.MemberService;
import com.gym.gym.service.InscriptionService; // Import the inscription service
import com.gym.gym.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private InscriptionService inscriptionService; // Service to handle inscriptions

    @GetMapping("/create")
    public String showCreateMemberForm(Model model) {
        model.addAttribute("member", new Member());
        List<Price> prices = priceService.findAllPrices();
        model.addAttribute("prices", prices);
        return "create_member";
    }

    @PostMapping
    public String createMember(@ModelAttribute("member") Member member,
                               @RequestParam("startDate") String startDate,
                               @RequestParam("nombreDeMois") int nombreDeMois,
                               @RequestParam("priceId") Long priceId) {
        // Save the member
        Member savedMember = memberService.saveMember(member);

        // Create an inscription linked to the saved member
        Inscription inscription = new Inscription();
        inscription.setMember(savedMember); // Set the member
        inscription.setStartDate(LocalDate.parse(startDate)); // Parse the start date
        inscription.setEndDate(inscription.getStartDate().plusMonths(nombreDeMois)); // Calculate end date
        inscription.setPrice(priceService.findPriceById(priceId)); // Set the selected price
        inscription.setTotal(inscription.getPrice().getAmount() * nombreDeMois); // Calculate total
        inscription.setNbrSeances(nombreDeMois); // Set the number of sessions
        inscription.setCreatedAt(LocalDate.now()); // Set created date
        inscription.setUpdatedAt(LocalDate.now()); // Set updated date
        inscription.setState(true); // Set initial state
        // Add any additional fields for inscription here

        inscriptionService.saveInscription(inscription); // Save the inscription

        return "redirect:/members"; // Redirect to the members list page after saving
    }

    // Other methods remain unchanged...
}
