create database QuanLyThueOto
use QuanLyThueOto
--drop database QuanLyThueOto

-- Tạo bảng Tài Khoản
create table TaiKhoan(
	UserID int IDENTITY(1,1) not null,
	TaiKhoan varchar(20) not null UNIQUE,
	MatKhau varchar(50) not null,
	VaiTro bit default 0, -- 0 khach hang
	primary key (UserID)
);
-- Tạo Bảng ChiTietTaiKhoan
create table ChiTietTaiKhoan(
	ID_Detail int IDENTITY(1,1) not null,
	UserID int not null UNIQUE,
	HoTen nvarchar(50) not null,
	AnhDaiDien nvarchar(50) null,
	CCCD nchar(12) null,
	BangLaiXe nvarchar(50) null,
	SDT nvarchar(10) not null,
	TrangThaiTaiKhoan bit default 0, -- chua xac thuc
	NgaySinh date not null,
	GioiTinh bit not null,
	DiaChi nvarchar(255) null,
	primary key (ID_Detail),
	foreign key (UserID) references TaiKhoan(UserID)
);
-- Tạo Bảng Xe
create table xe (
	MaXe nchar(10) primary key not null,
	TenXe nvarchar(50) not null,
	SoGhe int not null,
	TrangThai bit default 0 not null,--  0: chua thue
	GiaThue float not null,
	Anh_Xe varchar(50) not null,
	LoaiXe nvarchar(50) not null,
	GhiChu nvarchar(255) null
);
-- tao bang dich vu
create table dichvu(
	MaDichVu nchar(10) primary key not null,
	TenDichVu nvarchar(50) not null,
	DonGia float not null,
);
-- Tao Bang Hop Dong
create table HopDong(
	MaHopDong nchar(10) primary key not null,
	MaXe nchar(10) not null,
	Userid int not null,
	GhiChu nvarchar(255) null,
	NgayThue Date default GETDATE() null,
	NgayTra Date not null,
	MaDichVu nchar(10) not null,
	ThanhTien float not null,
	TrangThai bit default 1 not null, --1 đã thanh toán
	foreign key (MaXe) references xe(MaXe),
	foreign key (Userid) references TaiKhoan(Userid),
	foreign key (MaDichVu) references dichvu(MaDichVu)
);

-- tao bang danh gia
create table danhgia(
	id int primary key IDENTITY(1,1) not null,
	MaXe nchar(10) not null,
	NoiDung nvarchar(255) null,
	NgayDanhGia Date default GETDATE() null,
	SoSaoDanhGia int default 5 null
	foreign key (MaXe) references xe(MaXe)
);