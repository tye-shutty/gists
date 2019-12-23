----mariadb----
--new row
insert into calander_events (event_start, event_end, ce_user_id)
values ('2019-10-20 00:00:00','2019-10-20 01:00:00', 01);
insert into users (user_id, user_fname, user_lname, user_print_name, user_email, user_hash_pass, isAdmin) values
	(45, "tye11", "shutty", "test name11", "t11@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(44, "tye13", "shutty", "test name13", "t13@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(43, "tye12", "shutty", "test name12", "t12@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(42, "tye14", "shutty", "test name14", "t14@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(41, "tye15", "shutty", "test name15", "t15@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(40, "tye16", "shutty", "test name16", "t16@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(16, "tye21", "shutty", "test name21", "t21@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(17, "tye23", "shutty", "test name23", "t23@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(18, "tye22", "shutty", "test name22", "t22@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(19, "tye24", "shutty", "test name24", "t24@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(20, "tye25", "shutty", "test name25", "t25@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(21, "tye26", "shutty", "test name26", "t26@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(22, "tye31", "shutty", "test name31", "t31@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(23, "tye33", "shutty", "test name33", "t33@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(24, "tye32", "shutty", "test name32", "t32@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(25, "tye34", "shutty", "test name34", "t34@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(26, "tye35", "shutty", "test name35", "t35@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(27, "tye36", "shutty", "test name36", "t36@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(28, "tye41", "shutty", "test name41", "t41@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(29, "tye43", "shutty", "test name43", "t43@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(30, "tye42", "shutty", "test name42", "t42@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(31, "tye44", "shutty", "test name44", "t44@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(32, "tye45", "shutty", "test name45", "t45@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(33, "tye46", "shutty", "test name46", "t46@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(34, "tye51", "shutty", "test name51", "t51@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(35, "tye53", "shutty", "test name53", "t53@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(36, "tye52", "shutty", "test name52", "t52@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(37, "tye54", "shutty", "test name54", "t54@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(38, "tye55", "shutty", "test name55", "t55@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0),
	(39, "tye56", "shutty", "test name56", "t56@unb.ca", "$2y$10$PH4hQCDwSP9dhYP0rgChX.F1zW8kNPweQui2JwfsoEIbyMwPDgCA2", 0);
--alter column type
alter table users modify user_hash_pass VARCHAR(120) NOT NULL;
--alter col name
ALTER TABLE users MODIFY address VARCHAR(255), CHANGE name lastname VARCHAR(255) NOT NULL;
--new col
alter table users add [column] admin boolean after user_hash_pass;
