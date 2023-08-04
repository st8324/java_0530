DROP DATABASE IF EXISTS SHOPPINGMALL;

CREATE DATABASE SHOPPINGMALL;

USE SHOPPINGMALL;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(15)	NOT NULL PRIMARY KEY,
	`me_pw`	varchar(255)	NOT NULL,
	`me_phone`	varchar(13)	NOT NULL,
	`me_addr`	varchar(50)	NULL,
	`me_addr_detail`	varchar(50)	NULL,
	`me_post`	char(5)	NULL,
	`me_point`	int	NOT NULL DEFAULT 0,
	`me_authority`	varchar(5)	NOT NULL DEFAULT 'USER',
    `me_name` varchar(20) NOT NULL
);

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
	`ad_num`	int	NOT NULL  PRIMARY KEY AUTO_INCREMENT,
	`ad_name`	varchar(15)	NOT NULL,
	`ad_addr`	varchar(50)	NOT NULL,
	`ad_addr_detail`	varchar(50)	NOT NULL,
	`ad_post`	char(5)	NOT NULL,
	`ad_me_id`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`pr_code`	char(6)	NOT NULL PRIMARY KEY,
	`pr_name`	varchar(20)	NOT NULL,
	`pr_detail`	longtext	NOT NULL,
	`pr_price`	int	NOT NULL
);

DROP TABLE IF EXISTS `option`;

CREATE TABLE `option` (
	`op_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`op_name`	varchar(20)	NOT NULL,
	`op_amount`	int	NOT NULL DEFAULT 0,
	`op_pr_code`	char(6)	NOT NULL
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
	`fi_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`fi_name`	varchar(50)	NOT NULL,
	`fi_pr_code`	char(6)	NOT NULL
);

DROP TABLE IF EXISTS `point`;

CREATE TABLE `point` (
	`po_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`po_content`	varchar(30)	NOT NULL,
	`po_amount`	int	NOT NULL,
	`po_me_id`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
	`or_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`or_total`	int	NOT NULL,
	`or_price`	int	NOT NULL,
	`or_use_point`	int	NOT NULL DEFAULT 0,
	`or_save_point`	int	NOT NULL,
	`or_state`	varchar(10)	NOT NULL DEFAULT '제품준비중',
	`or_me_id`	varchar(15)	NOT NULL,
	`or_ad_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `order_list`;

CREATE TABLE `order_list` (
	`ol_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`ol_amount`	int	NOT NULL,
	`ol_price`	int	NOT NULL,
	`ol_or_num`	int	NOT NULL,
	`ol_op_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `basket`;

CREATE TABLE `basket` (
	`ba_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`ba_amount`	int	NOT NULL DEFAULT 1,
	`ba_me_id`	varchar(15)	NOT NULL,
	`ba_op_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
	`re_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`re_content`	longtext	NOT NULL,
	`re_thumb`	varchar(50)	NULL,
	`re_op_num`	int	NOT NULL,
	`re_me_id`	varchar(15)	NOT NULL
);

ALTER TABLE `address` ADD CONSTRAINT `FK_member_TO_address_1` FOREIGN KEY (
	`ad_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `option` ADD CONSTRAINT `FK_product_TO_option_1` FOREIGN KEY (
	`op_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_product_TO_file_1` FOREIGN KEY (
	`fi_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `point` ADD CONSTRAINT `FK_member_TO_point_1` FOREIGN KEY (
	`po_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_member_TO_order_1` FOREIGN KEY (
	`or_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_address_TO_order_1` FOREIGN KEY (
	`or_ad_num`
)
REFERENCES `address` (
	`ad_num`
);

ALTER TABLE `order_list` ADD CONSTRAINT `FK_order_TO_order_list_1` FOREIGN KEY (
	`ol_or_num`
)
REFERENCES `order` (
	`or_num`
);

ALTER TABLE `order_list` ADD CONSTRAINT `FK_option_TO_order_list_1` FOREIGN KEY (
	`ol_op_num`
)
REFERENCES `option` (
	`op_num`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_member_TO_basket_1` FOREIGN KEY (
	`ba_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_option_TO_basket_1` FOREIGN KEY (
	`ba_op_num`
)
REFERENCES `option` (
	`op_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_option_TO_review_1` FOREIGN KEY (
	`re_op_num`
)
REFERENCES `option` (
	`op_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_member_TO_review_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

