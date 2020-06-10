DROP TABLE IF EXISTS seansi;

CREATE TABLE SEANSI (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  zal INT NOT NULL,
  name VARCHAR(250) NOT NULL,
  seanstime VARCHAR(250) NOT NULL
);

INSERT INTO seansi (zal ,name, seanstime) VALUES
  ('1','film2', '13.12.20 13:00'),
  ('1','film4', '13.12.20 14:30');
