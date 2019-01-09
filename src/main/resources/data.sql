INSERT INTO `role` (id, role_name) VALUES(1, 'ADMIN');
INSERT INTO `role` (id, role_name) VALUES(2, 'USER');
INSERT INTO `role` (id, role_name) VALUES(3, 'SUPER_USER');

INSERT INTO privilege (id, privilege_name) VALUES(1, 'NEW_PRIVILEGE');
INSERT INTO privilege (id, privilege_name) VALUES(2, 'EDIT_PRIVILEGE');
INSERT INTO privilege (id, privilege_name) VALUES(3, 'DELETE_PRIVILEGE');
INSERT INTO privilege (id, privilege_name) VALUES(4, 'READ_PRIVILEGE');

INSERT INTO role_privilege (role_id, privilege_id) VALUES(1, 1);
INSERT INTO role_privilege (role_id, privilege_id) VALUES(1, 2);
INSERT INTO role_privilege (role_id, privilege_id) VALUES(1, 3);
INSERT INTO role_privilege (role_id, privilege_id) VALUES(1, 4);
INSERT INTO role_privilege (role_id, privilege_id) VALUES(2, 4);
INSERT INTO role_privilege (role_id, privilege_id) VALUES(3, 1);
INSERT INTO role_privilege (role_id, privilege_id) VALUES(3, 2);
INSERT INTO role_privilege (role_id, privilege_id) VALUES(3, 4);

INSERT INTO `user` (id, userpass, username, roles_id) VALUES(1, 'admin', 'admin@mitrais.com', 1);
INSERT INTO `user` (id, userpass, username, roles_id) VALUES (2, 'user', 'user@mitrais.com', 2);
INSERT INTO `user` (id, userpass, username, roles_id) VALUES (3, 'mitrais_user', 'mitrais_user@mitrais.com', 3);