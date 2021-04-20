INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
INSERT INTO stanje(id, ime) VALUES(1, "Nov");
INSERT INTO stanje(id, ime) VALUES(2, "U toku");
INSERT INTO stanje(id, ime) VALUES(3, "Zavrsen");

INSERT INTO sprint(id, ime, ukupno_bodova) VALUES(1, "Test Sprint", 17);
INSERT INTO sprint(id, ime, ukupno_bodova) VALUES(2, "Production Sprint", 26);

INSERT INTO zadatak(id, bodovi, ime, zaduzeni, sprint_id, stanje_id) VALUES(1, 6, "Kreirati navbar", "Marko team", 1, 1);
INSERT INTO zadatak(id, bodovi, ime, zaduzeni, sprint_id, stanje_id) VALUES(2, 16, "Kreirati login", "Sale team", 2, 2);
INSERT INTO zadatak(id, bodovi, ime, zaduzeni, sprint_id, stanje_id) VALUES(3, 6, "Kreirati tabelu", "Mare team", 2, 3);
INSERT INTO zadatak(id, bodovi, ime, zaduzeni, sprint_id, stanje_id) VALUES(4, 4, "Kreirati rest-api", "Darko team", 2, 2);
INSERT INTO zadatak(id, bodovi, ime, zaduzeni, sprint_id, stanje_id) VALUES(5, 4, "Refactor", "Marija team", 1, 2);
INSERT INTO zadatak(id, bodovi, ime, zaduzeni, sprint_id, stanje_id) VALUES(6, 7, "Kreiraj pretragu", "Sanja team", 1, 1);