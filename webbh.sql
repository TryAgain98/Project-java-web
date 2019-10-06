
CREATE DATABASE webbh CHARACTER SET utf8 COLLATE utf8_general_ci;
use webbh;


create table danhmucsp(
madm int  primary key auto_increment,
name varchar(200)
);

create table product(
masp int  primary key auto_increment,
name varchar(500),
OldPrice int,
NewPrice int,
thuongHieu varchar(500),
soluong int,
image varchar(500),
created_at datetime,
updated_at datetime,
ghichu varchar(1000),
trangThai varchar(500),
maDM int,
FOREIGN KEY(maDM) REFERENCES danhmucsp(maDM)
);

insert into danhmucsp(name) values("Điện Thoại");
insert into danhmucsp(name) values("Laptop");


insert into product(name,OldPrice,NewPrice,thuongHieu,soluong,image,created_at,updated_at,ghichu,trangthai,maDM)
values("Laptop LG Gram 2018 ",100000,
20000,"LG",20,"a.jpg",NOW(),NOW(),"Laptop LG Gram 2018 14ZD980-G AX52A5 có thiết kế sang trọng, cao cấp cùng với kích thước nhỏ gọn và siêu nhẹ, thiết bị sẵn sàng đồng hành cùng bạn trong mọi việc ở bất kỳ nơi nào. Phần khung thân bằng hợp kim Magie Cacbon Nano, chất liệu tiên tiến do LG độc quyền phát triển. Đây là chất liệu có độ bền cao và khả năng chịu đựng va chạm tốt nên thường được sử dụng trong chế tạo máy, xe hơi thể thao cao cấp.","New",2
);

insert into product(name,OldPrice,NewPrice,thuongHieu,soluong,image,created_at,updated_at,ghichu,trangthai,maDM)
values("Laptop LG Gram 2018 ",100000,
50000,"LG",20,"a.jpg",NOW(),NOW(),"Laptop LG Gram 2018 14ZD980-G AX52A5 có thiết kế sang trọng, cao cấp cùng với kích thước nhỏ gọn và siêu nhẹ, thiết bị sẵn sàng đồng hành cùng bạn trong mọi việc ở bất kỳ nơi nào. Phần khung thân bằng hợp kim Magie Cacbon Nano, chất liệu tiên tiến do LG độc quyền phát triển. Đây là chất liệu có độ bền cao và khả năng chịu đựng va chạm tốt nên thường được sử dụng trong chế tạo máy, xe hơi thể thao cao cấp.","",2
);
create table simDT(
maSim int primary key auto_increment,
soluong varchar(200),
maDM int
);
create table cameraTDT(
maCameraT int primary key auto_increment,
doPhanGiai varchar(200),
maDM int
);
create table cameraSDT(
maCameraS int primary key auto_increment,
doPhanGiai varchar(200),
maDM int
);
create table ramDT(
maRam int primary key auto_increment,
dungLuong varchar(200),
loai varchar(200),
maDM int
);
create table cpuDT(
maCPU int primary key auto_increment,
name varchar(200),
loai varchar(200),
maDM int
);
create table romDT(
maRom int primary key auto_increment,
dungLuong varchar(200),
loai varchar(200),
maDM int
);

create table manHinhDT(
maMH int primary key auto_increment,
doPhanGiai varchar(200),
kichthuoc varchar(200),
maDM int
);
create table HeDieuHanhDT(
maHDH int primary key auto_increment,
name varchar(200),
maDM int
);



create table ramMT(
maRam int primary key auto_increment,
dungLuong varchar(200),
loai varchar(200),
maDM int
);
create table cpuMT(
maCPU int primary key auto_increment,
name varchar(200),
loai varchar(200),
maDM int
);
create table romMT(
maRom int primary key auto_increment,
dungLuong varchar(200),
loai varchar(200),
maDM int
);

