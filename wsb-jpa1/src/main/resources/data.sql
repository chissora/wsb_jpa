insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (2, 'ul.Polna', '14', 'Warszawa', '12-040');

insert into doctor (id, first_name, last_name, specialization, telephone_number, email, doctor_number)
            values (1, 'Piotr', 'Nowak', 1, '123456789', 'piotrnowak@example.com', '123456789');

insert into patient (id, first_name, last_name, telephone_number, email, date_of_birth, patient_number)
            values (1, 'Jan', 'Kowalski', '123456789', 'jankowalski@example.com', '2000-11-11', '123456789');

insert into visit (id, description, time, doctor_id, patient_id)
            values (1, 'wizyta kontrolna', '2021-07-01 11:00:00', 1, 1);

insert into medical_treatment (id, description, type, visit_id)
            values (1, 'operacja kolana', 'operacja', 1);
