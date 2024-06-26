package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Specialization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.Collection;
import javax.persistence.CascadeType;



@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String telephoneNumber;

	private String email;

	@Column(nullable = false)
	private String doctorNumber;

	@Enumerated(EnumType.STRING)
	private Specialization specialization;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<VisitEntity> visits;

	@ManyToMany
	@JoinTable(
			name = "DOCTOR_TO_ADDRESS",
			joinColumns = @JoinColumn(name = "doctor_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "address_id", nullable = false)
	)
	private Collection<AddressEntity> addresses;

	// Getters and Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public String getTelephoneNumber() { return telephoneNumber; }
	public void setTelephoneNumber(String telephoneNumber) { this.telephoneNumber = telephoneNumber; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getDoctorNumber() { return doctorNumber; }
	public void setDoctorNumber(String doctorNumber) { this.doctorNumber = doctorNumber; }
	public Specialization getSpecialization() { return specialization; }
	public void setSpecialization(Specialization specialization) { this.specialization = specialization; }
	public Collection<VisitEntity> getVisits() { return visits; }
	public void setVisits(Collection<VisitEntity> visits) { this.visits = visits; }
	public Collection<AddressEntity> getAddresses() { return addresses; }
	public void setAddresses(Collection<AddressEntity> addresses) { this.addresses = addresses; }
}
