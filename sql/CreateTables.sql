CREATE TABLE `NBA3`.`Player` ( `id` INT NOT NULL AUTO_INCREMENT , 
							   `first_name` VARCHAR(50) NOT NULL , 
							   `last_name` VARCHAR(50) NOT NULL , 
							   `birth_date` DATE NULL , 
							    PRIMARY KEY (`id`))

/*-------------------------------------------------------------------------------*/

CREATE TABLE `NBA3`.`Team_Name` ( `id` INT NOT NULL AUTO_INCREMENT ,
								  `city` VARCHAR(30) NOT NULL , 
								  `name` VARCHAR(30) NOT NULL , 
								   PRIMARY KEY (`id`))

/*-------------------------------------------------------------------------------*/

CREATE TABLE `NBA3`.`Game` ( `id` INT NOT NULL AUTO_INCREMENT , 
                            `home_team_id` INT NOT NULL , 
                            `away_team_id` INT NOT NULL , 
                            `date_of_game` DATE NOT NULL , 
                            `is_playoff` VARCHAR(1) NOT NULL DEFAULT 'N' , 
                             PRIMARY KEY (`id`) , 
                             FOREIGN KEY (`home_team_id`) REFERENCES Team_Name(`id`),
                             FOREIGN KEY (`away_team_id`) REFERENCES Team_Name(`id`),
                             UNIQUE( `home_team_id`, `away_team_id`, `date_of_game`))
							  
/*-------------------------------------------------------------------------------*/
                             
CREATE TABLE `NBA3`.`PlayerGameStats` ( `player_Id` INT NOT NULL , 
									    `game_Id` INT NOT NULL , 
									    `teamname_id` INT NOT NULL , 
									    `minutesPlayed` DOUBLE NOT NULL , 
									    `fieldGoalsAttempted` INT NOT NULL , 
									    `fieldGoalPercentage` DOUBLE NOT NULL , 
									    `threePointersMade` INT NOT NULL , 
									    `threePointersAttempted` INT NOT NULL , 
									    `threePointPercentage` DOUBLE NOT NULL , 
									    `freethrowsMade` INT NOT NULL , 
									    `freethrowsAttempted` INT NOT NULL , 
									    `freethrowPercentage` DOUBLE NOT NULL , 
									    `offensiveRebounds` INT NOT NULL , 
									    `defensiveRebounds` INT NOT NULL , 
									    `totalRebounds` INT NOT NULL , 
									    `assists` INT NOT NULL , 
									    `personalFouls` INT NOT NULL , 
									    `steals` INT NOT NULL , 
									    `turnovers` INT NOT NULL , 
									    `blocks` INT NOT NULL , 
									    `points` INT NOT NULL , 
									    `fdsId` INT NOT NULL , 
									    PRIMARY KEY (`player_Id`, `game_Id`),
									    FOREIGN KEY (`player_Id`) REFERENCES Player(`id`),
									    FOREIGN KEY (`game_Id`) REFERENCES Game(`id`),
									    FOREIGN KEY (`teamname_id`) REFERENCES Team_Name(`id`),
									    FOREIGN KEY (`fdsId`) REFERENCES FDS(`id`),
									    UNIQUE( `player_Id`, `game_Id` ))
									    
/*-------------------------------------------------------------------------------*/		
									    
CREATE TABLE `NBA3`.`FDS` ( `id` INT NOT NULL AUTO_INCREMENT , 
						    `fanduelPoints` DOUBLE NULL , 
						    `draftkingPoints` DOUBLE NULL , 
						     PRIMARY KEY (`id`))
                             