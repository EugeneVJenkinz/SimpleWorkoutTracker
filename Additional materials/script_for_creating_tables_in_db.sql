USE simpleworkouttracker_db;

CREATE TABLE users (
  user_id BINARY(16) DEFAULT (uuid_to_bin(uuid())) NOT NULL PRIMARY KEY,
  username varchar(15),
  password varchar(100),
  training_history BINARY(16),
  enabled tinyint(1)
) ;

CREATE TABLE authorities (
  username varchar(15),
  authority varchar(25),
  user_id BINARY(16),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
) ;

CREATE TABLE exercises (
  exercise_id BINARY(16) DEFAULT (uuid_to_bin(uuid())) NOT NULL PRIMARY KEY,
  name varchar(50)
) ;

CREATE TABLE unique_training (
  unique_training_id BINARY(16) DEFAULT (uuid_to_bin(uuid())) NOT NULL PRIMARY KEY,
  training_date varchar(50),
  user_id BINARY(16),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
) ;

CREATE TABLE unique_exercises (
  unique_exercise_id BINARY(16) DEFAULT (uuid_to_bin(uuid())) NOT NULL PRIMARY KEY,
  repeats INT,
  relax_time INT,
  weight INT,
  unique_training_id BINARY(16),
  FOREIGN KEY (unique_training_id) REFERENCES unique_training(unique_training_id),
  exercise_id BINARY(16),
  FOREIGN KEY (exercise_id) REFERENCES exercises(exercise_id)
) ;

INSERT INTO simpleworkouttracker_db.users (username, password, enabled)
VALUES
	('userone', '{noop}userone', 1),
	('usertwo', '{noop}usertwo', 1);
    
INSERT INTO simpleworkouttracker_db.authorities (username, authority)
VALUES
	('userone', 'ROLE_USER'),
	('usertwo', 'ROLE_USER');
    