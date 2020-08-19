CREATE SCHEMA `CreditoComercio` ;

CREATE TABLE `CreditoComercio`.`empresa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `CreditoComercio`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `CreditoComercio`.`voucher` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_empresa` INT NULL,
  `id_usuario` INT NULL,
  `valor` DECIMAL NULL,
  PRIMARY KEY (`id`),
  INDEX `id_empresa_idx` (`id_empresa` ASC),
  INDEX `id_usuario_idx` (`id_usuario` ASC),
  CONSTRAINT `id_empresa`
    FOREIGN KEY (`id_empresa`)
    REFERENCES `CreditoComercio`.`empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `CreditoComercio`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);