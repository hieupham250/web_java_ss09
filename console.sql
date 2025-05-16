create database ss09;

use ss09;

# drop database ss09;

create table Customer
(
    id       bigint primary key auto_increment,
    username varchar(50)  not null unique,
    phone    varchar(20)  not null,
    address  varchar(255) not null,
    gender   varchar(10)  not null,
    email    varchar(255) not null unique,
    password text         not null
);

insert into Customer(username, phone, address, gender, email, password)
values ('hieupham', '0846462676', 'Hà Nội', 'Nam', 'ptrunghieu2507@gmail.com', '123');

create table Movies
(
    id          bigint primary key auto_increment,
    title       varchar(255) not null,
    director    varchar(255) not null,
    genre       varchar(255) not null,
    description varchar(255) not null,
    duration    int          not null,
    language    varchar(255) not null
);

insert into Movies(title, director, genre, description, duration, language)
values ('Mắt Biếc', 'Victor Vũ', 'Tình cảm',
        'Chuyện tình buồn giữa Ngạn và Hà Lan từ thuở học trò đến khi trưởng thành.', 117, 'Tiếng Việt'),
       ('Bố Già', 'Trấn Thành', 'Hài, Tình cảm', 'Câu chuyện về gia đình ông Ba Sang và con trai giữa Sài Gòn xô bồ.',
        128, 'Tiếng Việt'),
       ('Tiệc Trăng Máu', 'Nguyễn Quang Dũng', 'Hài kịch, Tâm lý',
        'Bảy người bạn chơi trò công khai tin nhắn dẫn đến những bí mật động trời bị lộ.', 115, 'Tiếng Việt'),
       ('Hai Phượng', 'Lê Văn Kiệt', 'Hành động', 'Một người mẹ đơn thân chiến đấu để giải cứu con gái bị bắt cóc.', 98,
        'Tiếng Việt'),
       ('Lật Mặt: 48H', 'Lý Hải', 'Hành động, Hài',
        'Gia đình phải trốn chạy khỏi sự truy sát sau khi vướng vào rắc rối nguy hiểm.', 110, 'Tiếng Việt');

create table ScreenRooms
(
    id             bigint primary key auto_increment,
    screenRoomName varchar(100) not null,
    totalSeat      int          not null
);

INSERT INTO ScreenRooms(screenRoomName, totalSeat)
VALUES ('Phòng 1', 100),
       ('Phòng 2', 120),
       ('Phòng 3', 80);

create table Schedules
(
    id             bigint primary key auto_increment,
    movieId        bigint,
    showTime       date,
    screenRoomId   bigint,
    availableSeats int,
    format         varchar(10) not null,
    foreign key (movieId) references Movies (id),
    foreign key (screenRoomId) references ScreenRooms (id)
);

INSERT INTO Schedules(movieId, showTime, screenRoomId, availableSeats, format)
VALUES (1, '2025-05-20 18:00:00', 1, 80, '2D'),
       (1, '2025-05-21 20:30:00', 2, 100, '3D'),
       (2, '2025-05-20 19:00:00', 3, 75, '2D'),
       (3, '2025-05-22 17:00:00', 1, 90, '2D'),
       (4, '2025-05-23 21:00:00', 2, 95, '3D');

create table Seats
(
    id           bigint primary key auto_increment,
    screenRoomId bigint,
    price        double      default 50000,
    status       varchar(20) default 'AVAILABLE',
    foreign key (screenRoomId) references ScreenRooms (id)
);

insert into Seats (screenRoomId, price, status)
values (1, 50000, 'AVAILABLE'),
       (1, 50000, 'AVAILABLE'),
       (2, 50000, 'AVAILABLE'),
       (2, 50000, 'AVAILABLE'),
       (3, 50000, 'AVAILABLE');

create table Tickets
(
    id         bigint primary key auto_increment,
    customerId bigint,
    scheduleId bigint,
    seatId     bigint,
    totalMoney double,
    created_at datetime,
    foreign key (customerId) references Customer (id),
    foreign key (seatId) references Seats (id),
    foreign key (scheduleId) references Schedules (id)
);

delimiter //
create procedure login(
    username_in varchar(50),
    password_in text
)
begin
    select *
    from Customer
    where username = username_in
      and password = password_in;
end;

create procedure find_all_movie()
begin
    select * from Movies;
end;

create procedure find_movie_by_id(
    id_in bigint
)
begin
    select *
    from Movies
    where id = id_in;
end;

create procedure find_all_screenroom()
begin
    select * from ScreenRooms;
end;

create procedure find_schedule_by_movie(
    movie_id_in bigint
)
begin
    select s.id,
           s.movieId,
           m.title AS movieTitle,
           s.showTime,
           s.screenRoomId,
           s.availableSeats,
           s.format
    from Schedules s
             join Movies m on s.movieId = m.id
    where s.movieId = movie_id_in;
end;

create procedure find_seats_by_screenroom(
    screenRoomId_in bigint
)
begin
    select *
    from Seats
    where screenRoomId = screenRoomId_in;
end;

create procedure get_booked_seats_by_schedule(
    scheduleId_in bigint
)
begin
    select seatId
    from Tickets
    where scheduleId = scheduleId_in;
end;

create procedure get_seat_price_by_id(
    seatId_in bigint
)
begin
    select price
    from Seats
    where id = seatId_in;
end;

create procedure create_ticket(
    customerId_in bigint,
    scheduleId_in bigint,
    seatId_in bigint,
    totalMoney_in double
)
begin
    insert into Tickets(customerId, scheduleId, seatId, totalMoney, created_at)
    values (customerId_in, scheduleId_in, seatId_in, totalMoney_in, now());
end;
delimiter //