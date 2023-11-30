USE [master]
GO
/****** Object:  Database [QuanLyThueOto]    Script Date: 11/30/2023 8:19:02 PM ******/
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
/****** Object:  Table [dbo].[ChiTietTaiKhoan]    Script Date: 11/30/2023 8:19:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietTaiKhoan](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[AnhDaiDien] [nvarchar](50) NULL,
	[CCCD] [nchar](12) NULL,
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
/****** Object:  Table [dbo].[danhgia]    Script Date: 11/30/2023 8:19:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[danhgia](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[MaXe] [nchar](10) NOT NULL,
	[NoiDung] [nvarchar](255) NULL,
	[NgayDanhGia] [date] NULL,
	[SoSaoDanhGia] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[dichvu]    Script Date: 11/30/2023 8:19:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dichvu](
	[MaDichVu] [nchar](10) NOT NULL,
	[TenDichVu] [nvarchar](50) NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
	[DonGia] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HopDong]    Script Date: 11/30/2023 8:19:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HopDong](
	[MaHopDong] [nchar](10) NOT NULL,
	[MaXe] [nchar](10) NOT NULL,
	[Userid] [int] NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
	[NgayThue] [date] NULL,
	[NgayTra] [date] NOT NULL,
	[MaVouncher] [nchar](50) NULL,
	[ThanhTien] [int] NOT NULL,
	[ThoiHanHopDong] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHopDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiXe]    Script Date: 11/30/2023 8:19:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiXe](
	[MaLoaiXe] [nchar](10) NOT NULL,
	[TenLoaiXe] [nvarchar](255) NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoaiXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MaNap]    Script Date: 11/30/2023 8:19:02 PM ******/
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
/****** Object:  Table [dbo].[SuaChuaBaoDuong]    Script Date: 11/30/2023 8:19:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SuaChuaBaoDuong](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaXe] [nchar](10) NOT NULL,
	[NoiDung] [nvarchar](255) NULL,
	[LanGanNhat] [date] NOT NULL,
	[NgaySuaChua] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/30/2023 8:19:02 PM ******/
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
/****** Object:  Table [dbo].[ThemDichVu]    Script Date: 11/30/2023 8:19:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThemDichVu](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[MaXe] [nchar](10) NOT NULL,
	[MaDichVu] [nchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vouncher]    Script Date: 11/30/2023 8:19:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vouncher](
	[MaVouncher] [nvarchar](50) NOT NULL,
	[NoiDung] [nvarchar](255) NOT NULL,
	[GiaTri] [int] NOT NULL,
	[TrangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaVouncher] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Xe]    Script Date: 11/30/2023 8:19:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Xe](
	[MaXe] [nchar](10) NOT NULL,
	[TenXe] [nvarchar](50) NOT NULL,
	[SoGhe] [int] NOT NULL,
	[TrangThai] [bit] NOT NULL,
	[GiaThue] [int] NOT NULL,
	[Anh_Xe] [varchar](50) NOT NULL,
	[MaLoaiXe] [nchar](10) NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaXe] ASC
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
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (31, 31, N'Nguyễn Bảo Ngọc', N'anhdaidiennew1.jpg', N'031265498712', N'anhbanglainew3.jpg', N'0934364726', CAST(N'1990-09-16' AS Date), 1, N'Hải Phòng', 1, 0)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (32, 32, N'Hoàng Linh Nhi', N'anhdaidiennew2.jpg', N'031265456498', N'anhbanglainew6.jpg', N'0684789987', CAST(N'1990-07-18' AS Date), 1, N'Hải Phòng', 1, 0)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (33, 33, N'Lê Linh Vân', N'anhdaidiennew3.jpg', N'031212345645', N'anhbanglainew8.jpg', N'0983251259', CAST(N'1990-03-20' AS Date), 1, N'Hải Phòng', 1, 0)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (34, 34, N'Vũ Thị Vân Anh ', N'anhdaidiennew4.jpg', N'031232469297', N'anhbanglainew13.jpg', N'0987654254', CAST(N'1995-05-08' AS Date), 1, N'Hải Phòng', 1, 0)
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [NgaySinh], [GioiTinh], [DiaChi], [YeuCauXacThuc], [SoDu]) VALUES (35, 35, N'Phạm Văn Tuấn', N'anhdaidiennew9.jpg', N'031265498232', N'anhbanglainew17.jpg', N'0694483219', CAST(N'1992-09-16' AS Date), 0, N'Hải Phòng', 0, 0)
SET IDENTITY_INSERT [dbo].[ChiTietTaiKhoan] OFF
GO
SET IDENTITY_INSERT [dbo].[danhgia] ON 

INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (1, 2, N'XE01      ', N'Xe vận hành tốt, giá cả hợp lý', CAST(N'2022-01-14' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (2, 29, N'XE01      ', N'Xe vận hành tốt, giá cả hợp lý, dịch vụ tốt', CAST(N'2022-01-26' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (3, 2, N'XE02      ', N'Trải nghiệm thuê rất tốt, đánh giá 5 sao', CAST(N'2022-02-22' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (4, 30, N'XE02      ', N'Trải nghiệm thuê rất tốt, đánh giá 5 sao', CAST(N'2022-02-15' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (5, 4, N'XE03      ', N'Xe vận hành tốt, lần sau vẫn sẽ thuê ở đây ', CAST(N'2022-03-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (6, 5, N'XE03      ', N'5 sao không phải nói nhiều', CAST(N'2022-04-29' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (7, 7, N'XE03      ', N'Trải nghiệm rất tốt, xe không gặp vấn đề gì khi tôi và gia đình đi chơi, đánh giá 5 sao', CAST(N'2022-04-16' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (8, 9, N'XE03      ', N'Xe tốt', CAST(N'2022-05-09' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (9, 3, N'XE04      ', N'lần sau sẽ tiếp tục ủng hộ', CAST(N'2022-05-22' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (10, 4, N'XE04      ', N'Chất lượng rất tốt, giá cả phù hợp, có nhiều ưu đãi tốt khi thuê xe.', CAST(N'2022-05-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (11, 5, N'XE04      ', N'Xe tốt', CAST(N'2022-06-12' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (12, 7, N'XE04      ', N'Xe vận hành tốt, giá cả hợp lý, dịch vụ tốt', CAST(N'2022-06-24' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (13, 3, N'XE05      ', N'Trải nghiệm thuê rất tốt', CAST(N'2022-07-08' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (14, 4, N'XE05      ', N'Trải nghiệm thuê rất tốt, đánh giá 5 sao', CAST(N'2022-07-19' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (15, 5, N'XE05      ', N'Xe vận hành tốt, lần sau vẫn sẽ thuê ở đây ', CAST(N'2022-07-29' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (16, 7, N'XE05      ', N'5 sao không phải nói nhiều', CAST(N'2022-08-06' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (17, 3, N'XE06      ', N'Trải nghiệm rất tốt, xe không gặp vấn đề gì khi tôi và gia đình đi chơi, đánh giá 5 sao', CAST(N'2022-08-17' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (18, 4, N'XE06      ', N'Xe tốt', CAST(N'2022-08-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (19, 5, N'XE06      ', N'lần sau sẽ tiếp tục ủng hộ', CAST(N'2022-09-15' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (20, 7, N'XE06      ', N'5 sao không phải nói nhiều', CAST(N'2022-09-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (21, 9, N'XE07      ', N'Xe vận hành tốt', CAST(N'2022-10-07' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (22, 10, N'XE07      ', N'Xe vận hành tốt, giá cả hợp lý, dịch vụ tốt', CAST(N'2022-10-20' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (23, 12, N'XE07      ', N'Trải nghiệm thuê rất tốt, đánh giá 5 sao', CAST(N'2022-10-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (24, 13, N'XE07      ', N'Trải nghiệm rất tốt', CAST(N'2022-11-15' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (25, 14, N'XE08      ', N'Xe vận hành tốt, lần sau vẫn sẽ thuê ở đây ', CAST(N'2022-11-19' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (26, 15, N'XE08      ', N'5 sao không phải nói nhiều', CAST(N'2022-11-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (27, 16, N'XE08      ', N'Trải nghiệm rất tốt, xe không gặp vấn đề gì khi tôi và gia đình đi chơi, đánh giá 5 sao', CAST(N'2022-12-17' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (28, 17, N'XE08      ', N'Xe tốt', CAST(N'2022-12-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (29, 18, N'XE09      ', N'lần sau sẽ tiếp tục ủng hộ', CAST(N'2022-09-19' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (30, 19, N'XE09      ', N'Xe tốt', CAST(N'2022-09-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (31, 20, N'XE09      ', N'Giá cả hợp lý, chất lượng tốt', CAST(N'2022-10-16' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (32, 21, N'XE09      ', N'Xe vận hành tốt, dịch vụ tốt', CAST(N'2022-10-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (33, 22, N'XE10      ', N'Xe tốt', CAST(N'2022-11-15' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (34, 23, N'XE10      ', N'Trải nghiệm thuê rất tốt, đánh giá 5 sao', CAST(N'2022-11-19' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (35, 24, N'XE10      ', N'Xe vận hành tốt, lần sau vẫn sẽ thuê ở đây ', CAST(N'2022-12-02' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (36, 25, N'XE10      ', N'5 sao không phải nói nhiều', CAST(N'2022-12-26' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (37, 26, N'XE11      ', N'Trải nghiệm rất tốt, xe không gặp vấn đề gì khi tôi và gia đình đi chơi, đánh giá 5 sao', CAST(N'2022-11-19' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (38, 27, N'XE11      ', N'Xe tốt', CAST(N'2022-11-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (39, 28, N'XE11      ', N'lần sau sẽ tiếp tục ủng hộ', CAST(N'2022-12-15' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (40, 29, N'XE11      ', N'Xe vận hành tốt', CAST(N'2022-12-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (41, 30, N'XE12      ', N'Xe vận hành tốt', CAST(N'2022-12-08' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (42, 9, N'XE12      ', N'Xe vận hành tốt, giá cả hợp lý, dịch vụ tốt', CAST(N'2022-12-16' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (43, 10, N'XE12      ', N'Trải nghiệm thuê rất tốt, đánh giá 5 sao', CAST(N'2022-12-24' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (44, 12, N'XE12      ', N'Xe tốt', CAST(N'2022-12-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (45, 13, N'XE13      ', N'Xe vận hành tốt, lần sau vẫn sẽ thuê ở đây ', CAST(N'2023-01-13' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (46, 14, N'XE13      ', N'5 sao không phải nói nhiều', CAST(N'2023-01-26' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (47, 15, N'XE13      ', N'Trải nghiệm rất tốt, xe không gặp vấn đề gì khi tôi và gia đình đi chơi, đánh giá 5 sao', CAST(N'2023-01-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (48, 16, N'XE13      ', N'Xe tốt', CAST(N'2023-02-20' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (49, 17, N'XE14      ', N'lần sau sẽ tiếp tục ủng hộ', CAST(N'2023-02-19' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (50, 18, N'XE14      ', N'Xe tốt', CAST(N'2023-02-28' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (51, 19, N'XE14      ', N'Xe vận hành tốt', CAST(N'2023-03-16' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (52, 20, N'XE14      ', N'Xe vận hành tốt, giá cả hợp lý, dịch vụ tốt', CAST(N'2023-03-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (53, 21, N'XE15      ', N'Trải nghiệm thuê rất tốt, đánh giá 5 sao', CAST(N'2023-04-15' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (54, 22, N'XE15      ', N'Trải nghiệm thuê rất tốt', CAST(N'2023-03-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (55, 23, N'XE15      ', N'Xe vận hành tốt, lần sau vẫn sẽ thuê ở đây ', CAST(N'2023-04-18' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (56, 24, N'XE15      ', N'5 sao không phải nói nhiều', CAST(N'2023-02-19' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (57, 25, N'XE16      ', N'Trải nghiệm rất tốt, xe không gặp vấn đề gì khi tôi và gia đình đi chơi, đánh giá 5 sao', CAST(N'2023-02-23' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (58, 26, N'XE16      ', N'Xe tốt', CAST(N'2023-03-06' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (59, 27, N'XE16      ', N'lần sau sẽ tiếp tục ủng hộ', CAST(N'2023-03-27' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [UserID], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (60, 28, N'XE16      ', N'Xe vận hành tốt, lần sau vẫn sẽ thuê ở đây ', CAST(N'2023-04-16' AS Date), 5)
SET IDENTITY_INSERT [dbo].[danhgia] OFF
GO
INSERT [dbo].[dichvu] ([MaDichVu], [TenDichVu], [GhiChu], [DonGia]) VALUES (N'DV01      ', N'Thuê người lái', N'Khách hầng sẽ có người lái xe đi cầm lái cho đến khi hết hợp đồng', 650000)
INSERT [dbo].[dichvu] ([MaDichVu], [TenDichVu], [GhiChu], [DonGia]) VALUES (N'DV02      ', N'Cứu hộ đường cao tốc', N'Đội cứu hộ sẽ đến hỗ trợ đưa xe khác đến cho khách hàng và đưa xe gặp vấn đề về cơ sở', 2000000)
INSERT [dbo].[dichvu] ([MaDichVu], [TenDichVu], [GhiChu], [DonGia]) VALUES (N'DV03      ', N'Đưa đón sân bay', N'khách hàng sẽ được đưa tới sân bay hoặc đón từ sân bay về', 1500000)
INSERT [dbo].[dichvu] ([MaDichVu], [TenDichVu], [GhiChu], [DonGia]) VALUES (N'DV04      ', N'Xăng xe', N'khách hàng sẽ được miễn phí lần đổ xăng xe đầu tiên nếu thuê dài hạn hoặc nhận xe đầy nhiên liệu khi thuê ngắn hạn', 1000000)
GO
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD01      ', N'XE01      ', 2, NULL, CAST(N'2022-01-06' AS Date), CAST(N'2022-01-14' AS Date), NULL, 5500000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD02      ', N'XE01      ', 29, NULL, CAST(N'2022-01-18' AS Date), CAST(N'2022-01-26' AS Date), NULL, 21000000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD03      ', N'XE02      ', 2, NULL, CAST(N'2022-02-04' AS Date), CAST(N'2022-02-22' AS Date), NULL, 13350000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD04      ', N'XE02      ', 30, NULL, CAST(N'2022-02-01' AS Date), CAST(N'2022-02-15' AS Date), NULL, 10750000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD05      ', N'XE03      ', 4, NULL, CAST(N'2022-03-13' AS Date), CAST(N'2022-03-30' AS Date), NULL, 73000000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD06      ', N'XE03      ', 5, NULL, CAST(N'2022-04-18' AS Date), CAST(N'2022-04-29' AS Date), NULL, 49000000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD07      ', N'XE03      ', 7, NULL, CAST(N'2022-04-03' AS Date), CAST(N'2022-04-16' AS Date), NULL, 61000000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD08      ', N'XE03      ', 9, NULL, CAST(N'2022-05-01' AS Date), CAST(N'2022-05-09' AS Date), NULL, 37000000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD09      ', N'XE04      ', 3, NULL, CAST(N'2022-05-11' AS Date), CAST(N'2022-05-22' AS Date), NULL, 39400000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD10      ', N'XE04      ', 4, NULL, CAST(N'2022-05-24' AS Date), CAST(N'2022-05-30' AS Date), NULL, 23400000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD11      ', N'XE04      ', 5, NULL, CAST(N'2022-06-01' AS Date), CAST(N'2022-06-12' AS Date), NULL, 39400000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD12      ', N'XE04      ', 7, NULL, CAST(N'2022-06-14' AS Date), CAST(N'2022-06-24' AS Date), NULL, 36200000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD13      ', N'XE05      ', 3, NULL, CAST(N'2022-06-27' AS Date), CAST(N'2022-07-08' AS Date), NULL, 11200000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD14      ', N'XE05      ', 4, NULL, CAST(N'2022-07-10' AS Date), CAST(N'2022-07-19' AS Date), NULL, 9500000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD15      ', N'XE05      ', 5, NULL, CAST(N'2022-07-20' AS Date), CAST(N'2022-07-29' AS Date), NULL, 9500000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD16      ', N'XE05      ', 7, NULL, CAST(N'2022-08-01' AS Date), CAST(N'2022-08-06' AS Date), NULL, 6100000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD17      ', N'XE06      ', 3, NULL, CAST(N'2022-08-08' AS Date), CAST(N'2022-08-17' AS Date), NULL, 45200000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD18      ', N'XE06      ', 4, NULL, CAST(N'2022-08-19' AS Date), CAST(N'2022-08-30' AS Date), NULL, 32200000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD19      ', N'XE06      ', 5, NULL, CAST(N'2022-09-01' AS Date), CAST(N'2022-09-15' AS Date), NULL, 40000000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD20      ', N'XE06      ', 7, NULL, CAST(N'2022-09-17' AS Date), CAST(N'2022-09-30' AS Date), NULL, 37400000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD21      ', N'XE07      ', 9, NULL, CAST(N'2022-10-01' AS Date), CAST(N'2022-10-07' AS Date), NULL, 19900000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD22      ', N'XE07      ', 10, NULL, CAST(N'2022-10-09' AS Date), CAST(N'2022-10-20' AS Date), NULL, 33400000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD23      ', N'XE07      ', 12, NULL, CAST(N'2022-10-22' AS Date), CAST(N'2022-10-30' AS Date), NULL, 25300000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD24      ', N'XE07      ', 13, NULL, CAST(N'2022-11-02' AS Date), CAST(N'2022-11-15' AS Date), NULL, 38800000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD25      ', N'XE08      ', 14, NULL, CAST(N'2022-11-05' AS Date), CAST(N'2022-11-19' AS Date), NULL, 38500000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD26      ', N'XE08      ', 15, NULL, CAST(N'2022-11-20' AS Date), CAST(N'2022-11-30' AS Date), NULL, 28500000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD27      ', N'XE08      ', 16, NULL, CAST(N'2022-12-01' AS Date), CAST(N'2022-12-17' AS Date), NULL, 43500000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD28      ', N'XE08      ', 17, NULL, CAST(N'2022-12-18' AS Date), CAST(N'2022-12-30' AS Date), NULL, 33500000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD29      ', N'XE09      ', 18, NULL, CAST(N'2022-09-05' AS Date), CAST(N'2022-09-19' AS Date), NULL, 29500000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD30      ', N'XE09      ', 19, NULL, CAST(N'2022-09-20' AS Date), CAST(N'2022-09-30' AS Date), NULL, 21900000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD31      ', N'XE09      ', 20, NULL, CAST(N'2022-10-04' AS Date), CAST(N'2022-10-16' AS Date), NULL, 25700000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD32      ', N'XE09      ', 21, NULL, CAST(N'2022-10-18' AS Date), CAST(N'2022-10-30' AS Date), NULL, 25700000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD33      ', N'XE10      ', 22, NULL, CAST(N'2022-11-01' AS Date), CAST(N'2022-11-15' AS Date), NULL, 29500000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD34      ', N'XE10      ', 23, NULL, CAST(N'2022-11-16' AS Date), CAST(N'2022-11-19' AS Date), NULL, 8600000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD35      ', N'XE10      ', 24, NULL, CAST(N'2022-11-20' AS Date), CAST(N'2022-12-02' AS Date), NULL, 25700000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD36      ', N'XE10      ', 25, NULL, CAST(N'2022-12-05' AS Date), CAST(N'2022-12-26' AS Date), NULL, 42800000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD37      ', N'XE11      ', 26, NULL, CAST(N'2022-11-05' AS Date), CAST(N'2022-11-19' AS Date), NULL, 32500000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD38      ', N'XE11      ', 27, NULL, CAST(N'2022-11-20' AS Date), CAST(N'2022-11-30' AS Date), NULL, 24100000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD39      ', N'XE11      ', 28, NULL, CAST(N'2022-12-03' AS Date), CAST(N'2022-12-15' AS Date), NULL, 28300000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD40      ', N'XE11      ', 29, NULL, CAST(N'2022-12-17' AS Date), CAST(N'2022-12-30' AS Date), NULL, 30400000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD41      ', N'XE12      ', 30, NULL, CAST(N'2022-12-02' AS Date), CAST(N'2022-12-08' AS Date), NULL, 13600000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD42      ', N'XE12      ', 9, NULL, CAST(N'2022-12-10' AS Date), CAST(N'2022-12-16' AS Date), NULL, 13600000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD43      ', N'XE12      ', 10, NULL, CAST(N'2022-12-18' AS Date), CAST(N'2022-12-24' AS Date), NULL, 13600000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD44      ', N'XE12      ', 12, NULL, CAST(N'2022-12-25' AS Date), CAST(N'2022-12-30' AS Date), NULL, 11800000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD45      ', N'XE13      ', 13, NULL, CAST(N'2023-01-02' AS Date), CAST(N'2023-01-13' AS Date), NULL, 23800000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD46      ', N'XE13      ', 14, NULL, CAST(N'2023-01-18' AS Date), CAST(N'2023-01-26' AS Date), NULL, 18100000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD47      ', N'XE13      ', 15, NULL, CAST(N'2023-01-27' AS Date), CAST(N'2023-01-30' AS Date), NULL, 8600000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD48      ', N'XE13      ', 16, NULL, CAST(N'2023-02-02' AS Date), CAST(N'2023-02-20' AS Date), NULL, 42800000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD49      ', N'XE14      ', 17, NULL, CAST(N'2023-02-12' AS Date), CAST(N'2023-02-19' AS Date), NULL, 16200000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD50      ', N'XE14      ', 18, NULL, CAST(N'2023-02-20' AS Date), CAST(N'2023-02-28' AS Date), NULL, 18100000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD51      ', N'XE14      ', 19, NULL, CAST(N'2023-03-01' AS Date), CAST(N'2023-03-16' AS Date), NULL, 31400000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD52      ', N'XE14      ', 20, NULL, CAST(N'2023-03-17' AS Date), CAST(N'2023-03-30' AS Date), NULL, 27600000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD53      ', N'XE15      ', 21, NULL, CAST(N'2023-04-03' AS Date), CAST(N'2023-04-15' AS Date), NULL, 28000000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD54      ', N'XE15      ', 22, NULL, CAST(N'2023-03-13' AS Date), CAST(N'2023-03-30' AS Date), NULL, 30700000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD55      ', N'XE15      ', 23, NULL, CAST(N'2023-04-06' AS Date), CAST(N'2023-04-18' AS Date), NULL, 22450000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD56      ', N'XE15      ', 24, NULL, CAST(N'2023-02-06' AS Date), CAST(N'2023-02-19' AS Date), NULL, 24100000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD57      ', N'XE16      ', 25, NULL, CAST(N'2023-02-12' AS Date), CAST(N'2023-02-23' AS Date), NULL, 20800000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD58      ', N'XE16      ', 26, NULL, CAST(N'2023-02-25' AS Date), CAST(N'2023-03-06' AS Date), NULL, 20800000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD59      ', N'XE16      ', 27, NULL, CAST(N'2023-03-10' AS Date), CAST(N'2023-03-27' AS Date), NULL, 30700000, 0)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaVouncher], [ThanhTien], [ThoiHanHopDong]) VALUES (N'HD60      ', N'XE16      ', 28, NULL, CAST(N'2023-03-29' AS Date), CAST(N'2023-04-16' AS Date), NULL, 30700000, 0)
GO
INSERT [dbo].[LoaiXe] ([MaLoaiXe], [TenLoaiXe], [GhiChu]) VALUES (N'DAU       ', N'Xe dầu', N'Xe chạy bằng nhiên liệu dầu')
INSERT [dbo].[LoaiXe] ([MaLoaiXe], [TenLoaiXe], [GhiChu]) VALUES (N'DIEN      ', N'Xe điện', N'Xe chạy bằng nhiên liệu điện')
INSERT [dbo].[LoaiXe] ([MaLoaiXe], [TenLoaiXe], [GhiChu]) VALUES (N'XANG      ', N'Xe xăng', N'Xe chạy bằng nhiên liệu xăng')
GO
SET IDENTITY_INSERT [dbo].[MaNap] ON 

INSERT [dbo].[MaNap] ([ID_MN], [MaNapTien], [NoiDung], [GiaTri], [TrangThai]) VALUES (1, N'NAP_5TRIEU', N'Mã nạp 5 triệu vào tài khoản', 5000000, 0)
INSERT [dbo].[MaNap] ([ID_MN], [MaNapTien], [NoiDung], [GiaTri], [TrangThai]) VALUES (2, N'NAP_7TRIEU', N'Mã nạp 5 triệu vào tài khoản', 7000000, 0)
INSERT [dbo].[MaNap] ([ID_MN], [MaNapTien], [NoiDung], [GiaTri], [TrangThai]) VALUES (3, N'NAP10TRIEU', N'Mã nạp 5 triệu vào tài khoản', 10000000, 0)
SET IDENTITY_INSERT [dbo].[MaNap] OFF
GO
SET IDENTITY_INSERT [dbo].[SuaChuaBaoDuong] ON 

INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (1, N'XE01      ', N'Bảo dưỡng định kỳ', CAST(N'2022-01-15' AS Date), CAST(N'2022-06-25' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (2, N'XE02      ', N'Bảo dưỡng định kỳ', CAST(N'2022-01-15' AS Date), CAST(N'2022-06-25' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (3, N'XE03      ', N'Bảo dưỡng định kỳ', CAST(N'2022-01-15' AS Date), CAST(N'2022-06-25' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (4, N'XE04      ', N'Bảo dưỡng định kỳ', CAST(N'2022-01-15' AS Date), CAST(N'2022-06-25' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (5, N'XE05      ', N'Bảo dưỡng định kỳ', CAST(N'2022-01-15' AS Date), CAST(N'2022-06-25' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (6, N'XE06      ', N'Bảo dưỡng định kỳ', CAST(N'2022-01-15' AS Date), CAST(N'2022-06-25' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (7, N'XE07      ', N'Bảo dưỡng định kỳ', CAST(N'2022-01-15' AS Date), CAST(N'2022-06-25' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (8, N'XE08      ', N'Bảo dưỡng định kỳ', CAST(N'2022-01-15' AS Date), CAST(N'2022-06-25' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (9, N'XE09      ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2023-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (10, N'XE10      ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2023-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (11, N'XE11      ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2023-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (12, N'XE12      ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2023-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (13, N'XE13      ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2023-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (14, N'XE14      ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2023-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (15, N'XE15      ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2023-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (16, N'XE16      ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2023-01-15' AS Date))
SET IDENTITY_INSERT [dbo].[SuaChuaBaoDuong] OFF
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
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (31, N'NgocNB', N'123123', N'ngocnb@gmail.com', 0, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (32, N'NhiHL', N'123123', N'nhihl@gmail.com', 0, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (33, N'VanLL', N'123123', N'vanll@gmail.com', 0, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (34, N'AnhVTV', N'123123', N'anhvtv@gmail.com', 0, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (35, N'TuanPV', N'123123', N'tuanpv@gmail.com', 0, 0)
SET IDENTITY_INSERT [dbo].[TaiKhoan] OFF
GO
INSERT [dbo].[Vouncher] ([MaVouncher], [NoiDung], [GiaTri], [TrangThai]) VALUES (N'EMHIEUCUTE', N'Giảm giá trị thuê xe 10%', 2, 0)
INSERT [dbo].[Vouncher] ([MaVouncher], [NoiDung], [GiaTri], [TrangThai]) VALUES (N'EMHIEUDINHVAINHO', N'Giảm giá trị thuê xe 15%', 3, 0)
INSERT [dbo].[Vouncher] ([MaVouncher], [NoiDung], [GiaTri], [TrangThai]) VALUES (N'EMHIEUTOP1THAPTRUYHON', N'Giảm giá trị thuê xe 5%', 1, 0)
GO
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE01      ', N'Kia Morning 5.2', 4, 0, 500000, N'Kia_Morning_5.2_4cho_xang.jpg', N'XANG      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE02      ', N'Vinfast VF5 2023', 4, 0, 650000, N'Vinfast_VF5_2023_4cho_dien.jpg', N'DIEN      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE03      ', N'Mercedes-Benz C 300 AMG', 4, 0, 4000000, N'Mercedes-Benz_C_300 AMG_4cho_xang.jpg', N'XANG      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE04      ', N'Mercedes- Benz C 200', 4, 0, 3200000, N'Mercedes-Benz_C_200_4cho_xang.jpg', N'XANG      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE05      ', N'Toyota VIOS', 4, 0, 850000, N'Toyota_VIOS_4cho_dau.jpg', N'DAU       ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE06      ', N'Audi Q7', 7, 0, 2600000, N'Audi_Q7_7cho_xang.jpg', N'XANG      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE07      ', N'Lexus GX460', 7, 0, 2700000, N'Lexus_GX460_7cho_xang.jpg', N'XANG      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE08      ', N'BMW X7', 7, 0, 2500000, N'BMW_X7_7cho_xang.jpg', N'XANG      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE09      ', N'Honda CR-V', 7, 0, 1900000, N'Honda_CR-V_7cho_xang.jpg', N'XANG      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE10      ', N'Mazda CX-8', 7, 0, 1900000, N'Mazda_CX-8_7cho_xang.jpg', N'XANG      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE11      ', N'Toyota Fortuner 2.4AT 4x2', 7, 0, 2100000, N'Toyota_Fortuner_2.4AT_4x2_7cho_dau.jpg', N'DAU       ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE12      ', N'Ford Transit', 16, 0, 1800000, N'Ford_Transit_16cho_ford_xang.jpg', N'XANG      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE13      ', N'Toyota Hiace', 16, 0, 1900000, N'Toyota_Hiace_16cho_dau.jpg', N'DAU       ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE14      ', N'Hyundai Solati', 16, 0, 1900000, N'Hyundai_Solati_16cho_ford_dau.jpg', N'DAU       ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE15      ', N'Xe Khách Samco Bầu Hơi', 29, 0, 1650000, N'Xe_Khach_Samco_Bau_Hoi_29cho_dau.jpg', N'DAU       ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE16      ', N'Xe Khách Samco Felix', 29, 0, 1650000, N'Xe_Khach_Samco_Felix_29cho_dau.jpg', N'DAU       ', NULL)
GO
/****** Object:  Index [UQ__ChiTietT__1788CCAD08BDAF2E]    Script Date: 11/30/2023 8:19:02 PM ******/
ALTER TABLE [dbo].[ChiTietTaiKhoan] ADD UNIQUE NONCLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__TaiKhoan__D5B8C7F0C95321F6]    Script Date: 11/30/2023 8:19:02 PM ******/
ALTER TABLE [dbo].[TaiKhoan] ADD UNIQUE NONCLUSTERED 
(
	[TaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__ThemDich__C0E6DE8ECE07570D]    Script Date: 11/30/2023 8:19:02 PM ******/
ALTER TABLE [dbo].[ThemDichVu] ADD UNIQUE NONCLUSTERED 
(
	[MaDichVu] ASC
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
ALTER TABLE [dbo].[HopDong] ADD  DEFAULT (getdate()) FOR [NgayThue]
GO
ALTER TABLE [dbo].[HopDong] ADD  DEFAULT ((1)) FOR [ThoiHanHopDong]
GO
ALTER TABLE [dbo].[MaNap] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT ((0)) FOR [VaiTro]
GO
ALTER TABLE [dbo].[Xe] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ChiTietTaiKhoan]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[TaiKhoan] ([UserID])
GO
ALTER TABLE [dbo].[danhgia]  WITH CHECK ADD FOREIGN KEY([MaXe])
REFERENCES [dbo].[Xe] ([MaXe])
GO
ALTER TABLE [dbo].[danhgia]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[TaiKhoan] ([UserID])
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD FOREIGN KEY([MaXe])
REFERENCES [dbo].[Xe] ([MaXe])
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD FOREIGN KEY([Userid])
REFERENCES [dbo].[TaiKhoan] ([UserID])
GO
ALTER TABLE [dbo].[SuaChuaBaoDuong]  WITH CHECK ADD FOREIGN KEY([MaXe])
REFERENCES [dbo].[Xe] ([MaXe])
GO
ALTER TABLE [dbo].[ThemDichVu]  WITH CHECK ADD FOREIGN KEY([MaDichVu])
REFERENCES [dbo].[dichvu] ([MaDichVu])
GO
ALTER TABLE [dbo].[ThemDichVu]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[TaiKhoan] ([UserID])
GO
ALTER TABLE [dbo].[ThemDichVu]  WITH CHECK ADD FOREIGN KEY([MaXe])
REFERENCES [dbo].[Xe] ([MaXe])
GO
ALTER TABLE [dbo].[Xe]  WITH CHECK ADD FOREIGN KEY([MaLoaiXe])
REFERENCES [dbo].[LoaiXe] ([MaLoaiXe])
GO
/****** Object:  StoredProcedure [dbo].[sp_DoanhThu]    Script Date: 11/30/2023 8:19:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[sp_DoanhThu](@month int)
	as begin
	Select 
		soghe LoaiXe,
		count(xe.SoGhe) soxe,
		sum(hd.ThanhTien) Doanhthu,
		min(hd.ThanhTien) ThapNhat,
		max(hd.ThanhTien) CaoNhat,
		avg(hd.ThanhTien) TrungBinh
	from HopDong hd
	Join Xe xe on hd.MaXe=xe.MaXe
	where month(NgayThue) =@month
	group by soghe
	end 
GO
/****** Object:  StoredProcedure [dbo].[sp_ThongKeHoaDon]    Script Date: 11/30/2023 8:19:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_ThongKeHoaDon]
    as begin
        select
            month(NgayThue) Thang,
            count(*) SoLuong,
            Min(NgayThue) DauTien,
            Max(NgayThue) CuoiCung
        from HopDong
        group by month(NgayThue)
    end
	exec sp_ThongKeHoaDon
GO
/****** Object:  StoredProcedure [dbo].[sp_ThongKeHopDong]    Script Date: 11/30/2023 8:19:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_ThongKeHopDong]
    as begin
        select
          *
        from HopDong      
    end
	exec sp_ThongKeHopDong
GO
USE [master]
GO
ALTER DATABASE [QuanLyThueOto] SET  READ_WRITE 
GO
