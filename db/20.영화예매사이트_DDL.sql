DROP DATABASE IF EXISTS CGV;

CREATE DATABASE CGV;

USE CGV;

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
	`mo_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`mo_title`	varchar(50) NOT NULL,
	`mo_title_eng`	varchar(100)	NOT NULL,
	`mo_opening_date`	date	NULL,
	`mo_running_time`	int	NOT NULL,
	`mo_plot`	longtext	NOT NULL,
	`mo_fi_num`	int	NOT NULL,
	`mo_ag_name`	varchar(10)	NOT NULL,
	`mo_reservation_rate`	int	NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
	`ge_name`	varchar(10)	NOT NULL PRIMARY KEY
);

DROP TABLE IF EXISTS `movie_genre`;

CREATE TABLE `movie_genre` (
	`mg_num`	int PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`mg_ge_name`	varchar(10)	NOT NULL,
	`mg_mo_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
	`ct_name`	varchar(20)	NOT NULL PRIMARY KEY
);

DROP TABLE IF EXISTS `country_production`;

CREATE TABLE `country_production` (
	`cp_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`cp_ct_name`	varchar(20)	NOT NULL,
	`cp_mo_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `film_person`;

CREATE TABLE `film_person` (
	`fp_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT, --
	`fp_name`	varchar(50)	NOT NULL, --
	`fp_thumbnail`	varchar(50)	NULL,
	`fp_agency`	varchar(20)	NULL,
	`fp_final_education`	varchar(20)	NULL,
	`fp_birthday`	date	NOT NULL,
	`fp_ct_name`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
	`ro_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT, --
	`ro_role`	varchar(30)	NOT NULL, --
	`ro_fp_num`	int	NOT NULL,
	`ro_mo_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
	`fi_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT, --
	`fi_name`	varchar(100)	NOT NULL, --
	`fi_state`	varchar(10)	NOT NULL -- 메인포스트/트레일러/스틸컷 
);

DROP TABLE IF EXISTS `movie_file`;

CREATE TABLE `movie_file` (
	`mf_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT, --
	`mf_fi_num`	int	NOT NULL,
	`mf_mo_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `age`;

CREATE TABLE `age` (
	`ag_name`	varchar(10)	NOT NULL PRIMARY KEY --
);

DROP TABLE IF EXISTS `theater`;

CREATE TABLE `theater` (
	`th_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT, --
	`th_name`	varchar(20)	NOT NULL, --
	`th_address`	varchar(50)	NOT NULL, --
	`th_re_name`	varchar(15)	NOT NULL, 
	`th_total_screen`	int	NOT NULL DEFAULT 1, --
	`th_total_seat`	int	NOT NULL --
);

DROP TABLE IF EXISTS `region`;

CREATE TABLE `region` (
	`re_name`	varchar(15)	NOT NULL PRIMARY KEY
);

DROP TABLE IF EXISTS `screen`;

CREATE TABLE `screen` (
	`sc_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT, --
	`sc_name`	varchar(20)	NOT NULL, --
	`sc_total_seat`	int	NOT NULL, -- 
	`sc_th_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
	`se_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT, --
	`se_name`	varchar(4)	NOT NULL, --
	`se_row`	char(1)	NOT NULL, --
	`se_col`	varchar(2)	NOT NULL, --
	`se_state`	varchar(10)	NOT NULL DEFAULT '일반', -- 일반/커플/스위트 
	`se_sc_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `movie_schedule`;

CREATE TABLE `movie_schedule` (
	`ms_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT, --
	`ms_mo_num`	int	NOT NULL,
	`ms_sc_num`	int	NOT NULL,
	`ms_date`	date	NOT NULL,--
	`ms_start_time`	time	NOT NULL,--
	`ms_end_time`	time	NOT NULL,--
	`ms_possible_seat`	int	NOT NULL,--
	`ms_discount`	char(1)	NOT NULL DEFAULT 'N'--
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(15)	NOT NULL PRIMARY KEY, --
	`me_pw`	varchar(20)	NOT NULL,--
	`me_name`	varchar(20)	NOT NULL,--
	`me_phone`	varchar(15)	NOT NULL,--
	`me_birthday`	date	NOT NULL,--
    `me_authority` varchar(5) NOT NULL DEFAULT 'USER'
);

DROP TABLE IF EXISTS `reservation`;

CREATE TABLE `reservation` (
	`rv_num`	varchar(20)	NOT NULL PRIMARY KEY,--
	`rv_adult`	int	NOT NULL DEFAULT 0,--
	`rv_ms_num`	int	NOT NULL,
	`rv_me_id`	varchar(15)	NOT NULL,
	`rv_teenager`	int	NOT NULL DEFAULT 0,--
	`rv_price`	int	NOT NULL--
);

DROP TABLE IF EXISTS `reservation_list`;

CREATE TABLE `reservation_list` (
	`rl_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,--
	`rl_rv_num`	varchar(20)	NOT NULL,
	`rl_se_num`	int	NOT NULL,
	`rl_pr_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `price`;

CREATE TABLE `price` (
	`pr_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT, --
	`pr_type`	varchar(3)	NOT NULL,
	`pr_price`	int	NOT NULL,
	`pr_discount_price`	int	NOT NULL
);

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
	`re_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,--
	`re_content`	longtext	NOT NULL,--
	`re_mo_num`	int	NOT NULL,
	`re_me_id`	varchar(15)	NOT NULL,
	`re_total_like`	int	NOT NULL DEFAULT 0 --
);

DROP TABLE IF EXISTS `like`;

CREATE TABLE `like` (
	`li_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT, --
	`me_id`	varchar(15)	NOT NULL,
	`re_num`	int	NOT NULL
);

ALTER TABLE `movie` ADD CONSTRAINT `FK_file_TO_movie_1` FOREIGN KEY (
	`mo_fi_num`
)
REFERENCES `file` (
	`fi_num`
);

ALTER TABLE `movie` ADD CONSTRAINT `FK_age_TO_movie_1` FOREIGN KEY (
	`mo_ag_name`
)
REFERENCES `age` (
	`ag_name`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_genre_TO_movie_genre_1` FOREIGN KEY (
	`mg_ge_name`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_movie_TO_movie_genre_1` FOREIGN KEY (
	`mg_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `country_production` ADD CONSTRAINT `FK_country_TO_country_production_1` FOREIGN KEY (
	`cp_ct_name`
)
REFERENCES `country` (
	`ct_name`
);

ALTER TABLE `country_production` ADD CONSTRAINT `FK_movie_TO_country_production_1` FOREIGN KEY (
	`cp_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `film_person` ADD CONSTRAINT `FK_country_TO_film_person_1` FOREIGN KEY (
	`fp_ct_name`
)
REFERENCES `country` (
	`ct_name`
);

ALTER TABLE `role` ADD CONSTRAINT `FK_film_person_TO_role_1` FOREIGN KEY (
	`ro_fp_num`
)
REFERENCES `film_person` (
	`fp_num`
);

ALTER TABLE `role` ADD CONSTRAINT `FK_movie_TO_role_1` FOREIGN KEY (
	`ro_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `movie_file` ADD CONSTRAINT `FK_file_TO_movie_file_1` FOREIGN KEY (
	`mf_fi_num`
)
REFERENCES `file` (
	`fi_num`
);

ALTER TABLE `movie_file` ADD CONSTRAINT `FK_movie_TO_movie_file_1` FOREIGN KEY (
	`mf_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `theater` ADD CONSTRAINT `FK_region_TO_theater_1` FOREIGN KEY (
	`th_re_name`
)
REFERENCES `region` (
	`re_name`
);

ALTER TABLE `screen` ADD CONSTRAINT `FK_theater_TO_screen_1` FOREIGN KEY (
	`sc_th_num`
)
REFERENCES `theater` (
	`th_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_screen_TO_seat_1` FOREIGN KEY (
	`se_sc_num`
)
REFERENCES `screen` (
	`sc_num`
);

ALTER TABLE `movie_schedule` ADD CONSTRAINT `FK_movie_TO_movie_schedule_1` FOREIGN KEY (
	`ms_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `movie_schedule` ADD CONSTRAINT `FK_screen_TO_movie_schedule_1` FOREIGN KEY (
	`ms_sc_num`
)
REFERENCES `screen` (
	`sc_num`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_movie_schedule_TO_reservation_1` FOREIGN KEY (
	`rv_ms_num`
)
REFERENCES `movie_schedule` (
	`ms_num`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_member_TO_reservation_1` FOREIGN KEY (
	`rv_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `reservation_list` ADD CONSTRAINT `FK_reservation_TO_reservation_list_1` FOREIGN KEY (
	`rl_rv_num`
)
REFERENCES `reservation` (
	`rv_num`
);

ALTER TABLE `reservation_list` ADD CONSTRAINT `FK_seat_TO_reservation_list_1` FOREIGN KEY (
	`rl_se_num`
)
REFERENCES `seat` (
	`se_num`
);

ALTER TABLE `reservation_list` ADD CONSTRAINT `FK_price_TO_reservation_list_1` FOREIGN KEY (
	`rl_pr_num`
)
REFERENCES `price` (
	`pr_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_movie_TO_review_1` FOREIGN KEY (
	`re_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_member_TO_review_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `like` ADD CONSTRAINT `FK_member_TO_like_1` FOREIGN KEY (
	`me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `like` ADD CONSTRAINT `FK_review_TO_like_1` FOREIGN KEY (
	`re_num`
)
REFERENCES `review` (
	`re_num`
);

