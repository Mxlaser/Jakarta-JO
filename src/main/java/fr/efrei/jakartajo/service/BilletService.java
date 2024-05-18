package fr.efrei.jakartajo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.jakartajo.repository.BilletRepository;

@Service
public class BilletService {
    private final BilletRepository repository;

}
