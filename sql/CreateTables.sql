CREATE TABLE `NBA3`.`Player` ( `id` INT NOT NULL AUTO_INCREMENT , 
							   `first_name` VARCHAR(50) NOT NULL , 
							   `last_name` VARCHAR(50) NOT NULL , 
							   `birth_date` DATE NULL , 
							    PRIMARY KEY (`id`))

/*-------------------------------------------------------------------------------*/

CREATE TABLE `NBA3`.`Team_Name` ( `city` VARCHAR(30) NOT NULL , 
								  `name` VARCHAR(30) NOT NULL , 
								   PRIMARY KEY (`city`, `name`))

/*-------------------------------------------------------------------------------*/

CREATE TABLE `NBA3`.`Game` ( `id` INT NOT NULL AUTO_INCREMENT , 
							 `home_team` VARCHAR(30) NOT NULL , 
							 `away_team` VARCHAR(30) NOT NULL , 
							 `date_of_game` DATE NOT NULL , 
							  PRIMARY KEY (`id`),
							  UNIQUE( `home_team`, `away_team`, `date_of_game`))