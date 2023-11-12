USE [master]
GO
/****** Object:  Database [QuanLyThueOto]    Script Date: 11/12/2023 2:42:38 PM ******/
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
ALTER DATABASE [QuanLyThueOto] SET AUTO_CLOSE OFF 
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
ALTER DATABASE [QuanLyThueOto] SET RECOVERY FULL 
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
EXEC sys.sp_db_vardecimal_storage_format N'QuanLyThueOto', N'ON'
GO
ALTER DATABASE [QuanLyThueOto] SET QUERY_STORE = ON
GO
ALTER DATABASE [QuanLyThueOto] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QuanLyThueOto]
GO
/****** Object:  Table [dbo].[ChiTietTaiKhoan]    Script Date: 11/12/2023 2:42:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietTaiKhoan](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[AnhDaiDien] [nvarchar](50) NULL,
	[CCCD] [nchar](12) NULL,
	[BangLaiXe] [nvarchar](50) NULL,
	[SDT] [nvarchar](10) NOT NULL,
	[TrangThaiTaiKhoan] [bit] NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[DiaChi] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[danhgia]    Script Date: 11/12/2023 2:42:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[danhgia](
	[id] [int] IDENTITY(1,1) NOT NULL,
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
/****** Object:  Table [dbo].[dichvu]    Script Date: 11/12/2023 2:42:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dichvu](
	[MaDichVu] [nchar](10) NOT NULL,
	[TenDichVu] [nvarchar](50) NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
	[DonGia] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HopDong]    Script Date: 11/12/2023 2:42:38 PM ******/
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
	[MaDichVu] [nchar](10) NOT NULL,
	[ThanhTien] [float] NOT NULL,
	[TrangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHopDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiXe]    Script Date: 11/12/2023 2:42:38 PM ******/
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
/****** Object:  Table [dbo].[SuaChuaBaoDuong]    Script Date: 11/12/2023 2:42:38 PM ******/
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
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/12/2023 2:42:38 PM ******/
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
/****** Object:  Table [dbo].[Xe]    Script Date: 11/12/2023 2:42:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Xe](
	[MaXe] [nchar](10) NOT NULL,
	[TenXe] [nvarchar](50) NOT NULL,
	[SoGhe] [int] NOT NULL,
	[TrangThai] [bit] NOT NULL,
	[GiaThue] [float] NOT NULL,
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

INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [Email], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [TrangThaiTaiKhoan], [NgaySinh], [GioiTinh], [DiaChi]) VALUES (1, 1, N'Nguyễn Đình Hoàng Long', N'longndh@gmail.com', NULL, NULL, NULL, N'123123123', 1, CAST(N'1990-01-11' AS Date), 0, N'Hải Phòng')
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [Email], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [TrangThaiTaiKhoan], [NgaySinh], [GioiTinh], [DiaChi]) VALUES (2, 2, N'Nguyễn Đình Thiên Long', N'longndt@gmail.com', NULL, NULL, NULL, N'123456456', 1, CAST(N'1990-02-12' AS Date), 0, N'Hải Phòng')
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [Email], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [TrangThaiTaiKhoan], [NgaySinh], [GioiTinh], [DiaChi]) VALUES (3, 3, N'Nguyễn Nghiêm', N'nghiemnguyen@gmail.com', NULL, NULL, NULL, N'123456789', 1, CAST(N'1990-03-13' AS Date), 0, N'Hải Phòng')
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [Email], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [TrangThaiTaiKhoan], [NgaySinh], [GioiTinh], [DiaChi]) VALUES (4, 4, N'Phạm Thị Nở', N'nopt@gmail.com', NULL, NULL, NULL, N'456456789', 1, CAST(N'1990-04-14' AS Date), 1, N'Hải Phòng')
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [Email], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [TrangThaiTaiKhoan], [NgaySinh], [GioiTinh], [DiaChi]) VALUES (5, 5, N'Nguyễn Chí Phèo', N'pheonc@gmail.com', NULL, NULL, NULL, N'147258369', 0, CAST(N'1990-05-15' AS Date), 0, N'Hải Phòng')
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [Email], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [TrangThaiTaiKhoan], [NgaySinh], [GioiTinh], [DiaChi]) VALUES (6, 6, N'Nguyễn Văn Tèo', N'teonv@gmail.com', NULL, NULL, NULL, N'456123789', 1, CAST(N'1990-06-16' AS Date), 0, N'Hải Phòng')
INSERT [dbo].[ChiTietTaiKhoan] ([ID], [UserID], [HoTen], [Email], [AnhDaiDien], [CCCD], [BangLaiXe], [SDT], [TrangThaiTaiKhoan], [NgaySinh], [GioiTinh], [DiaChi]) VALUES (7, 7, N'Lê Thị Hương Thảo', N'thaolth@gmail.com', NULL, NULL, NULL, N'789456123', 0, CAST(N'1990-07-17' AS Date), 1, N'Hải Phòng')
SET IDENTITY_INSERT [dbo].[ChiTietTaiKhoan] OFF
GO
SET IDENTITY_INSERT [dbo].[danhgia] ON 

INSERT [dbo].[danhgia] ([id], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (1, N'XE01      ', N'Xe vận hành tốt, giá cả hợp lý', CAST(N'2022-05-09' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (2, N'XE03      ', N'Trải nghiệm thuê rất tốt, đánh giá 5 sao', CAST(N'2022-06-03' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (3, N'XE06      ', N'Xe vận hành tốt, lần sau vẫn sẽ thuê ở đây ', CAST(N'2022-05-20' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (4, N'XE08      ', N'5 sao không phải nói nhiều', CAST(N'2022-07-23' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (5, N'XE09      ', N'Trải nghiệm rất tốt, xe không gặp vấn đề gì khi tôi và gia đình đi chơi, đánh giá 5 sao', CAST(N'2022-09-30' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (6, N'XE012     ', NULL, CAST(N'2022-01-29' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (7, N'XE014     ', N'lần sau sẽ tiếp tục ủng hộ', CAST(N'2022-11-15' AS Date), 5)
INSERT [dbo].[danhgia] ([id], [MaXe], [NoiDung], [NgayDanhGia], [SoSaoDanhGia]) VALUES (8, N'XE016     ', NULL, CAST(N'2022-12-30' AS Date), 5)
SET IDENTITY_INSERT [dbo].[danhgia] OFF
GO
INSERT [dbo].[dichvu] ([MaDichVu], [TenDichVu], [GhiChu], [DonGia]) VALUES (N'DV01      ', N'Thuê người lái', N'Khách hầng sẽ có người lái xe đi cầm lái cho đến khi hết hợp đồng', 650000)
INSERT [dbo].[dichvu] ([MaDichVu], [TenDichVu], [GhiChu], [DonGia]) VALUES (N'DV02      ', N'Cứu hộ đường cao tốc', N'Đội cứu hộ sẽ đến hỗ trợ đưa xe khác đến cho khách hàng và đưa xe gặp vấn đề về cơ sở', 2000000)
INSERT [dbo].[dichvu] ([MaDichVu], [TenDichVu], [GhiChu], [DonGia]) VALUES (N'DV03      ', N'Đưa đón sân bay', N'khách hàng sẽ được đưa tới sân bay hoặc đón từ sân bay về', 1500000)
INSERT [dbo].[dichvu] ([MaDichVu], [TenDichVu], [GhiChu], [DonGia]) VALUES (N'DV04      ', N'Xăng xe', N'khách hàng sẽ được miễn phí lần đổ xăng xe đầu tiên nếu thuê dài hạn hoặc nhận xe đầy nhiên liệu khi thuê ngắn hạn', 1000000)
GO
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaDichVu], [ThanhTien], [TrangThai]) VALUES (N'HD01      ', N'XE01      ', 3, NULL, CAST(N'2022-05-01' AS Date), CAST(N'2022-05-09' AS Date), N'DV04      ', 5000000, 1)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaDichVu], [ThanhTien], [TrangThai]) VALUES (N'HD02      ', N'XE03      ', 3, NULL, CAST(N'2022-05-29' AS Date), CAST(N'2022-06-03' AS Date), N'DV04      ', 21000000, 1)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaDichVu], [ThanhTien], [TrangThai]) VALUES (N'HD03      ', N'XE06      ', 5, NULL, CAST(N'2022-05-04' AS Date), CAST(N'2022-05-20' AS Date), N'DV04      ', 45200000, 1)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaDichVu], [ThanhTien], [TrangThai]) VALUES (N'HD04      ', N'XE08      ', 5, NULL, CAST(N'2022-07-19' AS Date), CAST(N'2022-07-23' AS Date), N'DV04      ', 13500000, 1)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaDichVu], [ThanhTien], [TrangThai]) VALUES (N'HD05      ', N'XE09      ', 5, NULL, CAST(N'2022-09-13' AS Date), CAST(N'2022-09-30' AS Date), N'DV04      ', 35200000, 1)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaDichVu], [ThanhTien], [TrangThai]) VALUES (N'HD06      ', N'XE012     ', 7, NULL, CAST(N'2022-01-18' AS Date), CAST(N'2022-01-29' AS Date), N'DV04      ', 22600000, 1)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaDichVu], [ThanhTien], [TrangThai]) VALUES (N'HD07      ', N'XE014     ', 7, NULL, CAST(N'2022-11-12' AS Date), CAST(N'2022-11-15' AS Date), N'DV04      ', 8350000, 1)
INSERT [dbo].[HopDong] ([MaHopDong], [MaXe], [Userid], [GhiChu], [NgayThue], [NgayTra], [MaDichVu], [ThanhTien], [TrangThai]) VALUES (N'HD08      ', N'XE016     ', 7, NULL, CAST(N'2022-12-13' AS Date), CAST(N'2022-12-30' AS Date), N'DV04      ', 30700000, 1)
GO
INSERT [dbo].[LoaiXe] ([MaLoaiXe], [TenLoaiXe], [GhiChu]) VALUES (N'LX01      ', N'Xe xăng', N'Xe chạy bằng nhiên liệu xăng')
INSERT [dbo].[LoaiXe] ([MaLoaiXe], [TenLoaiXe], [GhiChu]) VALUES (N'LX02      ', N'Xe điện', N'Xe chạy bằng nhiên liệu điện')
INSERT [dbo].[LoaiXe] ([MaLoaiXe], [TenLoaiXe], [GhiChu]) VALUES (N'LX03      ', N'Xe dầu', N'Xe chạy bằng nhiên liệu dầu')
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
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (9, N'XE09      ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2022-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (10, N'XE010     ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2022-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (11, N'XE011     ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2022-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (12, N'XE012     ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2022-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (13, N'XE013     ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2022-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (14, N'XE014     ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2022-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (15, N'XE015     ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2022-01-15' AS Date))
INSERT [dbo].[SuaChuaBaoDuong] ([ID], [MaXe], [NoiDung], [LanGanNhat], [NgaySuaChua]) VALUES (16, N'XE016     ', N'Bảo dưỡng định kỳ', CAST(N'2022-06-25' AS Date), CAST(N'2022-01-15' AS Date))
SET IDENTITY_INSERT [dbo].[SuaChuaBaoDuong] OFF
GO
SET IDENTITY_INSERT [dbo].[TaiKhoan] ON 

INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (1, N'LongNDH', N'songlong', N'longnd@gmail.com', 0, 1)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (2, N'LongNDT', N'songlong', N'longndt@gmail.com', 0, 1)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (3, N'NghiemN', N'songlong', N'nghiemnguyen@gmail.com', 1, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (4, N'NoPT', N'123456', N'nopt@gmail.com', 0, 1)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (5, N'PheoNC', N'123456', N'pheonc@gmail.com', 0, 0)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (6, N'TeoNV', N'songlong', N'teonv@gmail.com', 0, 1)
INSERT [dbo].[TaiKhoan] ([UserID], [TaiKhoan], [MatKhau], [Email], [Trangthai], [VaiTro]) VALUES (7, N'ThaoLTH', N'songlong', N'thaolth@gmail.com', 0, 0)
SET IDENTITY_INSERT [dbo].[TaiKhoan] OFF
GO
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE01      ', N'Kia Morning 5.2', 4, 0, 500000, N'Kia Morning 5.2_4cho_xang.png', N'LX01      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE010     ', N'Mazda CX-8', 7, 0, 1900000, N'Mazda CX-8_7cho_xang.png', N'LX01      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE011     ', N'Toyota Fortuner 2.4AT 4x2', 7, 0, 2100000, N'Toyota Fortuner 2.4AT 4x2_7cho_dau.png', N'LX03      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE012     ', N'Ford Transit', 16, 1, 1800000, N'Ford Transit_16cho_ford_xang.png', N'LX01      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE013     ', N'Toyota Hiace', 16, 0, 1900000, N'Toyota Hiace_16cho_dau.png', N'LX03      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE014     ', N'Hyundai Solati', 16, 1, 1900000, N'Hyundai Solati_16cho_ford_dau.png', N'LX03      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE015     ', N'Xe Khách Samco Bầu Hơi', 29, 0, 1650000, N'Xe Khach Samco Bau Hoi_29cho_dau.png', N'LX03      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE016     ', N'Xe Khách Samco Felix', 29, 1, 1650000, N'Xe Khach Samco Felix_29cho_dau.png', N'LX03      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE02      ', N'Vinfast VF5 2023', 4, 0, 650000, N'Vinfast VF5 2023_4cho_dien.png', N'LX02      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE03      ', N'Mercedes-Benz C 300 AMG', 4, 1, 4000000, N'Mercedes-Benz C 300 AMG_4cho_xang.png', N'LX01      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE04      ', N'Mercedes- Benz C 200', 4, 0, 3200000, N'Mercedes- Benz C 200_4cho_xang.png', N'LX01      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE05      ', N'Toyota VIOS', 4, 0, 850000, N'Toyota VIOS_4cho_dau.png', N'LX03      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE06      ', N'Audi Q7', 7, 1, 2600000, N'Audi Q7_7cho_xang.png', N'LX01      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE07      ', N'Lexus GX460', 7, 0, 2700000, N'Lexus GX460_7cho_xang.png', N'LX01      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE08      ', N'BMW X7', 7, 1, 2500000, N'BMW X7_7cho_xang.png', N'LX01      ', NULL)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [SoGhe], [TrangThai], [GiaThue], [Anh_Xe], [MaLoaiXe], [GhiChu]) VALUES (N'XE09      ', N'Honda CR-V', 7, 1, 1900000, N'Honda CR-V_7cho_xang.png', N'LX01      ', NULL)
GO
/****** Object:  Index [UQ__ChiTietT__1788CCAD9B448313]    Script Date: 11/12/2023 2:42:38 PM ******/
ALTER TABLE [dbo].[ChiTietTaiKhoan] ADD UNIQUE NONCLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__TaiKhoan__D5B8C7F02056B05A]    Script Date: 11/12/2023 2:42:38 PM ******/
ALTER TABLE [dbo].[TaiKhoan] ADD UNIQUE NONCLUSTERED 
(
	[TaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietTaiKhoan] ADD  DEFAULT ((0)) FOR [TrangThaiTaiKhoan]
GO
ALTER TABLE [dbo].[danhgia] ADD  DEFAULT (getdate()) FOR [NgayDanhGia]
GO
ALTER TABLE [dbo].[danhgia] ADD  DEFAULT ((5)) FOR [SoSaoDanhGia]
GO
ALTER TABLE [dbo].[HopDong] ADD  DEFAULT (getdate()) FOR [NgayThue]
GO
ALTER TABLE [dbo].[HopDong] ADD  DEFAULT ((1)) FOR [TrangThai]
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
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD FOREIGN KEY([MaDichVu])
REFERENCES [dbo].[dichvu] ([MaDichVu])
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
ALTER TABLE [dbo].[Xe]  WITH CHECK ADD FOREIGN KEY([MaLoaiXe])
REFERENCES [dbo].[LoaiXe] ([MaLoaiXe])
GO
USE [master]
GO
ALTER DATABASE [QuanLyThueOto] SET  READ_WRITE 
GO
