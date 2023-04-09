CREATE TABLE `film_tickets_booking`.`kh` (
  `MaKH` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `HoTen` VARCHAR(45) NULL,
  `SDT` INT(11) NULL,
  PRIMARY KEY (`MaKH`));

CREATE TABLE `film_tickets_booking`.`nhanvien` (
  `MaNV` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `Hoten` VARCHAR(45) NULL,
  PRIMARY KEY (`MaNV`));

CREATE TABLE `film_tickets_booking`.`phim` (
  `MaPhim` VARCHAR(45) NOT NULL,
  `TenPhim` VARCHAR(45) NOT NULL,
  `TheLoai` VARCHAR(45) NOT NULL,
  `ThoiLuong` TIME NOT NULL,
  PRIMARY KEY (`MaPhim`));

CREATE TABLE `film_tickets_booking`.`rapchieu` (
  `MaRap` VARCHAR(45) NOT NULL,
  `SoLuongGhe` INT NOT NULL,
  PRIMARY KEY (`MaRap`));

CREATE TABLE `film_tickets_booking`.`ghe` (
  `idghe` INT NOT NULL,
  `Hang_ghe` VARCHAR(45) NOT NULL,
  `SoGhe` INT NOT NULL,
  `MaRap` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idghe`),
  CONSTRAINT `MaRap`
    FOREIGN KEY (`MaRap`)
    REFERENCES `film_tickets_booking`.`rapchieu` (`MaRap`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    CREATE TABLE `film_tickets_booking`.`lichchieu` (
  `idlichchieu` INT NOT NULL,
  `MaRap` VARCHAR(45) NOT NULL,
  `MaPhim` VARCHAR(45) NOT NULL,
  `BatDau` DATETIME NOT NULL,
  `KetThuc` DATETIME NOT NULL,
  PRIMARY KEY (`idlichchieu`),
    FOREIGN KEY (`MaRap`)
    REFERENCES `film_tickets_booking`.`rapchieu` (`MaRap`),
    FOREIGN KEY (`MaPhim`)
    REFERENCES `film_tickets_booking`.`phim` (`MaPhim`)
);

CREATE TABLE `film_tickets_booking`.`datve` (
  `idDatVe` INT NOT NULL,
  `MaKH` INT NOT NULL,
  `idLichChieu` INT NOT NULL,
  `MaNV` INT NOT NULL,
  `Giave` FLOAT NOT NULL,
  PRIMARY KEY (`idDatVe`),
    FOREIGN KEY (`MaKH`)
    REFERENCES `film_tickets_booking`.`kh` (`MaKH`),
    FOREIGN KEY (`idLichChieu`)
    REFERENCES `film_tickets_booking`.`lichchieu` (`idlichchieu`),
  CONSTRAINT `MaNV`
    FOREIGN KEY (`MaNV`)
    REFERENCES `film_tickets_booking`.`nhanvien` (`MaNV`)
    );

CREATE TABLE `film_tickets_booking`.`ghedadat` (
  `idGheDaDat` INT NOT NULL,
  `idDatVe` INT NOT NULL,
  `idGhe` INT NOT NULL,
  PRIMARY KEY (`idGheDaDat`),
    FOREIGN KEY (`idDatVe`)
    REFERENCES `film_tickets_booking`.`datve` (`idDatVe`),
    FOREIGN KEY (`idGhe`)
    REFERENCES `film_tickets_booking`.`ghe` (`idghe`)
);

select count(1)
        from lichchieu inner join datve using(idlichchieu)
        inner join ghedadat using(iddatve)
        where lichchieu.Maphim like 'LLL';

