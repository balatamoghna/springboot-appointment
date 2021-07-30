package com.externship.appointment.Doctor_storage;

import java.util.List;

public interface DoctorRepository {
	List<Doctor> findAll();
	List<Doctor> findById(String Id);

	
}
