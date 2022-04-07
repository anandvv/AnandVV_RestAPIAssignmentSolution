insert into employees values(1, 'andy@gmail.com', 'Andy', 'Tang');
insert into employees values(2, 'bubba@gmail.com', 'Bubba', 'Watson');

insert into roles values(1, 'ADMIN');
insert into roles values(2, 'USER');

insert into users values(1, '$2a$12$hmaJFsepAI24/42/4yGB8OKoeWSknftb7qStshCgUfCXt5YzMqhI6', 'admin');
insert into users values(2, '$2a$12$hmaJFsepAI24/42/4yGB8OKoeWSknftb7qStshCgUfCXt5YzMqhI6', 'user');

insert into users_roles values(1, 1);
insert into users_roles values(2, 2);
