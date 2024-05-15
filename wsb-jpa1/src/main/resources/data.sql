insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (2, 'ul.Polna', '14', 'Warszawa', '12-040');

insert into doctor (id, first_name, last_name, specialization, telephone_number, email, doctor_number)
            values (1, 'Piotr', 'Nowak', 1, '123456789', 'piotrnowak@example.com', '123456789');

insert into patient (id, first_name, last_name, telephone_number, email, date_of_birth, patient_number, age)
            values (1, 'Jan', 'Kowalski', '123456789', 'jankowalski@example.com', '2000-11-11', '1234', 24);

insert into patient (id, first_name, last_name, telephone_number, email, date_of_birth, patient_number, age)
            values (2, 'Adam', 'Adamek', '123456789', 'adamek@example.com', '1999-05-20', '1235', 24);

insert into visit (id, description, time, doctor_id, patient_id)
            values (1, 'wizyta kontrolna', '2021-07-01 11:00:00', 1, 1);

insert into visit (id, description, time, doctor_id, patient_id)
            values (2, 'badanie usg', '2022-08-01 09:00:00', 1, 2);

insert into medical_treatment (id, description, type, visit_id)
            values (1, 'operacja kolana', 'operacja', 1);