create table manHinhMT(
maMH int primary key auto_increment,
doPhanGiai varchar(200),
kichthuoc varchar(200),
maDM int
);
create table HeDieuHanhMT(
maHDH int primary key auto_increment,
name varchar(200),
maDM int
);
create table cardDoHoaMT(
maCDH int primary key auto_increment,
name varchar(200),
maDM int
);
create table chiTietDT(
maCT int primary key auto_increment,
maRam int,
maRom int,
macpu int,
maHDH int,
maSim int,
maMH int,
macameraT int,
macameraS int,
masp int,
FOREIGN KEY(masp) REFERENCES product(masp),
FOREIGN KEY(maRam) REFERENCES ramDT(maram),
FOREIGN KEY(maRom) REFERENCES romDT(marom),
FOREIGN KEY(macpu) REFERENCES cpuDT(macpu),
FOREIGN KEY(maHDH) REFERENCES hedieuhanhDT(mahdh),
FOREIGN KEY(maMH) REFERENCES manhinhDT(mamh),
FOREIGN KEY(macameraT) REFERENCES cameraTDT(macameraT),
FOREIGN KEY(macameraS) REFERENCES cameraSDT(macameraS),
FOREIGN KEY(maSim) REFERENCES simDT(masim)
);

create table chiTietMT(
maCT int primary key auto_increment,
maRam int,
maRom int,
maCpu int,
maHDH int,
maMH int,
maCDH int,
masp int,
FOREIGN KEY(masp) REFERENCES product(masp),
FOREIGN KEY(maRam) REFERENCES ramMT(maram),
FOREIGN KEY(maRom) REFERENCES romMT(marom),
FOREIGN KEY(macpu) REFERENCES cpuMT(macpu),
FOREIGN KEY(maHDH) REFERENCES hedieuhanhMT(mahdh),
FOREIGN KEY(maMH) REFERENCES manhinhMT(mamh),
FOREIGN KEY(maCDH) REFERENCES cardDoHoaMT(maCDH)
);
insert into product(name,OldPrice,NewPrice,thuongHieu,soluong,image,created_at,updated_at,ghichu,trangthai,maDM)
values("Laptop HP Pavilion 14-ce2041TU",15390000,
0,"HP",20,"HPPavilion14ce2041TU.jfif",NOW(),NOW(),"Laptop HP  có thiết kế sang trọng, cao cấp cùng với kích thước nhỏ gọn và siêu nhẹ, thiết bị sẵn sàng đồng hành cùng bạn trong mọi việc ở bất kỳ nơi nào. Phần khung thân bằng hợp kim Magie Cacbon Nano, chất liệu tiên tiến do LG độc quyền phát triển. Đây là chất liệu có độ bền cao và khả năng chịu đựng va chạm tốt nên thường được sử dụng trong chế tạo máy, xe hơi thể thao cao cấp.","New",2
);
insert into product(name,OldPrice,NewPrice,thuongHieu,soluong,image,created_at,updated_at,ghichu,trangthai,maDM)
values("Laptop Asus ZenBook UX433FN-A6125T ",26000000,
24490000,"Asus",20,"AsusZenBookUX433FNA6125T.jfif",NOW(),NOW(),"Laptop asus  có thiết kế sang trọng, cao cấp cùng với kích thước nhỏ gọn và siêu nhẹ, thiết bị sẵn sàng đồng hành cùng bạn trong mọi việc ở bất kỳ nơi nào. Phần khung thân bằng hợp kim Magie Cacbon Nano, chất liệu tiên tiến do LG độc quyền phát triển. Đây là chất liệu có độ bền cao và khả năng chịu đựng va chạm tốt nên thường được sử dụng trong chế tạo máy, xe hơi thể thao cao cấp.","New",2
);
insert into product(name,OldPrice,NewPrice,thuongHieu,soluong,image,created_at,updated_at,ghichu,trangthai,maDM)
values("Điện thoại XIAOMI Redmi Note 7 ",4990000,
4590000,"
XIAOMI",20,"XIAOMIRedmiNo7.jfif",NOW(),NOW(),"  có thiết kế sang trọng, cao cấp cùng với kích thước nhỏ gọn và siêu nhẹ, thiết bị sẵn sàng đồng hành cùng bạn trong mọi việc ở bất kỳ nơi nào. Phần khung thân bằng hợp kim Magie Cacbon Nano, chất liệu tiên tiến do LG độc quyền phát triển. Đây là chất liệu có độ bền cao và khả năng chịu đựng va chạm tốt nên thường được sử dụng trong chế tạo máy, xe hơi thể thao cao cấp.","New",1
);
insert into product(name,OldPrice,NewPrice,thuongHieu,soluong,image,created_at,updated_at,ghichu,trangthai,maDM)
values("Điện Thoại iPhone X 64GB ",26990000,
20090000,"
Apple",40,"iphonX.jpg",NOW(),NOW(),"  có thiết kế sang trọng, cao cấp cùng với kích thước nhỏ gọn và siêu nhẹ, thiết bị sẵn sàng đồng hành cùng bạn trong mọi việc ở bất kỳ nơi nào. Phần khung thân bằng hợp kim Magie Cacbon Nano, chất liệu tiên tiến do LG độc quyền phát triển. Đây là chất liệu có độ bền cao và khả năng chịu đựng va chạm tốt nên thường được sử dụng trong chế tạo máy, xe hơi thể thao cao cấp.","New",1
);




