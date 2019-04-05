DELETE FROM HISTORY;
DELETE FROM USER_ROLES;
DELETE FROM USERS;


INSERT INTO USERS (name, email, password) VALUES
 ('Wizard', 'wizard@gmail.com', '{noop}password');

INSERT INTO USER_ROLES (role, user_id) VALUES
('ROLE_USER', 1);


INSERT INTO HISTORY (user_id, num_value) VALUES
(1, 100),
(1, 150),
(1, 200),
(1, 230);