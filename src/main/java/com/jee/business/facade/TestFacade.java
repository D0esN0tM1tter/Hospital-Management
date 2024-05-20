package com.jee.business.facade;

import java.sql.SQLException;

import com.jee.Models.Doctor;

public class TestFacade {

	public static void main(String[] args) {
        try {
            // Créez une instance de ApplicationFacade
            ApplicationFacade facade = new ApplicationFacade();

            // Appelez la méthode selectDoctor en passant l'ID du docteur
            int doctorId = 1; // ID du docteur à sélectionner
            Doctor doctor = (Doctor) facade.selectDoctor(doctorId);

            // Vérifiez si le docteur a été trouvé
            if (doctor != null) {
                // Affichez les détails du docteur
                System.out.println("Doctor details:");
                System.out.println("ID: " + doctor.getId());
                System.out.println("Name: " + doctor.getName());
                System.out.println("Firstname: " + doctor.getFirstname());
                System.out.println("Login: " + doctor.getLogin());
                System.out.println("Password: " + doctor.getPassword());
            } else {
                System.out.println("Doctor with ID " + doctorId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
