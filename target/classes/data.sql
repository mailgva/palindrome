--DELETE FROM USERS;

INSERT INTO users (name, email, password) VALUES
 ('User', 'user@gmail.com', '{noop}password'),
 ('Admin', 'admin@gmail.com', '{noop}password');

INSERT INTO user_roles (role, user_id) VALUES
('ROLE_USER', 1),
('ROLE_ADMIN', 2);


INSERT INTO HISTORY (user_id, num_value) VALUES
(1, 100),
(1, 150),
(2, 200),
(2, 230),
(1, 300),
(1, 430);