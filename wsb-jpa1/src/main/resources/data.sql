INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES
(1, 'xx', 'yy', 'city', '62-030'),
(2, 'ul.Polna', '14', 'Warszawa', '12-040'),
(3, 'ul.Lubelska', '12', 'Lublin', '33-040');

INSERT INTO doctor (id, first_name, last_name, specialization, telephone_number, email, doctor_number) VALUES
(1, 'Piotr', 'Nowak', 'SURGEON', '123456789', 'piotrnowak@example.com', '123456789'),
(2, 'Joanna', 'Nowak', 'DERMATOLOGIST', '987654321', 'joannanowak@example.com', '987654321');

INSERT INTO patient (id, first_name, last_name, telephone_number, email, date_of_birth, patient_number, age) VALUES
(1, 'Jan', 'Nowak', '123456789', 'jannowak@example.com', '2000-11-11', '1234', 24),
(2, 'Adam', 'Nowak', '123456789', 'adamnowak@example.com', '1999-05-20', '1235', 25),
(3, 'Anna', 'Kowalska', '987654321', 'annakowalska@example.com', '1949-04-22', '1236', 75);

INSERT INTO visit (id, description, time, doctor_id, patient_id) VALUES
(1, 'wizyta kontrolna', '2021-07-01 11:00:00', 1, 1),
(2, 'badanie usg', '2022-08-01 09:00:00', 2, 2),
(3, 'wizyta kontrolna', '2023-01-15 10:00:00', 1, 1),
(4, 'konsultacja', '2023-03-10 14:00:00', 2, 3),
(5, 'konsultacja', '2023-05-05 11:30:00', 1, 3);

INSERT INTO medical_treatment (id, description, type, visit_id) VALUES
(1, 'operacja kolana', 'operacja', 1),
(2, 'operacja serca', 'operacja', 2);

INSERT INTO patient_to_address (patient_id, address_id) VALUES
(1, 1),
(2, 2),
(3, 3);
