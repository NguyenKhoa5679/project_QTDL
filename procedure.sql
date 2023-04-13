SET GLOBAL log_bin_trust_function_creators = 1;

delimiter $$
drop function if exists KT_phim $$
create function KT_phim (MaPhim varchar(45))
returns boolean
begin 
	declare count_phim int;
	select count(1) into count_phim from phim where phim.Maphim = MaPhim;
    if count_phim > 0 then
		return true;
	else
		return false;
	end if;
end; $$
delimiter ;

-- Them Phim --------------------------------------------------------------------------------------------------------

Delimiter $$
Drop procedure if exists ThemPhim $$
create procedure ThemPhim(MaPhim varchar(45), TenPhim varchar(45), TheLoai varchar(45), ThoiLuong time)
begin
	insert into `film_tickets_booking`.`phim` value (MaPhim, TenPhim, TheLoai, ThoiLuong);
end; $$
delimiter ;

-- Trigger Them phim --------------------------------------------------------------------------------------------------------

DELIMITER $$
DROP TRIGGER IF EXISTS KT_ThemPhim $$ 
CREATE TRIGGER KT_ThemPhim BEFORE INSERT ON phim
FOR EACH ROW
BEGIN
	IF KT_Phim(New.MaPhim) then
		SIGNAL SQLSTATE '45000' 
		SET MESSAGE_TEXT = 'Ma Phim da ton tai';
	END IF;
END; $$
DELIMITER ;

CALL ThemPhim('LLL', 'LaLaLand', 'Romance', '1:30:00');

-- Xoa Phim -------------------------------------------------------------------------------------------------------------

Delimiter $$
drop procedure if exists Xoa_phim $$
create procedure Xoa_phim(MaPhim varchar(45))
begin
	delete from phim where phim.MaPhim = MaPhim;
end; $$
delimiter ;

Call Xoa_phim('LLL');
	
-- Sua Phim --------------------------------------------------------------------------------------------------------------

Delimiter $$
drop procedure if exists Sua_phim $$ 
create procedure Sua_phim(old_maphim varchar(45),MaPhim varchar(45), Tenphim varchar(45), Theloai varchar(45), thoiluong time)
begin 
	start transaction;
		if KT_phim(old_maphim) then
			call Xoa_Phim(old_maphim);
            call ThemPhim(MaPhim, TenPhim, TheLoai, thoiLuong);
		else
			SIGNAL SQLSTATE '45000' 
			SET MESSAGE_TEXT = 'Sua doi khong thanh cong';
		end if;	
    commit;
end; $$
delimiter ;

call sua_phim('LLL','LLA', 'LaLaLand', 'tinh cam', '1:20:00');


-- Them Lich chieu ----------------------------------------------------------------------------------

delimiter $$
drop procedure if exists Them_lichchieu $$
create procedure Them_lichchieu(idlicchieu int(11), Marap varchar(45), maphim varchar(45), batdau datetime, ketthuc datetime)
begin
	insert into `film_tickets_booking`.`lichchieu` value (idlicchieu , Marap, maphim, batdau, ketthuc);
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Them lich chieu khong thanh cong';
end; $$
delimiter ;

-- Xoa lich chieu -----------------------------------------------------------------------------------

-- Tim Kiem phim------------------------------------------------------------------------------------
delimiter $$
drop procedure if exists TimKiemPhim $$
create procedure TimKiemPhim (search text)
begin
	declare count_phim int;
	select count(1) into count_phim from phim where phim.TenPhim like concat('%', search ,'%');
    if count_phim > 0 then
		select * from phim where phim.TenPhim like concat('%', search ,'%') limit 10;
	else
		select 'Khong tim thay ket qua nao';
	end if;
end; $$
delimiter ;

call TimKiemPhim('k');

-- -------------------------------------------------------------------------------------
-- Thong ke soluong ve da duoc dat cua mot suat chieu

delimiter $$
drop procedure if exists ThongkeVeBan $$
create procedure ThongkeVeBan(MaPhim varchar(45), idlich int)
begin
	declare count_phim int;
	select count(1) into count_phim from phim where phim.MaPhim = MaPhim;
    if count_phim > 0 then
		select count(1)
        from lichchieu inner join datve using(idlichchieu)
        inner join ghedadat using(iddatve)
        where lichchieu.Maphim like MaPhim;
	else
		select 'Khong tim thay ket qua nao';
	end if;
end; $$
delimiter ;

-- Xoa LichChieu

delimiter $$
drop procedure if exists XoaLichChieu $$
create procedure XoaLichChieu(IDLichChieu int)
begin
	declare count_phim int;
	select count(1) into count_phim from lichchieu where lichchieu.idlichchieu = IDLichChieu;
    if count_phim > 0 then
		delete from Lichchieu where lichchieu.idlichchieu = IDLichChieu;
	else
		select 'Khong tim thay ket qua nao';
	end if;
end; $$
delimiter ;