select p.name as name, masp ,OldPrice, newprice ,thuonghieu, image, trangthai
 from product as p join danhmucsp as dm on dm.madm=p.madm
where p.name like '%laptop%' or dm.name like '%dienthoai%' or thuonghieu like '%laptop%';
DELETE from product where newprice = 24490000;

use webbh;
select masp from danhmucsp as dm join product as p on p.madm=dm.madm where dm.madm=1 ;

insert into ramMT(dungluong,loai,madm) values('8GB','DDR4','2');
insert into rammt(dungluong,loai,madm) values(' 4GB','DDR4','2');
insert into rammt(dungluong,loai,madm) values('4GB','DDR3L','2');
insert into rammt(dungluong,loai,madm) values('16GB','DDR4','2');
insert into ramdt(dungluong,madm) values('16GB','1');
insert into ramdt(dungluong,madm) values('3GB','1');

insert into rommt(dungluong,loai,madm) values('120GB','SSD WD Green ','2');
insert into rommt(dungluong,loai,madm) values('128GB','SSD Adata ','2');
insert into rommt(dungluong,loai,madm) values('1TB','HDD PC Seagate Barracuda','2');
insert into romdt(dungluong,madm) values('64GB','1');

insert into cpumt(name,loai,madm) values('CPU Intel Core i3-7100','intel ','2');
insert into cpumt(name,loai,madm) values(' CPU Intel Core i5-9400F','intel ','2');
insert into cpumt(name,loai,madm) values(' CPU Intel Core i7-9700K ','intel ','2');
insert into cpumt(name,loai,madm) values('CPU Intel Core i9-7900X X-series','intel ','2');
insert into cpumt(name,loai,madm) values('CPU Intel Core i9','intel ','2');

