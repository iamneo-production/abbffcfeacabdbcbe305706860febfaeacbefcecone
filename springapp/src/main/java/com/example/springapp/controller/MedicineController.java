package com.example.springapp.controller;

import com.example.springapp.model.Medicine;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicines") // Set the root path for this controller
public class MedicineController {
    private List<Medicine> medicineList = new ArrayList<>();

    // POST endpoint to add a new medicine
    @PostMapping
    public boolean addMedicine(@RequestBody Medicine medicine) {
        return medicineList.add(medicine);
    }

    // PUT endpoint to update a medicine by medicineId
    @PutMapping("/{id}")
    public Medicine updateMedicine(@PathVariable int id, @RequestBody Medicine updatedMedicine) {
        for (Medicine medicine : medicineList) {
            if (medicine.getMedicineId() == id) {
                medicine.setMedicineName(updatedMedicine.getMedicineName());
                medicine.setPrice(updatedMedicine.getPrice());
                medicine.setQuantity(updatedMedicine.getQuantity());
                medicine.setDescription(updatedMedicine.getDescription());
                return medicine;
            }
        }
        return null; // Handle not found scenario
    }
}
