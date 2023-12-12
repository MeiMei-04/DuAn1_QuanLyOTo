USE [master]
GO
/****** Object:  Database [QuanLyThueOto]    Script Date: 12/12/2023 8:34:10 PM ******/
CREATE DATABASE [QuanLyThueOto]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyThueOto', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QuanLyThueOto.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyThueOto_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QuanLyThueOto_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QuanLyThueOto] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyThueOto].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyThueOto] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QuanLyThueOto] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyThueOto] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyThueOto] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyThueOto] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyThueOto] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyThueOto] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyThueOto] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyThueOto] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyThueOto] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyThueOto] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyThueOto] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyThueOto] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyThueOto] SET QUERY_STORE = ON
GO
ALTER DATABASE [QuanLyThueOto] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QuanLyThueOto]
GO
/****** Object:  Table [dbo].[ChiTietTaiKhoan]    Script Date: 12/12/2023 8:34:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietTaiKhoan](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[AnhDaiDien] [nvarchar](50) NULL,
	[CCCD] [varchar](12) NULL,
	[BangLaiXe] [nvarchar](50) NULL,
	[SDT] [nvarchar](10) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[DiaChi] [nvarchar](255) NULL,
	[YeuCauXacThuc] [bit] NULL,
	[SoDu] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietXe]    Script Date: 12/12/2023 8:34:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietXe](
	[MaXe] [varchar](10) NOT NULL,
	[TenXe] [nvarchar](50) NOT NULL,
	[SoGhe] [int] NOT NULL,
	[GiaThue] [int] NOT NULL,
	[Anh_Xe] [varchar](50) NOT NULL,
	[MaHangXe] [int] NOT NULL,
	[TrangThaiXe] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[danhgia]    Script Date: 12/12/2023 8:34:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[danhgia](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[MaHopDong] [varchar](10) NOT NULL,
	[NoiDung] [nvarchar](255) NULL,
	[NgayDanhGia] [date] NULL,
	[SoSaoDanhGia] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 12/12/2023 8:34:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[MaDichVu] [varchar](10) NOT NULL,
	[TenDichVu] [nvarchar](50) NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
	[DonGia] [int] NOT NULL,
	[TrangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HangXe]    Script Date: 12/12/2023 8:34:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HangXe](
	[MaHangXe] [int] IDENTITY(1,1) NOT NULL,
	[TenHangXe] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHangXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HopDong]    Script Date: 12/12/2023 8:34:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HopDong](
	[MaHopDong] [varchar](10) NOT NULL,
	[MaXe] [varchar](10) NOT NULL,
	[Userid] [int] NOT NULL,
	[NgayThue] [date] NULL,
	[NgayHetHan] [date] NOT NULL,
	[NgayTraXe] [date] NULL,
	[SoNgayQuaHan] [int] NOT NULL,
	[MaVoucher] [nvarchar](50) NULL,
	[ThanhTien] [int] NOT NULL,
	[ThoiHanHopDong] [int] NOT NULL,
	[DiaDiemNhanXe] [nvarchar](255) NULL,
	[TinhTrangHopDong] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHopDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MaNap]    Script Date: 12/12/2023 8:34:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MaNap](
	[ID_MN] [int] IDENTITY(1,1) NOT NULL,
	[MaNapTien] [varchar](20) NOT NULL,
	[NoiDung] [nvarchar](255) NOT NULL,
	[GiaTri] [int] NOT NULL,
	[TrangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_MN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NopPhuPhi]    Script Date: 12/12/2023 8:34:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NopPhuPhi](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaHopDong] [varchar](10) NOT NULL,
	[MaPhuPhi] [varchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhuPhi]    Script Date: 12/12/2023 8:34:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhuPhi](
	[MaPhuPhi] [varchar](15) NOT NULL,
	[TenPhuPhi] [nvarchar](255) NOT NULL,
	[GiaTri] [int] NOT NULL,
	[TrangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhuPhi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 12/12/2023 8:34:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[TaiKhoan] [varchar](20) NOT NULL,
	[MatKhau] [varchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Trangthai] [bit] NOT NULL,
	[VaiTro] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThemDichVu]    Script Date: 12/12/2023 8:34:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThemDichVu](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaHopDong] [varchar](10) NOT NULL,
	[MaDichVu] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 12/12/2023 8:34:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Voucher](
	[MaVoucher] [nvarchar](50) NOT NULL,
	[NoiDung] [nvarchar](255) NOT NULL,
	[GiaTri] [int] NOT NULL,
	[TrangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaVoucher] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChiTietTaiKhoan] ON 

INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (1, 1, N'Nguyễn Đình Hoàng Long', NULL, NULL, NULL, N'0123123123', CAST(N'1990-01-11' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (2, 2, N'Nguyễn Đình Thiên Long', NULL, NULL, NULL, N'0123456456', CAST(N'1990-02-12' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (3, 3, N'Nguyễn Nghiêm', NULL, NULL, NULL, N'0123456789', CAST(N'1990-03-13' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (4, 4, N'Phạm Thị Nở', NULL, NULL, NULL, N'0456456789', CAST(N'1990-04-14' AS Date), 1, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (5, 5, N'Nguyễn Chí Phèo', NULL, NULL, NULL, N'0147258369', CAST(N'1990-07-15' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (6, 6, N'Nguyễn Văn Tèo', NULL, NULL, NULL, N'0456123789', CAST(N'1990-04-16' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (7, 7, N'Lê Thị Hương Thảo', NULL, NULL, NULL, N'0789456123', CAST(N'1990-04-17' AS Date), 1, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (8, 8, N'Admin', NULL, NULL, NULL, N'0789458533', CAST(N'1990-04-20' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (9, 9, N'Lê Thị Thảo', NULL, NULL, NULL, N'0789123123', CAST(N'1995-12-08' AS Date), 1, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (10, 10, N'Trần Khôi Nguyên', NULL, NULL, NULL, N'0781234596', CAST(N'1992-06-15' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (11, 11, N'Nguyễn Đình Hiếu', NULL, NULL, NULL, N'0112233344', CAST(N'1990-06-25' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (12, 12, N'Lê Đình Long', NULL, NULL, NULL, N'0681654489', CAST(N'1990-06-12' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (13, 13, N'Nguyễn Hoàng Phong', NULL, NULL, NULL, N'0644168067', CAST(N'1990-05-12' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (14, 14, N'Phạm Huy Hoàng', NULL, NULL, NULL, N'0985136542', CAST(N'1990-08-14' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (15, 15, N'Lê Quang Vinh', NULL, NULL, NULL, N'0913654653', CAST(N'1990-04-18' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (16, 16, N'Nguyễn Thị Ánh Viên', NULL, NULL, NULL, N'0976261843', CAST(N'1990-04-30' AS Date), 1, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (17, 17, N'Đoàn Văn Hậu', NULL, NULL, NULL, N'0976469830', CAST(N'1990-02-19' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (18, 18, N'Nguyễn Thế Anh', NULL, NULL, NULL, N'0985562353', CAST(N'1990-07-27' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (19, 19, N'Nguyễn Liên Mạnh', NULL, NULL, NULL, N'0986216546', CAST(N'1995-10-08' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (20, 20, N'Phạm Văn Trung', NULL, NULL, NULL, N'0865312515', CAST(N'1992-10-25' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (21, 21, N'Nguyễn Đứuc Trung', NULL, NULL, NULL, N'0963135733', CAST(N'1990-11-21' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (22, 22, N'Trần Đình Hiệp', NULL, NULL, NULL, N'0978753215', CAST(N'1990-05-12' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (23, 23, N'Bùi Văn Quý', NULL, NULL, NULL, N'0981616546', CAST(N'1990-08-13' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (24, 24, N'Nguyễn Đắc Kha', NULL, NULL, NULL, N'0932156465', CAST(N'1990-04-24' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (25, 25, N'Trần Quốc Tuấn', NULL, NULL, NULL, N'0987165630', CAST(N'1990-05-15' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (26, 26, N'Nguyễn Đình Minh', NULL, NULL, NULL, N'0934364726', CAST(N'1990-09-16' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (27, 27, N'Nguyễn Đức Trường', NULL, NULL, NULL, N'0684789987', CAST(N'1990-07-18' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (28, 28, N'Lương Thành Công', NULL, NULL, NULL, N'0983251259', CAST(N'1990-03-20' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (29, 29, N'Phùng Đình Vinh', NULL, NULL, NULL, N'0987654254', CAST(N'1995-05-08' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (30, 30, N'Cao Đăng Khoa', NULL, NULL, NULL, N'0694483219', CAST(N'1992-09-16' AS Date), 0, N'Hải Phòng', 1, 7000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (31, 31, N'Nguyễn Bảo Ngọc', N'anhdaidiennew1.jpg', N'031265498712', N'anhbanglainew3.jpg', N'0934364726', CAST(N'1990-09-16' AS Date), 1, N'Hải Phòng', 1, 100000000)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (32, 32, N'Hoàng Linh Nhi', N'anhdaidiennew2.jpg', N'031265456498', N'anhbanglainew6.jpg', N'0684789987', CAST(N'1990-07-18' AS Date), 1, N'Hải Phòng', 1, 0)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (33, 33, N'Lê Linh Vân', N'anhdaidiennew3.jpg', N'031212345645', N'anhbanglainew8.jpg', N'0983251259', CAST(N'1990-03-20' AS Date), 1, N'Hải Phòng', 1, 0)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (34, 34, N'Vũ Thị Vân Anh ', N'anhdaidiennew4.jpg', N'031232469297', N'anhbanglainew13.jpg', N'0987654254', CAST(N'1995-05-08' AS Date), 1, N'Hải Phòng', 1, 0)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (35, 35, N'Phạm Văn Tuấn', N'anhdaidiennew9.jpg', N'031265498232', N'anhbanglainew17.jpg', N'0694483219', CAST(N'1992-09-16' AS Date), 0, N'Hải Phòng', 0, 0)
SET IDENTITY_INSERT [dbo].[ChiTietTaiKhoan] OFF
GO
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE01', N'Kia Morning AT', 4, 500000, N'Kia_Morning_AT_4cho.jpg', 1, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE02', N'Kia Morning AT Luxury', 4, 550000, N'Kia_Morning_AT_Luxury_4cho.jpg', 1, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE03', N'Vinfast VF5 2023', 4, 650000, N'Vinfast_VF5_2023_4cho.jpg', 2, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE04', N'Vinfast VF5 Plus 2023', 4, 700000, N'Vinfast_VF5_Plus_2023_4cho.jpg', 2, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE05', N'Mercedes-Benz C 300 AMG', 4, 4000000, N'Mercedes-Benz_C_300 AMG_4cho.jpg', 3, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE06', N'Mercedes- Benz C 200', 4, 3200000, N'Mercedes-Benz_C_200_4cho.jpg', 3, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE07', N'Toyota VIOS GR-S', 4, 900000, N'Toyota_VIOS_GR-S_4cho.jpg', 4, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE08', N'Toyota VIOS 1.5E (CVT)', 4, 850000, N'Toyota_VIOS_1.5E_(CVT)_4cho.jpg', 4, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE09', N'Toyota VIOS 1.5E (MT)', 4, 800000, N'Toyota_VIOS_4cho.jpg', 4, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE10', N'Audi Q7 3.0 TFSI', 7, 2800000, N'Audi_Q7_3.0 TFSI_7cho.jpg', 5, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE11', N'Audi Q7 S Line', 7, 2600000, N'Audi_Q7_S_Line_7cho.jpg', 5, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE12', N'Lexus GX460', 7, 2800000, N'Lexus_GX460_7cho.jpg', 6, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE13', N'Lexus GX500 2024', 7, 3200000, N'Lexus_GX500_7cho.jpg', 6, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE14', N'BMW X7 xDrive40i Pure Excellence', 7, 3000000, N'BMW_X7_xDrive40i_Pure_Excellence_7cho.jpg', 7, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE15', N'BMW X5 xDrive40i xLine', 7, 2650000, N'BMW_X5_xDrive40i_xLine_7cho.jpg', 7, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE16', N'BMW X4 xDrive20i', 7, 2550000, N'BMW_X4_xDrive20i_7cho.jpg', 7, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE17', N'Honda CRV L AWD', 7, 1900000, N'Honda_CRV_L_AWD_7cho.jpg', 8, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE18', N'Honda CRV HYBRID (RS)', 7, 1850000, N'Honda_CRV_HYBRID_(RS)_7cho.jpg', 8, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE19', N'Honda CRV G', 7, 1800000, N'Honda_CRV_G_7cho.jpg', 8, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE20', N'Honda CRV L', 7, 1800000, N'Honda_CRV_L_7cho.jpg', 8, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE21', N'Mazda CX8 Premium', 7, 1900000, N'Mazda_CX8_Premium_7cho.jpg', 9, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE22', N'Mazda CX8 Premium AWD (7S)', 7, 1900000, N'Mazda_CX8_Premium_AWD_(7S)_7cho.jpg', 9, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE23', N'Mazda CX5 2.5 Signature Exclusive', 7, 1750000, N'Mazda_CX5_2.5_Signature_Exclusiv_7cho.jpg', 9, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE24', N'Toyota Fortuner 2.4AT 4x2', 7, 2100000, N'Toyota_Fortuner_2.4AT_4x2_7cho.jpg', 4, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE25', N'Toyota Fortuner 2.7AT 4×2', 7, 2100000, N'Toyota_Fortuner_2.7AT_4x2_7cho.jpg', 4, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE26', N'Ford Transit', 16, 1800000, N'Ford_Transit_16cho.jpg', 10, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE27', N'Toyota Hiace', 16, 1900000, N'Toyota_Hiace_16cho.jpg', 4, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE28', N'Hyundai Solati', 16, 1900000, N'Hyundai_Solati_16cho.jpg', 11, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE29', N'Xe Khách Samco Bầu Hơi', 29, 1700000, N'Xe_Khach_Samco_Bau_Hoi_29cho.jpg', 12, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE30', N'Xe Khách Samco Felix', 29, 1700000, N'Xe_Khach_Samco_Felix_29cho.jpg', 12, N'3000')
INSERT [dbo].[ChiTietXe] ([MaXe], [TenXe], [SoGhe], [GiaThue], [Anh_Xe], [MaHangXe], [TrangThaiXe]) VALUES (N'XE31', N'Xe Khách Samco Allergo', 29, 1700000, N'Xe_Khach_Samco_Allergo_29cho.jpg', 12, N'3000')
GO
SET IDENTITY_INSERT [dbo].[danhgia] ON 

INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (1, 13, N'HD01', N'Xe vận hành tốt, giá cả hợp lý', CAST(N'2022-01-14' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (2, 29, N'HD02', N'Xe vận hành tốt, giá cả hợp lý, dịch vụ tốt', CAST(N'2022-01-26' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (3, 2, N'HD03', N'Trải nghiệm thuê rất tốt, đánh giá 5 sao', CAST(N'2022-02-22' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (4, 30, N'HD04', N'Trải nghiệm thuê rất tốt, đánh giá 5 sao', CAST(N'2022-02-15' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (5, 14, N'HD05', N'Xe vận hành tốt, lần sau vẫn sẽ thuê ở đây ', CAST(N'2022-03-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (6, 15, N'HD06', N'5 sao không phải nói nhiều', CAST(N'2022-04-29' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (7, 17, N'HD07', N'Trải nghiệm rất tốt, xe không gặp vấn đề gì khi tôi và gia đình đi chơi, đánh giá 5 sao', CAST(N'2022-04-16' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (8, 19, N'HD08', N'Xe tốt', CAST(N'2022-05-09' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (9, 21, N'HD09', N'lần sau sẽ tiếp tục ủng hộ', CAST(N'2022-05-22' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (10, 4, N'HD10', N'Chất lượng rất tốt, giá cả phù hợp, có nhiều ưu đãi tốt khi thuê xe.', CAST(N'2022-05-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (11, 5, N'HD11', N'Xe tốt', CAST(N'2022-06-12' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (12, 16, N'HD12', N'Xe vận hành tốt, giá cả hợp lý, dịch vụ tốt', CAST(N'2022-06-24' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (13, 23, N'HD13', N'Trải nghiệm thuê rất tốt', CAST(N'2022-07-08' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (14, 24, N'HD14', N'Trải nghiệm thuê rất tốt, đánh giá 5 sao', CAST(N'2022-07-19' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (15, 25, N'HD15', N'Xe vận hành tốt, lần sau vẫn sẽ thuê ở đây ', CAST(N'2022-07-29' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (16, 27, N'HD16', N'5 sao không phải nói nhiều', CAST(N'2022-08-06' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (17, 3, N'HD17', N'Trải nghiệm rất tốt, xe không gặp vấn đề gì khi tôi và gia đình đi chơi, đánh giá 5 sao', CAST(N'2022-08-19' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaHopDong], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (18, 28, N'HD18', N'Xe tốt', CAST(N'2022-09-04' AS Date), 5)
SET IDENTITY_INSERT [dbo].[danhgia] OFF
GO
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [GhiChu], [DonGia], [TrangThai]) VALUES (N'DV01', N'Thuê người lái', N'Khách hầng sẽ có người lái xe đi cầm lái cho đến khi hết hợp đồng', 650000, 0)
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [GhiChu], [DonGia], [TrangThai]) VALUES (N'DV02', N'Cứu hộ đường cao tốc', N'Đội cứu hộ sẽ đến hỗ trợ đưa xe khác đến cho khách hàng và đưa xe gặp vấn đề về cơ sở', 2000000, 0)
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [GhiChu], [DonGia], [TrangThai]) VALUES (N'DV03', N'Đưa đón sân bay', N'khách hàng sẽ được đưa tới sân bay hoặc đón từ sân bay về', 1500000, 0)
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [GhiChu], [DonGia], [TrangThai]) VALUES (N'DV04', N'Xăng xe', N'khách hàng sẽ được miễn phí lần đổ xăng xe đầu tiên nếu thuê dài hạn hoặc nhận xe đầy nhiên liệu khi thuê ngắn hạn', 1000000, 0)
GO
SET IDENTITY_INSERT [dbo].[HangXe] ON 

INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe]) VALUES (1, N'KIA')
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe]) VALUES (2, N'Vinfast')
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe]) VALUES (3, N'Mercedes')
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe]) VALUES (4, N'Toyota')
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe]) VALUES (5, N'Audi')
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe]) VALUES (6, N'Lexus')
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe]) VALUES (7, N'BMW')
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe]) VALUES (8, N'Honda')
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe]) VALUES (9, N'Mazda')
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe]) VALUES (10, N'Ford')
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe]) VALUES (11, N'Hyundai')
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe]) VALUES (12, N'Samco')
SET IDENTITY_INSERT [dbo].[HangXe] OFF
GO
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD01', N'XE01', 13, CAST(N'2022-01-06' AS Date), CAST(N'2022-01-14' AS Date), CAST(N'2022-01-14' AS Date), 0, NULL, 4950000, 9, NULL, 1)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD02', N'XE03', 29, CAST(N'2022-01-18' AS Date), CAST(N'2022-01-26' AS Date), CAST(N'2022-01-26' AS Date), 0, NULL, 6435000, 9, NULL, 1)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD03', N'XE04', 2, CAST(N'2022-02-04' AS Date), CAST(N'2022-02-22' AS Date), CAST(N'2022-02-22' AS Date), 0, NULL, 14630000, 19, NULL, 1)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD04', N'XE05', 30, CAST(N'2022-02-01' AS Date), CAST(N'2022-02-15' AS Date), CAST(N'2022-02-15' AS Date), 0, NULL, 66000000, 15, NULL, 1)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD05', N'XE09', 14, CAST(N'2022-03-13' AS Date), CAST(N'2022-03-30' AS Date), CAST(N'2022-03-30' AS Date), 0, NULL, 15840000, 18, NULL, 2)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD06', N'XE11', 15, CAST(N'2022-04-18' AS Date), CAST(N'2022-04-29' AS Date), CAST(N'2022-04-29' AS Date), 0, NULL, 34326000, 12, NULL, 2)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD07', N'XE13', 17, CAST(N'2022-04-03' AS Date), CAST(N'2022-04-16' AS Date), CAST(N'2022-04-16' AS Date), 0, NULL, 49280000, 14, NULL, 2)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD08', N'XE16', 19, CAST(N'2022-05-01' AS Date), CAST(N'2022-05-09' AS Date), CAST(N'2022-05-09' AS Date), 0, NULL, 25245000, 9, NULL, 2)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD09', N'XE20', 21, CAST(N'2022-05-11' AS Date), CAST(N'2022-05-22' AS Date), CAST(N'2022-05-22' AS Date), 0, NULL, 23760000, 12, NULL, 3)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD10', N'XE22', 4, CAST(N'2022-05-24' AS Date), CAST(N'2022-05-30' AS Date), CAST(N'2022-05-30' AS Date), 0, NULL, 14630000, 7, NULL, 3)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD11', N'XE24', 5, CAST(N'2022-06-01' AS Date), CAST(N'2022-06-12' AS Date), CAST(N'2022-06-12' AS Date), 0, NULL, 27720000, 12, NULL, 3)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD12', N'XE25', 16, CAST(N'2022-06-14' AS Date), CAST(N'2022-06-24' AS Date), CAST(N'2022-06-24' AS Date), 0, NULL, 25410000, 11, NULL, 3)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD13', N'XE26', 23, CAST(N'2022-06-27' AS Date), CAST(N'2022-07-08' AS Date), CAST(N'2022-07-08' AS Date), 0, NULL, 23760000, 12, NULL, 4)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD14', N'XE27', 24, CAST(N'2022-07-10' AS Date), CAST(N'2022-07-19' AS Date), CAST(N'2022-07-19' AS Date), 0, NULL, 20900000, 10, NULL, 4)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD15', N'XE28', 25, CAST(N'2022-07-20' AS Date), CAST(N'2022-07-29' AS Date), CAST(N'2022-07-29' AS Date), 0, NULL, 20900000, 10, NULL, 4)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD16', N'XE29', 27, CAST(N'2022-08-01' AS Date), CAST(N'2022-08-06' AS Date), CAST(N'2022-08-06' AS Date), 0, NULL, 11220000, 6, NULL, 4)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD17', N'XE12', 3, CAST(N'2022-08-08' AS Date), CAST(N'2022-08-17' AS Date), CAST(N'2022-08-19' AS Date), 2, NULL, 34275000, 10, NULL, 5)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD18', N'XE13', 28, CAST(N'2023-08-19' AS Date), CAST(N'2022-08-30' AS Date), CAST(N'2022-09-04' AS Date), 5, NULL, 43090000, 12, NULL, 5)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD19', N'XE18', 30, CAST(N'2023-12-08' AS Date), CAST(N'2022-12-17' AS Date), NULL, 0, NULL, 20350000, 10, NULL, 4)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD20', N'XE19', 25, CAST(N'2023-12-19' AS Date), CAST(N'2022-12-30' AS Date), NULL, 0, NULL, 23760000, 12, NULL, 4)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD21', N'XE10', 23, CAST(N'2023-12-08' AS Date), CAST(N'2022-12-17' AS Date), NULL, 0, NULL, 30800000, 10, NULL, 4)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD22', N'XE11', 17, CAST(N'2023-12-19' AS Date), CAST(N'2022-12-30' AS Date), NULL, 0, NULL, 28600000, 12, NULL, 4)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD23', N'XE12', 16, CAST(N'2023-12-08' AS Date), CAST(N'2022-12-17' AS Date), NULL, 0, NULL, 30800000, 10, NULL, 4)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD24', N'XE13', 15, CAST(N'2023-12-01' AS Date), CAST(N'2022-12-30' AS Date), NULL, 0, NULL, 35200000, 12, NULL, 4)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD25', N'XE01', 25, CAST(N'2023-12-01' AS Date), CAST(N'2022-12-05' AS Date), NULL, 0, NULL, 2750000, 5, NULL, 5)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD26', N'XE01', 23, CAST(N'2023-12-06' AS Date), CAST(N'2022-12-10' AS Date), NULL, 0, NULL, 2750000, 5, NULL, 4)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD27', N'XE01', 17, CAST(N'2023-12-11' AS Date), CAST(N'2022-12-15' AS Date), NULL, 0, NULL, 2750000, 5, NULL, 4)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD28', N'XE01', 16, CAST(N'2023-12-16' AS Date), CAST(N'2022-12-20' AS Date), NULL, 0, NULL, 2750000, 5, NULL, 4)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [NgayThue], [NgayHetHan], [NgayTraXe], [SoNgayQuaHan], [MaVoucher], [ThanhTien], [ThoiHanHopDong], [DiaDiemNhanXe], [TinhTrangHopDong]) VALUES (N'HD29', N'XE01', 15, CAST(N'2023-12-21' AS Date), CAST(N'2022-12-25' AS Date), NULL, 0, NULL, 2750000, 5, NULL, 4)
GO
SET IDENTITY_INSERT [dbo].[MaNap] ON 

INSERT [dbo].[MaNap] ([ID_MN], [MaNapTien], [NoiDung], [GiaTri], [TrangThai]) VALUES (1, N'NAP_5TRIEU', N'Mã nạp 5 triệu vào tài khoản', 5000000, 0)
INSERT [dbo].[MaNap] ([ID_MN], [MaNapTien], [NoiDung], [GiaTri], [TrangThai]) VALUES (2, N'NAP_7TRIEU', N'Mã nạp 5 triệu vào tài khoản', 7000000, 0)
INSERT [dbo].[MaNap] ([ID_MN], [MaNapTien], [NoiDung], [GiaTri], [TrangThai]) VALUES (3, N'NAP10TRIEU', N'Mã nạp 5 triệu vào tài khoản', 10000000, 0)
SET IDENTITY_INSERT [dbo].[MaNap] OFF
GO
SET IDENTITY_INSERT [dbo].[NopPhuPhi] ON 

INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (1, N'HD01', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (2, N'HD02', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (3, N'HD03', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (4, N'HD04', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (5, N'HD05', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (6, N'HD06', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (7, N'HD07', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (8, N'HD08', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (9, N'HD09', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (10, N'HD10', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (11, N'HD11', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (12, N'HD12', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (13, N'HD13', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (14, N'HD14', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (15, N'HD15', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (16, N'HD16', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (17, N'HD17', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (18, N'HD17', N'Qua_han')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (19, N'HD18', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (20, N'HD18', N'Qua_han')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (21, N'HD19', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (22, N'HD20', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (23, N'HD21', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (24, N'HD22', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (25, N'HD23', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (26, N'HD24', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (27, N'HD25', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (28, N'HD26', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (29, N'HD27', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (30, N'HD28', N'VAT')
INSERT [dbo].[NopPhuPhi] ([ID], [MaHopDong], [MaPhuPhi]) VALUES (31, N'HD29', N'VAT')
SET IDENTITY_INSERT [dbo].[NopPhuPhi] OFF
GO
INSERT [dbo].[PhuPhi] ([MaPhuPhi], [TenPhuPhi], [GiaTri], [TrangThai]) VALUES (N'Phi_Ship', N'Phí nhận trả xe tại địa chỉ của khách hàng', 5, 0)
INSERT [dbo].[PhuPhi] ([MaPhuPhi], [TenPhuPhi], [GiaTri], [TrangThai]) VALUES (N'Qua_han', N'Quá hạn hợp đồng', 1, 0)
INSERT [dbo].[PhuPhi] ([MaPhuPhi], [TenPhuPhi], [GiaTri], [TrangThai]) VALUES (N'SCBD', N'Sửa chữa bảo dưỡng', 1, 0)
INSERT [dbo].[PhuPhi] ([MaPhuPhi], [TenPhuPhi], [GiaTri], [TrangThai]) VALUES (N'VAT', N'Thuế nhà nước (VAT)', 10, 0)
GO
SET IDENTITY_INSERT [dbo].[TaiKhoan] ON 

INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (1, N'LongNDH', N'songlong', N'longnd@gmail.com', 1, 1)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (2, N'LongNDT', N'songlong', N'longndt@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (3, N'NghiemN', N'songlong', N'nghiemnguyen@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (4, N'NoPT', N'123456', N'nopt@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (5, N'PheoNC', N'123456', N'pheonc@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (6, N'TeoNV', N'songlong', N'teonv@gmail.com', 1, 1)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (7, N'ThaoLTH', N'songlong', N'thaolth@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (8, N'admin', N'admin', N'admin@gmail.com', 1, 1)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (9, N'ThaoLT', N'123123', N'thaolt@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (10, N'NguyenTK', N'123123', N'nguyentrankhoi@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (11, N'userhieu', N'123123', N'userhieu@gmail.com', 1, 1)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (12, N'LongLD', N'123123', N'longld@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (13, N'PhongNH', N'123123', N'phongnh@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (14, N'HoangPH', N'123123', N'hoangph@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (15, N'VinhLQ', N'123123', N'vinhlq@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (16, N'VienNTA', N'123123', N'viennta@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (17, N'HauDV', N'123123', N'haudv@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (18, N'AnhNT', N'123123', N'anhnt@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (19, N'ManhNL', N'123123', N'manhnl@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (20, N'TrungPV', N'123123', N'trungpv@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (21, N'TrungND', N'123123', N'trungnd@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (22, N'HiepTD', N'123123', N'hieptd@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (23, N'QuyBV', N'123123', N'quybv@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (24, N'KhaND', N'123123', N'khand@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (25, N'TuanTQ', N'123123', N'tuantq@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (26, N'MinhND', N'123123', N'minhnd@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (27, N'TruongND', N'123123', N'truongnd@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (28, N'CongLT', N'123123', N'conglt@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (29, N'VinhPD', N'123123', N'vinhpd@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (30, N'KhoaCD', N'123123', N'khoacd@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (31, N'NgocNB', N'123123', N'ngocnb@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (32, N'NhiHL', N'123123', N'nhihl@gmail.com', 0, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (33, N'VanLL', N'123123', N'vanll@gmail.com', 0, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (34, N'AnhVTV', N'123123', N'anhvtv@gmail.com', 0, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (35, N'TuanPV', N'123123', N'tuanpv@gmail.com', 0, 0)
SET IDENTITY_INSERT [dbo].[TaiKhoan] OFF
GO
INSERT [dbo].[Voucher] ([MaVoucher], [NoiDung], [GiaTri], [TrangThai]) VALUES (N'EMHIEUCUTE', N'Giảm giá trị thuê xe 10%', 2, 0)
INSERT [dbo].[Voucher] ([MaVoucher], [NoiDung], [GiaTri], [TrangThai]) VALUES (N'EMHIEUDINHVAINHO', N'Giảm giá trị thuê xe 15%', 3, 0)
INSERT [dbo].[Voucher] ([MaVoucher], [NoiDung], [GiaTri], [TrangThai]) VALUES (N'EMHIEUTOP1THAPTRUYHON', N'Giảm giá trị thuê xe 5%', 1, 0)
GO
/****** Object:  Index [UQ__ChiTietT__1788CCAD657713CC]    Script Date: 12/12/2023 8:34:10 PM ******/
ALTER TABLE [dbo].[ChiTietTaiKhoan] ADD UNIQUE NONCLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__TaiKhoan__D5B8C7F09242D810]    Script Date: 12/12/2023 8:34:10 PM ******/
ALTER TABLE [dbo].[TaiKhoan] ADD UNIQUE NONCLUSTERED 
(
	[TaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietTaiKhoan] ADD  DEFAULT ((0)) FOR [YeuCauXacThuc]
GO
ALTER TABLE [dbo].[ChiTietTaiKhoan] ADD  DEFAULT ((0)) FOR [SoDu]
GO
ALTER TABLE [dbo].[danhgia] ADD  DEFAULT (getdate()) FOR [NgayDanhGia]
GO
ALTER TABLE [dbo].[danhgia] ADD  DEFAULT ((5)) FOR [SoSaoDanhGia]
GO
ALTER TABLE [dbo].[DichVu] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[HopDong] ADD  DEFAULT (getdate()) FOR [NgayThue]
GO
ALTER TABLE [dbo].[MaNap] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[PhuPhi] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT ((0)) FOR [VaiTro]
GO
ALTER TABLE [dbo].[ChiTietTaiKhoan]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[TaiKhoan] ([UserID])
GO
ALTER TABLE [dbo].[ChiTietXe]  WITH CHECK ADD FOREIGN KEY([MaHangXe])
REFERENCES [dbo].[HangXe] ([MaHangXe])
GO
ALTER TABLE [dbo].[danhgia]  WITH CHECK ADD FOREIGN KEY([MaHopDong])
REFERENCES [dbo].[HopDong] ([MaHopDong])
GO
ALTER TABLE [dbo].[danhgia]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[TaiKhoan] ([UserID])
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD FOREIGN KEY([MaVoucher])
REFERENCES [dbo].[Voucher] ([MaVoucher])
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD FOREIGN KEY([MaXe])
REFERENCES [dbo].[ChiTietXe] ([MaXe])
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD FOREIGN KEY([Userid])
REFERENCES [dbo].[TaiKhoan] ([UserID])
GO
ALTER TABLE [dbo].[NopPhuPhi]  WITH CHECK ADD FOREIGN KEY([MaHopDong])
REFERENCES [dbo].[HopDong] ([MaHopDong])
GO
ALTER TABLE [dbo].[NopPhuPhi]  WITH CHECK ADD FOREIGN KEY([MaPhuPhi])
REFERENCES [dbo].[PhuPhi] ([MaPhuPhi])
GO
ALTER TABLE [dbo].[ThemDichVu]  WITH CHECK ADD FOREIGN KEY([MaDichVu])
REFERENCES [dbo].[DichVu] ([MaDichVu])
GO
ALTER TABLE [dbo].[ThemDichVu]  WITH CHECK ADD FOREIGN KEY([MaHopDong])
REFERENCES [dbo].[HopDong] ([MaHopDong])
GO
/****** Object:  StoredProcedure [dbo].[sp_DoanhThu]    Script Date: 12/12/2023 8:34:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_DoanhThu](@month int,@year int)
	as begin
	Select 
		TenXe tenxe,
		soghe soghe,
		count(xe.SoGhe) soluong,
		sum(hd.ThanhTien) Doanhthu,
		min(hd.ThanhTien) ThapNhat,
		max(hd.ThanhTien) CaoNhat,
		avg(hd.ThanhTien) TrungBinh
	from HopDong hd
	Join ChiTietXe xe on hd.MaXe=xe.MaXe
	where month(NgayThue)=@month and year(NgayThue) =@year
	group by TenXe,SoGhe
	end
GO
USE [master]
GO
ALTER DATABASE [QuanLyThueOto] SET  READ_WRITE 
GO
