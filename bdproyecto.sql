SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_proyectointegradorgroup5
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_proyectointegradorgroup5
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_proyecto` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `db_proyecto` ;


CREATE TABLE IF NOT EXISTS `db_proyecto`.`propietario` (
  `idpropietario` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(35) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `dni` INT NULL DEFAULT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL ,
  `fechaNac` DATE NULL DEFAULT NULL,
  `fechaReg` DATETIME DEFAULT NULL,
  `estado` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`idpropietario`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;







SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


ALTER TABLE propietario
ADD UNIQUE (dni);


