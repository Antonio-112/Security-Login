create table Users(email varchar, username varchar, password varchar, role varchar);

-- admin
insert into Users(email, username, password, role)
values('guido@mail.com',
		'admin',
		'$2a$10$X.9iwQttgYHjZ/i75ZLlZe3HSYtKUB2s3pvKbpotONzP7GwD6wpoG',
		'ADMIN');
		
-- cliente
insert into Users(email, username, password, role)
values('james@mail.com',
		'client',
		'$2a$10$Zk./Z5UIduVBUwwjQcRtYuYcDnrW7t.RXbXI5GM8Xs.RLQy2l/UAe',
		'CLIENT');