insert into cpudt(name,madm) values('
Snapdragon 660 ','1');
insert into cpudt(name,madm) values('Apple A11 Bionic 6 nhân ','1');

insert into hedieuhanhmt(name,madm) values('Windows 10 Home 64-bit','2');
insert into hedieuhanhmt(name,madm) values('Windows 10 Pro 64-bit ','2');
insert into hedieuhanhmt(name,madm) values('Ubuntu ','2');
insert into hedieuhanhmt(name,madm) values('macOS ','2');
insert into hedieuhanhmt(name,madm) values('Free DOS ','2');
insert into hedieuhanhdt(name,madm) values('
Android 9.0 ','1');
insert into hedieuhanhdt(name,madm) values('
iOS 11 ','1');

insert into simdt(soluong,madm) values('1 Sim','1');
insert into simdt(soluong,madm) values('2 Sim','1');


insert into manhinhmt(dophangiai,kichthuoc,madm) values('1920 x 1080','14 inch Full HD ','2');
insert into manhinhmt(dophangiai,kichthuoc,madm) values('1366 x 768','15 inch Full HD ','2');
insert into manhinhmt(dophangiai,kichthuoc,madm) values('2880 x 1800','16 inch Full HD ','2');
insert into manhinhmt(dophangiai,kichthuoc,madm) values('2560 x 1600','17 inch Full HD ','2');
insert into manhinhmt(dophangiai,kichthuoc,madm) values('1280 x 720','18 inch Full HD ','2');
insert into manhinhmt(dophangiai,kichthuoc,madm) values('2160 x 1440','19 inch Full HD ','2');
insert into manhinhmt(dophangiai,kichthuoc,madm) values('3000 x 2000	','13 inch Full HD ','2');
insert into manhinhmt(dophangiai,kichthuoc,madm) values('3200 x 1800','20 inch Full HD ','2');
insert into manhinhdt(dophangiai,kichthuoc,madm) values('1080 x 2340','6.3 inches ','1');
insert into manhinhdt(dophangiai,kichthuoc,madm) values('1125 x 2436','	5.8 inch ','1');

insert into carddohoamt(name,madm) values('NVIDIA GeForce GTX 1050','2');
insert into carddohoamt(name,madm) values('NVIDIA GeForce GTX 1650','2');
insert into carddohoamt(name,madm) values('NVIDIA GeForce GTX 1050Ti','2');
insert into carddohoamt(name,madm) values('NVIDIA GeForce MX130','2');
insert into carddohoamt(name,madm) values('NVIDIA GeForce MX150','2');

insert into cameratdt(dophangiai,madm) values('8MP','1');
insert into cameratdt(dophangiai,madm) values('13MP','1');
insert into cameratdt(dophangiai,madm) values('16MP','1');
insert into cameratdt(dophangiai,madm) values('12MP','1');
insert into cameratdt(dophangiai,madm) values('25MP','1');
insert into cameratdt(dophangiai,madm) values('7 MP','1');

insert into camerasdt(dophangiai,madm) values('12MP','1');
insert into camerasdt(dophangiai,madm) values('15GB','1');
insert into camerasdt(dophangiai,madm) values('20GB','1');
insert into camerasdt(dophangiai,madm) values('10GB','1');
insert into camerasdt(dophangiai,madm) values('2 camera 12 MP','1');

insert into chitietmt(maram,marom,macpu,mahdh,mamh,macdh,masp)
values('1','1','1','1','1','1','1');
insert into chitietmt(maram,marom,macpu,mahdh,mamh,macdh,masp)
values('2','2','2','1','1','1','2');
insert into chitietmt(maram,marom,macpu,mahdh,mamh,macdh,masp)
values('1','1','2','1','1','1','3');
insert into chitietmt(maram,marom,macpu,mahdh,mamh,macdh,masp)
values('2','2','1','1','1','2','4');

insert into chitietdt(maram,marom,macpu,mahdh,mamh,masim,macameraT,macameraS,masp)
values('1','1','1','1','1','1','1','1','5');
insert into chitietdt(maram,marom,macpu,mahdh,mamh,masim,macameraT,macameraS,masp)
values('2','1','2','2','2','1','6','5','6');

select dungluong , loai ,r.maram as maram from ((product as p join chitietmt as mt on mt.masp=p.masp ) join rammt as r on r.maram=mt.maram) where p.madm=2;
 select dungluong , loai ,r.maram as maram from ((product as p join chitietdt as mt on mt.masp=p.masp ) join ramdt as r on r.maram=mt.maram) where p.madm=1;
 
 select dungluong , loai ,r.marom as marom from ((product as p join chitietmt as mt on mt.masp=p.masp ) join rommt as r on r.marom=mt.marom) where p.madm=2
select dungluong , loai ,r.marom as marom from ((product as p join chitietdt as mt on mt.masp=p.masp ) join romdt as r on r.marom=mt.marom) where p.madm=1

  select cp.name as name , loai ,cp.macpu as macpu from ((product as p join chitietdt as mt on mt.masp=p.masp ) join cpudt as cp on cp.macpu=mt.macpu) where p.madm=1
  select cp.name as name , loai ,cp.macpu as macpu from ((product as p join chitietmt as mt on mt.masp=p.masp ) join cpumt as cp on cp.macpu=mt.macpu) where p.madm=2

  select distinct h.name as name  ,h.mahdh as mahdh from ((product as p join chitietmt as mt on mt.masp=p.masp ) join hedieuhanhmt as h on h.mahdh=mt.mahdh) where p.madm=2
  select distinct h.name as name  ,h.mahdh as mahdh from ((product as p join chitietdt as mt on mt.masp=p.masp ) join hedieuhanhdt as h on h.mahdh=mt.mahdh) where p.madm=1

select distinct dophangiai,kichthuoc  ,h.mamh as mamh from ((product as p join chitietdt as mt on mt.masp=p.masp ) join manhinhdt as h on h.mamh=mt.mamh) where p.madm=1
select distinct dophangiai,kichthuoc  ,h.mamh as mahmh from ((product as p join chitietmt as mt on mt.masp=p.masp ) join manhinhmt as h on h.mamh=mt.mamh) where p.madm=2

select distinct h.name as name, h.macdh as macdh from ((product as p join chitietmt as mt on mt.masp=p.masp ) join carddohoamt as h on h.macdh=mt.macdh) where p.madm=2

select distinct s.soluong as soluong,s.masim as masim from ((product as p join chitietdt as dt on dt.masp=p.masp ) join simdt as s on s.masim=dt.masim) where p.madm=1

select distinct dophangiai,s.macamerat as macamerat from ((product as p join chitietdt as dt on dt.masp=p.masp ) join cameratdt as s on s.macamerat=dt.macamerat) where p.madm=1

select distinct dophangiai,s.macameras as macameras from ((product as p join chitietdt as dt on dt.masp=p.masp ) join camerasdt as s on s.macameras=dt.macameras) where p.madm=1


select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where (maram=1 or marom=1 or macpu=1 or mahdh=1 or mamh=1 or masim=1 or macamerat=1 or macameras=1 ) and madm=2

select dungluong  ,r.marom as marom from ((product as p join chitietdt as mt on mt.masp=p.masp ) join romdt as r on r.marom=mt.marom) where p.madm=1

use webbh;

delete  from customer where name='' ;

create table customer(
maKH int primary key auto_increment,
name varchar(200),
gender varchar(200),
phone varchar(200),
email varchar(200),
password varchar(200),
birthday date,
created_at datetime,
updated_at datetime
)

select * from customer where email = '' and password = '';

UPDATE customer SET name="hay",gender="Nam",phone="034",email="ok",password="lol" WHERE makh=5;

UPDATE danhmucsp SET name='Dien ' WHERE madm=1;

select dm.madm as madm ,dm.name as name  from danhmucsp as dm join product as p on p.madm=dm.madm where masp=1;


select * from product as p join chitietmt as mt on mt.masp=p.masp where p.masp=4;
select * from product as p join chitietdt as mt on mt.masp=p.masp where p.masp=6;

select * from product as p join chitietmt as mt on mt.masp=p.masp where p.masp=4;

select distinct cp.name as name  ,cp.macpu as macpu from   cpudt as cp ;

UPDATE customer SET name='c',gender='c',phone='c',email='c',password='c' WHERE makh=2;

create table lienHe(
name varchar(500),
email varchar(500),
address varchar(500),
phone varchar(500),
Them varchar(500)
);

insert into lienhe values("Học Viện Công Nghệ ACT","Toan@gmail.com","141 đường Chiến Thắng, Tân Triều, Thanh Trì, Hà Nội","0333456789","Tốt")

