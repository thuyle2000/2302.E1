CREATE TABLE `db2302.e1`.`tbmodule` (
`id` INT NOT NULL AUTO_INCREMENT , 
`sname` VARCHAR(5) NOT NULL , 
`lname` VARCHAR(40) NOT NULL , 
`hours` INT NOT NULL , 
`fee` INT NULL , 
PRIMARY KEY (`id`), UNIQUE `ix_sname` (`sname`)) ENGINE = InnoDB;

INSERT INTO `tbmodule` (`id`, `sname`, `lname`, `hours`, `fee`) VALUES 
(NULL, 'JP1', 'Java Programming 1', '50', '200'), 
(NULL, 'JP2', 'Java Advanced Programming 2', '52', '300'),
(NULL, 'XMJ', 'XML and JSON', '20', '140'), 
(NULL, 'PHPL', 'PHP and Laravel Framework', '56', '360');